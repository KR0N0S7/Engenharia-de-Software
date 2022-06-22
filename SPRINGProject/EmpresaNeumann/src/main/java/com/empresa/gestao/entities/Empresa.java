package com.empresa.gestao.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.empresa.gestao.dao.annotations.ChaveEstrangeira;

@Table(name = "empresas")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tipo_empmresa")
	@ChaveEstrangeira
	private TipoEmpresa tipoEmpresa;
	
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
	public TipoEmpresa getTipoEmpresa() {	return tipoEmpresa;	}
	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {	this.tipoEmpresa = tipoEmpresa;	}
}
