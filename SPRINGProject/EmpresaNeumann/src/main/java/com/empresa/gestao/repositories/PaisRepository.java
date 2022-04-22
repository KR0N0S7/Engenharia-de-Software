package com.empresa.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.gestao.entities.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

	
	
}
