package com.br.jotab.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		// WebMvcConfigurer.super.configureContentNegotiation(configurer);

		// http://localhost:8080/api/person/v1?mediaType=xml - HTTPS de required of
		// content negotiation via QUERY PARAM

		/*
		configurer.favorParameter(true)

				.parameterName("mediaType").ignoreAcceptHeader(true).useRegisteredExtensionsOnly(false)
				.defaultContentType(MediaType.APPLICATION_JSON).mediaType("json", MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML);
		
		
		// http://localhost:8080/api/person/v1?mediaType=xml - HTTPS de required of
				// content negotiation via HEADER PARAM
*/
				configurer.favorParameter(false)

						.ignoreAcceptHeader(false).useRegisteredExtensionsOnly(false)
						.defaultContentType(MediaType.APPLICATION_JSON)
							.mediaType("json", MediaType.APPLICATION_JSON)
							.mediaType("xml", MediaType.APPLICATION_XML)
				            .mediaType("x-yaml",MEDIA_TYPE_APPLICATION_YML);
	}

}
