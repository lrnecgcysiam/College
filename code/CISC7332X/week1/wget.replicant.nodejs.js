// https://en.wikipedia.org/wiki/Wget
/**
 * GNU Wget (or just Wget, formerly Geturl, 
 * also written as its package name, wget) is a computer
 * program that retrieves content from web servers.
 * It is part of the GNU Project.
 * Its name derives from "World Wide Web" and 
 * "get." It supports downloading via HTTP, HTTPS, and FTP. 
 * 
 */

 // Import the http module
 const http = require("http");
 const fs = require("fs");
 const URL = process.argv[2];
 const file = fs.createWriteStream(process.argv[3]);

 // get position of process arguments
 // console.log(process.argv[2],process.argv[3]);

try {
// Now we can send an HTTP GET request
const request =  http.get(URL, (res) => res.pipe(file));
} catch(error) {
    res.status(500).send(error)
}