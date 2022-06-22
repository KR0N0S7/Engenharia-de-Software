package com.empresa.gestao.object_handler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.empresa.gestao.command.ICommand;
import com.empresa.gestao.command.SalvarCommand;
import com.empresa.gestao.fachada.ResultadoFachada;
import com.empresa.gestao.services.ObjectService;
import com.empresa.gestao.services.ObjectSuperService;

@Controller
@RequestMapping("vh")
public class Handler {
	
	@RequestMapping("form")
	public ModelAndView criar() {
		ObjetoHandler objeto = new ObjetoHandler();
		ModelAndView mv = new ModelAndView("vh/form.html");
		mv.addObject("objeto", objeto);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "form")
	public ModelAndView salvarObjetos(ObjetoHandler objeto, BindingResult bindingResult) throws SQLException {
		ModelAndView mv = new ModelAndView("/index2.html");
		
		ICommand comandoSalvar = new SalvarCommand();
		Object lista = comandoSalvar.executar(objeto);
		
		mv.addObject("lista", lista);
		return mv;
	}
}
