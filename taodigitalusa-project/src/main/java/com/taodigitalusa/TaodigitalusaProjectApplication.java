package com.taodigitalusa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.taodigitalusa.controller.ProductController;

@SpringBootApplication
public class TaodigitalusaProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(TaodigitalusaProjectApplication.class, args);
		//ProductController c = ctx.getBean(ProductController.class);
		//System.out.println(c);
	}

}
