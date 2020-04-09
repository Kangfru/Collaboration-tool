package me.kangfru.project.service;

import java.util.List;

import me.kangfru.channelmessage.dto.ChannelMessageDTO;
import me.kangfru.member.dto.MemberDTO;
import me.kangfru.project.dto.ChannelDTO;
import me.kangfru.project.dto.ProjectDTO;

public interface ProjectService {
	
	public List<ProjectDTO> list(int member_id);
	public ProjectDTO view(int project_id);
	public List<ChannelDTO> getChannelList(int project_id);
	public Integer getGeneralChannelID(int project_id);
	public List<ChannelMessageDTO> getChatLog(int channel_id);
	public List<MemberDTO> getMemberList(int project_id);
	public String getChannelNow(int channel_id);
	public Integer createProject(ProjectDTO dto);
	public Integer initProject(ProjectDTO dto);
	public Integer initChannel(ProjectDTO dto);
	public Integer inviteMember(String email, int project_id);
	
}
