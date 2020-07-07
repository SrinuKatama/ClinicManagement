package com.bridgelabs.configaration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement
@Configuration
public class RestTemplateConfig 
{
	   @Bean
	   public RestTemplate getRestTemplate() 
	   {
	      return new RestTemplate();
	   } 

}
