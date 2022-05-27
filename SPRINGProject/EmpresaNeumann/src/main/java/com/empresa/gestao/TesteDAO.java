package com.empresa.gestao;

import java.sql.SQLException;

import com.empresa.gestao.dao.DAO;
import com.empresa.gestao.entities.Estado;
import com.empresa.gestao.entities.Fornecedor;
import com.empresa.gestao.entities.Pais;

public class TesteDAO {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, SQLException, NoSuchFieldException, SecurityException {

		DAO dao = new DAO();
		Pais pais = new Pais("Brasil");
		dao.salvar(pais);
		
		Estado uf = new Estado("Rio de Janeiro", "RJ");
		dao.salvar(uf);
		
		Fornecedor fornecedor = new Fornecedor();
		dao.listar(fornecedor);
		dao.consultarPorId(fornecedor);
		dao.excluir(fornecedor);
	}

}
