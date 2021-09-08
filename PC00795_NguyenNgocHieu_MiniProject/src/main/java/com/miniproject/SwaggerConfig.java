package com.miniproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Java Techie").apiInfo(apiInfo()).select()
				.paths(regex("/.*")).build();
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Shop Service")
				.description("Welcom To hieunnpc00795 Shop")
				.termsOfServiceUrl("http://localhost:8080/home/index")
				.license("Go To Shop")
				.licenseUrl("http://localhost:8080/home/index").version("1.0").build();
	}
}
