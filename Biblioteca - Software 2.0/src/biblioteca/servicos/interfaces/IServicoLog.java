package biblioteca.servicos.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import biblioteca.servicos.basicas.Log;

public interface IServicoLog {
	
	/**
	 * M�todo que Faz as Configura��es para a Adi��o de um Novo Log
	 * @param Mensagem = Mensagem do Log
	 * @throws IOException
	 */
	public void adicionarLog(String Mensagem) throws IOException;
	
	/**
	 * M�todo que Altera o Log com id = 1, que � o Log Espec�fico de erro
	 * @param Mensagem = Mensagem de Erro do Log
	 * @throws IOException
	 */
	public void adicionarLogTemporario(String Mensagem) throws IOException;
	
	/**
	 * M�todo que Retorna o �ltimo Log Adicionado Seja ele Log de Erro ou Log Normal
	 * @return Retorna a Mensagem do �ltimo log
	 * @throws IOException
	 */
	public String UltimoLog() throws IOException;
	
	/**
	 * M�todo que Retorna a Mensagem do Log Tempor�rio
	 * @return Mensagem do Log Tempor�rio
	 * @throws IOException
	 */
	public String LogTemporario() throws IOException;
	
	/**
	 * Retorna os 3 �ltimos Logs do Usu�rio
	 * @param id = id da Pessoa que os Logs Ser�o Buscados
	 * @param tipoPessoa = Tipo de Pessoa que os Logs Ser�o buscados
	 * @return lista com os 3 �ltimos Logs da Pessoa
	 * @throws IOException
	 */
	public Log[] tresUltimoLogUsuario(long id,int tipoPessoa) throws IOException;
	
	
	/**
	 * M�todo que Busca Todos os Logs de Determinado Usu�rio
	 * @param id = "id" do Usu�rio a quem os Logs Pertencem
	 * @return Lista com Os Logs do Usu�rio
	 * @throws IOException
	 */
	public ArrayList<Log> buscarLogPorIdUsuario(long id,int tipoPessoa) throws IOException;

}
