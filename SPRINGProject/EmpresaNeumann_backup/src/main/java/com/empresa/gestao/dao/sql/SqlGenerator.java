package com.empresa.gestao.dao.sql;

import javax.persistence.Table;

import com.empresa.gestao.dao.Tabela;

public class SqlGenerator {

	public static String gerarSQL(Object objeto) {
		Tabela tabela = objeto
				.getClass()
				.getDeclaredAnnotation(Tabela.class);
		
		String nomeTabela = objeto
				.getClass()
				.getSimpleName()
				.toLowerCase();
		
		Table tabelaRenomeada = objeto
				.getClass()
				.getDeclaredAnnotation(Table.class);
		
		if (tabelaRenomeada != null) {
			nomeTabela = tabelaRenomeada.name();
		}
		
		if (null != tabela && !tabela.nome().equals("_SEM_NOME_")) {
			nomeTabela = tabela.nome();
		}
		
		return nomeTabela;
	}
}
