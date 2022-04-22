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

import com.empresa.gestao.entities.Departamento;
import com.empresa.gestao.services.DepartamentoService;

@Controller
@RequestMapping("departamento")
public class DepartamentoController {

	@Autowired
	public DepartamentoService departamentoService;
		
	@RequestMapping("editar")
	public ModelAndView salvarDepartamento(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("departamento/form.html");
		Departamento departamento;
		if(id == null) {
			departamento = new Departamento();
		} else {
			try {
				departamento = departamentoService.obterDepartamento(id);
			} catch (Exception e) {
				departamento = new Departamento();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("departamento", departamento);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView departamentoSalvo(@Valid Departamento departamento, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("departamento/form.html");
			mv.addObject("departamento", departamento);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/departamento/listar");
		boolean novo = true;
		if (departamento == null) {
			novo = false;
		} 
		departamentoService.salvarDepartamento(departamento);
		if (novo) {
			mv.addObject("departamento", new Departamento());
		} else {
			mv.addObject("departamento", departamento);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Departamento salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarDepartamentos() {
		ModelAndView mv = new ModelAndView("departamento/listar.html");
		mv.addObject("lista", departamentoService.listarDepartamentos());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirDepartamento(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/departamento");
		try {
			departamentoService.excluirDepartamento(id);
			redirectAttributes.addFlashAttribute("mensagem", "Departamento excluído com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Departamento.");
		}
		return mv;
	}
}
