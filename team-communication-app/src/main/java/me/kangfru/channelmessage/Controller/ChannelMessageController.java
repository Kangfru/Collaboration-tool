package me.kangfru.channelmessage.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.kangfru.channelmessage.dto.ChannelMessageDTO;

@Controller
@RequestMapping("/channel")
public class ChannelMessageController {
	
	@GetMapping("/message")
	public String channelMessage() {
		return "channel/message/channelMessage";
	}
	
	@MessageMapping("/channel")
	@SendTo("/channel/message/chat")
	public ChannelMessageDTO chat(ChannelMessageDTO dto) throws Exception {
		System.out.println("dto");
		dto.setMessage("Test");
		return dto;
	}
}
