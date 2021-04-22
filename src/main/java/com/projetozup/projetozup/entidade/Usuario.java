package com.projetozup.projetozup.entidade;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
	@SequenceGenerator(name = "SEQ_ID_USUARIO", schema = "ZUP", sequenceName = "SEQ_ID_USUARIO", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_ID_USUARIO", strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private long idUsuario;
	
	@Column(name="cpf")
	private String cpf;
	@Column(name="nm_usuario")
	private String nmUsuario;
	@Column(name="email")
	private String email;
	@Column(name="dt_nasc")
	private LocalDate dtNasc;
}
