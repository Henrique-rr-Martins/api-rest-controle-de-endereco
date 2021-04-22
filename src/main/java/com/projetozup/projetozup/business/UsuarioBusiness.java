package com.projetozup.projetozup.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetozup.projetozup.repository.UsuarioRepository;
import com.projetozup.projetozup.util.UsuarioListaRetorno;

public class UsuarioBusiness {
	
	@Autowired
	private UsuarioRepository repositorio;
	
	@SuppressWarnings("finally")
	public UsuarioListaRetorno findAll() {
		UsuarioListaRetorno retorno = new UsuarioListaRetorno();
		retorno.setCdRetorno(204);
		
		try {
			retorno.setListaUsuario(this.repositorio.findAll());
			retorno.setCdRetorno(200);
			retorno.setMsgRetorno("Sucesso.");
			
		} catch (NullPointerException e) {
			retorno.setListaUsuario(null);
			retorno.setMsgRetorno("Dados inexistentes.");
		}catch(Exception e) {
			retorno.setListaUsuario(null);
			retorno.setMsgRetorno("Houve algum erro durante a requisição.");
		}finally {
			return retorno;
		}
		
	}
}
