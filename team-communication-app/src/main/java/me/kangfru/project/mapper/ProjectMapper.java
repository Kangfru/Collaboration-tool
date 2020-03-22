package me.kangfru.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import me.kangfru.project.dto.ChannelDTO;
import me.kangfru.project.dto.ProjectDTO;

@Mapper
public interface ProjectMapper {

	public List<ProjectDTO> list(int member_id);
	public ProjectDTO view(int project_id);
	public List<ChannelDTO> getChannelList(int project_id);
	
}
