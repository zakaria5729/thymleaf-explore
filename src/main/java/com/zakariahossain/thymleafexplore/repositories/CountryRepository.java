package com.zakariahossain.thymleafexplore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zakariahossain.thymleafexplore.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
