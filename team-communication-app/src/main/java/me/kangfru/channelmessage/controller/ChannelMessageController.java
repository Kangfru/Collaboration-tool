package me.kangfru.channelmessage.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import me.kangfru.channelmessage.dto.ChannelMessageDTO;
import me.kangfru.channelmessage.service.ChannelMessageService;
import me.kangfru.project.dto.ChannelDTO;

@Controller
@AllArgsConstructor
@RequestMapping("/channel")
public class ChannelMessageController {
	
	private ChannelMessageService service;
	
	@GetMapping("/message")
	public String channelMessage() {
		return "channel/message/channelMessage";
	}
	
	@MessageMapping("/chat")
	@SendTo("/channel/message/chat")
	public ChannelMessageDTO chat(ChannelMessageDTO dto) throws Exception {
		dto.setSendDate(new Date());
		service.saveChatToDB(dto);
		return dto;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Integer> createChannel(ChannelDTO dto) {
		return new ResponseEntity<Integer>(service.createChannel(dto), HttpStatus.OK);
	}
	
}
