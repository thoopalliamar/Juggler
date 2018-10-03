package com.stackroute.juggler.promocodes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient 
@SpringBootApplication
public class PromocodesApplication {

	// This is the main entry point of the application
	public static void main(String[] args) {
		SpringApplication.run(PromocodesApplication.class, args);
	}
}
