package com.projetozup.projetozup.entidade;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Endereco")
@Table(name = "Endereco")
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_ID_ENDERECO", schema = "ZUP", sequenceName = "SEQ_ID_ENDERECO", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_ID_ENDERECO", strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long idEndereco;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_usuario")
	@JsonBackReference
	private Usuario usuario;
	
	@Column(name = "cep")
	private String cep;
	@Column(name = "logradouro")
	private String logradouro;
	@Column(name = "numero")
	private int numero;
	@Column(name = "complemento")
	private String complemento;
	@Column(name = "bairro")
	private String bairro;
	@Column(name = "cidade")
	private String cidade;
	@Column(name = "uf")
	private String uf;
}