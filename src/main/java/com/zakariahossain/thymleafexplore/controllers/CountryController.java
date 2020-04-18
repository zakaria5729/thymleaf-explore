package com.zakariahossain.thymleafexplore.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zakariahossain.thymleafexplore.models.Country;
import com.zakariahossain.thymleafexplore.repositories.CountryRepository;

@Controller
public class CountryController {

	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping("/")
	public String showPage(Model model, @RequestParam(defaultValue = "1") int page) {
		Pageable pageable = PageRequest.of(page-1, 4, Sort.by("id").descending());
		model.addAttribute("countryList", countryRepository.findAll(pageable));
		model.addAttribute("currentPage", page);
		return "index";
	}
	
	@PostMapping("/save")
	public String saveCountry(@Valid Country country) {
		countryRepository.save(country);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteCountry(Long id) {
		countryRepository.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/get_country")
	@ResponseBody
	public Optional<Country> getCountry(Long id) {
		return countryRepository.findById(id);
	}
	
//	@GetMapping("/error")
//	public String errorMessage() {
//		return "error";
//	}
}
