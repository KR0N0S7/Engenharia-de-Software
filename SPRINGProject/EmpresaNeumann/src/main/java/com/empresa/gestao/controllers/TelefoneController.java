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

import com.empresa.gestao.entities.Telefone;
import com.empresa.gestao.services.TelefoneService;

@Controller
@RequestMapping("telefone")
public class TelefoneController {

	@Autowired
	public TelefoneService telefoneService;
		
	@RequestMapping("editar")
	public ModelAndView salvarTelefone(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("telefone/form.html");
		Telefone telefone;
		if(id == null) {
			telefone = new Telefone();
		} else {
			try {
				telefone = telefoneService.obterTelefone(id);
			} catch (Exception e) {
				telefone = new Telefone();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("telefone", telefone);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView telefoneSalvo(@Valid Telefone telefone, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("telefone/form.html");
			mv.addObject("telefone", telefone);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/telefone/listar");
		boolean novo = true;
		if (telefone == null) {
			novo = false;
		} 
		telefoneService.salvarTelefone(telefone);
		if (novo) {
			mv.addObject("telefone", new Telefone());
		} else {
			mv.addObject("telefone", telefone);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Telefone salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarTelefones() {
		ModelAndView mv = new ModelAndView("telefone/listar.html");
		mv.addObject("lista", telefoneService.listarTelefones());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirTelefone(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/telefone");
		try {
			telefoneService.excluirTelefone(id);
			redirectAttributes.addFlashAttribute("mensagem", "Telefone excluído com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Telefone.");
		}
		return mv;
	}
}
