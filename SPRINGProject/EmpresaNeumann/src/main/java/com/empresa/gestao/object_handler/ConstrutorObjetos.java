package com.empresa.gestao.object_handler;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.empresa.gestao.dao.annotations.ChaveEstrangeira;
import com.empresa.gestao.entities.Cidade;
import com.empresa.gestao.entities.Contato;
import com.empresa.gestao.entities.Departamento;
import com.empresa.gestao.entities.Endereco;
import com.empresa.gestao.entities.Estado;
import com.empresa.gestao.entities.Fornecedor;
import com.empresa.gestao.entities.Pais;
import com.empresa.gestao.entities.Ramal;
import com.empresa.gestao.entities.TipoEndereco;
import com.empresa.gestao.entities.TipoLogradouro;
import com.empresa.gestao.entities.Usuario;

public abstract class ConstrutorObjetos {

	public static List<Object> construir(ObjetoHandler objeto) {
		
		Field[] atributos = objeto.getClass().getDeclaredFields();
		
		Pais pais = new Pais();
		Estado uf = new Estado();
		Cidade cidade = new Cidade();
		TipoLogradouro tpLogradouro = new TipoLogradouro();
		TipoEndereco tpEndereco = new TipoEndereco();
		Endereco endereco = new Endereco();
		Fornecedor fornecedor = new Fornecedor();
		
		Ramal tel = new Ramal();
		Departamento depto = new Departamento();
		Contato contato = new Contato();
		Usuario user = new Usuario();
		
		List<Object> lista = Arrays.asList(
				pais, 
				uf, 
				cidade, 
				tpLogradouro, 
				tpEndereco,
				endereco,
				fornecedor,
				depto,
				tel,
				contato,
				user);
		
		int n = 0;

		for (Object obj : lista) {
			List<Field> listaAtributos;
			if (obj.getClass().getSuperclass().getSimpleName().equals("Object")) {
				listaAtributos = Arrays.asList(obj.getClass().getDeclaredFields());
			} else {
				List<Field> atributos1 = Arrays.asList(obj.getClass().getDeclaredFields());
				List<Field> atributosSuperClasse = Arrays.asList(obj.getClass().getSuperclass().getDeclaredFields());
				listaAtributos = Stream
						.concat(atributosSuperClasse.stream(), atributos1.stream())
						.collect(Collectors.toList());
			}
			
			for (Field atributo : listaAtributos) {
				if (atributo.getDeclaredAnnotation(ChaveEstrangeira.class) == null &&
						atributo.getName() != "id") {
					atributo.setAccessible(true);
					
					if (atributos[n].getDeclaredAnnotation(ChaveEstrangeira.class) == null) {
						atributos[n].setAccessible(true);
						try {
							Object valor = atributos[n].get(objeto);
							atributo.set(obj, valor);
						} catch (IllegalArgumentException | IllegalAccessException e) {
							e.printStackTrace();
						}  
						n++;
						
					} else {
						n++;
						atributos[n].setAccessible(true);
						try {
							Object valor = atributos[n].get(objeto);
							atributo.set(obj, valor);
						} catch (IllegalArgumentException | IllegalAccessException e) {
							e.printStackTrace();
						}  
						n++;
					}
					
				}
			}
		}
		
		return lista;
	}
}
