package com.gaig.poc.documentcreation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.gaig.poc.documentcreation.services")
@ComponentScan({"com.gaig.poc.documentcreation", "org.springframework.amqp.core"})
//@ComponentScan(basePackageClasses = {ExampleController.class, ExampleModel.class, ExmapleView.class})
public class DocumentCreationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentCreationServiceApplication.class, args);
	}

}
