package me.kangfru.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.kangfru.member.dto.MemberDTO;
import me.kangfru.member.service.MemberService;

@RequestMapping(value = "/member")
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/signIn")
	public String signInForm(Model model) {
		return "member/signIn";
	}
	
	@PostMapping("/signIn")
	public String signIn(Model model, MemberDTO dto) {
		memberService.signIn(dto);
		return "redirect:localhost:8080/";
	}
}
