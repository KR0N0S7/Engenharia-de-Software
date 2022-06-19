package com.empresa.gestao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.empresa.gestao.dao.DAO;
import com.empresa.gestao.entities.Endereco;
import com.empresa.gestao.entities.Estado;
import com.empresa.gestao.entities.Fornecedor;
import com.empresa.gestao.entities.Pais;
import com.empresa.gestao.services.ObjectService;

public class TesteDAO {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, SQLException, NoSuchFieldException, SecurityException, InvocationTargetException, InstantiationException, NoSuchMethodException {

		DAO dao = new DAO();
//		Pais pais = new Pais("Brasil");
		Object resultado = dao.consultarPorId(1l, Pais.class);
		System.out.println(resultado.toString());
		
//		Estado uf = new Estado("Rio de Janeiro", "RJ");
//		dao.salvar(uf);
		
//		Fornecedor fornecedor = new Fornecedor(1, "teste2@teste", "123456789", "asd", "qwerty", 123, "rfvedc", "oiesrt");
//		ObjectService os = new ObjectService(dao);
//		os.alterarObject((long) 1, fornecedor);
		
		
	}

}
