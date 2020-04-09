package me.kangfru.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.kangfru.channelmessage.dto.ChannelMessageDTO;
import me.kangfru.member.dto.MemberDTO;
import me.kangfru.project.dto.ChannelDTO;
import me.kangfru.project.dto.ProjectDTO;
import me.kangfru.project.mapper.ProjectMapper;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectMapper mapper;
	
	@Override
	public List<ProjectDTO> list(int member_id) {
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

	@Override
	public Integer getGeneralChannelID(int project_id) {
		// TODO Auto-generated method stub
		return mapper.getGeneralChannelID(project_id);
	}

	@Override
	public List<ChannelMessageDTO> getChatLog(int channel_id) {
		// TODO Auto-generated method stub
		return mapper.getChatLog(channel_id);
	}

	@Override
	public List<MemberDTO> getMemberList(int project_id) {
		// TODO Auto-generated method stub
		return mapper.getMemberList(project_id);
	}

	@Override
	public String getChannelNow(int channel_id) {
		// TODO Auto-generated method stub
		return mapper.getChannelNow(channel_id);
	}
	
}
