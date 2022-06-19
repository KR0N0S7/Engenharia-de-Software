package com.empresa.gestao.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empresa.gestao.entities.Produto;
import com.empresa.gestao.services.ObjectService;
import com.empresa.gestao.services.ProdutoService;

@Controller
@RequestMapping("produto")
public class ProdutoController {

	@Autowired
	public ObjectService produtoService;
		
	@RequestMapping("editar")
	public ModelAndView salvarProduto(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("produto/form.html");
		Produto produto;
		if(id == null) {
			produto = new Produto();
		} else {
			try {
				produto = produtoService.obterProduto(id);
			} catch (Exception e) {
				produto = new Produto();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("produto", produto);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView produtoSalvo(@Valid Produto produto, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("produto/form.html");
			mv.addObject("produto", produto);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/produto/listar");
		boolean novo = true;
		if (produto == null) {
			novo = false;
		} 
		produtoService.salvarProduto(produto);
		if (novo) {
			mv.addObject("produto", new Produto());
		} else {
			mv.addObject("produto", produto);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarProduto() {
		ModelAndView mv = new ModelAndView("produto/listar.html");
		mv.addObject("lista", produtoService.listarProdutos());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirProduto(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/produto");
		try {
			produtoService.excluirProduto(id);
			redirectAttributes.addFlashAttribute("mensagem", "Produto exclu�do com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Produto.");
		}
		return mv;
	}
}
