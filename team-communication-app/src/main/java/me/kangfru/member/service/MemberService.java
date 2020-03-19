package me.kangfru.member.service;

import java.util.List;

import me.kangfru.member.dto.MemberDTO;

public interface MemberService {

	public List<MemberDTO> list();
	public MemberDTO view();
	public Integer signIn(MemberDTO dto);
	public MemberDTO login(MemberDTO dto);
	public Integer signOut();
	
}
