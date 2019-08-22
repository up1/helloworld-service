package com.example.workshophelloservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class WorkshopHelloServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopHelloServiceApplication.class, args);
	}

}
