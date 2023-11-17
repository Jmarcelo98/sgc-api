package com.jmsports.sgcapi.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Component
public class SwaggerConfig {

	private final String URL_CONTROLS = "com.jmsports.sgcapi.controllers";

//	ativar esse bem quando tiver com security
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metadata())
//				.securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apiKey()))
//
//				.select().apis(RequestHandlerSelectors.basePackage(URL_CONTROLS)).paths(PathSelectors.any()).build();
//	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(URL_CONTROLS))
				.build().apiInfo(metadata());
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("SGC JMSports").description("Management and configuration system")
				.version("1.0.0").build();

	}

	/*
	 * private List<SecurityReference> defaultAuth() { AuthorizationScope
	 * authorizationScope = new AuthorizationScope("global", "accessEverything");
	 * AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	 * authorizationScopes[0] = authorizationScope; return Arrays.asList(new
	 * SecurityReference("JWT", authorizationScopes)); }
	 * 
	 * private SecurityContext securityContext() { return
	 * SecurityContext.builder().securityReferences(defaultAuth()).build(); }
	 * 
	 * private ApiKey apiKey() { return new ApiKey("JWT", "Authorization",
	 * "header"); }
	 */
}