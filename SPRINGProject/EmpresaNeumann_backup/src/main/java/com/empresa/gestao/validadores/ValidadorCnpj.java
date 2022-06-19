package com.empresa.gestao.validadores;

import com.empresa.gestao.entities.Fornecedor;

public class ValidadorCnpj implements IStrategy {

	public String processar(Object entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		String cnpj = fornecedor.getCnpj().replace("-", "").replace(".", "").replace("/", "");
				
		if(cnpj == null || cnpj.length()!=14){
			return "CPNJ inválido<br/>";
		}else {
			return null;
		}
		
	}

}
