  
package com.projetozup.projetozup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetozup.projetozup.entidade.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}