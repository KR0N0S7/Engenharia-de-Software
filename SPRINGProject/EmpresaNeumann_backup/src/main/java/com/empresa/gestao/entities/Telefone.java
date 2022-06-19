package com.empresa.gestao.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "telefones")
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ddd;
	private String numero;
	private String ddi;
	
//	@OneToMany(mappedBy = "telefone")
//	private List<Contato> contatos;
	
//	@ManyToOne
	private Fornecedor fornecedor;
	
//	@ManyToOne
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
//	public List<Contato> getContato() {		return contatos;	}
//	public void setContato(List<Contato> contatos) {	this.contatos = contatos;	}
}
