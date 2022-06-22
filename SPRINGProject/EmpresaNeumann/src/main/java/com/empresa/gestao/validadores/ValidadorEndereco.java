package com.empresa.gestao.validadores;

import com.empresa.gestao.object_handler.ObjetoHandler;

public class ValidadorEndereco implements InterfaceStrategy {
	
	public String processar(Object entidade) {
		
		ObjetoHandler objeto = (ObjetoHandler)entidade;
		
		String logradouro = objeto.getLogradouro();
		String numero = objeto.getNumero();
		String bairro = objeto.getBairro();
		String cidade = objeto.getDescricaoCidade();
		String estado = objeto.getDescricaoEstado();
		String pais = objeto.getDescricaoPais();
		String cep = objeto.getCep();
		
		if (logradouro == null || logradouro.isBlank()) {
			return "Logradouro obrigatório";	
		}
		
		if (numero == null) {
			return "Número obrigatório";	
		}

		if (bairro == null || bairro.isBlank()) {
			return "Bairro obrigatório";	
		}
		
		if (cidade == null|| cidade.isBlank()) {
			return "Cidade obrigatória";	
		}

		if (estado == null || estado.isBlank()) {
			return "Estado obrigatório";	
		}
		
		if (pais == null || pais.isBlank()) {
			return "País obrigatório";	
		}

		if (cep == null) {
			return "CEP obrigatório";	
		} 
		
		return null;
		
	}
}