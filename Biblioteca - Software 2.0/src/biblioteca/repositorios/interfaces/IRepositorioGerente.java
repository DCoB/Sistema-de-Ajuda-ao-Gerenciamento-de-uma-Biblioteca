package biblioteca.repositorios.interfaces;

import java.io.IOException;

import biblioteca.servicos.basicas.Gerente;

public abstract interface IRepositorioGerente {
	
	/**
	 * M�todo que Cria o Banco(Pasta) Onde Ficar�o Todos os Arquivos de Gerentes.
	 * Tamb�m Cria o Gerente 'Sistema' com ID = 0
	 * @throws IOException
	 */
	public void criarBancoGerente() throws IOException;
	
	/**
	 * M�todo que Exclu� Todos os Arquivos do Banco 'Gerentes'. 
	 * Deixando Somente o Arquivo com id = 0 (Arquivo de Sistema)
	 * @throws IOException
	 */
	public void limparBancoGerente() throws IOException;
	
	/**
	 * M�todo que Faz a Adi��o de um Novo Gerente no Banco
	 * @param aluno = Gerente a ser Adicionado
	 * @param x = 'id' do Gerente a Ser Adicionado
	 * @return Gerente Adicionado
	 * @throws IOException
	 */
	public Gerente adicionarGerente(Gerente ge) throws IOException;
	
	
	/**
	 * M�todo que Edita um Gerente no Banco
	 * @param id = 'id' do Gerente a Ser Editado
	 * @param aluno = Gerente j� com As Novas Informa��es
	 * @return Gerente Editado
	 * @throws IOException
	 */
	public Gerente editarGerente(Gerente ge) throws IOException;
	
	
	/**
	 * M�todo que Seta um Gerente como Exclu�do no Banco
	 * @param id = 'id' do Gerente a ser Exclu�do
	 * @return Gerente Exclu�do
	 * @throws IOException
	 */
	public Gerente excluirGerente(Gerente g,long id) throws IOException;
	
	
	/**
	 * M�todo que Busca um Gerente no Banco Identificado Pelo seu 'id'
	 * @param id = 'id' do Gerente Buscado
	 * @return Gerente Buscado ou NULL(CASO N�O HAJA GERENTE COM ESSE ID)
	 * @throws IOException
	 */
	public Gerente buscarGerentePorId(long id) throws IOException;
	
	/**
	 * M�todo que Checa se o Login Est� Dispon�vel ou j� Existe Algu�m com o Mesmo Login
	 * @param login = Login a Se Checado
	 * @return (TRUE)Caso o Login Esteja Dispon�vel, (FALSE)Caso o Login N�o Esteja Dispon�vel
	 * @throws IOException
	 */
	public boolean checarLoginDisponivel(String login) throws IOException;
	
	

}
