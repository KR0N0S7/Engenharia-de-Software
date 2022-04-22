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

import com.empresa.gestao.entities.Ramal;
import com.empresa.gestao.services.RamalService;

@Controller
@RequestMapping("ramal")
public class RamalController {

	@Autowired
	public RamalService ramalService;
		
	@RequestMapping("editar")
	public ModelAndView salvarRamal(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("ramal/form.html");
		Ramal ramal;
		if(id == null) {
			ramal = new Ramal();
		} else {
			try {
				ramal = ramalService.obterRamal(id);
			} catch (Exception e) {
				ramal = new Ramal();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("ramal", ramal);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView ramalSalvo(@Valid Ramal ramal, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("ramal/form.html");
			mv.addObject("ramal", ramal);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/ramal/listar");
		boolean novo = true;
		if (ramal == null) {
			novo = false;
		} 
		ramalService.salvarRamal(ramal);
		if (novo) {
			mv.addObject("ramal", new Ramal());
		} else {
			mv.addObject("ramal", ramal);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Ramal salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarRamais() {
		ModelAndView mv = new ModelAndView("ramal/listar.html");
		mv.addObject("lista", ramalService.listarRamais());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirRamal(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/ramal");
		try {
			ramalService.excluirRamal(id);
			redirectAttributes.addFlashAttribute("mensagem", "Ramal excluído com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Ramal.");
		}
		return mv;
	}
}
