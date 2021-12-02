package com.github.raystorm.sample;

import com.giffing.wicket.spring.boot.starter.app.WicketBootStandardWebApplication;
import com.github.raystorm.sample.pages.HomePage;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.wicketstuff.annotation.scan.AnnotatedMountScanner;

/**
 *  Initialize Wicket as a Spring Boot Application
 */
@SpringBootApplication
public class SampleApplication
{
    public static void main(String[] args) throws Exception
    { SpringApplication.run(SampleApplication.class, args); }
}
