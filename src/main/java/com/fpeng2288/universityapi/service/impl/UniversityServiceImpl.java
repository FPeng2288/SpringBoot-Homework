package com.fpeng2288.universityapi.service.impl;

import com.fpeng2288.universityapi.exception.ThirdPartyApiException;
import com.fpeng2288.universityapi.model.UniversityResponse;
import com.fpeng2288.universityapi.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * ClassName: UniversityServiceImpl
 * Package: com.fpeng2288.universityapi.service.impl
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/15 0:40
 * @version 1.0
 */
@Service
public class UniversityServiceImpl implements UniversityService {

    private final RestTemplate restTemplate;

    @Autowired
    public UniversityServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public UniversityResponse[] getUniversitiesByCountry(String country) {
        // Call third-party API to get universities by country
        String url = "http://universities.hipolabs.com/search?country=" + country;

        try{
            // Use RestTemplate to call third-party API
            UniversityResponse[] response = restTemplate.getForObject(url, UniversityResponse[].class);
            if (response == null) {
                response = new UniversityResponse[0];
            }
            return response;

        }catch (Exception e){
            throw new ThirdPartyApiException("Failed to get universities data for country: " + country, e);
        }
    }

   /* @Override
   // Stream API to get universities by multiple countries
    public List<UniversityResponse> getUniversitiesByCountries(List<String> countries) {
        return countries.parallelStream()
                .map(this::getUniversitiesByCountry)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }*/

    @Override
    // Use CompletableFuture to implement parallel requests
    public List<UniversityResponse> getUniversitiesByCountries(List<String> countries) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        try {
            List<CompletableFuture<UniversityResponse[]>> futures = countries.stream()
                    .map(country -> CompletableFuture.supplyAsync(() -> getUniversitiesByCountry(country), executor))
                    .collect(Collectors.toList());

            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

            return futures.stream()
                    .map(CompletableFuture::join)
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());

        } finally {
            executor.shutdown();
        }
    }

    @Override
    public UniversityResponse[] getAllUniversities() {
        String url = "http://universities.hipolabs.com/search";

        try {
            UniversityResponse[] response = restTemplate.getForObject(url, UniversityResponse[].class);
            if (response == null) {
                response = new UniversityResponse[0];
            }
            return response;
        } catch (Exception e) {
            throw new ThirdPartyApiException("Failed to get all universities data", e);
        }
    }

}
