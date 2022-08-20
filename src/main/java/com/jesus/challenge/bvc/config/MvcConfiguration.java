package com.jesus.challenge.bvc.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
