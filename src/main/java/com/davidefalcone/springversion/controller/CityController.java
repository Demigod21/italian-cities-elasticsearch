package com.davidefalcone.springversion.controller;


import com.davidefalcone.springversion.repository.CityRepository;
import com.davidefalcone.springversion.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/search")
    public List<City> searchCitiesByName(@RequestParam String name) {
        return cityRepository.findByDenominazioneInItalianoContainingIgnoreCase(name);
    }
}
