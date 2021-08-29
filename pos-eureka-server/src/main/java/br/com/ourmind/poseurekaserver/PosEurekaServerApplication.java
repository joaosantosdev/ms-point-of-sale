package br.com.ourmind.poseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class PosEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosEurekaServerApplication.class, args);
	}

}
