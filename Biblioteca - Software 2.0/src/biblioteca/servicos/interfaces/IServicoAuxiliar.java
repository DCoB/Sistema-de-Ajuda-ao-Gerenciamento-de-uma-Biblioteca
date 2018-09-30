package biblioteca.servicos.interfaces;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface IServicoAuxiliar {
	
	public boolean login(String login, String senha, int tipoPessoa) throws IOException, NoSuchAlgorithmException;
	
	/**
	 * M�todo que Executa Todoas as Configura��es Iniciais Necess�rias para Rodas as Aplica��es Posteriores
	 * @throws IOException
	 */
	public void primeiraExecucao() throws IOException;
	
	/**
	 * M�todo que Limpa Todos os Bancos 
	 * @throws IOException
	 */
	public void limparTodosOsBancos() throws IOException;
	
	/**
	 * M�todo que Criptografa a Senha
	 * @param senha = Senha a ser Criptografada
	 * @return Senha Criptografada
	 * @throws NoSuchAlgorithmException
	 */
	public String criptografarSenha(String senha) throws NoSuchAlgorithmException;
	
	/**
	 * M�todo que Salva no ArquivoAuxiliar o Login e a Senha de uma Usu�rio
	 * @param login = login a Ser Salvo
	 * @param senha = senha a Ser Salva
	 * @throws IOException
	 */
	public void manterConectado(String login, String senha) throws IOException;
	
	/**
	 * M�todo que busca no Arquivo Auxiliar o Login Salvo
	 * @return Login Salvo
	 * @throws IOException
	 */
	public String getLoginSalvo() throws IOException;
	
	/**
	 * * M�todo que busca no Arquivo Auxiliar a Senha Salvo
	 * @return Senha Salva
	 * @throws IOException
	 */
	public String getSenhaSalvo() throws IOException;
	
	/**
	 * M�todo que Tira todos os Acentos da String
	 * @param str = String a ter os Acentos Retirados
	 * @return String sem Acentos
	 */
	public String deAccent(String str);
	
	/**
	 * Formatar Matr�cula para o Modelo Padr�o de Exibi��o
	 * @param i = Matr�cula
	 * @return Matr�cula Formatada
	 */
	public String formatarMatricula(int i);

}
