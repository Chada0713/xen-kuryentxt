package com.xenenergy.projects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class KuryentxtWebsiteApplication extends WebMvcConfigurerAdapter {


    public static void main(String[] args) {
        SpringApplication.run(KuryentxtWebsiteApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/ext/**").addResourceLocations("file:///C:/Kuryentxtweb/ext/");
    }
}
