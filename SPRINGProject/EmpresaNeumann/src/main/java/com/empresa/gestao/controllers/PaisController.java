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

import com.empresa.gestao.entities.Pais;
import com.empresa.gestao.services.PaisService;

@Controller
@RequestMapping("pais")
public class PaisController {

	@Autowired
	public PaisService paisService;
		
	@RequestMapping("editar")
	public ModelAndView salvarPais(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("pais/form.html");
		Pais pais;
		if(id == null) {
			pais = new Pais();
		} else {
			try {
				pais = paisService.obterPais(id);
			} catch (Exception e) {
				pais = new Pais();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("pais", pais);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView paisSalvo(@Valid Pais pais, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("pais/form.html");
			mv.addObject("pais", pais);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/pais/listar");
		boolean novo = true;
		if (pais == null) {
			novo = false;
		} 
		paisService.salvarPais(pais);
		if (novo) {
			mv.addObject("pais", new Pais());
		} else {
			mv.addObject("pais", pais);
		}
		redirectAttributes.addFlashAttribute("mensagem", "País salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarPaies() {
		ModelAndView mv = new ModelAndView("pais/listar.html");
		mv.addObject("lista", paisService.listarPaises());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirPais(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/pais");
		try {
			paisService.excluirPais(id);
			redirectAttributes.addFlashAttribute("mensagem", "País excluído com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir País.");
		}
		return mv;
	}
}
