package me.kangfru.member.service;

import java.util.List;

import me.kangfru.member.dto.MemberDTO;

public interface MemberService {

	List<MemberDTO> list();
	MemberDTO view();
	Integer signIn(MemberDTO dto);
	Integer signOut();
	
}
