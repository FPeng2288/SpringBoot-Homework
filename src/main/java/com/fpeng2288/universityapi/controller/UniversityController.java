package com.fpeng2288.universityapi.controller;

import com.fpeng2288.universityapi.model.UniversityResponse;
import com.fpeng2288.universityapi.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName: UniversityController
 * Package: com.fpeng2288.universityapi.controller
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/14 23:00
 * @version 1.0
 */
@RestController
@RequestMapping("/universities")
public class UniversityController {

    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    // GET /universities?country=United+Kingdom
    @GetMapping
    public List<UniversityResponse> getUniversitiesByCountry(@RequestParam String country) {

        UniversityResponse[] responses = universityService.getUniversitiesByCountry(country);

        return Arrays.asList(responses);
    }

    // GET /universities/multi?countries=United+Kingdom&countries=Australia
    @GetMapping("/multi")
    public List<UniversityResponse> getUniversitiesByMultipleCountries(@RequestParam List<String> countries) {

        return universityService.getUniversitiesByCountries(countries);
    }

    // GET /universities/all
    @GetMapping("/all")
    public List<UniversityResponse> getAllUniversities() {
        UniversityResponse[] responses = universityService.getAllUniversities();
        return Arrays.asList(responses);
    }

}
