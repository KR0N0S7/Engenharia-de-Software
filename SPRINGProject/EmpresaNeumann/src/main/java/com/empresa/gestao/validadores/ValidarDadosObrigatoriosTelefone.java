package com.empresa.gestao.validadores;

import com.empresa.gestao.object_handler.ObjetoHandler;

public class ValidarDadosObrigatoriosTelefone implements InterfaceStrategy {

	public String processar(Object entidade) {
		
		ObjetoHandler objeto = (ObjetoHandler)entidade;

		String ddi = objeto.getDdi();
    	String ddd = objeto.getDdd();
    	String numero = objeto.getNumero();

		if(ddi == null || ddi == ""){
		 	return "DDI Telefone obrigatório";
	 	}

		if(ddd == null || ddd == ""){
		 	return "DDD Telefone obrigatório";
	 	}
		 
		if(numero == null || numero == ""){
		 	return "Número Telefone obrigatório";
	 	}

		return null;
	}
}
