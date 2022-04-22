package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.Pais;
import com.empresa.gestao.repositories.PaisRepository;

@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;
	
	public Pais salvarPais(Pais pais) {
		return paisRepository.save(pais);
	}
	
	public List<Pais> listarPaises() {
		return paisRepository.findAll();
	}
	
	public Pais obterPais(Long id) {
		Optional<Pais> pais = paisRepository.findById(id);
		return pais.get();
	}
	
	public void excluirPais(Long id) {
		paisRepository.deleteById(id);
	}
}
