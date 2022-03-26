package com.empresa.gestao.endereco;

import java.util.List;

public class Pais {

	private String descricao;
	private List<UF> ufs;
	
	public String getDescricao() {	return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
	public List<UF> getUfs() {	return ufs;	}
	public void setUfs(List<UF> ufs) {	this.ufs = ufs;	}
	
	public Pais(String descricao, List<UF> ufs) {
		this.descricao = descricao;
		this.ufs = ufs;
	}
	
	
}
