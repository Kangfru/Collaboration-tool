package me.kangfru.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@GetMapping("/login")
	public String loginForm(Model model) {
		return "member/login";
	}

	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		if(session.getAttribute("loginInfo") != null)
			session.removeAttribute("loginInfo");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", consumes = "application/json", produces = "application/text; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<String> login(Model model, @RequestBody MemberDTO dto, HttpSession session) {
		MemberDTO resultDTO = memberService.login(dto);
		System.out.println(dto);
		if(resultDTO != null) {
			session.setAttribute("loginInfo", resultDTO);
			System.out.println(session.getAttribute("loginInfo"));
			return new ResponseEntity<String>("로그인 성공", HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("로그인 실패", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
