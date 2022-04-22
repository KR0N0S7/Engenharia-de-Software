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

import com.empresa.gestao.entities.Cidade;
import com.empresa.gestao.services.CidadeService;

@Controller
@RequestMapping("cidade")
public class CidadeController {

	@Autowired
	public CidadeService cidadeService;
		
	@RequestMapping("editar")
	public ModelAndView salvarCidade(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("cidade/form.html");
		Cidade cidade;
		if(id == null) {
			cidade = new Cidade();
		} else {
			try {
				cidade = cidadeService.obterCidade(id);
			} catch (Exception e) {
				cidade = new Cidade();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("cidade", cidade);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView fornecedorSalvo(@Valid Cidade cidade, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("cidade/form.html");
			mv.addObject("cidade", cidade);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/cidade/listar");
		boolean novo = true;
		if (cidade == null) {
			novo = false;
		} 
		cidadeService.salvarCidade(cidade);
		if (novo) {
			mv.addObject("cidade", new Cidade());
		} else {
			mv.addObject("cidade", cidade);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Cidade salva com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarCidades() {
		ModelAndView mv = new ModelAndView("cidade/listar.html");
		mv.addObject("lista", cidadeService.listarCidades());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirCidade(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/cidade");
		try {
			cidadeService.excluirCidade(id);
			redirectAttributes.addFlashAttribute("mensagem", "Cidade excluída com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Cidade.");
		}
		return mv;
	}
}
