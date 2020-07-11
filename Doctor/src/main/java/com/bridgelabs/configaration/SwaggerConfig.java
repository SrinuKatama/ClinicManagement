package com.bridgelabs.configaration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig 
{
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.
				basePackage("com.bridgelabs")).build();
	}
	
	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Bean(name = "OBJECT_MAPPER_BEAN") public ObjectMapper jsonObjectMapper() {
	 * return Jackson2ObjectMapperBuilder.json()
	 * .serializationInclusion(Include.NON_NULL) // Don’t include null values
	 * .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) //ISODate
	 * .modules(new JSR310Module())
	 * 
	 * .build(); }
	 */
	

}