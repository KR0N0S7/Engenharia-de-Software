package com.empresa.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.gestao.entities.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

	
}