package be.ipam.cryptowallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CryptowalletApplication {

	@Bean
	public Docket api() { 
		return new Docket(DocumentationType.OAS_30)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.any())              
	          .paths(PathSelectors.any())                          
	          .build();                                           
	}	
	
	public static void main(String[] args) {
		SpringApplication.run(CryptowalletApplication.class, args);
	}
		

	
	
	
}
