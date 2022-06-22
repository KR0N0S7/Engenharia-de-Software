package com.empresa.gestao.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "status")
public class Status {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String status;
	
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
	public String getStatus() {	return status;	}
	public void setStatus(String status) {	this.status = status;	}

}
