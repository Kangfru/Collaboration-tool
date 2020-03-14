package me.kangfru.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import me.kangfru.member.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	List<MemberDTO> list();
	MemberDTO view();
	Integer signIn(MemberDTO dto);
	Integer signOut();
	
}
