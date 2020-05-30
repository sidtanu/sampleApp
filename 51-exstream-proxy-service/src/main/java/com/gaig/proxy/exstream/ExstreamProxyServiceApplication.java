package com.gaig.proxy.exstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExstreamProxyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExstreamProxyServiceApplication.class, args);
	}

}
