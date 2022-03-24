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
