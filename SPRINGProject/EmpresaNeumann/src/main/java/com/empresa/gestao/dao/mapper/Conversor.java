package com.empresa.gestao.dao.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Conversor {

	//////Arrumar controllers
	//////
	public static List<Object> mapper(Class<?> clazz, ResultSet resultado) throws SQLException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		ResultSetMetaData metaDados = resultado.getMetaData();
		List<Object> lista = new ArrayList<>();
		
		while (resultado.next()) {

			Object obj = clazz.getDeclaredConstructor().newInstance();
			
			int n = 1;
			for (Field field : obj.getClass().getDeclaredFields()) {
				
				System.out.println(field.getName() + ": " +  resultado.getObject(n));
				System.out.println(metaDados.getColumnLabel(n));
				
				field.setAccessible(true);
				field.set(obj, resultado.getObject(metaDados.getColumnLabel(n)));
				n++;
			}
			lista.add(obj);
		}
		
		return lista;
	}
	
	public static Object construtorMaker(Object objeto, ResultSet resultado) throws SQLException, IllegalArgumentException, IllegalAccessException {
		
		while (resultado.next()) {
			int n = 1;
			for (Field field : objeto.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				field.set(objeto, resultado.getObject(n));
				n++;
			}
		}

		return objeto;		
	}
}
