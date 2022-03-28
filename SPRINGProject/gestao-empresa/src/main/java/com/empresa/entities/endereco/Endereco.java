package com.empresa.entities.endereco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;

//import com.empresa.entities.fornecedor.Fornecedor;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private int cep;
	private String logradouro;
	private String numero;
	private String bairro;
	private String complemento;
	
	@ManyToOne
	private Cidade cidade;
	
	@ManyToOne
	private TipoLogradouro tipoLogradouro;
	
	@ManyToOne
	private TipoEndereco tipoEndereco;
	
//	@OneToOne
//	private Fornecedor fornecedor;

	public long getId() {	return id;	}
	public void setId(long id) {	this.id = id;	}
	public int getCep() {	return cep;	}
	public void setCep(int cep) {	this.cep = cep;	}
	public String getLogradouro() {		return logradouro;	}
	public void setLogradouro(String logradouro) {		this.logradouro = logradouro;	}
	public String getNumero() {		return numero;	}
	public void setNumero(String numero) {		this.numero = numero;	}
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
//	public Fornecedor getFornecedor() {		return fornecedor;	}
//	public void setFornecedor(Fornecedor fornecedor) {	this.fornecedor = fornecedor;	}
//	
	
	
}
