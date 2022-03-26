package com.empresa.gestao.endereco;

import java.util.List;

public class UF {

	private String descricao;
	private String sigla;
	private Pais pais;
	private List<Cidade> cidades;
	
	public String getDescricao() {	return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
	public String getSigla() {	return sigla;	}
	public void setSigla(String sigla) {	this.sigla = sigla;	}
	public Pais getPais() {		return pais;	}
	public void setPais(Pais pais) {	this.pais = pais;	}
	public List<Cidade> getCidades() {	return cidades;	}
	public void setCidades(List<Cidade> cidades) {	this.cidades = cidades;	}
	
	public UF(String descricao, String sigla, Pais pais, List<Cidade> cidades) {
		this.descricao = descricao;
		this.sigla = sigla;
		this.pais = pais;
		this.cidades = cidades;
	}
	
	
}
