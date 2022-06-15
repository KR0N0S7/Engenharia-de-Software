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

import com.empresa.gestao.entities.Servico;
import com.empresa.gestao.services.ObjectService;
import com.empresa.gestao.services.ServicoService;

@Controller
@RequestMapping("servico")
public class ServicoController {

	@Autowired
	public ObjectService servicoService;
		
	@RequestMapping("editar")
	public ModelAndView salvarServico(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("servico/form.html");
		Servico servico;
		if(id == null) {
			servico = new Servico();
		} else {
			try {
				servico = servicoService.obterServico(id);
			} catch (Exception e) {
				servico = new Servico();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("servico", servico);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView servicoSalvo(@Valid Servico servico, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("servico/form.html");
			mv.addObject("servico", servico);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/servico/listar");
		boolean novo = true;
		if (servico == null) {
			novo = false;
		} 
		servicoService.salvarServico(servico);
		if (novo) {
			mv.addObject("servico", new Servico());
		} else {
			mv.addObject("servico", servico);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Servi�o salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarServicos() {
		ModelAndView mv = new ModelAndView("servico/listar.html");
		mv.addObject("lista", servicoService.listarServicos());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirServico(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/servico");
		try {
			servicoService.excluirServico(id);
			redirectAttributes.addFlashAttribute("mensagem", "Servi�o exclu�do com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Servi�o.");
		}
		return mv;
	}
}
