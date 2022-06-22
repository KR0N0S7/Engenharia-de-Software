package com.empresa.gestao.fachada;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.empresa.gestao.dao.DAO;
import com.empresa.gestao.dao.DAOcomHeranca;
import com.empresa.gestao.dao.IDAO;
import com.empresa.gestao.object_handler.ConstrutorObjetos;
import com.empresa.gestao.object_handler.ObjetoHandler;
import com.empresa.gestao.validadores.IStrategy;
import com.empresa.gestao.validadores.ValidadorCnpj;
import com.empresa.gestao.validadores.ValidadorDadosContato;
import com.empresa.gestao.validadores.ValidadorDadosFornecedor;
import com.empresa.gestao.validadores.ValidadorEndereco;
import com.empresa.gestao.validadores.ValidadorFornecimento;
import com.empresa.gestao.validadores.VerificarUnicidadeCnpj;

public class Fachada implements IFachada {

	private IDAO dao;
	private Map<String, Map<String, List<IStrategy>>> regraNegocio;

	public Fachada() {

		regraNegocio = new HashMap<String, Map<String, List<IStrategy>>>();

		String nomeChave;
		nomeChave = ObjetoHandler.class.getName();
		dao = new DAO();

		List<IStrategy> regraNegocioSalvar = new ArrayList<IStrategy>();
		regraNegocioSalvar.add(new ValidadorCnpj());
		regraNegocioSalvar.add(new VerificarUnicidadeCnpj());
		regraNegocioSalvar.add(new ValidadorDadosContato());
		regraNegocioSalvar.add(new ValidadorDadosFornecedor());
		regraNegocioSalvar.add(new ValidadorEndereco());
		regraNegocioSalvar.add(new ValidadorFornecimento());

		List<IStrategy> regraNegocioAlterar = new ArrayList<IStrategy>();
		regraNegocioAlterar.add(new ValidadorCnpj());
		regraNegocioAlterar.add(new ValidadorDadosContato());
		regraNegocioAlterar.add(new ValidadorDadosFornecedor());
		regraNegocioAlterar.add(new ValidadorEndereco());
		regraNegocioAlterar.add(new ValidadorFornecimento());

		List<IStrategy> regraNegocioExcluir = new ArrayList<IStrategy>();
		
		List<IStrategy> regraNegocioListar = new ArrayList<IStrategy>();

		Map<String, List<IStrategy>> regraNegocioObject = new HashMap<String, List<IStrategy>>();
		regraNegocioObject.put("SALVAR", regraNegocioSalvar);
		regraNegocioObject.put("ALTERAR", regraNegocioAlterar);
		regraNegocioObject.put("EXCLUIR", regraNegocioExcluir);
		regraNegocioObject.put("LISTAR", regraNegocioListar);

		regraNegocio.put(nomeChave, regraNegocioObject);

	}
	
	private String executarRegras(Object entidade, String operacao) {
		String nomeClasse = entidade.getClass().getName();
		StringBuilder mensagem = new StringBuilder();

		Map<String, List<IStrategy>> regrasOperacao = regraNegocio.get(nomeClasse);
		if (regrasOperacao != null) {
			List<IStrategy> regras = regrasOperacao.get(operacao);
			if (regras != null) {
				for (IStrategy strategy : regras) {
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
	}

	private ResultadoFachada salvarDependendoStatus(Object daoObjeto, Object entidade, ResultadoFachada resultado) {

		resultado.setEntidade(entidade.getClass().getSimpleName());
		String msg = executarRegras(entidade, "SALVAR");
		if (msg != "Erro na validação.") {
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
		} else {
			resultado.setMsg(msg);
			return resultado;
		}
		
	}

	
}
