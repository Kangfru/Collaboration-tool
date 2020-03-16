var stompClient = null;

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversation").show();
	} else {
		$("#conversation").hide();
	}
	$("#greetings").html("");
}

function connect() {
	var socket = new SockJS('/websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/channel/message/chat', function (chat) {
	    	showChat(JSON.parse(chat.body));
	    });
	});
}

function sendChat() {
	stompClient.send("/channel/message/chat", {}, JSON.stringify({'name': 'test', 'message': $("#chatMessage").val()}));
}

function showChat(chat) {
  $("#greetings").append("<tr><td>" + chat.name + " : " + chat.message + "</td></tr>");
}

function disconnect() {
	if (stompClient !== null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {
		connect();
	});
	$("#disconnect").click(function() {
		disconnect();
	});
	$( "#chatSend" ).click(function(){ 
		sendChat(); 
	});
});