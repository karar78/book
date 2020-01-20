package com.penguinrandomhouse.consumer.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;

/**
 * Custom RestTemplate builder.
 *
 * @author Karar
 * @since 2020-01-20
 */
@Configuration
public class RestTemplateClient {

	/**
	 * Provide customised RestTemplate object for the whole application.
	 *
	 * @param builder injected RestTemplateBuilder object
	 */
    @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {

		// create customised object mapper for Jackson data binding
		ObjectMapper objectMapper = new ObjectMapper();

		// ignore unmapped fields
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		// some data, e.g. Work; has 1..n multiplicity.
		// The deserialiser should be able to handle this condition
		// by converting both single and multiple values into array.
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

		// create new jackson http message converter with the object mapper above
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(objectMapper);

		// update object mapper of all jackson http message converters
		RestTemplate restTemplate = builder.build();
		Iterator<HttpMessageConverter<?>> it = restTemplate.getMessageConverters().iterator();
		while (it.hasNext()) {
			HttpMessageConverter conv = it.next();
			if (conv instanceof MappingJackson2HttpMessageConverter) {
				((MappingJackson2HttpMessageConverter) conv).setObjectMapper(objectMapper);
			}
		}

		return restTemplate;
	}
}
