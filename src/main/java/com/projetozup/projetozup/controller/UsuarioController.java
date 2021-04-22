package com.projetozup.projetozup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetozup.projetozup.business.UsuarioBusiness;
import com.projetozup.projetozup.util.UsuarioListaRetorno;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {
	
	private UsuarioBusiness business = new UsuarioBusiness();
	
	@GetMapping
	public UsuarioListaRetorno findAll() {
		return business.findAll();
	}
}
