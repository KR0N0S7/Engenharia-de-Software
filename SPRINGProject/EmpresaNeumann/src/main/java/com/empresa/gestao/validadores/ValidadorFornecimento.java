package com.empresa.gestao.validadores;

import com.empresa.gestao.entities.Fornecedor;

public class ValidadorFornecimento implements IStrategy {
	
	public String processar(Object entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		
		int qntdProdutos = fornecedor.getProdutosOfertados().size();
		int qntdServicos = fornecedor.getServicosOfertados().size();
		
		if(qntdProdutos == 0 && qntdServicos == 0) {
			return "Você precisa cadastrar pelos menos um produto ou serviço<br/>";
		}else {
			return null;
		}
	
	}			
}
