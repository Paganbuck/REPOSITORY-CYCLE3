package com.Ciclo3.ProyectoArray;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class ProyectoArrayApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProyectoArrayApplication.class, args);

	}

}
