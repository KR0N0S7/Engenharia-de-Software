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

import com.empresa.gestao.entities.CNAE;
import com.empresa.gestao.services.ObjectService;

@Controller
@RequestMapping("cnae")
public class CNAEController {

	@Autowired
	public ObjectService cnaeService;
		
	@RequestMapping("editar")
	public ModelAndView salvarCNAE(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("cnae/form.html");
		Object cnae;
		if(id == null) {
			cnae = new CNAE();
		} else {
			try {
				cnae = cnaeService.obterObject(id);
			} catch (Exception e) {
				cnae = new CNAE();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("cnae", cnae);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView cnaeSalvo(@Valid CNAE cnae, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("cnae/form.html");
			mv.addObject("cnae", cnae);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/cnae/listar");
		boolean novo = true;
		if (cnae == null) {
			novo = false;
		} 
		cnaeService.salvarObject(cnae);
		if (novo) {
			mv.addObject("cnae", new CNAE());
		} else {
			mv.addObject("cnae", cnae);
		}
		redirectAttributes.addFlashAttribute("mensagem", "CNAE salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarCNAEs() {
		ModelAndView mv = new ModelAndView("cnae/listar.html");
		mv.addObject("lista", cnaeService.listarObject());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirCNAE(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/cnae");
		try {
			cnaeService.excluirObject(id);
			redirectAttributes.addFlashAttribute("mensagem", "CNAE exclu�da com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir CANE.");
		}
		return mv;
	}
}
