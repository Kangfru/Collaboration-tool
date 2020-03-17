package me.kangfru.channelmessage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import me.kangfru.channelmessage.dto.ChannelMessageDTO;

@Mapper 
public interface ChannelMessageMapper {

	public List<ChannelMessageDTO> getChat(int channel_id);
	public Integer saveChatToDB(ChannelMessageDTO dto);
	
}
