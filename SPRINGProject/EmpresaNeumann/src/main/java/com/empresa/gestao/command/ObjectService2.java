package com.empresa.gestao.command;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.empresa.gestao.dao.IDAO;
import com.empresa.gestao.fachada.Fachada;
import com.empresa.gestao.fachada.IFachada;

@Service
public class ObjectService2 {

//	IDAO dao;
//	IFachada fachada;
//
//	public ObjectService(IFachada fachada) {
//		this.dao = dao;
//		this.fachada = fachada;
//	}

	public void salvarObject(Object obj) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, SQLException {
		IFachada fachada = new Fachada(obj.getClass());
		fachada.salvar(obj);
	}

	public Object listarObjects(Class<?> clazz) throws SQLException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		IFachada fachada = new Fachada(clazz);
		return dao.listar(clazz);
	}

	public Object obterObject(Long id, Class<?> clazz) throws SQLException, IllegalAccessException, InvocationTargetException, InstantiationException, IllegalArgumentException, NoSuchMethodException, SecurityException {
		Object obj = dao.consultarPorId(id, clazz);
		return obj;
	}
	
	public void alterarObject(Long id, Object obj) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, SQLException {
		dao.alterar(id, obj);
	}

	public void excluirObject(Long id, Object objeto) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		dao.excluir(id, objeto);
	}
}
