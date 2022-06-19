package com.empresa.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.gestao.entities.TipoEndereco;

@Repository
public interface TipoEnderecoRepository extends JpaRepository<TipoEndereco, Long> {

	
	
}
