package com.empresa.gestao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String login;
	private String senha;
	
	@ManyToOne
	private Pessoa pessoa;

	public String getLogin() {	return login;	}
	public void setLogin(String login) {	this.login = login;	}
	public String getSenha() {	return senha;	}
	public void setSenha(String senha) {	this.senha = senha;	}
	public Pessoa getPessoa() {		return pessoa;	}
	public void setPessoa(Pessoa pessoa) {		this.pessoa = pessoa;	}
	public long getId() {	return id;	}
	public void setId(long id) {	this.id = id;	}

}
