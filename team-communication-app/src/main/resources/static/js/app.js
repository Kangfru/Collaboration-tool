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
		
		stompClient.subscribe('/channel/message/chat', function (dto) {
			console.log(dto)
	    	showChat(JSON.parse(dto.body));
	    });
	});
}

function sendChat() {
	stompClient.send("/app/chat", {}, JSON.stringify({'message': $("#chatMessage").val(), 'member_id':'1', 'channel_id':'1'}));
}

function showChat(dto) {
  $("#greetings").append("<tr><td>" + dto.nickName + " : " + dto.message + " - " + dto.sendDate + "</td></tr>");
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