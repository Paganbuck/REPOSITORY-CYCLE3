package com.Ciclo3.ProyectoArray;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class ProyectoArrayApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProyectoArrayApplication.class, args);

	}
/*El dia 10 de septiembre se presento el backend de la aplicacion al tutor y se
comprueba que corre correctamente con las requests GET, POST, PATCH, DELETE.
ya puede pasarse el avance de la apliacion a la rama release.
 */

	///a partir de este momento se crea la rama release en el repositorio local
}
