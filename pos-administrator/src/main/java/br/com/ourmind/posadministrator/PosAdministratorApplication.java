package br.com.ourmind.posadministrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PosAdministratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosAdministratorApplication.class, args);
	}

}
