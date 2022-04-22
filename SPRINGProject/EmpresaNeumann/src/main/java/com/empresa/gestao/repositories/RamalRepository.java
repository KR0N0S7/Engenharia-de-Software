package com.empresa.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.gestao.entities.Ramal;

@Repository
public interface RamalRepository extends JpaRepository<Ramal, Long> {

	
}