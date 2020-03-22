package me.kangfru.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.kangfru.project.dto.ChannelDTO;
import me.kangfru.project.dto.ProjectDTO;
import me.kangfru.project.mapper.ProjectMapper;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectMapper mapper;
	
	@Override
	public List<ProjectDTO> list(int member_id) {
		System.out.println(member_id);
		return mapper.list(member_id);
	}

	@Override
	public ProjectDTO view(int project_id) {
		// TODO Auto-generated method stub
		return mapper.view(project_id);
	}

	@Override
	public List<ChannelDTO> getChannelList(int project_id) {
		// TODO Auto-generated method stub
		return mapper.getChannelList(project_id);
	}
	
}
