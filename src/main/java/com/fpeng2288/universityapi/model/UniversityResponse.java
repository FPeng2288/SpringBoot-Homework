package com.fpeng2288.universityapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * ClassName: UniversityResponse
 * Package: com.fpeng2288.universityapi.model
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/15 0:47
 * @version 1.0
 */
@Data
public class UniversityResponse {

    private List<String> domains;

    @JsonProperty("alpha_two_code")
    private String alphaTwoCode;

    @JsonProperty("web_pages")
    private List<String> webPages;

    private String country;

    private String name;

    @JsonProperty("state-province")
    private String stateProvince;
}
