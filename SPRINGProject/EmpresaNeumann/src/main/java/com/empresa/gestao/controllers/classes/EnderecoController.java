package com.empresa.gestao.controllers.classes;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empresa.gestao.controllers.GenericController;
import com.empresa.gestao.entities.Endereco;

@Controller
@RequestMapping("endereco")
public class EnderecoController extends GenericController{

	@RequestMapping(method = RequestMethod.POST, path = CRIAR_ALTERAR)
	public ModelAndView salvar(@Valid Endereco objeto, BindingResult bindingResult, RedirectAttributes redirectAttributes)
			throws Exception {
		return super.salvar(objeto, bindingResult, redirectAttributes);
	}
}