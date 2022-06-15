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

import com.empresa.gestao.entities.Contato;
import com.empresa.gestao.services.ContatoService;
import com.empresa.gestao.services.ObjectService;

@Controller
@RequestMapping("contato")
public class ContatoController {

	@Autowired
	public ObjectService contatoService;
		
	@RequestMapping("editar")
	public ModelAndView salvarContato(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("contato/form.html");
		Contato contato;
		if(id == null) {
			contato = new Contato();
		} else {
			try {
				contato = contatoService.obterContato(id);
			} catch (Exception e) {
				contato = new Contato();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("contato", contato);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView contatoSalvo(@Valid Contato contato, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("contato/form.html");
			mv.addObject("contato", contato);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/contato/listar");
		boolean novo = true;
		if (contato == null) {
			novo = false;
		} 
		contatoService.salvarContato(contato);
		if (novo) {
			mv.addObject("contato", new Contato());
		} else {
			mv.addObject("contato", contato);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Contato salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarContato() {
		ModelAndView mv = new ModelAndView("contato/listar.html");
		mv.addObject("lista", contatoService.listarContatos());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirContato(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/contato");
		try {
			contatoService.excluirContato(id);
			redirectAttributes.addFlashAttribute("mensagem", "Contato exclu�do com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Contato.");
		}
		return mv;
	}
}
