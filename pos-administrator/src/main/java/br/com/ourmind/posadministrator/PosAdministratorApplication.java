package br.com.ourmind.posadministrator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PosAdministratorApplication implements CommandLineRunner {

	@Value("${spring.datasource.password}")
	private String pass;
	
	public static void main(String[] args) {
		SpringApplication.run(PosAdministratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.pass);
	}

}
