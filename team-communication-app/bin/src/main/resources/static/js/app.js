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

		// stompClient.subscribe('/channel/message/chat', function (dto) {
		// console.log(dto)
		// showChat(JSON.parse(dto.body));
		// });
	});
}

function sendChat() {
	const member_id = document.querySelector('#member_id');
	const channel_id = document.querySelector('#channel_id');
	const nickName = document.querySelector('#nickName').value;
	const message = $("#chatMessage").val();
	stompClient.send("/app/chat", {}, JSON.stringify({
		'message' : message,
		'member_id' : member_id.value,
		'channel_id' : channel_id.value
	}));
	var dto = {
		nickName : nickName,
		message : message,
		sendDate : new Date()
	}
	showChat(dto);
}

function showChat(dto) {
	var sendDate = new Date(dto.sendDate).format("MM/dd a/p hh:mm");

	$(".chat").append(
			"<tr><td>" + dto.nickName + " : " + dto.message + " - "	+ sendDate + "</td></tr>");
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
	$("#chatSend").click(function() {
		sendChat();
	});
});

function init() {
	connect();
};

Date.prototype.format = function(f) {

	if (!this.valueOf())
		return " ";

	var weekKorName = [ "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" ];

	var weekKorShortName = [ "일", "월", "화", "수", "목", "금", "토" ];

	var weekEngName = [ "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
			"Friday", "Saturday" ];

	var weekEngShortName = [ "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" ];

	var d = this;

	return f.replace(/(yyyy|yy|MM|dd|KS|KL|ES|EL|HH|hh|mm|ss|a\/p)/gi,
			function($1) {

				switch ($1) {

				case "yyyy":
					return d.getFullYear(); // 년 (4자리)

				case "yy":
					return (d.getFullYear() % 1000).zf(2); // 년 (2자리)

				case "MM":
					return (d.getMonth() + 1).zf(2); // 월 (2자리)

				case "dd":
					return d.getDate().zf(2); // 일 (2자리)

				case "KS":
					return weekKorShortName[d.getDay()]; // 요일 (짧은 한글)

				case "KL":
					return weekKorName[d.getDay()]; // 요일 (긴 한글)

				case "ES":
					return weekEngShortName[d.getDay()]; // 요일 (짧은 영어)

				case "EL":
					return weekEngName[d.getDay()]; // 요일 (긴 영어)

				case "HH":
					return d.getHours().zf(2); // 시간 (24시간 기준, 2자리)

				case "hh":
					return ((h = d.getHours() % 12) ? h : 12).zf(2); // 시간
																		// (12시간
																		// 기준,
																		// 2자리)

				case "mm":
					return d.getMinutes().zf(2); // 분 (2자리)

				case "ss":
					return d.getSeconds().zf(2); // 초 (2자리)

				case "a/p":
					return d.getHours() < 12 ? "오전" : "오후"; // 오전/오후 구분

				default:
					return $1;

				}

			});

};

String.prototype.string = function(len) {
	var s = '', i = 0;
	while (i++ < len) {
		s += this;
	}
	return s;
};

String.prototype.zf = function(len) {
	return "0".string(len - this.length) + this;
};

Number.prototype.zf = function(len) {
	return this.toString().zf(len);
};

init();
