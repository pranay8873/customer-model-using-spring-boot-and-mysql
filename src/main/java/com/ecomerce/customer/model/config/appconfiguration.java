package com.ecomerce.customer.model.config;

import ch.qos.logback.core.model.Model;
import com.ecomerce.customer.model.repository.customerrepo;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.modelmbean.ModelMBean;

@Configuration
public class appconfiguration{
    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }

}
