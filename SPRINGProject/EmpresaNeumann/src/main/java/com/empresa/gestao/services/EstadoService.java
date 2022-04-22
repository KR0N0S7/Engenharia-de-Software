package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.Estado;
import com.empresa.gestao.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado salvarEstado(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public List<Estado> listarEstados() {
		return estadoRepository.findAll();
	}
	
	public Estado obterEstado(Long id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		return estado.get();
	}
	
	public void excluirEstado(Long id) {
		estadoRepository.deleteById(id);
	}
}
