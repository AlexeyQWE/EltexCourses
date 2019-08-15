
var http = require("http");
var fs = require("fs");

http.createServer(function(req, resp){
    var filePath = req.url.substr(0);
    if (filePath === "/")
        filePath = "index.html";
    fs.readFile(filePath, function(error, data) {
        resp.end(data);
    });
    return;
}).listen(3000, function(){
    console.log("Node.JS Server running");
});