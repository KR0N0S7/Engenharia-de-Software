package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.Departamento;
import com.empresa.gestao.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public Departamento salvarDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	
	public List<Departamento> listarDepartamentos() {
		return departamentoRepository.findAll();
	}
	
	public Departamento obterDepartamento(Long id) {
		Optional<Departamento> departamento = departamentoRepository.findById(id);
		return departamento.get();
	}
	
	public void excluirDepartamento(Long id) {
		departamentoRepository.deleteById(id);
	}
}
