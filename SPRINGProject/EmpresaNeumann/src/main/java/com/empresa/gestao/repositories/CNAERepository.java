package com.empresa.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.gestao.entities.CNAE;

@Repository
public interface CNAERepository extends JpaRepository<CNAE, Long> {
		
	
}
