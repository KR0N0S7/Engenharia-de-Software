package com.empresa.gestao.validadores;

import com.empresa.gestao.entities.Endereco;

public class ValidadorEndereco implements IStrategy {
	
	public String processar(Object entidade) {
		
		Endereco endereco = (Endereco)entidade;
		String tipoEndereco = endereco.getTipoEndereco().toString();
		String tipoLogradouro = endereco.getTipoLogradouro().toString();
		String logradouro = endereco.getLogradouro();
		String numero = endereco.getNumero();
		String bairro = endereco.getBairro();
		String cidade = endereco.getCidade().toString();
		String estado = endereco.getCidade().getEstado().toString();
		String pais = endereco.getCidade().getEstado().getPais().toString();
		String cep = endereco.getCep();
		
		if ( tipoEndereco  == null || tipoEndereco.isBlank()){
			return "Tipo do endereço obrigatório<br/>";
		}
		
		if ( tipoLogradouro== null ||tipoLogradouro.isBlank()) {
			return "Tipo do logradouro obrigatório<br/>";	
		}
		
		if (logradouro == null || logradouro.isBlank()) {
			return "Logradouro obrigatório<br/>";	
		}
		
		if (numero == null) {
			return "Número obrigatório<br/>";	
		}

		if (bairro == null || bairro.isBlank()) {
			return "Bairro obrigatório<br/>";	
		}
		
		if (cidade == null|| cidade.isBlank()) {
			return "Cidade obrigatória<br/>";	
		}

		if (estado == null || estado.isBlank()) {
			return "Estado obrigat�rio<br/>";	
		}
		
		if (pais == null || pais.isBlank()) {
			return "País obrigatório<br/>";	
		}

		if (cep == null) {
			return "CEP obrigatório<br/>";	
		} else {
			return null;
		}
	}
}