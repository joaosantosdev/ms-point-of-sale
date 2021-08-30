package br.com.ourmind.posconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class PosConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosConfigServerApplication.class, args);
	}

}
