package com.empresa.gestao.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.empresa.gestao.dao.annotations.ChaveEstrangeira;

@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	
	@ChaveEstrangeira
	private Pessoa pessoa;

	public String getLogin() {	return login;	}
	public void setLogin(String login) {	this.login = login;	}
	public String getSenha() {	return senha;	}
	public void setSenha(String senha) {	this.senha = senha;	}
	public Pessoa getPessoa() {		return pessoa;	}
	public void setPessoa(Pessoa pessoa) {		this.pessoa = pessoa;	}
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
}
