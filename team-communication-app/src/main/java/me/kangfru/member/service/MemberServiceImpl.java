package me.kangfru.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.kangfru.member.dto.MemberDTO;
import me.kangfru.member.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
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
		return memberMapper.siginIn(dto);
	}

	@Override
	public Integer signOut() {
		// TODO Auto-generated method stub
		return memberMapper.signOut();
	}

}
