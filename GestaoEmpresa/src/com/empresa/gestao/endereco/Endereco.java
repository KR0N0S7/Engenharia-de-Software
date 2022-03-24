package com.empresa.gestao.endereco;

import com.empresa.gestao.fornecedor.Fornecedor;

public class Endereco {

	private String cep;
	private String logradouro;
	private String numero;
	private String bairro;
	private String complemento;
	private Cidade cidade;
	private TipoLogradouro tipoLogradouro;
	private TipoEndereco tipoEndereco;
	private Fornecedor fornecedor;
	
	public String getCep() {	return cep;	}
	public void setCep(String cep) {	this.cep = cep;	}
	public String getLogradouro() {		return logradouro;	}
	public void setLogradouro(String logradouro) {		this.logradouro = logradouro;	}
	public String getNumero() {		return numero;	}
	public void setNumero(String numero) {		this.numero = numero;	}
	public String getBairro() {		return bairro;	}
	public void setBairro(String bairro) {		this.bairro = bairro;	}
	public String getComplemento() {	return complemento;	}
	public void setComplemento(String complemento) {	this.complemento = complemento;	}
	public Cidade getCidade() {		return cidade;	}
	public void setCidade(Cidade cidade) {		this.cidade = cidade;	}
	public TipoLogradouro getTipoLogradouro() {		return tipoLogradouro;	}
	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {		this.tipoLogradouro = tipoLogradouro;	}
	public TipoEndereco getTipoEndereco() {		return tipoEndereco;	}
	public void setTipoEndereco(TipoEndereco tipoEndereco) {	this.tipoEndereco = tipoEndereco;	}
	public Fornecedor getFornecedor() {		return fornecedor;	}
	public void setFornecedor(Fornecedor fornecedor) {		this.fornecedor = fornecedor;	}
}
