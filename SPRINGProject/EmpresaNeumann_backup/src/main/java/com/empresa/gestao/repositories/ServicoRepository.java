package com.empresa.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.gestao.entities.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

	
}
