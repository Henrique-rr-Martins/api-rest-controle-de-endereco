package com.projetozup.projetozup.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Usuario")
@Table(name = "Usuario")
public class Usuario {

	@Id
	@Column(name = "id_usuario")
	public long idUsuario;
	
	
}
