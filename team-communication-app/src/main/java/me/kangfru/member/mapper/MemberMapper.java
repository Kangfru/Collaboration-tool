package me.kangfru.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import me.kangfru.member.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	public List<MemberDTO> list();
	public MemberDTO view();
	public Integer signIn(MemberDTO dto);
	public Integer signOut();
	
}
