package com.julius.base.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BaseOrganizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseOrganizationApplication.class, args);
	}

}
