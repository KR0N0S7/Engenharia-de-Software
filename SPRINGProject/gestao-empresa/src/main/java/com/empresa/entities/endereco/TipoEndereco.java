package com.empresa.entities.endereco;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoEndereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	
	@OneToMany(mappedBy = "tipoEndereco")
	private List<Endereco> endereco;
	
	public String getNome() {	return nome;	}
	public void setNome(String nome) {	this.nome = nome;	}
	public String getDescricao() {		return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
	public long getId() {	return id;	}
	public void setId(long id) {	this.id = id;	}
	public List<Endereco> getEndereco() {	return endereco;	}
	public void setEndereco(List<Endereco> endereco) {		this.endereco = endereco;	}
	
	public TipoEndereco(String nome, String descricao, List<Endereco> endereco) {
		this.nome = nome;
		this.descricao = descricao;
		this.endereco = endereco;
	}
	
	
}
