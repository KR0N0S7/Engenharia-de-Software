package com.empresa.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.gestao.entities.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
	
}
