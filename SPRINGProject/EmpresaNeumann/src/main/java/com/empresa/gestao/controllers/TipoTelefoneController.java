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

import com.empresa.gestao.entities.TipoTelefone;
import com.empresa.gestao.services.TipoTelefoneService;

@Controller
@RequestMapping("tptel")
public class TipoTelefoneController {

	@Autowired
	public TipoTelefoneService tipoTelefoneService;
		
	@RequestMapping("editar")
	public ModelAndView salvarTipoTelefone(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("tptel/form.html");
		TipoTelefone tptel;
		if(id == null) {
			tptel = new TipoTelefone();
		} else {
			try {
				tptel = tipoTelefoneService.obterTipoTelefone(id);
			} catch (Exception e) {
				tptel = new TipoTelefone();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("tptel", tptel);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView tipoTelefoneSalvo(@Valid TipoTelefone tptel, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("tptel/form.html");
			mv.addObject("tptel", tptel);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/tptel/listar");
		boolean novo = true;
		if (tptel == null) {
			novo = false;
		} 
		tipoTelefoneService.salvarTipoTelefone(tptel);
		if (novo) {
			mv.addObject("tptel", new TipoTelefone());
		} else {
			mv.addObject("tptel", tptel);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Tipo de Telefone salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarTiposTelefones() {
		ModelAndView mv = new ModelAndView("tptel/listar.html");
		mv.addObject("lista", tipoTelefoneService.listarTiposTelefones());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirTipoTelefone(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/tptel");
		try {
			tipoTelefoneService.excluirTipoTelefone(id);
			redirectAttributes.addFlashAttribute("mensagem", "Tipo de Telefone excluído com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Tipo de Telefone.");
		}
		return mv;
	}
}
