package com.empresa.gestao.fornecedor;

public class Telefone {

	private String ddd;
	private String numero;
	private String ddi;
	private Contato contato;
	private Fornecedor fornnecedor;
	private TipoTelefone tipoTelefone;
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDdi() {
		return ddi;
	}
	public void setDdi(String ddi) {
		this.ddi = ddi;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	public Fornecedor getFornnecedor() {
		return fornnecedor;
	}
	public void setFornnecedor(Fornecedor fornnecedor) {
		this.fornnecedor = fornnecedor;
	}
	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}
	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
}
