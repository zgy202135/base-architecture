package com.julius.base.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BaseCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseCommonApplication.class, args);
	}
}
