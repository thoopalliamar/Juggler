package com.stackroute.juggler.theatreregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TheatreRegistrationApplication {

	// main entry point of application
	public static void main(String[] args) {
		SpringApplication.run(TheatreRegistrationApplication.class, args);
	}
}
