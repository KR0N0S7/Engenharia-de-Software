package com.empresa.gestao.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO {

	public void salvar(Object objeto) throws SQLException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;
	public Object consultarPorId(Object objeto) throws SQLException;
	public List<Object> listar(Object objeto);
	public void alterar(Object objeto);
	public void excluir(Object objeto) throws NoSuchFieldException, SecurityException, SQLException, IllegalArgumentException, IllegalAccessException;
}
