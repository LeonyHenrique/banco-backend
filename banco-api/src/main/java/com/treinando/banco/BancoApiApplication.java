package com.treinando.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.treinando.banco")
public class BancoApiApplication {

	  public static void main(String[] args) {
	        SpringApplication.run(BancoApiApplication.class, args);
	}

}
