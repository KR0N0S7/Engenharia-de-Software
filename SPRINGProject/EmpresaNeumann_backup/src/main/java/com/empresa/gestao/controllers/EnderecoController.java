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

import com.empresa.gestao.entities.Endereco;
import com.empresa.gestao.services.EnderecoService;
import com.empresa.gestao.services.ObjectService;

@Controller
@RequestMapping("local")
public class EnderecoController {

	@Autowired
	private ObjectService enderecoService;
	
	@RequestMapping("editar")
	public ModelAndView salvarEndereco(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("local/endereco.html");
		Object endereco;
		if (id == null) {
			endereco = new Endereco();
		} else {
			try {
				endereco = enderecoService.obterObject(id, Endereco.class);
			} catch (Exception e) {
				endereco = new Endereco();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("local", endereco);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView salvarEndereco(@Valid Endereco endereco, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, SQLException {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("local/endereco.html");
			mv.addObject("local", endereco);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/local/listar");
		boolean novo = true;
		if (endereco.getId() != null) {
			novo = false;
		}
		enderecoService.salvarObject(endereco);
		if (novo) {
			mv.addObject("local", new Endereco());
		} else {
			mv.addObject("local", endereco);
		}
		mv.addObject("mensagem", "Endere�o salvo com sucecsso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarEndereco() throws NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, SQLException {
		ModelAndView mv = new ModelAndView("local/listar.html");
		mv.addObject("lista", enderecoService.listarObjects(Endereco.class));
		return mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirEndereco(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/local");
		try {
			enderecoService.excluirObject(id);
			redirectAttributes.addFlashAttribute("mensagem", "Endere�o exclu�do com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir endere�o." + e.getMessage());
		}
		return mv;
	}
}
