package com.project.fleet;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class FleetApplication {
	
	


	public static void main(String[] args) throws SQLException {
		ConfigurableApplicationContext run = SpringApplication.run(FleetApplication.class, args);
		//FleetApplication app = new FleetApplication();
		
	}

}
