package com.empresa.gestao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.Fornecedor;
import com.empresa.gestao.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}

	public List<Fornecedor> listarFornecedores() {
		return fornecedorRepository.findAll();
	}
	
	
}
