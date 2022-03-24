package com.empresa.gestao.abstrata;

import com.empresa.gestao.fornecedor.Fornecedor;
import com.empresa.gestao.fornecedor.Usuario;

public abstract class Log {

	private long dataHora;
	
	public void registrarTransacao(Usuario usuario, Fornecedor fornecedor) {
		
	}

	public long getDataHora() {
		return dataHora;
	}
}
