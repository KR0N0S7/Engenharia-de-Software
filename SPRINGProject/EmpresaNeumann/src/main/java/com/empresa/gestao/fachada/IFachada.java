package com.empresa.gestao.fachada;

import java.sql.SQLException;

public interface IFachada {

    public Object salvar(Object entidade) throws SQLException;

}
