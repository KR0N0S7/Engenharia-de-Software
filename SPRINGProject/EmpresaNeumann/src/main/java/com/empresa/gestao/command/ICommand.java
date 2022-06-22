package com.empresa.gestao.command;

import java.sql.SQLException;
import java.util.List;

import com.empresa.gestao.fachada.ResultadoFachada;

public interface ICommand {
	
	public Object executar(Object entidade) throws SQLException;
	
}

