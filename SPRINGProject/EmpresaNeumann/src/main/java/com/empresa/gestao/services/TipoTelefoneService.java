package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.TipoTelefone;
import com.empresa.gestao.repositories.TipoTelefoneRepository;

@Service
public class TipoTelefoneService {

	@Autowired
	private TipoTelefoneRepository tipoTelefoneRepository;
	
	public TipoTelefone salvarTipoTelefone(TipoTelefone tipoTelefone) {
		return tipoTelefoneRepository.save(tipoTelefone);
	}
	
	public List<TipoTelefone> listarTiposTelefones() {
		return tipoTelefoneRepository.findAll();
	}
	
	public TipoTelefone obterTipoTelefone(Long id) {
		Optional<TipoTelefone> tipoTelefone = tipoTelefoneRepository.findById(id);
		return tipoTelefone.get();
	}
	
	public void excluirTipoTelefone(Long id) {
		tipoTelefoneRepository.deleteById(id);
	}
}
