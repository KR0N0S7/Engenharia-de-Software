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

import com.empresa.gestao.entities.TipoLogradouro;
import com.empresa.gestao.services.ObjectService;
import com.empresa.gestao.services.TipoLogradouroService;

@Controller
@RequestMapping("tplog")
public class TipoLogradouroController {

	@Autowired
	public ObjectService tipoLogradouroService;
		
	@RequestMapping("editar")
	public ModelAndView salvarTipoLogradouro(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("tplog/form.html");
		TipoLogradouro tplog;
		if(id == null) {
			tplog = new TipoLogradouro();
		} else {
			try {
				tplog = tipoLogradouroService.obterTipoLogradouro(id);
			} catch (Exception e) {
				tplog = new TipoLogradouro();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("tplog", tplog);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView tipoLogradouroSalvo(@Valid TipoLogradouro tplog, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("tplog/form.html");
			mv.addObject("pessoa", tplog);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/tplog/listar");
		boolean novo = true;
		if (tplog == null) {
			novo = false;
		} 
		tipoLogradouroService.salvarTipoLogradouro(tplog);
		if (novo) {
			mv.addObject("tplog", new TipoLogradouro());
		} else {
			mv.addObject("tplog", tplog);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Tipo de Logradouro salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarTiposLogradouros() {
		ModelAndView mv = new ModelAndView("tplog/listar.html");
		mv.addObject("lista", tipoLogradouroService.listarTiposLogradouros());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirTipoLogradouro(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/tplog");
		try {
			tipoLogradouroService.excluirTipoLogradouro(id);
			redirectAttributes.addFlashAttribute("mensagem", "Tipo de Logradouro exclu�do com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Tipo de Logradouro.");
		}
		return mv;
	}
}
