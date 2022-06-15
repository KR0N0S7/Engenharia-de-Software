package com.empresa.gestao.services;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.empresa.gestao.dao.IDAO;

@Service
public class ObjectService {

	IDAO dao;

	public ObjectService(IDAO dao) {
		this.dao = dao;
	}

	public void salvarObject(Object obj) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, SQLException {
		dao.salvar(obj);
	}

	public Object listarObjects(Class<?> clazz) throws SQLException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		return dao.listar(clazz);
	}

	public Object obterObject(Long id, Class<?> clazz) throws SQLException, IllegalAccessException, InvocationTargetException, InstantiationException, IllegalArgumentException, NoSuchMethodException, SecurityException {
		Object obj = dao.consultarPorId(id, clazz);
		return obj;
	}
	
	public void alterarObject(Long id, Object obj) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, SQLException {
		dao.alterar(id, obj);
	}

	public void excluirObject(Long id) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		dao.excluir(id);
	}
}
