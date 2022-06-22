//package com.empresa.gestao.fachada;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.empresa.gestao.dao.DAO;
//import com.empresa.gestao.dao.DAOcomHeranca;
//import com.empresa.gestao.dao.IDAO;
//import com.empresa.gestao.entities.Fornecedor;
//import com.empresa.gestao.object_handler.ConstrutorObjetos;
//import com.empresa.gestao.object_handler.ObjetoHandler;
//import com.empresa.gestao.validadores.IStrategy;
//import com.empresa.gestao.validadores.ValidadorCnpj;
//import com.empresa.gestao.validadores.ValidadorDadosContato;
//import com.empresa.gestao.validadores.ValidadorDadosFornecedor;
//import com.empresa.gestao.validadores.ValidadorEndereco;
//import com.empresa.gestao.validadores.ValidadorFornecimento;
//import com.empresa.gestao.validadores.VerificarUnicidadeCnpj;
//
//public class Fachada_Backup implements IFachada {
//
//	private IDAO dao;
//	private Map<String, Map<String, List<IStrategy>>> regraNegocio;
//	private ResultadoFachada resultado;
//
//	public Fachada_Backup() {
//
//		regraNegocio = new HashMap<String, Map<String, List<IStrategy>>>();
//
//		String nomeChave;
//		nomeChave = ObjetoHandler.class.getName();
//		dao = new DAO();
//
//		List<IStrategy> regraNegocioSalvar = new ArrayList<IStrategy>();
//		regraNegocioSalvar.add(new ValidadorCnpj());
//		regraNegocioSalvar.add(new VerificarUnicidadeCnpj());
//		regraNegocioSalvar.add(new ValidadorDadosContato());
//		regraNegocioSalvar.add(new ValidadorDadosFornecedor());
//		regraNegocioSalvar.add(new ValidadorEndereco());
//		regraNegocioSalvar.add(new ValidadorFornecimento());
//
//		List<IStrategy> regraNegocioAlterar = new ArrayList<IStrategy>();
//		regraNegocioAlterar.add(new ValidadorCnpj());
//		regraNegocioAlterar.add(new ValidadorDadosContato());
//		regraNegocioAlterar.add(new ValidadorDadosFornecedor());
//		regraNegocioAlterar.add(new ValidadorEndereco());
//		regraNegocioAlterar.add(new ValidadorFornecimento());
//
//		List<IStrategy> regraNegocioExcluir = new ArrayList<IStrategy>();
//		
//		List<IStrategy> regraNegocioListar = new ArrayList<IStrategy>();
//
//		Map<String, List<IStrategy>> regraNegocioObject = new HashMap<String, List<IStrategy>>();
//		regraNegocioObject.put("SALVAR", regraNegocioSalvar);
//		regraNegocioObject.put("ALTERAR", regraNegocioAlterar);
//		regraNegocioObject.put("EXCLUIR", regraNegocioExcluir);
//		regraNegocioObject.put("LISTAR", regraNegocioListar);
//
//		regraNegocio.put(nomeChave, regraNegocioObject);
//
//	}
//	
//	private String executarRegras(Object entidade, String operacao) {
//		String nomeClasse = entidade.getClass().getName();
//		StringBuilder mensagem = new StringBuilder();
//
//		Map<String, List<IStrategy>> regrasOperacao = regraNegocio.get(nomeClasse);
//		if (regrasOperacao != null) {
//			List<IStrategy> regras = regrasOperacao.get(operacao);
//			if (regras != null) {
//				for (IStrategy strategy : regras) {
//					String mensagemPosValidacao = strategy.processar(entidade);
//					if (mensagemPosValidacao != null) {
//						mensagem.append(mensagemPosValidacao);
//					}
//				}
//			}
//		}
//
//		if (mensagem.length() > 0) {
//			return mensagem.toString();
//		} else {
//			return null;
//		}
//	}
//
//	@Override
//	public Object salvar(Object entidade) {
//		
//		List<Object> lista = new ArrayList<>();
//		lista = ConstrutorObjetos.construir((ObjetoHandler) entidade);
//		
//		for (Object object : lista) {
//			if (object.getClass().getSuperclass().getSimpleName().equals("Object")) {
//				dao.salvar(object);
//				
//			} else {
//				DAOcomHeranca daoHeranca = new DAOcomHeranca();
//				
//				daoHeranca.salvar(object);
//			}
//			
//		}
//		
//		
//		resultado = new ResultadoFachada();
//		List<Object> entidades = new ArrayList<Object>();
//		ObjetoHandler fornecedor = (ObjetoHandler) entidade;
//
//		boolean status = fornecedor.getStatus().equals("Rascunho");
//		if (!status) {
//			String msg = executarRegras(entidade, "SALVAR");
//			if (msg == null) {
//				try {
//					dao.salvar(entidade);
//					entidades.add(entidade);
//					resultado.setEntidades(entidades);
//					resultado.setMsg("Salvo com sucesso.");
//
//				} catch (Exception e) {
//					e.printStackTrace();
//					resultado.setMsg("Não foi possivel salvar!");
//					entidades.add(entidade);
//					resultado.setEntidades(entidades);
//				}
//			} else {
//				resultado.setMsg(msg);
//				entidades.add(entidade);
//				resultado.setEntidades(entidades);
//			}
//
//		} else {
//			try {
//				dao.salvar(entidade);
//				entidades.add(entidade);
//				resultado.setEntidades(entidades);
//				resultado.setMsg("Salvo com sucesso.");
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				resultado.setMsg("Não foi possivel registrar!");
//				entidades.add(entidade);
//				resultado.setEntidades(entidades);
//			}
//		}
//
//		return resultado;
//	}
//
//	@Override
//	public Object alterar(Long id, Object entidade) {
//		resultado = new ResultadoFachada();
//
//		List<Object> entidades = new ArrayList<Object>();
//		String msg = executarRegras(entidade, "ALTERAR");
//
//		if (msg == null) {
//			try {
//				dao.alterar(id, entidade);
//
//				entidades.add(entidade);
//				resultado.setEntidades(entidades);
//				resultado.setMsg("Alterado com sucesso.");
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				resultado.setMsg("Nao foi possivel alterar!");
//
//			}
//		} else {
//			resultado.setMsg(msg);
//			entidades.add(entidade);
//			resultado.setEntidades(entidades);
//
//		}
//
//		return resultado;
//	}
//
//	@Override
//	public Object excluir(Long id, Object entidade) {
//		resultado = new ResultadoFachada();
//
//		String msg = executarRegras(entidade, "EXCLUIR");
//
//		if (msg == null) {
//			try {
//				dao.excluir(id, entidade);
//				List<Object> entidades = new ArrayList<Object>();
//				entidades.add(entidade);
//				resultado.setEntidades(entidades);
//				resultado.setMsg("Excluido com sucesso!");
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				resultado.setMsg("Não foi possivel excluir!");
//
//			}
//		} else {
//			resultado.setMsg(msg);
//
//		}
//
//		return resultado;
//	}
//
//	@Override
//	public Object consultar(Long id, Class<?> clazz) {
//		resultado = new ResultadoFachada();
//		
////		String msg = executarRegras(entidade, "CONSULTAR");
////		
////		String nomeClasse = clazz.getName();
////		
////		Object entidade = clazz.getDeclaredConstructor().newInstance();
////		if (msg == null) {
////			try {
////				if (entidade.getClass().getDeclaredMethod("getId") == null) {
////					resultado.setEntidades(dao.consultarPorId(id, clazz));
////				} else {
////					resultado.setEntidades(new ArrayList<Object>(1));
////					resultado.getEntidades().add(entidade);
////				}
////			} catch (Exception e) {
////				resultado.setMsg("Não foi poss�vel consultar!");
////			}
////		} else {
////			List<Object> entidades = new ArrayList<Object>();
////			entidades.add(entidade);
////			resultado.setEntidades(entidades);
////			resultado.setMsg(msg);
////		}
//
//		return resultado;
//	}
//}
