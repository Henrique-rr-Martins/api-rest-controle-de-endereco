package com.projetozup.projetozup;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetozup.projetozup.util.JpaUtil;

@SpringBootApplication
public class ProjetozupApplication {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("pt", "BR"));
		SpringApplication.run(ProjetozupApplication.class, args);
		
		JpaUtil.testaConexao();
	}

}
