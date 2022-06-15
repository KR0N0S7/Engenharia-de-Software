package com.empresa.gestao.controllers;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empresa.gestao.entities.Pais;
import com.empresa.gestao.services.ObjectService;
import com.empresa.gestao.services.PaisService;

@Controller
@RequestMapping("pais")
public class PaisController {

	@Autowired
	public ObjectService paisService;
		
	@RequestMapping("editar")
	public ModelAndView salvarPais(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("pais/form.html");
		Object pais;
		if(id == null) {
			pais = new Pais();
		} else {
			try {
				pais = paisService.obterObject(id, Pais.class);
			} catch (Exception e) {
				pais = new Pais();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("pais", pais);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView paisSalvo(@Valid Pais pais, BindingResult  bindingResult, RedirectAttributes redirectAttributes) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, SQLException {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("pais/form.html");
			mv.addObject("pais", pais);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/pais/listar");
		boolean novo = true;
		if (pais.getId() != null) {
			novo = false;
		} 
		if (novo) {
			paisService.salvarObject(pais);
			mv.addObject("pais", new Pais());
		} else {
			Long id = pais.getId();
			paisService.alterarObject(id, pais);
			mv.addObject("pais", pais);
		}
		redirectAttributes.addFlashAttribute("mensagem", "País salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarPaises() throws SQLException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		ModelAndView mv = new ModelAndView("pais/listar.html");
		mv.addObject("lista", paisService.listarObjects(Pais.class));
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirPais(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/pais");
		try {
			paisService.excluirObject(id);
			redirectAttributes.addFlashAttribute("mensagem", "Pa�s exclu�do com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Pa�s.");
		}
		return mv;
	}
}
