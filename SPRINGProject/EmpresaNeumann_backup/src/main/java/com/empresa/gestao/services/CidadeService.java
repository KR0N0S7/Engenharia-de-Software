package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.Cidade;
import com.empresa.gestao.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade salvarCidade(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}
	
	public List<Cidade> listarCidades() {
		return cidadeRepository.findAll();
	}
	
	public Cidade obterCidade(Long id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		return cidade.get();
	}
	
	public void excluirCidade(Long id) {
		cidadeRepository.deleteById(id);
	}
}
