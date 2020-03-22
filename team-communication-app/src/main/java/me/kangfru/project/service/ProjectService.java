package me.kangfru.project.service;

import java.util.List;

import me.kangfru.project.dto.ChannelDTO;
import me.kangfru.project.dto.ProjectDTO;

public interface ProjectService {
	
	public List<ProjectDTO> list(int member_id);
	public ProjectDTO view(int project_id);
	public List<ChannelDTO> getChannelList(int project_id);

}
