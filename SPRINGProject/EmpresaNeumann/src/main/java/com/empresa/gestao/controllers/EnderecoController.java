package com.empresa.gestao.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.empresa.gestao.entities.Endereco;
import com.empresa.gestao.services.EnderecoService;

@Controller
@RequestMapping("local")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@RequestMapping(path = "novo")
	public ModelAndView novoEndereco() {
		ModelAndView mv = new ModelAndView("local/endereco.html");
		mv.addObject("local", new Endereco());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "novo")
	public ModelAndView salvarEndereco(@Valid Endereco endereco, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("local/endereco.html");
		if(bindingResult.hasErrors()) {
			mv.addObject("local", endereco);
			return mv;
		}
		Endereco enderecoSalvo = enderecoService.salvarEndereco(endereco);
		if (endereco == null) {
			mv.addObject("local", new Endereco());
		} else {
			mv.addObject("local", enderecoSalvo);
		}
		mv.addObject("mensagem", "Endereço salvo com sucecsso!");
		return mv;
	}
	
//	@RequestMapping
//	public ModelAndView listarEndereco() {
//		ModelAndView mv = new ModelAndView();
//		
//		return mv;
//	}
//	
//	@RequestMapping
//	public ModelAndView editarEndereco() {
//		ModelAndView mv = new ModelAndView();
//		
//		return mv;
//	}
//	
//	@RequestMapping
//	public ModelAndView excluirEndereco() {
//		ModelAndView mv = new ModelAndView();
//		
//		return mv;
//	}
}
