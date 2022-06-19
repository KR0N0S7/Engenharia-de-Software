package com.empresa.gestao.validadores;

import java.util.List;

import com.empresa.gestao.dao.DAO;
import com.empresa.gestao.entities.Fornecedor;

public class VerificarUnicidadeCnpj implements IStrategy {

	public String processar(Object entidade) {
		String verificaDado = new String();
		Fornecedor fornecedorAnalisado = (Fornecedor)entidade;
		Fornecedor cnpj = new Fornecedor();
		
		cnpj.setPesquisa(fornecedorAnalisado.getCnpj().toString());
		List<Object> fornecedoresDoBanco = new DAO().consultar(cnpj);
		
		for(Object fornecedores : fornecedoresDoBanco) {
			Fornecedor f = (Fornecedor) fornecedores;
			if(f.getCnpj().equals(fornecedorAnalisado.getCnpj())) {
				verificaDado = "Cnpj já existe.<br/>";	
				break;
			}
		}
			
		if (verificaDado != "") {
			return verificaDado;
		}else{
			return null;
		}
	}

}
