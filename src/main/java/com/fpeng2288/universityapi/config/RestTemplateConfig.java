package com.fpeng2288.universityapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: RestTemplateConfig
 * Package: com.fpeng2288.universityapi.config
 * Description:
 *
 * @author Fan Peng
 * Create 2024/12/14 22:51
 * @version 1.0
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
