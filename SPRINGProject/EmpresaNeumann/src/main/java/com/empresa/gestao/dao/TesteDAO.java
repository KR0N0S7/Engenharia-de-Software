package com.empresa.gestao.dao;

import java.lang.reflect.Field;
import java.sql.SQLException;

import com.empresa.gestao.entities.Pais;

public class TesteDAO {

	public static void main(String[] args) throws SQLException {
		
		
		AbstractDAO.consultarUltimaEntrada("Pais");
		
		Pais pais = new Pais();
		Field[] atributo = pais.getClass().getFields();
		
		for (Field field : atributo) {
			System.out.println(field.getName().toString());
			
		}
		
		
	}
}
