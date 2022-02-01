package com.example.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.CountryDTO;
import com.example.demo.service.CountryClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class GraphqlConsumeDemoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(GraphqlConsumeDemoApplication.class, args);
		/*ConfigurableApplicationContext context =SpringApplication.run(GraphqlConsumeDemoApplication.class, args);
		CountryClient client = (CountryClient) context.getBean("countryClient");
	    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	    CountryDTO countryDto = client.getCountryDetails("BE");
	    log.info(ow.writeValueAsString(countryDto));*/
	}

}
