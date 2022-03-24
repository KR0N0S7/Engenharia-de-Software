package com.empresa.gestao.fornecedor;

import java.util.List;

import com.empresa.gestao.empresa.Empresa;
import com.empresa.gestao.endereco.CNAE;
import com.empresa.gestao.endereco.Endereco;
import com.empresa.gestao.produto.Produto;
import com.empresa.gestao.produto.Status;
import com.empresa.gestao.servico.OrdemServico;
import com.empresa.gestao.servico.Servico;

public class Fornecedor {

	private boolean isRascunho;
	private int id;
	private String email;
	private String cnpj;
	private String inscricaoEstadual;
	private String inscricaoMunicipal;
	private long dtCadastro;
	private String rzSocial;
	private String nmFantasia;
	private Endereco endereco;
	private List<CNAE> cnae;
	private List<Empresa> empresas;	
	public boolean isRascunho() {
		return isRascunho;
	}

	public void setRascunho(boolean isRascunho) {
		this.isRascunho = isRascunho;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public long getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(long dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public String getRzSocial() {
		return rzSocial;
	}

	public void setRzSocial(String rzSocial) {
		this.rzSocial = rzSocial;
	}

	public String getNmFantasia() {
		return nmFantasia;
	}

	public void setNmFantasia(String nmFantasia) {
		this.nmFantasia = nmFantasia;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<CNAE> getCnae() {
		return cnae;
	}

	public void setCnae(List<CNAE> cnae) {
		this.cnae = cnae;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<OrdemServico> getOrdemServicos() {
		return ordemServicos;
	}

	public void setOrdemServicos(List<OrdemServico> ordemServicos) {
		this.ordemServicos = ordemServicos;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public List<TipoFornecimento> getTipoFornecimento() {
		return tipoFornecimento;
	}

	public void setTipoFornecimento(List<TipoFornecimento> tipoFornecimento) {
		this.tipoFornecimento = tipoFornecimento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	private List<OrdemServico> ordemServicos;
	private List<Servico> servicos;
	private List<Produto> produtos;
	private List<Contato> contatos;
	private List<Telefone> telefone;
	private List<TipoFornecimento> tipoFornecimento;
	private Status status;
	
	public void salvar() {
		
	}
	
	public void alterar() {
		
	}
	
	public Fornecedor consultar() {
		return null;
	}
	
	public void excluir() {
		
	}
	
	public void inativar() {
		
	}
	
	public void ativar() {
		
	}
	
	public void addContato(Contato contato) {
		contatos.add(contato);
	}
	
	public void validarCNPJ() {
		
	}
	
	public void validarListarFornecimento() {
		
	}
}
