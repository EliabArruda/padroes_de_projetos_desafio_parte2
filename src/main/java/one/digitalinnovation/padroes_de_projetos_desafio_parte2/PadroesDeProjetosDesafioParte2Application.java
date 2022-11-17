package one.digitalinnovation.padroes_de_projetos_desafio_parte2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot
   construído com as seguintes dependências:

 * Spring Data Jpa
 * String Web
 * H2 Data Base
 * OpenFeign
 *
 */

@EnableFeignClients
@SpringBootApplication
public class PadroesDeProjetosDesafioParte2Application {

	public static void main(String[] args) {
		SpringApplication.run(PadroesDeProjetosDesafioParte2Application.class, args);
	}

}
