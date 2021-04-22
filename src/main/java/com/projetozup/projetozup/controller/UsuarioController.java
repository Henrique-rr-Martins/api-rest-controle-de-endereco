package com.projetozup.projetozup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetozup.projetozup.business.UsuarioBusiness;
import com.projetozup.projetozup.entidade.Usuario;
import com.projetozup.projetozup.util.UsuarioListaRetorno;
import com.projetozup.projetozup.util.UsuarioObjRetorno;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {
	
	@Autowired
	private UsuarioBusiness business;
	
	@GetMapping
	public UsuarioListaRetorno buscarTodos() {
		return business.buscarTodos();
	}
	
	@PostMapping
	public UsuarioObjRetorno salvar(@RequestBody Usuario usuario) {
		
		return business.salvar(usuario);
	}
}
