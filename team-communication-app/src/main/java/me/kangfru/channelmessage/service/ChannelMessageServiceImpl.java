package me.kangfru.channelmessage.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.kangfru.channelmessage.dto.ChannelMessageDTO;
import me.kangfru.channelmessage.mapper.ChannelMessageMapper;
import me.kangfru.project.dto.ChannelDTO;


@Service
public class ChannelMessageServiceImpl implements ChannelMessageService {

	@Autowired
	private ChannelMessageMapper mapper;
	
	@Override
	public Integer saveChatToDB(ChannelMessageDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("ChannelMessageServiceImpl.saveChatToDB().dto : " + dto);
		return mapper.saveChatToDB(dto);
	}

	@Override
	public Integer createChannel(ChannelDTO dto) {
		// TODO Auto-generated method stub
		return mapper.createChannel(dto);
	}

}
