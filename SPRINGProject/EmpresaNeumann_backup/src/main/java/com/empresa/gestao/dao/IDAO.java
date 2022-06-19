package com.empresa.gestao.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface IDAO {

	public void salvar(Object objeto) throws SQLException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;
	public Object consultarPorId(Long id, Class<?> clazz) throws SQLException, IllegalAccessException, InvocationTargetException, InstantiationException, IllegalArgumentException, NoSuchMethodException, SecurityException;
	public Object listar(Class<?> clazz) throws SQLException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException;
	public void alterar(Long id, Object objeto) throws SQLException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;
	public void excluir(Object objeto) throws NoSuchFieldException, SecurityException, SQLException, IllegalArgumentException, IllegalAccessException;
}
