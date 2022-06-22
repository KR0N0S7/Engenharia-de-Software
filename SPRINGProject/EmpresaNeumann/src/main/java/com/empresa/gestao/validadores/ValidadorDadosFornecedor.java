package com.empresa.gestao.validadores;

import com.empresa.gestao.object_handler.ObjetoHandler;

public class ValidadorDadosFornecedor implements InterfaceStrategy {

	public String processar(Object entidade) {
		
		ObjetoHandler objeto = (ObjetoHandler)entidade;
		
		String cnpj = objeto.getCnpj();
		String razaoSocial = objeto.getRzSocial();
		String nomeFantasia = objeto.getNmFantasia();
		String inscricaoMunicipal = objeto.getInscricaoMunicipal();
		String inscricaoEstadual = objeto.getInscricaoEstadual();
		
		if (cnpj == null || cnpj.isBlank()) {
			return "CNPJ obrigatório";	
		}
		
		if (razaoSocial  == null || razaoSocial.isBlank()) {
			return "Razão social obrigatório";	
		}
		
		if (nomeFantasia == null || nomeFantasia.isBlank()) {
			return "Nome Fantasia obrigatório";	
		}
		
		if (inscricaoMunicipal == null || inscricaoMunicipal.isBlank()) {
			return "Inscrição Municipal obrigatório";	
		}
		
		if (inscricaoEstadual == null || inscricaoEstadual.isBlank()) {
			return "Inscrição Estadual obrigatório";	
		}
				
		return null;
		
	}

}

