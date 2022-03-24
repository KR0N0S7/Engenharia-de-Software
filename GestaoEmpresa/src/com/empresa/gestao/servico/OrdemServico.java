package com.empresa.gestao.servico;

import java.util.List;

import com.empresa.gestao.empresa.Empresa;
import com.empresa.gestao.fornecedor.Fornecedor;

public class OrdemServico {

	private long dtInicio;
	private Empresa empresa;
	private List<Servico> servicos;
	private Fornecedor fornecedor;
	public long getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(long dtInicio) {
		this.dtInicio = dtInicio;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public List<Servico> getServicos() {
		return servicos;
	}
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
