package com.empresa.gestao.fachada;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.empresa.gestao.dao.DAO;
import com.empresa.gestao.dao.DAOcomHeranca;
import com.empresa.gestao.dao.InterfaceDAO;
import com.empresa.gestao.object_handler.ConstrutorObjetos;
import com.empresa.gestao.object_handler.ObjetoHandler;
import com.empresa.gestao.validadores.InterfaceStrategy;
import com.empresa.gestao.validadores.ValidadorCnpj;
import com.empresa.gestao.validadores.ValidadorDadosFornecedor;
import com.empresa.gestao.validadores.ValidadorEndereco;
import com.empresa.gestao.validadores.VerificarUnicidadeCnpj;

public class Fachada implements IFachada {

	private InterfaceDAO dao;
	private Map<String, Map<String, List<InterfaceStrategy>>> regraNegocio;

	public Fachada() {

		regraNegocio = new HashMap<String, Map<String, List<InterfaceStrategy>>>();

		String nomeChave = ObjetoHandler.class.getSimpleName();
		dao = new DAO();

		List<InterfaceStrategy> regraNegocioSalvar = new ArrayList<InterfaceStrategy>();
		regraNegocioSalvar.add(new ValidadorCnpj());
		regraNegocioSalvar.add(new VerificarUnicidadeCnpj());
		regraNegocioSalvar.add(new ValidadorDadosFornecedor());
		regraNegocioSalvar.add(new ValidadorEndereco());

		List<InterfaceStrategy> regraNegocioAlterar = new ArrayList<InterfaceStrategy>();
		regraNegocioAlterar.add(new ValidadorCnpj());
		regraNegocioAlterar.add(new ValidadorDadosFornecedor());
		regraNegocioAlterar.add(new ValidadorEndereco());

		List<InterfaceStrategy> regraNegocioExcluir = new ArrayList<InterfaceStrategy>();
		
		List<InterfaceStrategy> regraNegocioListar = new ArrayList<InterfaceStrategy>();

		Map<String, List<InterfaceStrategy>> regraNegocioObject = new HashMap<String, List<InterfaceStrategy>>();
		regraNegocioObject.put("SALVAR", regraNegocioSalvar);
		regraNegocioObject.put("ALTERAR", regraNegocioAlterar);
		regraNegocioObject.put("EXCLUIR", regraNegocioExcluir);
		regraNegocioObject.put("LISTAR", regraNegocioListar);

		regraNegocio.put(nomeChave, regraNegocioObject);

	}
	
	private String executarRegras(Object entidade, String operacao) throws SQLException {
		String nomeClasse = entidade.getClass().getSimpleName();
		StringBuilder mensagem = new StringBuilder();

		Map<String, List<InterfaceStrategy>> regrasOperacao = regraNegocio.get(nomeClasse);
		if (regrasOperacao != null) {
			List<InterfaceStrategy> regras = regrasOperacao.get(operacao);
			if (regras != null) {
				for (InterfaceStrategy strategy : regras) {
					String mensagemPosValidacao = strategy.processar(entidade);
					if (mensagemPosValidacao != null) {
						mensagem.append(mensagemPosValidacao);
					}
				}
			}
		}

		if (mensagem.length() > 0) {
			return mensagem.toString();
		} else {
			return null;
		}
	}

	@Override
	public Object salvar(Object entidade) throws SQLException {
		List<Object> lista = new ArrayList<>();
		lista = ConstrutorObjetos.construir((ObjetoHandler) entidade);
		List<ResultadoFachada> listaResultado = new ArrayList<>();
		
		String mensagem = executarRegras(entidade, "SALVAR");
		
		if (mensagem == null) {
			
			for (Object object : lista) {
				ResultadoFachada resultado = new ResultadoFachada();
				
				if (object.getClass().getSuperclass().getSimpleName().equals("Object")) {
					listaResultado.add(salvarDependendoStatus(dao, object, resultado));
					
				} else {
					DAOcomHeranca daoH = new DAOcomHeranca();
					listaResultado.add(salvarDependendoStatus(daoH, object, resultado));
					
				}
				
			}
		
			return listaResultado;
			
		} else {

			return mensagem;
		}
		
	}

	private ResultadoFachada salvarDependendoStatus(Object daoObjeto, Object entidade, ResultadoFachada resultado) {

		resultado.setEntidade(entidade.getClass().getSimpleName());
		
		try {
			daoObjeto.getClass().getSuperclass()
			.getDeclaredMethod("salvarObjectHandler", Object.class)
			.invoke(daoObjeto, entidade);
			resultado.setMsg("Salvo com sucesso.");
			return resultado;
		} catch (Exception e) {
			e.printStackTrace();
			resultado.setMsg("Não foi possivel salvar!");
			return resultado;
		}
		
	}

	
}
