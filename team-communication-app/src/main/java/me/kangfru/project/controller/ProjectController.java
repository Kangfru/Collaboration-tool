package me.kangfru.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.kangfru.project.service.ProjectService;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {

	@Autowired
	private ProjectService service;
	
	@GetMapping(value = "/list")
	public String list(Model model, @RequestParam int member_id) {
		model.addAttribute("list", service.list(member_id));
		return "project/list";
		
	}
	
	@GetMapping(value = "/view")
	public String view(Model model, @RequestParam int project_id) {
		model.addAttribute("channelList", service.getChannelList(project_id));
		return "project/view";
	}
	
}
