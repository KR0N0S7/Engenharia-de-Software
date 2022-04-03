package com.empresa.gestao.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.empresa.gestao.entities.Fornecedor;
import com.empresa.gestao.services.FornecedorService;

@Controller
@RequestMapping("fornecedor")
public class FornecedorController {

	@Autowired
	public FornecedorService fornecedorService;
	
	@RequestMapping("novo")
	public ModelAndView novoFornecedor() {
		ModelAndView mv = new ModelAndView("fornecedor/form.html");
		mv.addObject("fornecedor", new Fornecedor());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "novo")
	public ModelAndView salvarFornecedor(@Valid Fornecedor fornecedor, BindingResult  bindingResult) {
		ModelAndView mv = new ModelAndView("fornecedor/form.html");
		if(bindingResult.hasErrors()) {
			mv.addObject("fornecedor", fornecedor);
			return mv;
		}
		Fornecedor fornecedorSalvo = fornecedorService.salvarFornecedor(fornecedor);
		if (fornecedor == null) {
			mv.addObject("fornecedor", new Fornecedor());
		} else {
			mv.addObject("fornecedor", fornecedorSalvo);
		}
		mv.addObject("mensagem", "Fornecedor salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarFornecedores() {
		ModelAndView mv = new ModelAndView("fornecedor/listar.html");
		mv.addObject("lista", fornecedorService.listarFornecedores());
		return  mv;
	}
}
