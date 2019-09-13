package com.example.workshophelloservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class WorkshopHelloServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =  SpringApplication.run(WorkshopHelloServiceApplication.class, args);
		String[] beans = ctx.getBeanDefinitionNames();
		for (String bean: beans) {
			System.out.println(bean);
		}
		System.out.println(">>>" + ctx.getBeanDefinitionCount());
	}

}
