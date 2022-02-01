package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Country;
import com.example.demo.model.CountryDTO;
import com.example.demo.service.CountryClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/graphql")
@Slf4j
public class GraphqlController {
 @Autowired
 CountryClient client;
 @PostMapping("/post")
 public Mono<CountryDTO> egtCountry(@RequestBody Country country) throws IOException{
	 log.info("Country Code::"+country.getCode());
	 ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	  Mono<CountryDTO> countryDto = client.getCountryDetails(country.getCode());
	  return countryDto;
 }
 
}
