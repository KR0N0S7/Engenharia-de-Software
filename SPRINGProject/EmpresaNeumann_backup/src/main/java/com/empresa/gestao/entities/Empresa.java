package com.empresa.gestao.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//@Entity
//@Table(name = "empresas")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private TipoEmpresa tipoEmpresa;
	
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
	public TipoEmpresa getTipoEmpresa() {	return tipoEmpresa;	}
	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {	this.tipoEmpresa = tipoEmpresa;	}
	
}
