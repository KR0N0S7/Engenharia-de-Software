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

import com.empresa.gestao.entities.Fornecedor;
import com.empresa.gestao.services.FornecedorService;

@Controller
@RequestMapping("fornecedor")
public class FornecedorController {

	@Autowired
	public FornecedorService fornecedorService;
		
	@RequestMapping("editar")
	public ModelAndView salvarFornecedor(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("fornecedor/form.html");
		Fornecedor fornecedor;
		if(id == null) {
			fornecedor = new Fornecedor();
		} else {
			try {
				fornecedor = fornecedorService.obterFornecedor(id);
			} catch (Exception e) {
				fornecedor = new Fornecedor();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("fornecedor", fornecedor);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView fornecedorSalvo(@Valid Fornecedor fornecedor, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("fornecedor/form.html");
			mv.addObject("fornecedor", fornecedor);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/fornecedor/listar");
		boolean novo = true;
		if (fornecedor == null) {
			novo = false;
		} 
		fornecedorService.salvarFornecedor(fornecedor);
		if (novo) {
			mv.addObject("fornecedor", new Fornecedor());
		} else {
			mv.addObject("fornecedor", fornecedor);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Fornecedor salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarFornecedores() {
		ModelAndView mv = new ModelAndView("fornecedor/listar.html");
		mv.addObject("lista", fornecedorService.listarFornecedores());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirFornecedor(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/fornecedor");
		try {
			fornecedorService.excluirFornecedor(id);
			redirectAttributes.addFlashAttribute("mensagem", "Fornecedor excluído com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Fornecedor.");
		}
		return mv;
	}
}
