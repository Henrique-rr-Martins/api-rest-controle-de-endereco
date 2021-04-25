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

import com.projetozup.projetozup.business.EnderecoBusiness;
import com.projetozup.projetozup.entidade.Endereco;

@RestController
@RequestMapping({"/enderecos"})
public class EnderecoController {

	@Autowired
	private EnderecoBusiness business;
	
	@GetMapping
	public ResponseEntity<?> buscarTodos(){
		return business.buscarTodos();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name = "id") Long idEndereco){
		return business.buscarPorId(idEndereco);
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Endereco endereco){
		return business.salvar(endereco);
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<?> atualizar(@PathVariable(name = "id") Long idEndereco, @RequestBody Endereco endereco){
		return business.atualizar(idEndereco, endereco);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<?> deletar(@PathVariable(name = "id") Long idEndereco){
		return business.deletar(idEndereco);
	}
}
