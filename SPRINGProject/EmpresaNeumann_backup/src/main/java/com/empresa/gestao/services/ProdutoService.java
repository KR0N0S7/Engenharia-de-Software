package com.empresa.gestao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.gestao.entities.Produto;
import com.empresa.gestao.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}
	
	public Produto obterProduto(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.get();
	}
	
	public void excluirProduto(Long id) {
		produtoRepository.deleteById(id);
	}
}
