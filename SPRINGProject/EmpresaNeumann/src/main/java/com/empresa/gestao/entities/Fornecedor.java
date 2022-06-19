package com.empresa.gestao.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import com.empresa.gestao.dao.annotations.ChaveEstrangeira;

@Table(name = "fornecedores")
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotEmpty(message = "Campo obrigat�rio.")
//	@Size(min = 14, max = 14, message = "CNPJ deve conter 14 d�gitos")
//	@CNPJ
	private String cnpj;
	
	@Column(name = "dt_cadastro")
	private long dtCadastro;
	
	private String email;
	
	@Column(name = "inscricao_estadual")
	private String inscricaoEstadual;
	
	@Column(name = "inscricao_municipal")
	private String inscricaoMunicipal;
	
	@Column(name = "nm_fantasia")
	private String nmFantasia;
	
	@Column(name = "rz_social")
	private String rzSocial;
	
	@Column(name = "tipo_fornecimento")
	private TipoFornecimento tipoFornecimento;
	
	private Status status;
	
	@ManyToOne
	@ChaveEstrangeira
	private Endereco endereco;
	
	public Long getId() {	return id;	}
	public void setId(Long id) {	this.id = id;	}
	public String getEmail() {	return email;	}
	public void setEmail(String email) {	this.email = email;	}
	public String getCnpj() {	return cnpj;	}
	public void setCnpj(String cnpj) {	this.cnpj = cnpj;	}
	public String getInscricaoEstadual() {	return inscricaoEstadual;	}
	public void setInscricaoEstadual(String inscricaoEstadual) {	this.inscricaoEstadual = inscricaoEstadual;	}
	public String getInscricaoMunicipal() {	return inscricaoMunicipal;	}
	public void setInscricaoMunicipal(String inscricaoMunicipal) {	this.inscricaoMunicipal = inscricaoMunicipal;	}
	public long getDtCadastro() {	return dtCadastro;	}
	public void setDtCadastro(long dtCadastro) {	this.dtCadastro = dtCadastro;	}
	public String getRzSocial() {	return rzSocial;	}
	public void setRzSocial(String rzSocial) {	this.rzSocial = rzSocial;	}
	public String getNmFantasia() {	return nmFantasia;	}
	public void setNmFantasia(String nmFantasia) {	this.nmFantasia = nmFantasia;	}
	public Endereco getEndereco() {	return endereco;	}
	public void setEndereco(Endereco endereco) {	this.endereco = endereco;	}
	public Status getStatus() {	return status;	}
	public void setStatus(Status status) {	this.status = status; }
	public TipoFornecimento getTipoFornecimento() {	return tipoFornecimento;	}
	public void setTipoFornecimento(TipoFornecimento tipoFornecimento) {	this.tipoFornecimento = tipoFornecimento;	}
	
//	public void salvar() {
//		
//	}
//	
//	public void alterar() {
//		
//	}
//	
//	public Fornecedor consultar() {
//		return null;
//	}
//	
//	public void excluir() {
//		
//	}
//	
//	public void inativar() {
//		
//	}
//	
//	public void ativar() {
//		
//	}
//	
//	public void addContato(Contato contato) {
//		contatos.add(contato);
//	}
//	
//	public void validarCNPJ() {
//		
//	}
//	
//	public void validarListarFornecimento() {
//		
//	}
}

