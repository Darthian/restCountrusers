package com.ism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("resultado")
public class IndexController {

	@RequestMapping("/")
	public String showIndex(Model model) {
		model.addAttribute("resultado", "Mensaje del Session PUTO");
		return "index";
	}

	@RequestMapping("/about")
	public String showAbout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "about";
	}

//	@RequestMapping("/admin")
//	public String showAdmin(Model model) {
//
//		model.addAttribute("mensaje", "Mensaje del modelo PUTO");
//		return "admin";
//	}
}
