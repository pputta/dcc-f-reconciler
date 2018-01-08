package com.ctl.dccf.reconciler;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.google.common.base.Predicates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by pramod on 1/8/2018.
 */
@SpringBootApplication
@EnableSwagger2
public class ReconcilerServiceApplication {
	//Replace the word template below with actual template name - eg: dcc-driver
	@Bean
	public Docket serviceApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("dcc-f-reconciler")
				.apiInfo(apiInfo()).select().paths(Predicates.not(PathSelectors.regex("/error"))).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Reconciler Micro Service")
				.description("Reconciler Micro service")
				.termsOfServiceUrl("http://www.centurylink.com/")
				.contact(new Contact("CenturyLink Inc.", "http://www.centurylink.com/", ""))
				.licenseUrl("http://www.centurylink.com/").version("1.0").build();
	}

	@Bean
	@Primary
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.requestFactory(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
				.messageConverters(new MappingJackson2HttpMessageConverter())
				.build();
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
		return (Jackson2ObjectMapperBuilder builder) -> {
				builder.dateFormat(new ISO8601DateFormat());
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ReconcilerServiceApplication.class, args);
	}
}
