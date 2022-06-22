package com.empresa.gestao.validadores;

import java.sql.SQLException;

public interface InterfaceStrategy {

	public String processar(Object entidade) throws SQLException;
}
