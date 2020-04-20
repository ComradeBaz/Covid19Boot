package com.domrade.Covid19Boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = { "com.domrade.services", "com.domrade.interfaces", "com.domrade.dao",
		"com.domrade.beans", "com.domrade.chartjs", "com.domrade.rest", "com.domrade.service.controllers" })
@EntityScan(basePackages = { "com.domrade.entity" })
@Configuration
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
public class Covid19BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19BootApplication.class, args);
	}

}
