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
		
//		stompClient.subscribe('/channel/message/chat', function (dto) {
//			console.log(dto)
//	    	showChat(JSON.parse(dto.body));
//	    });
	});
}

function sendChat() {
	const member_id = document.querySelector('#member_id');
	const channel_id = document.querySelector('#channel_id');
	const nickName = document.querySelector('#nickName').value;
	const message = $("#chatMessage").val();
	stompClient.send("/app/chat", {}, JSON.stringify({'message': message, 'member_id':member_id.value, 'channel_id':channel_id.value}));
	var dto = {
			nickName : nickName,
			message : message,
			sendDate : new Date()
	}
	showChat(dto);
}

function showChat(dto) {
  $(".chat").append("<tr><td>" + dto.nickName + " : " + dto.message + " - " + dto.sendDate + "</td></tr>");
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

function init(){
	connect();
};

init();
