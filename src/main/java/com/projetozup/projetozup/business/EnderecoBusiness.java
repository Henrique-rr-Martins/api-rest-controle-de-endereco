package com.projetozup.projetozup.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import com.projetozup.projetozup.entidade.Endereco;
import com.projetozup.projetozup.repository.EnderecoRepository;

@Service
public class EnderecoBusiness {

	@Autowired
	private EnderecoRepository repositorio;

	public ResponseEntity<?> buscarTodos() {
		try {
			Collection<Endereco> lista = this.repositorio.findAll();
			return new ResponseEntity<Collection<Endereco>>(lista, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Erro desconhecido. Entrar em contato com o administrador",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> buscarPorId(Long idEndereco) {
		try {

			Optional<Endereco> endereco = this.repositorio.findById(idEndereco);

			if (endereco.orElseGet(() -> null) != null) {
				return new ResponseEntity<Endereco>(endereco.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Não existem dados para  esse endereço.", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Erro desconhecido. Entrar em contato com o administrador",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> salvar(Endereco endereco) {
		try {
			return new ResponseEntity<Endereco>(this.repositorio.save(endereco), HttpStatus.CREATED);
		} catch (JpaSystemException | GenericJDBCException | HttpMessageNotReadableException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Erro no preenchimento dos dados. Favor preencher corretamente.",
					HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Erro desconhecido. Entrar em contato com o administrador",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> atualizar(Long idEndereco, Endereco endereco) {
		try {

			return repositorio.findById(idEndereco).map(record -> {
				record.setCep(endereco.getCep());
				record.setLogradouro(endereco.getLogradouro());
				record.setNumero(endereco.getNumero());
				record.setComplemento(endereco.getComplemento());
				record.setBairro(endereco.getBairro());
				record.setCidade(endereco.getCidade());
				

				Endereco update = repositorio.save(record);

				return new ResponseEntity(update, HttpStatus.CREATED);
			}).orElse(new ResponseEntity<String>("Endereço não encontrado.", HttpStatus.BAD_REQUEST));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Erro desconhecido. Entrar em contato com o administrador",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> deletar(Long idEndereco) {
		try {
			repositorio.deleteById(idEndereco);
			return new ResponseEntity<String>("Endereço de id " + idEndereco + " deletado.", HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Endereço não encontrado.", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Erro desconhecido. Entrar em contato com o administrador",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
