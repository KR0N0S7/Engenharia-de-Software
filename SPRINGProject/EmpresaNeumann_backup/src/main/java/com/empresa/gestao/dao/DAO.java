package com.empresa.gestao.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.empresa.gestao.connection.ConexaoDB;
import com.empresa.gestao.dao.mapper.Conversor;
import com.empresa.gestao.dao.sql.SqlGenerator;

@Repository
@Scope(value = "prototype")
public class DAO implements IDAO {

	@Override
	public void salvar(Object objeto) throws SQLException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
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
				ManyToMany mTm = atributo.getDeclaredAnnotation(ManyToMany.class);
				OneToMany oTm = atributo.getDeclaredAnnotation(OneToMany.class);
				
				if (mTm == null && oTm == null) {
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
		}
		sql = sql.substring(0, sql.length() - 2) + ")";
		sql += parteFinalSQL.substring(0, parteFinalSQL.length() - 2) + ")";
		
		Connection conexao = ConexaoDB.getConexao();
		PreparedStatement psql = conexao.prepareStatement(sql);
		
		int i = 1;
		for (Field atributo : atributos) {
			Transiente transiente = atributo.getDeclaredAnnotation(Transiente.class);
			if (null != transiente) {
				continue;
			}
			ManyToMany mTm = atributo.getDeclaredAnnotation(ManyToMany.class);
			OneToMany oTm = atributo.getDeclaredAnnotation(OneToMany.class);
			
			if (mTm == null && oTm == null) {
				Id id = atributo.getDeclaredAnnotation(Id.class);
				if (null == id) {
					atributo.setAccessible(true);
					psql.setObject(i++, atributo.get(objeto));
				}
			}
		}
		psql.execute();
		conexao.close();
		System.out.println(sql);
	}

	@Override
	public void alterar(Long id, Object objeto) throws SQLException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		String nomeTabela = SqlGenerator.gerarSQL(objeto);
		
		String sql = "UPDATE " + nomeTabela;
		String parteFinal = " SET ";
		
		Field[] atributos = objeto.getClass().getDeclaredFields();
		for (Field atributo : atributos) {
			Transiente transiente = atributo.getDeclaredAnnotation(Transiente.class);
			if (null != transiente) {
				continue;
			}
			
			Id identificacao = atributo.getDeclaredAnnotation(Id.class);
			if (null != identificacao) {
				continue;
			}
			
			ManyToMany mTm = atributo.getDeclaredAnnotation(ManyToMany.class);
			OneToMany oTm = atributo.getDeclaredAnnotation(OneToMany.class);
			
			if (mTm == null && oTm == null) {
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
				nomeColuna += " = ";
				parteFinal += nomeColuna + "?, ";
			}
		}
		sql = sql + parteFinal;
		sql = sql.substring(0, sql.length() - 2) + " WHERE id=" + id;
				
		Connection conexao = ConexaoDB.getConexao();
		PreparedStatement psql = conexao.prepareStatement(sql);
		
		int i = 1;
		for (Field atributo : atributos) {
			Transiente transiente = atributo.getDeclaredAnnotation(Transiente.class);
			if (null != transiente) {
				continue;
			}
			Id identificacao = atributo.getDeclaredAnnotation(Id.class);
			if (null != identificacao) {
				continue;
			}
			ManyToMany mTm = atributo.getDeclaredAnnotation(ManyToMany.class);
			OneToMany oTm = atributo.getDeclaredAnnotation(OneToMany.class);
			
			if (mTm == null && oTm == null) {
				atributo.setAccessible(true);
				psql.setObject(i++, atributo.get(objeto));
			}
		}
		psql.execute();
		conexao.close();
		System.out.println(sql);
	}

	@Override
	public void excluir(Object objeto) throws NoSuchFieldException, SecurityException, SQLException, IllegalArgumentException, IllegalAccessException {
		
		String nomeTabela = SqlGenerator.gerarSQL(objeto);
		
		String sql = "DELETE FROM " + nomeTabela + " WHERE id=?";
		
		Connection conexao = ConexaoDB.getConexao();
		PreparedStatement psql = conexao.prepareStatement(sql);
		
		Field id = objeto
				.getClass()
				.getDeclaredField("id");
		id.setAccessible(true);
		psql.setObject(1, id.get(objeto));
		
		psql.execute();
		conexao.close();
		System.out.println(sql);
	}

	@Override
	public Object listar(Class<?> clazz) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException {
				
		Object objeto = clazz.getConstructor().newInstance();
		
		String nomeTabela = SqlGenerator.gerarSQL(objeto);
		
		String sql = "SELECT * FROM " + nomeTabela;
		
		Connection conexao = ConexaoDB.getConexao();
		PreparedStatement psql = conexao.prepareStatement(sql);
		
		ResultSet resultado = psql.executeQuery();
			
		Object lista = null;
		try {
			
			lista = Conversor.mapper(clazz, resultado);
		} catch (SecurityException |
				IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		conexao.close();
		System.out.println(sql);
		
		return lista;
	}

	@Override
	public Object consultarPorId(Long id, Class<?> clazz) throws SQLException, IllegalAccessException, InvocationTargetException, InstantiationException, IllegalArgumentException, NoSuchMethodException, SecurityException {
		
		Object objeto = clazz.getConstructor().newInstance();
		
		String nomeTabela = SqlGenerator.gerarSQL(objeto);
		
		String sql = "SELECT * FROM " + nomeTabela + " WHERE id=" + id;
 
		Connection conexao = ConexaoDB.getConexao();
		PreparedStatement psql = conexao.prepareStatement(sql);
				
		ResultSet resultado = psql.executeQuery();
		
		try {
			
			objeto = Conversor.construtorMaker(objeto, resultado);
		} catch (SecurityException |
				IllegalArgumentException e) {
			e.printStackTrace();
		}	
		
		conexao.close();
		System.out.println(sql);
		
		return objeto;
	}
	
}
