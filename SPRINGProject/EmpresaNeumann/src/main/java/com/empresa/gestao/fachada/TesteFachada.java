package com.empresa.gestao.fachada;

import com.empresa.gestao.object_handler.Handler;
import com.empresa.gestao.object_handler.ObjetoHandler;

public class TesteFachada {

	public static void main(String[] args) {
		
		ObjetoHandler oh = new ObjetoHandler();
		Fachada fachada = new Fachada();
		
		fachada.salvar(oh);		
	}
}
