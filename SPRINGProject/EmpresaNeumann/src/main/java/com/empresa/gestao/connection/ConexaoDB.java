package com.empresa.gestao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

//	public static Connection getConexao() throws SQLException {
//		return DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa_neumann",
//				"root",
//				"root");
//	}
	
	public static Connection getConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:h2:mem:empresa_neumann",
				"sa",
				"");
	}
}
