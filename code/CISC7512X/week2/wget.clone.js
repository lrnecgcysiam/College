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

 // Now we can send an HTTP GET request
 http.get("http://google.com", (res) =>
 res.pipe(process.stdout));


 