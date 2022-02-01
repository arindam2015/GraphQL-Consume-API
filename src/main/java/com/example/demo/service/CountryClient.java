package com.example.demo.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.model.CountryDTO;
import com.example.demo.model.GrapgqlRequestBody;
import com.example.demo.util.GraphqlSchemaReaderUtil;

import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
	@Slf4j
	public class CountryClient {
	private final WebClient webClient;
	 @Value("${graphql.endpoint}")
	  private String url;
	 
	  public CountryClient(WebClient.Builder webClientBuilder) {
		  this.webClient = webClientBuilder.baseUrl(url).build();
		  }

	  public Mono<CountryDTO> getCountryDetails(final String countryCode) throws IOException {
        log.info("url::"+url);
	    //WebClient webClient = WebClient.builder().build();

	    GrapgqlRequestBody graphQLRequestBody = new GrapgqlRequestBody();

	    final String query = GraphqlSchemaReaderUtil.getSchemaFromFileName("getCountryDetails");
	    final String variables = GraphqlSchemaReaderUtil.getSchemaFromFileName("variables");
        log.info("CountryCode::"+countryCode);
	    graphQLRequestBody.setQuery(query);
	    graphQLRequestBody.setVariables(variables.replace("countryCode", countryCode));

	    return webClient.post()
	        .uri(url)
	        .bodyValue(graphQLRequestBody)
	        .retrieve()
	        .bodyToMono(CountryDTO.class);
	         //.block();
	  }
	}


