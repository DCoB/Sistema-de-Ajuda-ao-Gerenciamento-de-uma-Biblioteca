package biblioteca.repositorios.interfaces;

import java.io.IOException;

import biblioteca.servicos.basicas.Livro;

public abstract interface IRepositorioLivro {
	
	/**
	 * Método que Cria o Banco(Pasta) Onde Ficarão Todos os Arquivos de Livros.
	 * Também Cria o Livro 'Sistema' com ID = 0
	 * @throws IOException
	 */
	public void criarBancoLivro() throws IOException;
	
	/**
	 * Método que Excluí Todos os Arquivos do Banco 'Livro'. 
	 * Deixando Somente o Arquivo com id = 0 (Arquivo de Sistema)
	 * @throws IOException
	 */
	public void limparBancoLivro() throws IOException;
	
	/**
	 * Método que Faz a Adição de um Novo Livro no Banco
	 * @param livro = Livro a ser Adicionado
	 * @param x = 'id' do Livro a Ser Adicionado
	 * @return Livro Adicionado
	 * @throws IOException
	 */
	public Livro adicionarLivro(Livro livro, long x) throws IOException;
	
	
	/**
	 * Método que Edita um Livro no Banco
	 * @param id = 'id' do Livro a Ser Editado
	 * @param aluno = Livro já com As Novas Informações
	 * @return Livro Editado
	 * @throws IOException
	 */
	public Livro editarLivro(long id,Livro livro)throws IOException;
	
	/**
	 * Método que Seta um Livro como Excluído no Banco
	 * @param l = Livro a Ser Excluído
	 * @param id = 'id' do Livro a ser Excluído
	 * @return Livro Excluído
	 * @throws IOException
	 */
	public Livro excluirLivro(Livro l,long id)throws IOException;
	
	/**
	 * Método que Busca um Livro no Banco Identificado Pelo seu 'id'
	 * @param id = 'id' do Livro Buscado
	 * @return Livro Buscado ou NULL(CASO NÃO HAJA LIVRO COM ESSE ID)
	 * @throws IOException
	 */
	public Livro buscarLivroPorId(long id)throws IOException;
	

}
