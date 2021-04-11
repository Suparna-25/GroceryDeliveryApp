package com.cg.grocerydeliveryapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class GrocerydeliveryapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrocerydeliveryapplicationApplication.class, args);
		System.out.print("Started port 8085");
	}

}
