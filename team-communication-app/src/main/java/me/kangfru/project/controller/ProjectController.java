package me.kangfru.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.kangfru.project.dto.ProjectDTO;
import me.kangfru.project.service.ProjectService;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {

	@Autowired
	private ProjectService service;
	
	@GetMapping(value = "/list")
	public String list(Model model, @RequestParam int member_id) {
		List<ProjectDTO> list = service.list(member_id);
		for(ProjectDTO dto : list) {
			dto.setGeneralChannelId(service.getGeneralChannelID(dto.getId()));
		}
		System.out.println(list);
		model.addAttribute("list", list);
		return "project/list";
	}
	
	@GetMapping(value = "/view")
	public String view(Model model, @RequestParam int project_id, @RequestParam int channel_id) {
		model.addAttribute("projectDTO", service.view(project_id));
		model.addAttribute("channelList", service.getChannelList(project_id));
		model.addAttribute("memberList", service.getMemberList(project_id));
		model.addAttribute("channelNow", service.getChannelNow(channel_id));
		model.addAttribute("chatLog", service.getChatLog(channel_id));
		return "project/view"; 
	}
	
	@GetMapping("/create")
	public String create(@RequestParam int admin_id) {
		return "project/create";
	}
	
	@PostMapping("/create")
	public String createProcess(ProjectDTO dto) {
		service.createProject(dto);
		service.initProject(dto);
		service.initChannel(dto);
		return "redirect:/";
	}
	
	@PostMapping("/invite")
	public ResponseEntity<Integer> inviteMember(String email, int project_id){
		
		return new ResponseEntity<Integer>(service.inviteMember(email, project_id), HttpStatus.OK);
		
	}
}
