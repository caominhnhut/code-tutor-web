package com.vn.green.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vn.green.common.constant.Constants;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {
		Constants.ALL_MODULE,
		Constants.PERSISTENT_SERVICE
})
@EnableJpaRepositories(basePackages = {
		Constants.PERSISTENT_REPOSITORY
})
@EntityScan(basePackages = {
		Constants.PERSISTENT_ENTITY
})
@PropertySources({
		@PropertySource("classpath:liquibase.properties"),
		@PropertySource("classpath:persistent.properties"),
		@PropertySource("classpath:document.properties")
})
public class CodeTutorApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(CodeTutorApplication.class, args);
	}
}
