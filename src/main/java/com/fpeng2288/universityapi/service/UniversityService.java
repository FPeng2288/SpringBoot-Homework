package com.fpeng2288.universityapi.service;

import com.fpeng2288.universityapi.model.UniversityResponse;

import java.util.List;

/**
 * ClassName: UniversityService
 * Package: com.fpeng2288.universityapi.service
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/15 0:19
 * @version 1.0
 */
public interface UniversityService {

    UniversityResponse[] getUniversitiesByCountry(String country);

    List<UniversityResponse> getUniversitiesByCountries(List<String> countries);

    UniversityResponse[] getAllUniversities();
}
