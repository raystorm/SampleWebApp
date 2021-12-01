package com.github.raystorm.sample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *  Initialize Wicket as a Spring Boot Application
 */
@SpringBootApplication
public class SampleApplication
{
    public static void main(String[] args) throws Exception
    {
       new SpringApplicationBuilder()
             .sources(SampleApplication.class)
             .run(args);
    }



}
