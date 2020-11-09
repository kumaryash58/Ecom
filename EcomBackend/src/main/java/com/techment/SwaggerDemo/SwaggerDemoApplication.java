package com.techment.SwaggerDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan()
public class SwaggerDemoApplication extends SpringBootServletInitializer{

//	@Bean
//	public Docket docket() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.techment.SwaggerDemo")).paths(any()).build()
//				.apiInfo(new ApiInfo("Basic Demo Project",
//						"API's for the Address service", "2.0", null,
//						new Contact("LinkedIn Learning","https://www.linkedin.com/learning", ""),
//						null, null, new ArrayList()));
//	}
	

	
	
	//@TestPropertySource(locations = "classpath:application.properties")
	
	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
	
	private static Class<SwaggerDemoApplication> applicationClass = SwaggerDemoApplication.class;
	
	   @RequestMapping("/")
	    public String home(){
	        return "index";
	    }

}
