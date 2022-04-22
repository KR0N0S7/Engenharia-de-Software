package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.Servico;
import com.empresa.gestao.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;
	
	public Servico salvarServico(Servico servico) {
		return servicoRepository.save(servico);
	}
	
	public List<Servico> listarServicos() {
		return servicoRepository.findAll();
	}
	
	public Servico obterServico(Long id) {
		Optional<Servico> servico = servicoRepository.findById(id);
		return servico.get();
	}
	
	public void excluirServico(Long id) {
		servicoRepository.deleteById(id);
	}
}
