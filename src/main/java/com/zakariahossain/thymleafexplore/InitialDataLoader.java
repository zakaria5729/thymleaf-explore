package com.zakariahossain.thymleafexplore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.zakariahossain.thymleafexplore.models.Country;
import com.zakariahossain.thymleafexplore.repositories.CountryRepository;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		countryRepository.saveAll(getCountries());
	}
	
	private List<Country> getCountries() {
		List<Country> countries = new ArrayList<>();
		
		countries.add(new Country("Earth", "World"));
		countries.add(new Country("Bangladesh", "Dhaka"));
		countries.add(new Country("India", "New Delhi"));
		countries.add(new Country("Pakistan", "Islamabad"));
		countries.add(new Country("Srilanka", "Colombo"));
		countries.add(new Country("China", "Beijing"));
		countries.add(new Country("Nepal", "Kathmandu"));
		countries.add(new Country("Afganistal", "Kabul"));
		countries.add(new Country("Australia", "Canbera"));
		countries.add(new Country("England", "London"));
		countries.add(new Country("Italy", "Rome"));
		countries.add(new Country("Spain", "Madrid"));
		countries.add(new Country("France", "Paris"));
		countries.add(new Country("Canada", "Ottawa"));
		countries.add(new Country("Turkey", "Ankara"));
		countries.add(new Country("Egypt", "Cairo"));
		countries.add(new Country("Russia", "Moscow"));
		
		return countries;
	}
}
