package com.infosis.hotel.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

/**
 *
 * @author Johnniray Betancourt
 */
@SpringBootApplication
public class CoreHotel extends SpringBootServletInitializer implements WebApplicationInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        
        return application.sources(CoreHotel.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CoreHotel.class, args);
    }

}
