package com.projetozup.projetozup.util;

import java.util.Collection;

import com.projetozup.projetozup.entidade.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioListaRetorno {
	private int cdRetorno;
	private String msgRetorno;
	private Collection<Usuario> listaUsuario;
}
