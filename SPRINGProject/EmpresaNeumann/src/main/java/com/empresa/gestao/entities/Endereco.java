package com.empresa.gestao.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.empresa.gestao.dao.annotations.ChaveEstrangeira;

@Table(name = "enderecos")
public class Endereco {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String cep;
	private String logradouro;
	private String numero;
	private String bairro;
	private String complemento;
	
	@ChaveEstrangeira
	private Cidade cidade;
	
	@Column(name = "tipo_logradouro")
	@ChaveEstrangeira
	private TipoLogradouro tipoLogradouro;
	
	@Column(name = "tipo_endereco")
	@ChaveEstrangeira
	private TipoEndereco tipoEndereco;
	
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
	public String getCep() {	return cep;	}
	public void setCep(String cep) {	this.cep = cep;	}
	public String getLogradouro() {	return logradouro;	}
	public void setLogradouro(String logradouro) {	this.logradouro = logradouro;	}
	public String getNumero() {		return numero;	}
	public void setNumero(String numero) {	this.numero = numero;	}
	public String getBairro() {		return bairro;	}
	public void setBairro(String bairro) {		this.bairro = bairro;	}
	public String getComplemento() {	return complemento;	}
	public void setComplemento(String complemento) {	this.complemento = complemento;	}
	public Cidade getCidade() {		return cidade;	}
	public void setCidade(Cidade cidade) {	this.cidade = cidade;	}
	public TipoLogradouro getTipoLogradouro() {		return tipoLogradouro;	}
	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {	this.tipoLogradouro = tipoLogradouro;	}
	public TipoEndereco getTipoEndereco() {		return tipoEndereco;	}
	public void setTipoEndereco(TipoEndereco tipoEndereco) {	this.tipoEndereco = tipoEndereco;	}
}
