package com.shoppinglist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.shoppinglist.web.db_service.DatabaseInitialise;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shoppinglist.web"})
public class AppLauncher {
	
	@Autowired
	private DatabaseInitialise databaseInitialise;
	
	public static void main(String[] args) {
		SpringApplication.run(AppLauncher.class, args);
	}

}
