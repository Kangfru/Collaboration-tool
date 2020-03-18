package me.kangfru.channelmessage.service;

import me.kangfru.channelmessage.dto.ChannelMessageDTO;

public interface ChannelMessageService {

	public Integer saveChatToDB(ChannelMessageDTO dto);
	
}
