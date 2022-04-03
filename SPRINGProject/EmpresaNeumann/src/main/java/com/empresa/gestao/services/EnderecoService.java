package com.empresa.gestao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.Endereco;
import com.empresa.gestao.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco salvarEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public List<Endereco> listarEndereco() {
		return enderecoRepository.findAll();
	}
}
