package com.empresa.gestao.empresa;

import java.util.List;

import com.empresa.gestao.fornecedor.Fornecedor;
import com.empresa.gestao.servico.OrdemServico;

public class Empresa {

	private List<Fornecedor> fornecedor;
	private OrdemServico ordemServico;
	private TipoEmpresa tipoEmpresa;
	
	public List<Fornecedor> getFornecedor() {	return fornecedor;	}
	public void setFornecedor(List<Fornecedor> fornecedor) {	this.fornecedor = fornecedor;	}	
	public OrdemServico getOrdemServico() {		return ordemServico;	}
	public TipoEmpresa getTipoEmpresa() {	return tipoEmpresa;	}	
	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {	this.tipoEmpresa = tipoEmpresa;	}
}
