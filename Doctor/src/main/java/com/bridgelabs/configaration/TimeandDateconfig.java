package com.bridgelabs.configaration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bridgelabs.utility.LocalDateDeserializer;
import com.bridgelabs.utility.LocalDateSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class TimeandDateconfig {

	/*
	 * @Bean
	 * 
	 * @Primary public ObjectMapper serializingObjectMapper() { ObjectMapper
	 * objectMapper = new ObjectMapper(); JavaTimeModule javaTimeModule = new
	 * JavaTimeModule(); javaTimeModule.addSerializer(LocalDate.class, new
	 * LocalDateSerializer()); javaTimeModule.addDeserializer(LocalDate.class, new
	 * LocalDateDeserializer()); objectMapper.registerModule(javaTimeModule); return
	 * objectMapper; }
	 */

}
