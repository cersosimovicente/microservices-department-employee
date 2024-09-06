package com.microservice.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceDepartmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDepartmentApplication.class, args);
	}
}
