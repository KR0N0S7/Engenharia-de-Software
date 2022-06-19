package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.Telefone;
import com.empresa.gestao.repositories.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;
	
	public Telefone salvarTelefone(Telefone telefone) {
		return telefoneRepository.save(telefone);
	}
	
	public List<Telefone> listarTelefones() {
		return telefoneRepository.findAll();
	}
	
	public Telefone obterTelefone(Long id) {
		Optional<Telefone> telefone = telefoneRepository.findById(id);
		return telefone.get();
	}
	
	public void excluirTelefone(Long id) {
		telefoneRepository.deleteById(id);
	}
}
