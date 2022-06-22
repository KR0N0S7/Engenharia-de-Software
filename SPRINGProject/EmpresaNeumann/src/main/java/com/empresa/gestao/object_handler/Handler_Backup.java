//package com.empresa.gestao.object_handler;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.empresa.gestao.services.ObjectService;
//import com.empresa.gestao.services.ObjectSuperService;
//
//@Controller
//@RequestMapping("vh")
//public class Handler_Backup {
//
//	@Autowired
//	ObjectService service;
//	
//	@Autowired
//	ObjectSuperService superService;
//	
//	@RequestMapping("form")
//	public ModelAndView criar() {
//		ObjetoHandler objeto = new ObjetoHandler();
//		ModelAndView mv = new ModelAndView("vh/form.html");
//		mv.addObject("objeto", objeto);
//		return mv;
//	}
//	
//	@RequestMapping(method = RequestMethod.POST, path = "form")
//	public ModelAndView salvarObjetos(ObjetoHandler objeto, BindingResult bindingResult) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, SQLException {
//		ModelAndView mv = new ModelAndView("/index.html");
//		List<Object> lista = new ArrayList<>();
//		lista = ConstrutorObjetos.construir(objeto);
//		
//		for (Object object : lista) {
//			if (object.getClass().getSuperclass().getSimpleName().equals("Object")) {
//				service.salvarObject(object);
//				
//			} else {
//				superService.salvarObject(object);
//			}
//			
//		}
//		mv.addObject("mensagem", "Açao executada com sucesso.");
//		return mv;
//	}
//}
