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

import com.empresa.gestao.entities.TipoEndereco;
import com.empresa.gestao.services.TipoEnderecoService;

@Controller
@RequestMapping("tpend")
public class TipoEnderecoController {

	@Autowired
	public TipoEnderecoService tipoEnderecoService;
		
	@RequestMapping("editar")
	public ModelAndView salvarTipoEndereco(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("tpend/form.html");
		TipoEndereco tpend;
		if(id == null) {
			tpend = new TipoEndereco();
		} else {
			try {
				tpend = tipoEnderecoService.obterTipoEndereco(id);
			} catch (Exception e) {
				tpend = new TipoEndereco();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("tpend", tpend);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView tipoEnderecoSalvo(@Valid TipoEndereco tpend, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("tpend/form.html");
			mv.addObject("tpend", tpend);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/tpend/listar");
		boolean novo = true;
		if (tpend == null) {
			novo = false;
		} 
		tipoEnderecoService.salvarTipoEndereco(tpend);
		if (novo) {
			mv.addObject("tpend", new TipoEndereco());
		} else {
			mv.addObject("tpend", tpend);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Tipo de Endereço salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarTiposEnderecos() {
		ModelAndView mv = new ModelAndView("tpend/listar.html");
		mv.addObject("lista", tipoEnderecoService.listarTiposEnderecos());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirTipoEndereco(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/tpend");
		try {
			tipoEnderecoService.excluirTipoEndereco(id);
			redirectAttributes.addFlashAttribute("mensagem", "Tipo de Endereço excluído com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Tipo de Endereço.");
		}
		return mv;
	}
}
