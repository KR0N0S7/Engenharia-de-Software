package com.empresa.gestao.controllers;

import java.lang.reflect.Method;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empresa.gestao.controllers.html_builder.HtmlBuilder;
import com.empresa.gestao.services.ObjectService;

public abstract class GenericController extends HtmlBuilder {
	
	@Autowired
	public ObjectService service;

	@RequestMapping(CRIAR_ALTERAR)
	public ModelAndView criar(@RequestParam(required = false) Long id) throws Exception {
		String nomeClasse = this.getClass().getSimpleName();
		
		String nomeEntidade = HtmlBuilder.nomeEntidade(nomeClasse);
				
		String pacote = "com.empresa.gestao.entities." + nomeEntidade;
		Class<?> classeEntity = Class.forName(pacote);
		
		String html = HtmlBuilder.construtorForm(nomeClasse);
		
		ModelAndView mv = new ModelAndView(html);		
		Object objeto;
		if(id == null) {
			objeto = classeEntity.getDeclaredConstructor().newInstance();
		} else {
			try {
				objeto = service.obterObject(id, classeEntity);
			} catch (Exception e) {
				objeto = classeEntity.getDeclaredConstructor().newInstance();
				mv.addObject("mensagem", e.getMessage());
			}
		}
		mv.addObject(nomeEntidade.toLowerCase(), objeto);
		return mv;
	}
	
	public ModelAndView salvar(@Valid Object objeto, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception {
		String nomeClasse = this.getClass().getSimpleName();
		
		String nomeEntidade = HtmlBuilder.nomeEntidade(nomeClasse);
		
		String htmlForm = HtmlBuilder.construtorForm(nomeClasse);
//		String redirect = HtmlBuilder.construtorRedirect(nomeClasse);
		
		String pacote = "com.empresa.gestao.entities." + nomeEntidade;
		Class<?> classeEntity = Class.forName(pacote);
				
		String nomeEntidadeLetraMinuscula = nomeEntidade.toLowerCase();
		
		if(bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView(htmlForm);
			mv.addObject(nomeEntidadeLetraMinuscula, objeto);
			return mv;
		}
		ModelAndView mv = new ModelAndView(htmlForm);
		boolean novo = true;
		
//		objeto = objeto.getClass().cast(classeEntity.getDeclaredConstructor().newInstance());
		Method getId = objeto.getClass().getMethod("getId");
		
		if (getId.invoke(objeto) != null) {
			novo = false;
		} 
		if (novo) {
			service.salvarObject(objeto);
			mv.addObject(nomeEntidadeLetraMinuscula, classeEntity.getDeclaredConstructor().newInstance());
		} else {
			Long id = (Long) getId.invoke(objeto);
			service.alterarObject(id, objeto);
			mv.addObject(nomeEntidadeLetraMinuscula, objeto);
		}
		mv.addObject("mensagem", "Ação realizada com sucesso!");
		return mv;
	}
	
	@RequestMapping("/listar")
	public ModelAndView listar() throws Exception {
		String nomeClasse = this.getClass().getSimpleName();
		
		String nomeEntidade = HtmlBuilder.nomeEntidade(nomeClasse);
		
		String htmlListar = HtmlBuilder.construtorListar(nomeClasse);
		
		String pacote = "com.empresa.gestao.entities." + nomeEntidade;
		Class<?> classeEntity = Class.forName(pacote);
		
		ModelAndView mv = new ModelAndView(htmlListar);
		mv.addObject("lista", service.listarObjects(classeEntity));
		return  mv;	
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluir(@RequestParam Long id, RedirectAttributes redirectAttributes) throws Exception {
		String nomeClasse = this.getClass().getSimpleName();
		
		String nomeEntidade = HtmlBuilder.nomeEntidade(nomeClasse);
		
		String pacote = "com.empresa.gestao.entities." + nomeEntidade;
		Class<?> classeEntity = Class.forName(pacote);
		@SuppressWarnings("deprecation")
		Object objeto = classeEntity.newInstance();
		
		ModelAndView mv = new ModelAndView("redirect:/" + nomeEntidade.toLowerCase() + "/listar");
		try {
			service.excluirObject(id, objeto);
			redirectAttributes.addFlashAttribute("mensagem", "Ação realizada com sucesso.");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao tentar excluir.");
		}
		return mv;
	}
}
