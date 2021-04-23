package com.projetozup.projetozup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetozup.projetozup.business.UsuarioBusiness;
import com.projetozup.projetozup.entidade.Usuario;

@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {
	
	@Autowired
	private UsuarioBusiness business;
	
	@GetMapping
	public ResponseEntity<?> buscarTodos() {
		return business.buscarTodos();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Long idUsuario) {
		return business.buscarPorId(idUsuario);
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Usuario usuario) {
		return business.salvar(usuario);
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<?> atualizar(@PathVariable(name = "id") Long idUsuario, @RequestBody Usuario usuario){
		return business.atualizar(idUsuario, usuario);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<?> deletar(@PathVariable(name = "id") Long idUsuario){
		return business.deletar(idUsuario);
	}
}
