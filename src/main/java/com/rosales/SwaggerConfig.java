package com.rosales;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
//@EnableSwagger2
//https://github.com/spring-projects/spring-hateoas/issues/1094
//https://github.com/springfox/springfox/issues/2932
public class SwaggerConfig {
	

	/*public static final Contact DEFAULT_CONTACT = new Contact("MitoCode Network", "https://www.mitocode.com",
			"cursos@mitocodenetwork.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Mediapp Api Documentation", "Mediapp Api Documentation", "1.0",
			"PREMIUM", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
			new ArrayList<>());

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
	}*/
}
