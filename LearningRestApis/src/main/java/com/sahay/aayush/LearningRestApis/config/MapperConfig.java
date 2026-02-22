package com.sahay.aayush.LearningRestApis.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    //we make different beans here

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
