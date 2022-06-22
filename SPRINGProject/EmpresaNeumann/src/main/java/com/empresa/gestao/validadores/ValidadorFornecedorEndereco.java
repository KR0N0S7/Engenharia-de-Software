package com.empresa.gestao.validadores;

import com.empresa.gestao.entities.Fornecedor;

public class ValidadorFornecedorEndereco implements IStrategy {
	public String processar(Object entidade) {
		
		Fornecedor fornecedor = (Fornecedor)entidade;
		String tipoEndereco = fornecedor.getEndereco().getTipoEndereco().toString();
		String tipoLogradouro = fornecedor.getEndereco().getTipoLogradouro().toString();
		String logradouro = fornecedor.getEndereco().getLogradouro();
		Integer numero = fornecedor.getEndereco().getNumero();
		String bairro = fornecedor.getEndereco().getBairro();
		String cidade = fornecedor.getEndereco().getCidade().toString();
		String estado = fornecedor.getEndereco().getCidade().getEstado().toString();
		String pais = fornecedor.getEndereco().getCidade().getEstado().getPais().toString();
		Integer cep = fornecedor.getEndereco().getCep();
		
		if ( tipoEndereco  == null || tipoEndereco.isBlank()){
			return "Tipo do endereço obrigatório<br/>";
		}
		
		if ( tipoLogradouro== null ||tipoLogradouro.isBlank()) {
			return "Tipo do logradouro obrigatório<br/>";	
		}
		
		if (logradouro == null || logradouro.isBlank()) {
			return "Logradouro obrigatório<br/>";	
		}
		
		if (numero == null) {
			return "Número obrigatório<br/>";	
		}

		if (bairro == null || bairro.isBlank()) {
			return "Bairro obrigatório<br/>";	
		}
		
		if (cidade == null|| cidade.isBlank()) {
			return "Cidade obrigatória<br/>";	
		}

		if (estado == null || estado.isBlank()) {
			return "Estado obrigat�rio<br/>";	
		}
		
		if (pais == null || pais.isBlank()) {
			return "Pa�s obrigatório<br/>";	
		}

		if (cep == null) {
			return "CEP obrigatório<br/>";	
		} else {
			return null;
		}
	}
}