package com.shehnaz.ProductCategories;

//import io.swagger.v3.oas.annotations.ExternalDocumentation;
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.info.Contact;
//import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.util.logging.Logger;

//@OpenAPIDefinition(
////		info = @Info(
////				title = "Product Service Rest API documentation",
////				description = "Product Service Rest API",
////				version = "v1",
////				contact = @Contact(
////						name = "Shehnaz Jawed",
////						email = "shehnazjavaid55@gmail.com"
////				)
//				//,
////				externalDocs= @ExternalDocumentation(
////						description = "This is Api external document",
////						url = "shehnazjawed.com"
////				)
//		)
//)
@Slf4j
@SpringBootApplication
public class ProductCategoriesApplication {


	//private static final Logger log= LoggerFactory.getLogger(ProductCategoriesApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(ProductCategoriesApplication.class, args);
//		log.info("Product Application Successfully Started!");
//		log.warn("This is warnning message");
//		log.debug("This is debug message");
//		log.error("this is error message");
//		log.trace("This is trace message");
//
	}

}
