package com.tobrasil.aluno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class AlunoApplication {
	private static final Logger log = LoggerFactory.getLogger(AlunoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AlunoApplication.class, args);
		log.info(">>>>>>>>>>> Serviço pronto!");
		System.out.println(">>>>>>>>>>> Serviço pronto!");
	}

}
