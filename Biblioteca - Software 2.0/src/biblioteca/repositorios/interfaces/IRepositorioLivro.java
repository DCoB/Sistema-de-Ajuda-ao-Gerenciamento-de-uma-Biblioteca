package biblioteca.repositorios.interfaces;

import java.io.IOException;

import biblioteca.servicos.basicas.Livro;

public abstract interface IRepositorioLivro {
	
	/**
	 * M�todo que Cria o Banco(Pasta) Onde Ficar�o Todos os Arquivos de Livros.
	 * Tamb�m Cria o Livro 'Sistema' com ID = 0
	 * @throws IOException
	 */
	public void criarBancoLivro() throws IOException;
	
	/**
	 * M�todo que Exclu� Todos os Arquivos do Banco 'Livro'. 
	 * Deixando Somente o Arquivo com id = 0 (Arquivo de Sistema)
	 * @throws IOException
	 */
	public void limparBancoLivro() throws IOException;
	
	/**
	 * M�todo que Faz a Adi��o de um Novo Livro no Banco
	 * @param livro = Livro a ser Adicionado
	 * @param x = 'id' do Livro a Ser Adicionado
	 * @return Livro Adicionado
	 * @throws IOException
	 */
	public Livro adicionarLivro(Livro livro, long x) throws IOException;
	
	
	/**
	 * M�todo que Edita um Livro no Banco
	 * @param id = 'id' do Livro a Ser Editado
	 * @param aluno = Livro j� com As Novas Informa��es
	 * @return Livro Editado
	 * @throws IOException
	 */
	public Livro editarLivro(long id,Livro livro)throws IOException;
	
	/**
	 * M�todo que Seta um Livro como Exclu�do no Banco
	 * @param l = Livro a Ser Exclu�do
	 * @param id = 'id' do Livro a ser Exclu�do
	 * @return Livro Exclu�do
	 * @throws IOException
	 */
	public Livro excluirLivro(Livro l,long id)throws IOException;
	
	/**
	 * M�todo que Busca um Livro no Banco Identificado Pelo seu 'id'
	 * @param id = 'id' do Livro Buscado
	 * @return Livro Buscado ou NULL(CASO N�O HAJA LIVRO COM ESSE ID)
	 * @throws IOException
	 */
	public Livro buscarLivroPorId(long id)throws IOException;
	

}
