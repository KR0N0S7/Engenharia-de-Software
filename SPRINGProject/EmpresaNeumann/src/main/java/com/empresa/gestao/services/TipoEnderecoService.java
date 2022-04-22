package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.TipoEndereco;
import com.empresa.gestao.repositories.TipoEnderecoRepository;

@Service
public class TipoEnderecoService {

	@Autowired
	private TipoEnderecoRepository tipoEnderecoRepository;
	
	public TipoEndereco salvarTipoEndereco(TipoEndereco tipoEndereco) {
		return tipoEnderecoRepository.save(tipoEndereco);
	}
	
	public List<TipoEndereco> listarTiposEnderecos() {
		return tipoEnderecoRepository.findAll();
	}
	
	public TipoEndereco obterTipoEndereco(Long id) {
		Optional<TipoEndereco> tipoEnderedo = tipoEnderecoRepository.findById(id);
		return tipoEnderedo.get();
	}
	
	public void excluirTipoEndereco(Long id) {
		tipoEnderecoRepository.deleteById(id);
	}
}
