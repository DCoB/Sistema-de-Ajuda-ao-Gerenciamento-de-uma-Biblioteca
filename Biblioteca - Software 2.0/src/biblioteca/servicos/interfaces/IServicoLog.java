package biblioteca.servicos.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import biblioteca.servicos.basicas.Log;

public interface IServicoLog {
	
	/**
	 * Método que Faz as Configurações para a Adição de um Novo Log
	 * @param Mensagem = Mensagem do Log
	 * @throws IOException
	 */
	public void adicionarLog(String Mensagem) throws IOException;
	
	/**
	 * Método que Altera o Log com id = 1, que é o Log Específico de erro
	 * @param Mensagem = Mensagem de Erro do Log
	 * @throws IOException
	 */
	public void adicionarLogTemporario(String Mensagem) throws IOException;
	
	/**
	 * Método que Retorna o Último Log Adicionado Seja ele Log de Erro ou Log Normal
	 * @return Retorna a Mensagem do Último log
	 * @throws IOException
	 */
	public String UltimoLog() throws IOException;
	
	/**
	 * Método que Retorna a Mensagem do Log Temporário
	 * @return Mensagem do Log Temporário
	 * @throws IOException
	 */
	public String LogTemporario() throws IOException;
	
	/**
	 * Retorna os 3 Últimos Logs do Usuário
	 * @param id = id da Pessoa que os Logs Serão Buscados
	 * @param tipoPessoa = Tipo de Pessoa que os Logs Serão buscados
	 * @return lista com os 3 Últimos Logs da Pessoa
	 * @throws IOException
	 */
	public Log[] tresUltimoLogUsuario(long id,int tipoPessoa) throws IOException;
	
	
	/**
	 * Método que Busca Todos os Logs de Determinado Usuário
	 * @param id = "id" do Usuário a quem os Logs Pertencem
	 * @return Lista com Os Logs do Usuário
	 * @throws IOException
	 */
	public ArrayList<Log> buscarLogPorIdUsuario(long id,int tipoPessoa) throws IOException;

}
