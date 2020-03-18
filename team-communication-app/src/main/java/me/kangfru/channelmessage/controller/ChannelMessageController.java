package me.kangfru.channelmessage.controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import me.kangfru.channelmessage.dto.ChannelMessageDTO;
import me.kangfru.channelmessage.service.ChannelMessageService;

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
		dto.setNickName("강프루");
		dto.setSendDate(new Date());
		System.out.println("ChannelMessageController.chat().dto : " + dto);
		Integer result = service.saveChatToDB(dto);
		System.out.println(result);
		return dto;
	}
}
