package me.kangfru.channelmessage.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ChannelMessageDTO {
	
	private int id;
	private String nickName;
	private String message;
	private Date sendDate;
	private int member_id, channel_id;
	
}
