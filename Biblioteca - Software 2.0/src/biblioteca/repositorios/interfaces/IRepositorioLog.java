package biblioteca.repositorios.interfaces;

import java.io.IOException;

import biblioteca.servicos.basicas.Log;

public abstract interface IRepositorioLog {
	
	/**
	 * Efetua a cria��o de um log no sistema.
	 * @param log
	 * @throws IOException
	 */
	public void criarLog(Log log) throws IOException;
	
	/**
	 * Realiza a edi��o de um log no sistema.
	 * @param log
	 * @throws IOException
	 */
	public void editarLog(Log log) throws IOException;
	
}
