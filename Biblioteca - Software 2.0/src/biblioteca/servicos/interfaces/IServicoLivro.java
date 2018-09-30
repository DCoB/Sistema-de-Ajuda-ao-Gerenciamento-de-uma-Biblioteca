package biblioteca.servicos.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import biblioteca.servicos.basicas.Livro;

public interface IServicoLivro {
	
	/**
	 * M�todo que Trata o Objeto Livro para Ser Adicionado no Banco Pelo Reposit�rio
	 * @param l = Livro a Ser Adicionado
	 * @return (TRUE)Caso a Adi��o do Livro Foi bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Erro na Adi��o do Livro
	 * @throws IOException
	 */
	public boolean cadastrarLivro(Livro l) throws IOException;
	
	/**
	 * M�todo que Trata as Informa��es do Livro para Ser Editado pelo Reposit�rio
	 * @param l = Livro a Ser Editado
	 * @param id = 'id' do Livro a Ser Editado
	 * @return (TRUE)Caso a Edi��o do Livro Tenha Sido bem Sucedida ou (FALSE)Caso a Edi��o do Livro N�o Tenha Sida Bem Sucedida
	 * @throws IOException
	 */
	public boolean alterarLivro(Livro l,long id) throws IOException;
	
	/**
	 * M�todo que Trata as Informa��es do Objeto para a Exclus�o do Mesmo pelo Reposit�rio
	 * @param id = 'id' do Livro a Ser Exclu�do
	 * @return (TRUE)Caso a Exclu�o Tenha sido Bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Problema na Exclus�o do Livro
	 * @throws IOException
	 */
	public boolean deletarLivro(long id) throws IOException;
	
	/**
	 * M�todo que Busca em Todo Banco de Livro Todos os Arquivos ATIVOS
	 * @return Lista com Todos os Livros ATIVOS Registrados no Banco
	 * @throws IOException
	 */
	public Livro[] listaLivros() throws IOException;
	
	/**
	 * Classe que Retorna os 4 �ltimos Livros Adicionados no Banco,
	 * Para que Funcione � Necess�rio ter no M�n 4 Livros Ativos No Banco
	 * @return Lista com os 4 �ltimos Livros Adicionados no Banco
	 * @throws IOException 
	 */
	public Livro[] ultimosLivros() throws IOException;
	
	/**
	 * M�todo que Gera N�meros de Ids Alet�rios
	 * @return 4 Livros Aleat�rios
	 * @throws IOException
	 */
	public Livro[] recomendaLivros() throws IOException;
	
	/**
	 * M�todo que Organiza A Lista de Arquivos ATIVOS do Banco
	 * Pelo T�tulo em Ordem Alf�betica ou o Inverso
	 * @param alfa = (FALSE) Ordem Alfab�tica ou (TRUE) Ordem Inversa da Alfab�tica
	 * @return Lista Organizada em Ordem Alfab�tica ou Inverso
	 * @throws IOException
	 */
	public ArrayList<Livro> organizaTitulo(boolean alfa) throws IOException;
	
	/**
	 * M�todo que Organiza A Lista de Arquivos ATIVOS do Banco
	 * Pela Nota em Ordem Decrescente ou Crescente
	 * @param cresc = (TRUE)Em Ordem Crescente ou (FALSE)Em Ordem Decrescente
	 * @return Lista Organizada em Ordem Decrescente ou Crescente
	 * @throws IOException
	 */
	public ArrayList<Livro> organizaNota(boolean cresc) throws IOException;
	
	public Livro buscarLivroPorId(long id)throws IOException;
	
	/**
	 * M�todo realiza varredura no banco e retorna um array de livros do mesmo t�tulo
	 * @param titulo
	 * @return
	 * @throws IOException
	 */
	public Livro[] buscarLivro(String titulo) throws IOException;
	
	/**
	 * Busca o Livro Pelas Suas Palavras que Fazem Parte do Seu T�tulo
	 * @param Titulo = Titulo do Livro
	 * @return Livro Buscado
	 * @throws IOException
	 */
	public Livro[] buscarLivrosInciais(String Titulo) throws IOException;
	
	/**
	 * Atualiza os dias Restantes de Todos os Livros
	 * @throws IOException
	 */
	public void atualizarAtrasos() throws IOException;
	
	/**
	 * Adiciona uma Cr�tica de uma Aluno a um Livro
	 * @param critica = Critica a ser Adicionada
	 * @param l = Livro e que a Cr�tica ser� Adicionada
	 * @throws IOException
	 */
	public void adicionarCritica(String critica,Livro l) throws IOException;
	
	/**
	 * Arquivos Padr�o B�sicos de Livros para o Funcionamento Perfeito do Aplicativo
	 * @throws IOException
	 */
	public void arquivosB�sicos() throws IOException;

}
