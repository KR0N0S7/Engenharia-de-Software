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

import com.empresa.gestao.dao.ChaveEstrangeira;

//@Entity
//@Table(name = "fornecedores")
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
	
	private Status status;
	
	@Column(name = "tipo_fornecimento")
	private TipoFornecimento tipoFornecimento;
	
	@ManyToOne
	@ChaveEstrangeira
	private Endereco endereco;
	
//	@ManyToMany
//	@JoinTable(
//			name = "classificacao_fornecedores",
//			joinColumns = @JoinColumn(name = "fornecedor_id"),
//			inverseJoinColumns = @JoinColumn(name = "cnae_id"))
//	private List<CNAE> cnaes;
//	
//	@ManyToMany
//	@JoinTable(
//			name = "relacao_trabalho",
//			joinColumns = @JoinColumn(name = "fornecedor_id"),
//			inverseJoinColumns = @JoinColumn(name = "empresa_id"))
//	private List<Empresa> empresas;
//	
//	@OneToMany(mappedBy = "fornecedor")
//	@Column(name = "ordem_servicos")
//	private List<OrdemServico> ordemServicos;
//	
//	@ManyToMany
//	@JoinTable(
//			name = "fornecimento_servicos",
//			joinColumns = @JoinColumn(name = "fornecedor_id"),
//			inverseJoinColumns = @JoinColumn(name = "servico_id"))
//	private List<Servico> servicosOfertados;
//	
//	@OneToMany(mappedBy = "fornecedor")
//	private List<Produto> produtosOfertados;
//	
//	@OneToMany(mappedBy = "fornecedor")
//	private List<Contato> contatos;
//	
//	@OneToMany(mappedBy = "fornecedor")
//	private List<Telefone> telefones;
//	
//	private List<TipoFornecimento> tipoFornecimento;
//	private Status status;
//	
//	public boolean isRascunho() {	return isRascunho;	}
//	public void setRascunho(boolean isRascunho) {	this.isRascunho = isRascunho;	}

	
	public Fornecedor() {
	}
	
	
	
	public Fornecedor(String email, String cnpj, String inscricaoEstadual, String inscricaoMunicipal, long dtCadastro,
		String rzSocial, String nmFantasia) {
		this.email = email;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.dtCadastro = dtCadastro;
		this.rzSocial = rzSocial;
		this.nmFantasia = nmFantasia;
	}
	
	


	public Fornecedor(Long id, String cnpj, long dtCadastro, String email, String inscricaoEstadual,
			String inscricaoMunicipal, String nmFantasia, String rzSocial, Endereco endereco) {
		this.id = id;
		this.cnpj = cnpj;
		this.dtCadastro = dtCadastro;
		this.email = email;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.nmFantasia = nmFantasia;
		this.rzSocial = rzSocial;
		this.endereco = endereco;
	}



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
	
//	public List<CNAE> getCnaes() {	return cnaes;	}
//	public void setCnaes(List<CNAE> cnae) {	this.cnaes = cnae;	}
//	public List<Empresa> getEmpresas() {	return empresas;	}
//	public void setEmpresas(List<Empresa> empresas) {	this.empresas = empresas;	}
//	public List<OrdemServico> getOrdemServicos() {	return ordemServicos;	}
//	public void setOrdemServicos(List<OrdemServico> ordemServicos) {	this.ordemServicos = ordemServicos;	}
//	public List<Servico> getServicosOfertados() {	return servicosOfertados;	}
//	public void setServicosOfertados(List<Servico> servicos) {	this.servicosOfertados = servicos;	}
//	public List<Produto> getProdutosOfertados() {	return produtosOfertados;	}
//	public void setProdutosOfertados(List<Produto> produtos) {	this.produtosOfertados = produtos;	}
//	public List<Contato> getContatos() {	return contatos;	}
//	public void setContatos(List<Contato> contatos) {	this.contatos = contatos;	}
//	public List<Telefone> getTelefones() {	return telefones;	}
//	public void setTelefones(List<Telefone> telefones) {	this.telefones = telefones;	}
	
//	public List<TipoFornecimento> getTipoFornecimento() {	return tipoFornecimento;	}
//	public void setTipoFornecimento(List<TipoFornecimento> tipoFornecimento) {	this.tipoFornecimento = tipoFornecimento;	}
//	public Status getStatus() {		return status;	}
//	public void setStatus(Status status) {	this.status = status;	}
//	public Status getStatus() {	return status;	}
//	public void setStatus(Status status) {	this.status = status;	}
//	
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

