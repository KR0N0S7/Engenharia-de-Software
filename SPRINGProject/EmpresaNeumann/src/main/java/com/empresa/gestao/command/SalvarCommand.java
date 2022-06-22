package com.empresa.gestao.command;

import java.sql.SQLException;

public class SalvarCommand extends AbstractCommand {

	@Override
	public Object executar(Object entidade) throws SQLException {
		return fachada.salvar(entidade);
	}
}
