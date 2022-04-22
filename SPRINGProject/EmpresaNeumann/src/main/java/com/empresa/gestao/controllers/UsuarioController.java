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

import com.empresa.gestao.entities.Usuario;
import com.empresa.gestao.services.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	public UsuarioService usuarioService;
		
	@RequestMapping("editar")
	public ModelAndView salvarUsuario(@RequestParam(required = false) Long id) {
		ModelAndView mv = new ModelAndView("usuario/form.html");
		Usuario usuario;
		if(id == null) {
			usuario = new Usuario();
		} else {
			try {
				usuario = usuarioService.obterUsuario(id);
			} catch (Exception e) {
				usuario = new Usuario();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "editar")
	public ModelAndView usuarioSalvo(@Valid Usuario usuario, BindingResult  bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("usuario/form.html");
			mv.addObject("usuario", usuario);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/usuario/listar");
		boolean novo = true;
		if (usuario == null) {
			novo = false;
		} 
		usuarioService.salvarUsuario(usuario);
		if (novo) {
			mv.addObject("usuario", new Usuario());
		} else {
			mv.addObject("usuario", usuario);
		}
		redirectAttributes.addFlashAttribute("mensagem", "Usuario salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listarUsuarios() {
		ModelAndView mv = new ModelAndView("usuario/listar.html");
		mv.addObject("lista", usuarioService.listarUsuarios());
		return  mv;
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirUsuario(@RequestParam long id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/usuario");
		try {
			usuarioService.excluirUsuario(id);
			redirectAttributes.addFlashAttribute("mensagem", "Usuário excluído com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Usuário.");
		}
		return mv;
	}
}
