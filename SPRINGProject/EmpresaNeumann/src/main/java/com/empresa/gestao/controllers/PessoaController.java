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

import com.empresa.gestao.entities.Pessoa;
import com.empresa.gestao.services.PessoaService;

@Controller
@RequestMapping("pessoa")
public class PessoaController {

	@Autowired
	public PessoaService pessoaService;
		
	@RequestMapping("editar")
	public ModelAndView salvarPessoa(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("pessoa/form.html");
		Pessoa pessoa;
		if(id == null) {
			pessoa = new Pessoa();
		} else {
			try {
				pessoa = pessoaService.obterPessoa(id);
			} catch (Exception e) {
				pessoa = new Pessoa();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("pessoa", pessoa);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView pessoaSalvo(@Valid Pessoa pessoa, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("pessoa/form.html");
			mv.addObject("pessoa", pessoa);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/pessoa/listar");
		boolean novo = true;
		if (pessoa == null) {
			novo = false;
		} 
		pessoaService.salvarPessoa(pessoa);
		if (novo) {
			mv.addObject("pessoa", new Pessoa());
		} else {
			mv.addObject("pessoa", pessoa);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Pessoa salva com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarPessoas() {
		ModelAndView mv = new ModelAndView("pessoa/listar.html");
		mv.addObject("lista", pessoaService.listarPessoas());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirPessoa(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/pessoa");
		try {
			pessoaService.excluirPessoa(id);
			redirectAttributes.addFlashAttribute("mensagem", "Pessoa excluída com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Pessoa.");
		}
		return mv;
	}
}
