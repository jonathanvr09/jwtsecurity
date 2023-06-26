package com.dh.store.carRent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Clock;

@SpringBootApplication
public class CarRentApplication {
	public static void main(String[] args) {
		SpringApplication.run(CarRentApplication.class, args);}

	@Bean
	public Clock clock(){
		return Clock.systemDefaultZone();
	}

}
