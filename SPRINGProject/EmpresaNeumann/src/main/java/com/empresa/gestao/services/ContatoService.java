package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.Contato;
import com.empresa.gestao.repositories.ContatoRepository;

@Service
public class ContatoService extends PessoaService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	public Contato salvarContato(Contato contato) {
		return contatoRepository.save(contato);
	}
	
	public List<Contato> listarContatos() {
		return contatoRepository.findAll();
	}
	
	public Contato obterContato(Long id) {
		Optional<Contato> contato = contatoRepository.findById(id);
		return contato.get();
	}
	
	public void excluirContato(Long id) {
		contatoRepository.deleteById(id);
	}
}
