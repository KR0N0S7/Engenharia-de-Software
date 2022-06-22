package com.empresa.gestao.validadores;

import java.sql.SQLException;
import java.util.List;

import com.empresa.gestao.dao.AbstractDAO;
import com.empresa.gestao.object_handler.ObjetoHandler;

public class VerificarUnicidadeCnpj implements InterfaceStrategy {

	public String processar(Object entidade) throws SQLException {
		
		ObjetoHandler objeto = (ObjetoHandler)entidade;
		String cnpjObjeto = objeto.getCnpj();
		
		@SuppressWarnings("unchecked")
		List<String> listaCnpj = (List<String>) AbstractDAO.listarObjetoEspecifico("cnpj", "fornecedores");
		
		if (listaCnpj.contains(cnpjObjeto)) {
			return "Cnpj já existe.";	
		}
			
		return null;
	}

}
