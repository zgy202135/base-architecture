package com.julius.base.organization;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "com.julius.base.organization.mapper")
public class BaseOrganizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseOrganizationApplication.class, args);
	}

}
