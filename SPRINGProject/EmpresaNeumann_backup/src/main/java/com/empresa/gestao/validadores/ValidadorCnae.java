package com.empresa.gestao.validadores;

import com.empresa.gestao.entities.Fornecedor;

public class ValidadorCnae implements IStrategy {

	public String processar(Object entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;

        for (int i = 0; i<fornecedor.getCnaes().size(); i++) {
        String cnae = fornecedor.getCnaes().get(i).getNumero();
           
        	if(cnae == null || cnae.isBlank()){
				return "Cnae(s) obrigatório(s)\n";
			}
        }	
		return null;
		
	}

}
