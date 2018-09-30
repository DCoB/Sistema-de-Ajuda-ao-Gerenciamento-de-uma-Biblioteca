package biblioteca.repositorios.interfaces;

import java.io.IOException;

import biblioteca.servicos.basicas.Funcionario;

public abstract interface IRepositorioFuncionario {

	/**
	 * M�todo que Cria o Banco(Pasta) Onde Ficar�o Todos os Arquivos de Funcion�rios.
	 * Tamb�m Cria o Funcion�rio 'Sistema' com ID = 0
	 * @throws IOException
	 */
	public void criarBancoFuncionario() throws IOException;
	
	/**
	 * M�todo que Exclu� Todos os Arquivos do Banco 'Funcionario'. 
	 * Deixando Somente o Arquivo com id = 0 (Arquivo de Sistema)
	 * @throws IOException
	 */
	public void limparBancoFuncionario() throws IOException;
	
	/**
	 * M�todo que Faz a Adi��o de um Novo Funcion�rio no Banco
	 * @param func = Funcion�rio a ser Adicionado
	 * @param x = 'id' do Funcion�rio a Ser Adicionado
	 * @return Funcion�rio Adicionado
	 * @throws IOException
	 */
	public Funcionario adicionarFuncionario(Funcionario func,long x) throws IOException;
	
	/**
	 * M�todo que Edita um Funcion�rio no Banco
	 * @param id = 'id' do Funcion�rio a Ser Editado
	 * @param func = Funcion�rio j� com As Novas Informa��es
	 * @return Funcion�rio Editado
	 * @throws IOException
	 */
	public Funcionario editarFuncionario(Funcionario func,long id) throws IOException;
	
	/**
	 * M�todo que Seta um Funcion�rio como Exclu�do no Banco
	 * @param id = 'id' do Funcion�rio a ser Exclu�do
	 * @return Funcion�rio Exclu�do
	 * @throws IOException
	 */
	public Funcionario excluirFuncionario(Funcionario f,long id) throws IOException;
	
	/**
	 * M�todo que Busca um Funcion�rio no Banco Identificado Pelo seu 'id'
	 * @param id = 'id' do Funcion�rio Buscado
	 * @return Funcion�rio Buscado ou NULL(CASO N�O HAJA ALUNO COM ESSE ID)
	 * @throws IOException
	 */
	public Funcionario buscarFuncionarioPorId(long id) throws IOException;
	
	/**
	 * M�todo que Checa se o Login Est� Dispon�vel ou j� Existe Algu�m com o Mesmo Login
	 * @param login = Login a Se Checado
	 * @return (TRUE)Caso o Login Esteja Dispon�vel, (FALSE)Caso o Login N�o Esteja Dispon�vel
	 * @throws IOException
	 */
	public boolean checarLoginDisponivel(String login) throws IOException;
}
