package com.ism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ism.entity.Country;
import com.ism.entity.User;
import com.ism.service.CountryService;
import com.ism.service.UserService;

@Controller
@SessionAttributes("country")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private CountryService countryService;

	@RequestMapping("/user/{idCountry}")
	public String showUser(Model model,@ModelAttribute("result") String result , @PathVariable("idCountry") int id) {
		Country country = countryService.findById(id);
		model.addAttribute("country", country);
		model.addAttribute("user", new User());
		model.addAttribute("result", result);
		model.addAttribute("users",userService.findAll(id));
		return "user";
	}

	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	public String handleUser(@ModelAttribute("user") User user, 
			@ModelAttribute("country") Country country, 
			Model model, RedirectAttributes r) {
		
		userService.save(user, country);
		r.addFlashAttribute("result","Se han realizado los cambios exitosamente\n");
		
		return "redirect:/user/"+country.getIdCountry();
	}

}
