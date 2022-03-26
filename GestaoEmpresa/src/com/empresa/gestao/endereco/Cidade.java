package com.empresa.gestao.endereco;

import java.util.List;

public class Cidade {

	private String descricao;
	private UF uf;
	private List<Endereco> enderecos;
	
	public String getDescricao() {	return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
	public UF getUf() {		return uf;	}
	public void setUf(UF uf) {		this.uf = uf;	}
	public List<Endereco> getEnderecos() {		return enderecos;	}
	public void setEnderecos(List<Endereco> enderecos) {	this.enderecos = enderecos;	}
	
	public Cidade(String descricao, UF uf, List<Endereco> enderecos) {
		this.descricao = descricao;
		this.uf = uf;
		this.enderecos = enderecos;
	}
	
	
}
