package com.empresa.gestao.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.empresa.gestao.connection.ConexaoDB;
import com.empresa.gestao.dao.sql.SqlGenerator;
import com.empresa.gestao.entities.Estado;

public class DAO implements IDAO {

	@Override
	public void salvar(Object objeto) throws SQLException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
			
//		Tabela tabela = objeto
//				.getClass()
//				.getDeclaredAnnotation(Tabela.class);
//		
//		String nomeTabela = objeto
//				.getClass()
//				.getSimpleName()
//				.toLowerCase();
//		
//		Table tabelaRenomeada = objeto
//				.getClass()
//				.getDeclaredAnnotation(Table.class);
//		
//		if (tabelaRenomeada != null) {
//			nomeTabela = tabelaRenomeada.name();
//		}
//		
//		if (null != tabela && !tabela.nome().equals("_SEM_NOME_")) {
//			nomeTabela = tabela.nome();
//		}
		
		String nomeTabela = SqlGenerator.gerarSQL(objeto);
		
		String sql = "INSERT INTO " + nomeTabela;
		sql += "(";
		
		String parteFinalSQL = " VALUES(";
		Field[] atributos = objeto.getClass().getDeclaredFields();
		for (Field atributo : atributos) {
			Transiente transiente = atributo.getDeclaredAnnotation(Transiente.class);
			if (null != transiente) {
				continue;
			}
			Id id = atributo.getDeclaredAnnotation(Id.class);
			if (null == id) {
				String nomeColuna = atributo
						.getName()
						.toLowerCase();
				Coluna coluna = atributo.getDeclaredAnnotation(Coluna.class);
				ChaveEstrangeira chaveEstrangeira = atributo.getDeclaredAnnotation(ChaveEstrangeira.class);
				if (chaveEstrangeira != null) {
					nomeColuna += "_id";
				}
				Column column = atributo.getDeclaredAnnotation(Column.class);
				if (column != null) {
					nomeColuna = column.name();
				}
				if (null != coluna && !coluna.nome().equals("_SEM_NOME_")) {
					nomeColuna = coluna.nome();
				}
				sql +=  nomeColuna + ", ";
				parteFinalSQL += "?, ";
			}
		}
		sql = sql.substring(0, sql.length() - 2) + ")";
		sql += parteFinalSQL.substring(0, parteFinalSQL.length() - 2) + ")";
		
//		Connection conexao = ConexaoDB.getConexao();
//		PreparedStatement psql = conexao.prepareStatement(sql);
//		
//		int i = 1;
//		for (Field atributo : atributos) {
//			Transiente transiente = atributo.getDeclaredAnnotation(Transiente.class);
//			if (null != transiente) {
//				continue;
//			}
//			Id id = atributo.getDeclaredAnnotation(Id.class);
//			if (null == id) {
//				atributo.setAccessible(true);
//				psql.setObject(i++, atributo.get(objeto));
//			}
//		}
//		psql.execute();
//		conexao.close();
		System.out.println(sql);
	}

	@Override
	public void alterar(Object objeto) {
		
		
		String sql = "ALTER TABLE";
	}

	@Override
	public void excluir(Object objeto) throws NoSuchFieldException, SecurityException, SQLException, IllegalArgumentException, IllegalAccessException {
		
		String nomeTabela = SqlGenerator.gerarSQL(objeto);
		
		String sql = "DELETE FROM " + nomeTabela + " WHERE id=?";
		
//		Connection conexao = ConexaoDB.getConexao();
//		PreparedStatement psql = conexao.prepareStatement(sql);
//		
//		Field id = objeto
//				.getClass()
//				.getDeclaredField("id");
//		id.setAccessible(true);
//		psql.setObject(1, id.get(objeto));
//		
//		psql.execute();
//		conexao.close();
		System.out.println(sql);
	}

	@Override
	public List<Object> listar(Object objeto) {
		
		String nomeTabela = SqlGenerator.gerarSQL(objeto);
		
		String sql = "SELECT * FROM " + nomeTabela;
		
		System.out.println(sql);
		
		return null;
	}

	@Override
	public Object consultarPorId(Object objeto) throws SQLException {
		
		// SELECT * FROM nome_tabela WHERE tabela_id = ?;
		
		String nomeTabela = SqlGenerator.gerarSQL(objeto);
		
		String sql = "SELECT * FROM " + nomeTabela + " WHERE id=?";
		
		
//		Connection conexao = ConexaoDB.getConexao();
//		
//		
//		psql.execute();
//		conexao.close();
		System.out.println(sql);
		return null;
	}
}
