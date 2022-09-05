package com.Ciclo3.ProyectoArray;

import com.Ciclo3.ProyectoArray.modelos.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class ProyectoArrayApplication {

	@GetMapping("/hello")
	public String hello(){
		return "Hola equipo Array... Saldremos vivos de esto!";
	}

	@GetMapping("/test")
	public String test(){
		Empresa empresa1 = new Empresa("Tekman SAS","calle la alegria","3112633288","800212132-3");
		empresa1.setNombre("Vision y Proyectos");
		////hasta aqui ya se instancio una empresa se definieron los datos iniciales, y luego se renombro
		return empresa1.getNombre();
	}

	public static void main(String[] args) {

		SpringApplication.run(ProyectoArrayApplication.class, args);

	}

}
