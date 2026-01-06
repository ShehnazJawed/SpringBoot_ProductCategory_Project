package com.shehnaz.ProductCategories;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;

@OpenAPIDefinition(
		info = @Info(
				title = "Product Service Rest API documentation",
				description = "Product Service Rest API",
				version = "v1",
				contact = @Contact(
						name = "Shehnaz Jawed",
						email = "shehnazjavaid55@gmail.com"
				)
				//,
//				externalDocs= @ExternalDocumentation(
//						description = "This is Api external document",
//						url = "shehnazjawed.com"
//				)
		)
)
@SpringBootApplication
public class ProductCategoriesApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductCategoriesApplication.class, args);
	}

}
