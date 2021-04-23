package com.projetozup.projetozup.business;

import java.util.Collection;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import com.projetozup.projetozup.entidade.Usuario;
import com.projetozup.projetozup.repository.UsuarioRepository;

@Service
public class UsuarioBusiness {

	@Autowired
	private UsuarioRepository repositorio;

	public ResponseEntity<?> buscarTodos() {
		try {
			Collection<Usuario> lista = this.repositorio.findAll();
			return new ResponseEntity<Collection<Usuario>>(lista, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Erro desconhecido. Entrar em contato com o administrador",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> buscarPorId(Long idUsuario) {
		try {

			Optional<Usuario> usu = this.repositorio.findById(idUsuario);

			if (usu.orElseGet(() -> null) != null) {
				return new ResponseEntity<Usuario>(usu.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Não existem dados para  esse usuário.", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Erro desconhecido. Entrar em contato com o administrador",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> salvar(Usuario usuario) {
		try {
			return new ResponseEntity<Usuario>(this.repositorio.save(usuario), HttpStatus.CREATED);
		} catch (DataIntegrityViolationException | ConstraintViolationException  e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Integridade violada. Email ou cpf já cadastrados.",
					HttpStatus.BAD_REQUEST);
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
	public ResponseEntity<?> atualizar(Long idUsuario, Usuario usuario) {
		try {

			return repositorio.findById(idUsuario).map(record -> {
				record.setCpf(usuario.getCpf());
				record.setNmUsuario(usuario.getNmUsuario());
				record.setEmail(usuario.getEmail());
				record.setDtNasc(usuario.getDtNasc());

				Usuario update = repositorio.save(record);

				return new ResponseEntity(update, HttpStatus.CREATED);
			}).orElse(new ResponseEntity<String>("Usuário não encontrado.", HttpStatus.BAD_REQUEST));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Erro desconhecido. Entrar em contato com o administrador",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<?> deletar(Long idUsuario) {
		try {
			repositorio.deleteById(idUsuario);
			return new ResponseEntity<String>("Usuário de id " + idUsuario + " deletado.", HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Usuário não encontrado.", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Erro desconhecido. Entrar em contato com o administrador",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
