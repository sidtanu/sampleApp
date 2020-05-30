package com.gaig.proxy.empower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmpowerProxyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpowerProxyServiceApplication.class, args);
	}

}
