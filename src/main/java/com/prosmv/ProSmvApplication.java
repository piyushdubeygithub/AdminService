package com.prosmv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProSmvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProSmvApplication.class, args);
	}

}
