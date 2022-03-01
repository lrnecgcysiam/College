
// Homework #3
// cisc 7332x
// In any language of your choice, implement a simple web-server.
// Your web-server should serve pages from some folder. You should be 
// able to point your web-browser at the URL of your web-server, 
// and see pages (and images) in that folder. This is not much
// different than writing a web-client. I recommend you use Java,
// since it's pretty easy to setup a basic server in that language---
// although you're free to use any language.

// Inspired by the youtube video below
// https://www.youtube.com/watch?v=lCNUsi4Qfuw


//  Import the java packages

import java.net.*;
import java.io.*;


public class SimpleServerJava {
    public static void main(String[] args) throws IOException {
        int port = 8081;

        // opening a server socket
        ServerSocket serverSocket = new ServerSocket(port);
        System.err.println("Server is runnning on port: " + port);

        while(true) {
            // get the client socket
            Socket clientSocket = serverSocket.accept();
            
            // log the connection 
            System.err.println(" Client connected");

            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
            String s;

            // Read the data from Client side ( reading the headers )

            while((s = in.readLine())!=null){
                // read all the data until it is null.
                System.out.println(s);

                // keep checking if the line are empty
                if(s.isEmpty()) {
                    // break out the loop if empty
                    break;
                }
        }
        // Now we can send the response to the client with a CLient output 
        OutputStream clientOutput = clientSocket.getOutputStream();
        // Write output to client
        clientOutput.write("HTTP/1.1 200 OK\r\n".getBytes());
        clientOutput.write("\r\n".getBytes());
        clientOutput.write("<b>Please Visit go to lrnecgysiam.com</b>".getBytes());
        clientOutput.write("\r\n\r\n".getBytes());

        // calling the flush method 
        // Learn more by visiting this blog entry
        // https://medium.com/@gabriellamedas/remember-to-flush-your-streams-a0ce23043947
        clientOutput.flush();

        // Print string to terminal 
        System.err.println("Client connection closed!");
            in.close();
            clientOutput.close();
    }
}
}
