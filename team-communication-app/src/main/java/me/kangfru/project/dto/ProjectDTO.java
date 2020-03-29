package me.kangfru.project.dto;

import lombok.Data;

@Data
public class ProjectDTO {

	private int id, admin_id, member_id, projet_id;
	private String projectName;
	private int generalChannelId;
	
}
