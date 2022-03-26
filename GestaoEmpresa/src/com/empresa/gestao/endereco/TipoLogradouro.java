package com.empresa.gestao.endereco;

public class TipoLogradouro {

	private String nome;
	private String descricao;
	private Endereco endereco;
	
	public String getNome() {	return nome;	}
	public void setNome(String nome) {		this.nome = nome;	}
	public String getDescricao() {		return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
	public Endereco getEndereco() {		return endereco;	}
	public void setEndereco(Endereco endereco) {	this.endereco = endereco;	}
	
	public TipoLogradouro(String nome, String descricao, Endereco endereco) {
		this.nome = nome;
		this.descricao = descricao;
		this.endereco = endereco;
	}
	
	
}
