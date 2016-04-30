package com.ism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ism.entity.Country;
import com.ism.service.CountryService;

@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/country")
	public String showAdmin(Model model, @ModelAttribute("result") String result) {

		Country country = new Country();
		model.addAttribute("country", country);
		model.addAttribute("result", result);
		return "country";
	}
	
	@RequestMapping(value="/country/save", method=RequestMethod.POST)
	public String handleCountry(@ModelAttribute("country") Country countryForm, Model model, RedirectAttributes r, @RequestParam("state") String state){
//		model.addAttribute("countryForm",countryForm);
		System.out.println("Request param:"+state);
		System.out.println(countryForm);
		r.addFlashAttribute("result","Se han realizado los cambios exitosamente");
		return "redirect:/country";
	}

}
