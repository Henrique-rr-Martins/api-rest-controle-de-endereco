package com.projetozup.projetozup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetozup.projetozup.util.JpaUtil;

@SpringBootApplication
public class ProjetozupApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetozupApplication.class, args);
		
		
		System.out.println(JpaUtil.getEntityManager().isOpen());
	}

}
