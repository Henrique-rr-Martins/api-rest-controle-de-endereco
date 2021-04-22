package com.projetozup.projetozup.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetozup.projetozup.entidade.Usuario;
import com.projetozup.projetozup.repository.UsuarioRepository;
import com.projetozup.projetozup.util.UsuarioListaRetorno;
import com.projetozup.projetozup.util.UsuarioObjRetorno;

@Service
public class UsuarioBusiness {
	
	@Autowired
	private UsuarioRepository repositorio;
	
	public UsuarioListaRetorno buscarTodos() {
		UsuarioListaRetorno retorno = new UsuarioListaRetorno();
		retorno.setCdRetorno(204);
		
//		try {
//			retorno.setListaUsuario(this.repositorio.findAll());
//			retorno.setCdRetorno(200);
//			retorno.setMsgRetorno("Sucesso.");
//			
//		} catch (NullPointerException e) {
//			retorno.setListaUsuario(null);
//			retorno.setMsgRetorno("Dados inexistentes.");
//		}catch(Exception e) {
//			retorno.setListaUsuario(null);
//			retorno.setMsgRetorno("Houve algum erro durante a requisição.");
//		}
		
		retorno.setListaUsuario(this.repositorio.findAll());
		
		return retorno;
		
	}
	
	public UsuarioObjRetorno salvar(Usuario usuario) {
		UsuarioObjRetorno retorno = new UsuarioObjRetorno();
		
		retorno = null;
		this.repositorio.save(usuario);
//		retorno.setCdRetorno(400);
//		retorno.setUsuario(usuario);
//		
//		this.repositorio.save(usuario);
//		if(usuario != null && usuario.getCpf() != null && usuario.getCpf().trim().length() >= 11 && usuario.getEmail() != null && usuario.getEmail().trim().length() > 0) {
//			try {
//				retorno.setUsuario(this.repositorio.save(usuario));
//				retorno.setCdRetorno(201);
//				retorno.setMsgRetorno("Sucesso.");
//			} catch(NullPointerException e){
//				retorno.setMsgRetorno("Usuário de cpf " + usuario.getCpf() + " não  foi salvo.");
//			} catch (Exception e) {
//				retorno.setMsgRetorno("Processo não pôde ser finalizado.");
//			}
//		}else {
//			retorno.setMsgRetorno("Por favor preencha cpf e email.");
//		}
		
		return retorno;
	}
}
