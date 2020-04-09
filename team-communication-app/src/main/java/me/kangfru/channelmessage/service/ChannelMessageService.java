package me.kangfru.channelmessage.service;

import me.kangfru.channelmessage.dto.ChannelMessageDTO;
import me.kangfru.project.dto.ChannelDTO;

public interface ChannelMessageService {

	public Integer saveChatToDB(ChannelMessageDTO dto);

	public Integer createChannel(ChannelDTO dto);
	
}
