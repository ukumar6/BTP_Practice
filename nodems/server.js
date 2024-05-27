// getting the dependencies of standard express module
const express = require('express')
// initialising an app - server side app
const app = express()
// to get info from file
const fs = require('fs')

//start serving the whole folder using my webserver
app.use(express.static('webapp'));

// registering the end point
app.get('/', function (req, res) {
  res.send('Hello World')
})
console.log("server started at 3000");

// registering the end point
app.get('/employees', function (req, res) {
    var contentFile = fs.readFileSync("./webapp/emp.json","utf-8");
    res.send(contentFile);
  })

// to set port number
app.listen(process.env.PORT || 3000)