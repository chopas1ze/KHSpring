var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);

app.get('/', function(req, res){
  res.sendfile('src/main/webapp/chat/index.html');
});

io.on('connection', function(socket){
	

  socket.on('join', function(user){
    socket.user = user;
  });

  socket.on('chat message', function(msg){
	
    io.emit('chat message', {'user':socket.user, 'msg':msg});

    console.log(msg);
  });

});

http.listen(3000, function(){
  console.log('listening on *:3000');
});