package com.empresa.gestao.entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ordens_servicos")
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private long dtInicio;
	
	private Empresa empresa;
	
	private List<Servico> servicos;
	
	private Fornecedor fornecedor;
	
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}	
	public long getDtInicio() {	return dtInicio;	}
	public void setDtInicio(long dtInicio) {	this.dtInicio = dtInicio;	}
	public Empresa getEmpresa() {	return empresa;	}
	public void setEmpresa(Empresa empresa) {	this.empresa = empresa;	}
	public List<Servico> getServicos() {	return servicos;	}
	public void setServicos(List<Servico> servicos) {	this.servicos = servicos;	}
	public Fornecedor getFornecedor() {	return fornecedor;	}
	public void setFornecedor(Fornecedor fornecedor) {	this.fornecedor = fornecedor;	}
}
