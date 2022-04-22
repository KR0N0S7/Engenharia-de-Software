package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.CNAE;
import com.empresa.gestao.repositories.CNAERepository;

@Service
public class CNAEService {
		
	@Autowired
	private CNAERepository cnaeRepository;
	
	public CNAE salvarCNAE(CNAE cnae) {
		return cnaeRepository.save(cnae);
	}
	
	public List<CNAE> listarCNAEs() {
		return cnaeRepository.findAll();
	}
	
	public CNAE obterCNAE(long id) {
		Optional<CNAE> cnae = cnaeRepository.findById(id);
		return cnae.get();
	}
	
	public void excluirCNAE(Long id) {
		cnaeRepository.deleteById(id);
	}
}
