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

import com.empresa.gestao.entities.OrdemServico;
import com.empresa.gestao.services.OrdemServicoService;

@Controller
@RequestMapping("os")
public class OrdemServicoController {

	@Autowired
	public OrdemServicoService ordemServicoService;
		
	@RequestMapping("editar")
	public ModelAndView salvarOS(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("os/form.html");
		OrdemServico ordemServico;
		if(id == null) {
			ordemServico = new OrdemServico();
		} else {
			try {
				ordemServico = ordemServicoService.obterOrdemServico(id);
			} catch (Exception e) {
				ordemServico = new OrdemServico();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("os", ordemServico);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView osSalvo(@Valid OrdemServico ordemServico, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("os/form.html");
			mv.addObject("os", ordemServico);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/os/listar");
		boolean novo = true;
		if (ordemServico == null) {
			novo = false;
		} 
		ordemServicoService.salvarOrdemServico(ordemServico);
		if (novo) {
			mv.addObject("os", new OrdemServico());
		} else {
			mv.addObject("os", ordemServico);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Ordem de Serviço salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarOSs() {
		ModelAndView mv = new ModelAndView("os/listar.html");
		mv.addObject("lista", ordemServicoService.listarOrdensServicos());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirOS(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/os");
		try {
			ordemServicoService.excluirOrdemServico(id);
			redirectAttributes.addFlashAttribute("mensagem", "Ordem de Serviço excluído com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Orde de Serviço.");
		}
		return mv;
	}
}
