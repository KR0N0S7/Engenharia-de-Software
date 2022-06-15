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

import com.empresa.gestao.entities.Empresa;
import com.empresa.gestao.services.EmpresaService;
import com.empresa.gestao.services.ObjectService;

@Controller
@RequestMapping("empresa")
public class EmpresaController {

	@Autowired
	public ObjectService empresaService;
		
	@RequestMapping("editar")
	public ModelAndView salvarEmpresa(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("empresa/form.html");
		Empresa empresa;
		if(id == null) {
			empresa = new Empresa();
		} else {
			try {
				empresa = empresaService.obterEmpresa(id);
			} catch (Exception e) {
				empresa = new Empresa();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("empresa", empresa);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView empresaSalvo(@Valid Empresa empresa, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("empresa/form.html");
			mv.addObject("empresa", empresa);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/empresa/listar");
		boolean novo = true;
		if (empresa == null) {
			novo = false;
		} 
		empresaService.salvarEmpresa(empresa);
		if (novo) {
			mv.addObject("empresa", new Empresa());
		} else {
			mv.addObject("empresa", empresa);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Empresa salva com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarEmpresas() {
		ModelAndView mv = new ModelAndView("empresa/listar.html");
		mv.addObject("lista", empresaService.listarEmpresas());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirEmpresa(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/empresa");
		try {
			empresaService.excluirEmpresa(id);
			redirectAttributes.addFlashAttribute("mensagem", "Empresa exclu�da com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Empresa.");
		}
		return mv;
	}
}
