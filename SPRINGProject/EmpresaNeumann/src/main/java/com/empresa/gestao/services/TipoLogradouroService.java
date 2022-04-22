package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.TipoLogradouro;
import com.empresa.gestao.repositories.TipoLogradouroRepository;

@Service
public class TipoLogradouroService {

	@Autowired
	private TipoLogradouroRepository tipoLogradouroRepository;
	
	public TipoLogradouro salvarTipoLogradouro(TipoLogradouro tipoLogradouro) {
		return tipoLogradouroRepository.save(tipoLogradouro);
	}
	
	public List<TipoLogradouro> listarTiposLogradouros() {
		return tipoLogradouroRepository.findAll();
	}
	
	public TipoLogradouro obterTipoLogradouro(Long id) {
		Optional<TipoLogradouro> tipoLogradouro = tipoLogradouroRepository.findById(id);
		return tipoLogradouro.get();
	}
	
	public void excluirTipoLogradouro(Long id) {
		tipoLogradouroRepository.deleteById(id);
	}
}
