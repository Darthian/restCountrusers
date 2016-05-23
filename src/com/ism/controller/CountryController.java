package com.ism.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ism.entity.Country;
import com.ism.service.CountryService;

@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/country")
	public String showAdmin(Model model, @ModelAttribute("result") String result) {

		List<Country> countries = countryService.findAll();
		Country country = new Country();
		model.addAttribute("country", country);
		model.addAttribute("result", result);
		model.addAttribute("countries", countries);
		return "country";
	}
	
	@RequestMapping(value="/country/save", method=RequestMethod.POST)
	public String handleCountry(@ModelAttribute("country") Country country, Model model, RedirectAttributes r/*, @RequestParam("state") String state*/){
//		model.addAttribute("countryForm",countryForm);
		System.out.println("id:"+country);
		countryService.saveOrUpdate(country);
		r.addFlashAttribute("result","Se han realizado los cambios exitosamente\n");
		return "redirect:/country";
	}
	
//	/country/${country}/update
	
	@RequestMapping(value="/country/{idCountry}/update")
	public String showUpdate(Model model, @PathVariable("idCountry") int id){
		Country country = countryService.findById(id);
		model.addAttribute("country", country);
		return "country";
	}
	
	@RequestMapping(value="/country/{idCountry}/delete")
	public String showDelete(@PathVariable("idCountry") int id, RedirectAttributes r){
		countryService.delete(id);
		r.addFlashAttribute("result","Se han realizado los cambios exitosamente\n");
		return "redirect:/country";
	}
}
