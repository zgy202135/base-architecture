package com.julius.base.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationEventMulticaster;

@SpringBootApplication
@EnableDiscoveryClient
public class BaseBusApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseBusApplication.class, args);
	}
}
