package com.ism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ism.entity.User;

@Controller
public class UserController {
	
	@RequestMapping("/user")
	public String showUser(Model model, @ModelAttribute("result") String result) {

		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("result", result);
		return "user";
	}
	
	@RequestMapping(value="/user/save", method=RequestMethod.POST)
	public String handleCountry(@ModelAttribute("user") User userForm, Model model, RedirectAttributes r){
//		model.addAttribute("userForm",userForm);
		System.out.println(userForm);
		r.addFlashAttribute("result","Se han realizado los cambios exitosamente");
		return "redirect:/user";
	}

}
