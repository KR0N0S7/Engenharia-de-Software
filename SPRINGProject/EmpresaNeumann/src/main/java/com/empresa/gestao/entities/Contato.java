package com.empresa.gestao.entities;

import javax.persistence.Table;

import com.empresa.gestao.dao.annotations.ChaveEstrangeira;

@Table(name = "contatos")
public class Contato extends Pessoa {
	
	private String email;
	
	@ChaveEstrangeira
	private Departamento departamento;
	
	@ChaveEstrangeira
	private Fornecedor fornecedor;
	
	@ChaveEstrangeira
	private Telefone telefone;
	
	public String getEmail() {	return email;	}
	public void setEmail(String email) {	this.email = email;	}
	public Departamento getDepartamento() {	return departamento;	}
	public void setDepartamento(Departamento departamento) {	this.departamento = departamento;	}
	public Fornecedor getFornecedor() {	return fornecedor;	}
	public void setFornecedor(Fornecedor fornecedor) {	this.fornecedor = fornecedor;	}
	public Telefone getTelefone() {		return telefone;	}
	public void setTelefone(Telefone telefone) {	this.telefone = telefone;	}
}
