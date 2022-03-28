package com.empresa.entities.endereco;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String descricao;
	
	@OneToMany(mappedBy = "pais")
	private List<UF> ufs;
	
	public long getId() {	return id;	}
	public void setId(long id) {	this.id = id;	}
	public String getDescricao() {	return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
	public List<UF> getUfs() {	return ufs;	}
	public void setUfs(List<UF> ufs) {	this.ufs = ufs;	}
	
	public Pais(String descricao, List<UF> ufs) {
		this.descricao = descricao;
		this.ufs = ufs;
	}
		
}
