package com.empresa.gestao.validadores;

import com.empresa.gestao.object_handler.ObjetoHandler;

public class ValidadorCnpj implements InterfaceStrategy {

	public String processar(Object entidade) {
		
		ObjetoHandler objeto = (ObjetoHandler) entidade;
		
		String cnpj = objeto.getCnpj().replace("-", "").replace(".", "").replace("/", "");
				
		if(cnpj == null || cnpj.length()!=14){
			return "CPNJ inválido.";
		}else {
			return null;
		}
		
	}

}
