package com.empresa.gestao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.empresa.gestao.entities.Endereco;

@Controller
@RequestMapping("local")
public class EnderecoController {

	@RequestMapping(path = "endereco")
	public ModelAndView novoEndereco() {
		ModelAndView mv = new ModelAndView("local/endereco.html");
		mv.addObject("local", new Endereco());
		return mv;
	}
}
