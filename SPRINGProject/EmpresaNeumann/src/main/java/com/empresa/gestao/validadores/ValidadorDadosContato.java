package com.empresa.gestao.validadores;

import java.util.ArrayList;
import java.util.List;

import com.empresa.gestao.entities.Contato;
import com.empresa.gestao.entities.Fornecedor;

public class ValidadorDadosContato implements IStrategy {

	public String processar(Object entidade) {
		String verificaDado = new String();
		Fornecedor fornecedor = (Fornecedor)entidade;
		
		List<Contato> contatos = new ArrayList();
		contatos = fornecedor.getContatos();
		int tamanho = contatos.size();
		
		if(tamanho == 0) {
			return "Você precisa de pelo menos um contato associoado<br/>";
		}else{
			return null;
               
		}
	}
}

		



