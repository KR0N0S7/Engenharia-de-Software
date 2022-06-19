package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.Ramal;
import com.empresa.gestao.repositories.RamalRepository;

@Service
public class RamalService {

	@Autowired
	private RamalRepository ramalRepository;
	
	public Ramal salvarRamal(Ramal ramal) {
		return ramalRepository.save(ramal);
	}
	
	public List<Ramal> listarRamais() {
		return ramalRepository.findAll();
	}
	
	public Ramal obterRamal(Long id) {
		Optional<Ramal> ramal = ramalRepository.findById(id);
		return ramal.get();
	}
	
	public void excluirRamal(Long id) {
		ramalRepository.deleteById(id);
	}
}
