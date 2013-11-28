var express = require('express'),
    server = require('http');

var app = express(),
    http = require('http'),
    port = process.env.PORT || 5000,
    server = http.createServer(app).listen(port);

//express configuration
app.use("/fonts", express.static(__dirname + '/app/assets/fonts'));
app.use("/stylesheets", express.static(__dirname + '/app/assets/stylesheets'));
app.use("/javascripts", express.static(__dirname + '/app/assets/javascripts'));
app.use("/images", express.static(__dirname + '/app/assets/images'));
app.use("/controllers", express.static(__dirname + '/app/controllers'));
app.use("/views", express.static(__dirname + '/app/views'));
app.use("/services", express.static(__dirname + '/app/services'));

app.use(express.basicAuth('admin', 'admin'));

app.get('/', function(request, response) {
	response.sendfile(__dirname + '/app/index.html');
});

console.log('Server is running and listening on port '+port);