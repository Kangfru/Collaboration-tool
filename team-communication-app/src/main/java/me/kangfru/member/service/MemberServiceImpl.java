package me.kangfru.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.kangfru.member.dto.MemberDTO;
import me.kangfru.member.mapper.MemberMapper;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	private MemberMapper memberMapper;
	
	@Override
	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		return memberMapper.list();
	}

	@Override
	public MemberDTO view() {
		// TODO Auto-generated method stub
		return memberMapper.view();
	}

	@Override
	public Integer signIn(MemberDTO dto) {
		// TODO Auto-generated method stub
		return memberMapper.signIn(dto);
	}

	public MemberDTO login(MemberDTO dto) {
		return memberMapper.login(dto);
	}
	
	@Override
	public Integer signOut() {
		// TODO Auto-generated method stub
		return memberMapper.signOut();
	}

}
