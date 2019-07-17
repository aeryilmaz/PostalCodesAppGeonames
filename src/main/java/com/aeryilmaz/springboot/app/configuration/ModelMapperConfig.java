package com.aeryilmaz.springboot.app.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper createModelMapper()
    {
        return new ModelMapper();
    }
}
