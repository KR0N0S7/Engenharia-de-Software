package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.OrdemServico;
import com.empresa.gestao.repositories.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	public OrdemServico salvarOrdemServico(OrdemServico ordemServico) {
		return ordemServicoRepository.save(ordemServico);
	}
	
	public List<OrdemServico> listarOrdensServicos() {
		return ordemServicoRepository.findAll();
	}
	
	public OrdemServico obterOrdemServico(Long id) {
		Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(id);
		return ordemServico.get();
	}
	
	public void excluirOrdemServico(Long id) {
		ordemServicoRepository.deleteById(id);
	}
}
