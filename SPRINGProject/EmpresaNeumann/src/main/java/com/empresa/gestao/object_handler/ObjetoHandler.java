package com.empresa.gestao.object_handler;

import com.empresa.gestao.dao.annotations.ChaveEstrangeira;

public class ObjetoHandler {

	//pais
	private String descricaoPais;
	
	//estado
	private String descricaoEstado;
	private String siglaEstado;

	//cidade
	private String descricaoCidade;

	//tipo logradouro
	private String nomeTipoLogradouro;
	private String descricaoTipoLogradouro;
	
	//tipo endereço
	private String nomeTipoEndereco;
	private String descricaoTipoEndereco;

	//endereço
	private String cep;
	private String logradouro;
	private String numero;
	private String bairro;
	private String complemento;
	
	//fornecedor
	private String cnpj;
	private long dtCadastro;
	private String email;
	private String inscricaoEstadual;
	private String inscricaoMunicipal;
	private String nmFantasia;
	private String rzSocial;
	//tipo fornecimento
	@ChaveEstrangeira
	private String tipoFornecimento;
	//status
//	@ChaveEstrangeira
//	private String status;
	
	
	
	//departamento
	private String descricaoDepartamento;
	
	//telefone
	private String ddd;
	private String numeroTelefone;
	private String ddi;
	//ramal
	private String codigo;
	private String descricaoRamal;
	//tipo telefone
	@ChaveEstrangeira
	private String tipoTelefone;
	
	//pessoa
	private String nomePessoa;
	//contato
	private String emailContato;
	
	//usuario
	private String login;
	private String senha;
	
	public String getCep() {	return cep;	}
	public void setCep(String cep) {	this.cep = cep;	}
	public String getLogradouro() {	return logradouro;	}
	public void setLogradouro(String logradouro) {	this.logradouro = logradouro;	}
	public String getNumero() {	return numero;	}
	public void setNumero(String numero) {	this.numero = numero;	}
	public String getBairro() {	return bairro;	}
	public void setBairro(String bairro) {	this.bairro = bairro;	}
	public String getComplemento() {	return complemento;	}
	public void setComplemento(String complemento) {	this.complemento = complemento;	}
	public String getDescricaoCidade() {	return descricaoCidade;	}
	public void setDescricaoCidade(String descricaoCidade) {	this.descricaoCidade = descricaoCidade;	}
	public String getDescricaoEstado() {	return descricaoEstado;	}
	public void setDescricaoEstado(String descricaoEstado) {	this.descricaoEstado = descricaoEstado;	}
	public String getSiglaEstado() {	return siglaEstado;	}
	public void setSiglaEstado(String siglaEstado) {	this.siglaEstado = siglaEstado;	}
	public String getDescricaoPais() {	return descricaoPais;	}
	public void setDescricaoPais(String descricaoPais) {	this.descricaoPais = descricaoPais;	}
	public String getNomeTipoLogradouro() {	return nomeTipoLogradouro;	}
	public void setNomeTipoLogradouro(String nomeTipoLogradouro) {	this.nomeTipoLogradouro = nomeTipoLogradouro;	}
	public String getDescricaoTipoLogradouro() {	return descricaoTipoLogradouro;	}
	public void setDescricaoTipoLogradouro(String descricaoTipoLogradouro) {	this.descricaoTipoLogradouro = descricaoTipoLogradouro;	}
	public String getNomeTipoEndereco() {	return nomeTipoEndereco;	}
	public void setNomeTipoEndereco(String nomeTipoEndereco) {	this.nomeTipoEndereco = nomeTipoEndereco;	}
	public String getDescricaoTipoEndereco() {	return descricaoTipoEndereco;	}
	public void setDescricaoTipoEndereco(String descricaoTipoEndereco) {	this.descricaoTipoEndereco = descricaoTipoEndereco;	}
	public String getCnpj() {	return cnpj;	}
	public void setCnpj(String cnpj) {	this.cnpj = cnpj;	}
	public long getDtCadastro() {	return dtCadastro;	}
	public void setDtCadastro(long dtCadastro) {	this.dtCadastro = dtCadastro;	}
	public String getEmail() {	return email;	}
	public void setEmail(String email) {	this.email = email;	}
	public String getInscricaoEstadual() {	return inscricaoEstadual;	}
	public void setInscricaoEstadual(String inscricaoEstadual) {	this.inscricaoEstadual = inscricaoEstadual;	}
	public String getInscricaoMunicipal() {	return inscricaoMunicipal;	}
	public void setInscricaoMunicipal(String inscricaoMunicipal) {	this.inscricaoMunicipal = inscricaoMunicipal;	}
	public String getNmFantasia() {	return nmFantasia;	}
	public void setNmFantasia(String nmFantasia) {	this.nmFantasia = nmFantasia;	}
	public String getRzSocial() {	return rzSocial;	}
	public void setRzSocial(String rzSocial) {	this.rzSocial = rzSocial;	}
	public String getTipoFornecimento() {	return tipoFornecimento;	}
	public void setTipoFornecimento(String tipoFornecimento) {	this.tipoFornecimento = tipoFornecimento;	}
//	public String getStatus() {	return status;	}
//	public void setStatus(String status) {	this.status = status;	}
	public String getEmailContato() {	return emailContato;	}
	public void setEmailContato(String emailContato) {	this.emailContato = emailContato;	}
	public String getDescricaoDepartamento() {	return descricaoDepartamento;	}
	public void setDescricaoDepartamento(String descricaoDepartamento) {	this.descricaoDepartamento = descricaoDepartamento;	}
	public String getDdd() {	return ddd;	}
	public void setDdd(String ddd) {	this.ddd = ddd;	}
	public String getNumeroTelefone() {	return numeroTelefone;	}
	public void setNumeroTelefone(String numeroTelefone) {	this.numeroTelefone = numeroTelefone;	}
	public String getDdi() {	return ddi;	}
	public void setDdi(String ddi) {	this.ddi = ddi;	}
	public String getTipoTelefone() {	return tipoTelefone;	}
	public void setTipoTelefone(String tipoTelefone) {	this.tipoTelefone = tipoTelefone;	}
	public String getNomePessoa() {	return nomePessoa;	}
	public void setNomePessoa(String nomePessoa) {	this.nomePessoa = nomePessoa;	}
	public String getLogin() {	return login;	}
	public void setLogin(String login) {	this.login = login;	}
	public String getSenha() {	return senha;	}
	public void setSenha(String senha) {	this.senha = senha;	}
	public String getCodigo() {	return codigo;	}
	public void setCodigo(String codigo) {		this.codigo = codigo;	}
	public String getDescricaoRamal() {	return descricaoRamal;	}
	public void setDescricaoRamal(String descricaoRamal) {	this.descricaoRamal = descricaoRamal;	}
	
}
