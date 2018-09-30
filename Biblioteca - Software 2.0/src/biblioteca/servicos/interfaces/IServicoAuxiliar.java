package biblioteca.servicos.interfaces;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface IServicoAuxiliar {
	
	public boolean login(String login, String senha, int tipoPessoa) throws IOException, NoSuchAlgorithmException;
	
	/**
	 * Método que Executa Todoas as Configurações Iniciais Necessárias para Rodas as Aplicações Posteriores
	 * @throws IOException
	 */
	public void primeiraExecucao() throws IOException;
	
	/**
	 * Método que Limpa Todos os Bancos 
	 * @throws IOException
	 */
	public void limparTodosOsBancos() throws IOException;
	
	/**
	 * Método que Criptografa a Senha
	 * @param senha = Senha a ser Criptografada
	 * @return Senha Criptografada
	 * @throws NoSuchAlgorithmException
	 */
	public String criptografarSenha(String senha) throws NoSuchAlgorithmException;
	
	/**
	 * Método que Salva no ArquivoAuxiliar o Login e a Senha de uma Usuário
	 * @param login = login a Ser Salvo
	 * @param senha = senha a Ser Salva
	 * @throws IOException
	 */
	public void manterConectado(String login, String senha) throws IOException;
	
	/**
	 * Método que busca no Arquivo Auxiliar o Login Salvo
	 * @return Login Salvo
	 * @throws IOException
	 */
	public String getLoginSalvo() throws IOException;
	
	/**
	 * * Método que busca no Arquivo Auxiliar a Senha Salvo
	 * @return Senha Salva
	 * @throws IOException
	 */
	public String getSenhaSalvo() throws IOException;
	
	/**
	 * Método que Tira todos os Acentos da String
	 * @param str = String a ter os Acentos Retirados
	 * @return String sem Acentos
	 */
	public String deAccent(String str);
	
	/**
	 * Formatar Matrícula para o Modelo Padrão de Exibição
	 * @param i = Matrícula
	 * @return Matrícula Formatada
	 */
	public String formatarMatricula(int i);

}
