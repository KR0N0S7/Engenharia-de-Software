package com.empresa.gestao.dao;

import java.sql.SQLException;

public interface IDAO {

	public void salvar(Object objeto) throws SQLException;
	public Object consultarPorId(Long id, Class<?> clazz) throws SQLException;
	public Object listar(Class<?> clazz) throws SQLException;
	public void alterar(Long id, Object objeto) throws SQLException;
	public void excluir(Long id, Object objeto) throws SQLException;
}
