package com.empresa.gestao.services;

import java.sql.SQLException;

import com.empresa.gestao.dao.DAO;
import com.empresa.gestao.dao.IDAO;

public class AbstractService implements IService {

	IDAO dao = new DAO();
	
	
	public void salvarObject(Object obj) throws SQLException {
		dao.salvar(obj);
	}

	public Object listarObjects(Class<?> clazz) throws SQLException {
		return dao.listar(clazz);
	}

	public Object obterObject(Long id, Class<?> clazz) throws SQLException {
		Object obj = dao.consultarPorId(id, clazz);
		return obj;
	}
	
	public void alterarObject(Long id, Object obj) throws SQLException {
		dao.alterar(id, obj);
	}

	public void excluirObject(Long id, Object objeto) throws SQLException {
		dao.excluir(id, objeto);
	}
	
}
