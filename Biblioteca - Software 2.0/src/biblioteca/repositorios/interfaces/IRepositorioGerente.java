package biblioteca.repositorios.interfaces;

import java.io.IOException;

import biblioteca.servicos.basicas.Gerente;

public abstract interface IRepositorioGerente {
	
	/**
	 * Método que Cria o Banco(Pasta) Onde Ficarão Todos os Arquivos de Gerentes.
	 * Também Cria o Gerente 'Sistema' com ID = 0
	 * @throws IOException
	 */
	public void criarBancoGerente() throws IOException;
	
	/**
	 * Método que Excluí Todos os Arquivos do Banco 'Gerentes'. 
	 * Deixando Somente o Arquivo com id = 0 (Arquivo de Sistema)
	 * @throws IOException
	 */
	public void limparBancoGerente() throws IOException;
	
	/**
	 * Método que Faz a Adição de um Novo Gerente no Banco
	 * @param aluno = Gerente a ser Adicionado
	 * @param x = 'id' do Gerente a Ser Adicionado
	 * @return Gerente Adicionado
	 * @throws IOException
	 */
	public Gerente adicionarGerente(Gerente ge) throws IOException;
	
	
	/**
	 * Método que Edita um Gerente no Banco
	 * @param id = 'id' do Gerente a Ser Editado
	 * @param aluno = Gerente já com As Novas Informações
	 * @return Gerente Editado
	 * @throws IOException
	 */
	public Gerente editarGerente(Gerente ge) throws IOException;
	
	
	/**
	 * Método que Seta um Gerente como Excluído no Banco
	 * @param id = 'id' do Gerente a ser Excluído
	 * @return Gerente Excluído
	 * @throws IOException
	 */
	public Gerente excluirGerente(Gerente g,long id) throws IOException;
	
	
	/**
	 * Método que Busca um Gerente no Banco Identificado Pelo seu 'id'
	 * @param id = 'id' do Gerente Buscado
	 * @return Gerente Buscado ou NULL(CASO NÃO HAJA GERENTE COM ESSE ID)
	 * @throws IOException
	 */
	public Gerente buscarGerentePorId(long id) throws IOException;
	
	/**
	 * Método que Checa se o Login Está Disponível ou já Existe Alguém com o Mesmo Login
	 * @param login = Login a Se Checado
	 * @return (TRUE)Caso o Login Esteja Disponível, (FALSE)Caso o Login Não Esteja Disponível
	 * @throws IOException
	 */
	public boolean checarLoginDisponivel(String login) throws IOException;
	
	

}
