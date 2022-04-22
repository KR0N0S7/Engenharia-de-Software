package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.Pessoa;
import com.empresa.gestao.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa salvarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public List<Pessoa> listarPessoas() {
		return pessoaRepository.findAll();
	}
	
	public Pessoa obterPessoa(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		return pessoa.get();
	}
	
	public void excluirPessoa(Long id) {
		pessoaRepository.deleteById(id);
	}
}
