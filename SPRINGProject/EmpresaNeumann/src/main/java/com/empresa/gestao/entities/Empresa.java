package com.empresa.gestao.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany
	private List<Fornecedor> fornecedor;
	
	@OneToMany(mappedBy = "empresa")
	private List<OrdemServico> ordemServicos;
	
	private TipoEmpresa tipoEmpresa;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public List<Fornecedor> getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(List<Fornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}
	public List<OrdemServico> getOrdemServico() {
		return ordemServicos;
	}
	
	public List<OrdemServico> getOrdemServicos() {
		return ordemServicos;
	}
	public void setOrdemServicos(List<OrdemServico> ordemServicos) {
		this.ordemServicos = ordemServicos;
	}
	public TipoEmpresa getTipoEmpresa() {
		return tipoEmpresa;
	}
	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}
	
}
