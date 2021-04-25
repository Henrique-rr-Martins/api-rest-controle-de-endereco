package com.projetozup.projetozup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetozup.projetozup.entidade.Endereco;

@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco, Long>{

}
