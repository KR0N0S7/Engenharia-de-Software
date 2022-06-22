package com.empresa.gestao.command;

import com.empresa.gestao.fachada.Fachada;
import com.empresa.gestao.fachada.IFachada;

public abstract class AbstractCommand implements ICommand {

	protected IFachada fachada = new Fachada();
	
}
