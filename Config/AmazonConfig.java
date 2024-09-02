package com.amazonapi.amazonapi.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AmazonConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
