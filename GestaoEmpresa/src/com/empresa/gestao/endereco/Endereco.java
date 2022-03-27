package com.empresa.gestao.endereco;

import com.empresa.gestao.exceptions.ExcecaoTamanhoPermitido;
import com.empresa.gestao.fornecedor.Fornecedor;

public class Endereco {

	private int cep;
	private String logradouro;
	private String numero;
	private String bairro;
	private String complemento;
	private Cidade cidade;
	private TipoLogradouro tipoLogradouro;
	private TipoEndereco tipoEndereco;
	private Fornecedor fornecedor;
	
	public int getCep() {	return cep;	}
	public void setCep(int cep) {	this.cep = cep;		}
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
	
	public Endereco(int cep, String logradouro, String numero, String bairro, String complemento, Cidade cidade,
			TipoLogradouro tipoLogradouro, TipoEndereco tipoEndereco, Fornecedor fornecedor) throws ExcecaoTamanhoPermitido {
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.tipoLogradouro = tipoLogradouro;
		this.tipoEndereco = tipoEndereco;
		this.fornecedor = fornecedor;
	}
	
}
