package com.empresa.gestao.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.empresa.gestao.dao.annotations.ChaveEstrangeira;

@Table(name = "servicos")
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	@Column(name = "ordem_servico")
	@ChaveEstrangeira
	private OrdemServico ordemServico;
	
	@ChaveEstrangeira
	private Fornecedor fornecedor;
	
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
	public String getDescricao() {	return descricao;	}
	public void setDescricao(String descricao) {	this.descricao = descricao;	}
	public OrdemServico getOrdemServico() {		return ordemServico;	}
	public void setOrdemServico(OrdemServico ordemServico) {	this.ordemServico = ordemServico;	}
	public Fornecedor getFornecedor() {	return fornecedor;	}
	public void setFornecedor(Fornecedor fornecedor) {	this.fornecedor = fornecedor;	}
}
