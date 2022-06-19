package com.empresa.gestao.validadores;

import com.empresa.gestao.entities.Fornecedor;

public class ValidadorDadosFornecedor implements IStrategy {

	public String processar(Object entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		String cnpj = fornecedor.getCnpj();
		String razaoSocial = fornecedor.getRzSocial();
		String nomeFantasia = fornecedor.getNmFantasia();
		String inscMun = fornecedor.getInscricaoMunicipal();
		String inscEst = fornecedor.getInscricaoEstadual();
		
		if (cnpj == null || cnpj.isBlank()) {
			return "CNPJ obrigatório<br/>";	
		}
		
		if (razaoSocial  == null || razaoSocial.isBlank()) {
			return "Razão social obrigatório<br/>";	
		}
		
		if (nomeFantasia == null || nomeFantasia.isBlank()) {
			return "Nome Fantasia obrigatório<br/>";	
		}
		
		if (inscMun == null || inscMun.isBlank()) {
			return "Inscrição Municipal obrigatório<br/>";	
		}
		
		if (inscEst == null || inscEst.isBlank()) {
			return "Inscrição Estadual obrigatório<br/>";	
		}
				
		return null;
		
	}

}

