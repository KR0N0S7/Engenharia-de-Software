package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.Empresa;
import com.empresa.gestao.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa salvarEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
	public List<Empresa> listarEmpresas() {
		return empresaRepository.findAll();
	}
	
	public Empresa obterEmpresa(Long id) {
		Optional<Empresa> empresa = empresaRepository.findById(id);
		return empresa.get();
	}
	
	public void excluirEmpresa(Long id) {
		empresaRepository.deleteById(id);
	}
}
