package com.empresa.gestao.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "telefones")
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ddd;
	private String numero;
	private String ddi;
	
	private Fornecedor fornecedor;
	
	private TipoTelefone tipoTelefone;
	
	public String getDdd() {	return ddd;	}
	public void setDdd(String ddd) {	this.ddd = ddd;	}
	public String getNumero() {	return numero;	}
	public void setNumero(String numero) {	this.numero = numero;	}
	public String getDdi() {	return ddi;	}
	public void setDdi(String ddi) {	this.ddi = ddi;	}
	public Fornecedor getFornecedor() {		return fornecedor;	}
	public void setFornnecedor(Fornecedor fornecedor) {		this.fornecedor = fornecedor;	}
	public TipoTelefone getTipoTelefone() {		return tipoTelefone;	}
	public void setTipoTelefone(TipoTelefone tipoTelefone) {	this.tipoTelefone = tipoTelefone;	}
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
}
