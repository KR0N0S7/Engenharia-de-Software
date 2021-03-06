package com.empresa.gestao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "contatos")
public class Contato extends Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	
//	@ManyToOne
	private Departamento departamento;
	
//	@ManyToOne
	private Fornecedor fornecedor;
	
	@ManyToOne
	private Telefone telefone;
	
	public String getEmail() {	return email;	}
	public void setEmail(String email) {	this.email = email;	}
	public Departamento getDepartamento() {	return departamento;	}
	public void setDepartamento(Departamento departamento) {	this.departamento = departamento;	}
	public Fornecedor getFornecedor() {	return fornecedor;	}
	public void setFornecedor(Fornecedor fornecedor) {	this.fornecedor = fornecedor;	}
	public Telefone getTelefone() {		return telefone;	}
	public void setTelefone(Telefone telefone) {	this.telefone = telefone;	}
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
}
