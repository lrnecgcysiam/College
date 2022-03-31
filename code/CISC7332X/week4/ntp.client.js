// CHris Samuel
// 24141468
// chris.samuel68@bcmail.cuny.edu

// In any programming language of your choice (C prefered), write an NTP client. 
// NTP is Network Time Protocol. Your program sends a UDP packet to the server.
// The server responds with a similarly formatted UDP packet with the current time.
// A public ntp server is: pool.ntp.org. This homework is part research part programming. 
// Research part: Find the NTP specification, and determine what the UDP packet format is (google, etc.). 
// Programming Part: Write a program to send the packet and recieve a response. When your program is executed, it will output the current time (recieved from NTP server) to standard output, in ``Wed Sep 24 07:29:23 EDT 2008'' format, (Note that since you're using UDP, not all packets will get through---so you might need to run the program a few times in order to get the correct time). You can lookup the format for the to/from message in ``NTP RFC'' (google for it)---the format is pretty simple. Your program should work similar to the unix utility ``ntptime''. Note that you should not use any "NTP" libraries---this homework is about creating your own UDP packet and sending it via the regular socket API.

// https://en.wikipedia.org/wiki/Network_Time_Protocol
// https://openwrt.org/docs/guide-user/services/ntp/client-server


getNetworkTime = function (server, port, callback) {
    if (callback === null || typeof callback !== "function") {
        return;
    }

    server = server || exports.defaultNtpServer;
    port = port || exports.defaultNtpPort;

    var client = dgram.createSocket("udp4"),
        ntpData = new Buffer(48);

    // RFC 2030 -> LI = 0 (no warning, 2 bits), VN = 3 (IPv4 only, 3 bits), Mode = 3 (Client Mode, 3 bits) -> 1 byte
    // -> rtol(LI, 6) ^ rotl(VN, 3) ^ rotl(Mode, 0)
    // -> = 0x00 ^ 0x18 ^ 0x03
    ntpData[0] = 0x1B;

    for (var i = 1; i < 48; i++) {
        ntpData[i] = 0;
    }

    var timeout = setTimeout(function () {
        client.close();
        callback("Timeout waiting for NTP response.", null);
    }, exports.ntpReplyTimeout);

    // Some errors can happen before/after send() or cause send() to was impossible.
    // Some errors will also be given to the send() callback.
    // We keep a flag, therefore, to prevent multiple callbacks.
    // NOTE : the error callback is not generalised, as the client has to lose the connection also, apparently.
    var errorFired = false;

    client.on('error', function (err) {
        if (errorFired) {
            return;
        }

        callback(err, null);
        errorFired = true;

        clearTimeout(timeout);
    });

    client.send(ntpData, 0, ntpData.length, port, server, function (err) {
        if (err) {
            if (errorFired) {
                return;
            }
            clearTimeout(timeout);
            callback(err, null);
            errorFired = true;
            client.close();
            return;
        }

        client.once('message', function (msg) {
            clearTimeout(timeout);
            client.close();

            // Offset to get to the "Transmit Timestamp" field (time at which the reply
            // departed the server for the client, in 64-bit timestamp format."
            var offsetTransmitTime = 40,
                intpart = 0,
                fractpart = 0;

            // Get the seconds part
            for (var i = 0; i <= 3; i++) {
                intpart = 256 * intpart + msg[offsetTransmitTime + i];
            }

            // Get the seconds fraction
            for (i = 4; i <= 7; i++) {
                fractpart = 256 * fractpart + msg[offsetTransmitTime + i];
            }

            var milliseconds = (intpart * 1000 + (fractpart * 1000) / 0x100000000);

            // **UTC** time
            var date = new Date("Jan 01 1900 GMT");
            date.setUTCMilliseconds(date.getUTCMilliseconds() + milliseconds);

            callback(null, date);
        });
    });
}