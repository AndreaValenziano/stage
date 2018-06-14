package com.purepay;

import com.purepay.exceptions.ProxyErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.purepay")
@EnableSwagger2
public class StartBillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartBillingApplication.class, args);
	}

	@Bean
	public ProxyErrorDecoder myErrorDecoder() {
		return new ProxyErrorDecoder();
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.build();

		//.apis(RequestHandlerSelectors.basePackage("guru.springframework.controllers"))
	}
}
