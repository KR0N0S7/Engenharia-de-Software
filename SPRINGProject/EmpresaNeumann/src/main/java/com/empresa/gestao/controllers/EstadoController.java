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

import com.empresa.gestao.entities.Estado;
import com.empresa.gestao.services.EstadoService;
import com.empresa.gestao.services.ObjectService;

@Controller
@RequestMapping("estado")
public class EstadoController {

	@Autowired
	public ObjectService estadoService;
		
	@RequestMapping("editar")
	public ModelAndView salvarEstado(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("estado/form.html");
		Estado estado;
		if(id == null) {
			estado = new Estado();
		} else {
			try {
				estado = estadoService.obterEstado(id);
			} catch (Exception e) {
				estado = new Estado();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("estado", estado);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView estadoSalvo(@Valid Estado estado, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("estado/form.html");
			mv.addObject("estado", estado);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/estado/listar");
		boolean novo = true;
		if (estado == null) {
			novo = false;
		} 
		estadoService.salvarEstado(estado);
		if (novo) {
			mv.addObject("estado", new Estado());
		} else {
			mv.addObject("estado", estado);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Estado salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarEstados() {
		ModelAndView mv = new ModelAndView("estado/listar.html");
		mv.addObject("lista", estadoService.listarEstados());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirEstado(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/estado");
		try {
			estadoService.excluirEstado(id);
			redirectAttributes.addFlashAttribute("mensagem", "Estado exclu�do com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Estado.");
		}
		return mv;
	}
}
