package biblioteca.servicos.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import biblioteca.servicos.basicas.Livro;

public interface IServicoLivro {
	
	/**
	 * Método que Trata o Objeto Livro para Ser Adicionado no Banco Pelo Repositório
	 * @param l = Livro a Ser Adicionado
	 * @return (TRUE)Caso a Adição do Livro Foi bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Erro na Adição do Livro
	 * @throws IOException
	 */
	public boolean cadastrarLivro(Livro l) throws IOException;
	
	/**
	 * Método que Trata as Informações do Livro para Ser Editado pelo Repositório
	 * @param l = Livro a Ser Editado
	 * @param id = 'id' do Livro a Ser Editado
	 * @return (TRUE)Caso a Edição do Livro Tenha Sido bem Sucedida ou (FALSE)Caso a Edição do Livro Não Tenha Sida Bem Sucedida
	 * @throws IOException
	 */
	public boolean alterarLivro(Livro l,long id) throws IOException;
	
	/**
	 * Método que Trata as Informações do Objeto para a Exclusão do Mesmo pelo Repositório
	 * @param id = 'id' do Livro a Ser Excluído
	 * @return (TRUE)Caso a Excluão Tenha sido Bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Problema na Exclusão do Livro
	 * @throws IOException
	 */
	public boolean deletarLivro(long id) throws IOException;
	
	/**
	 * Método que Busca em Todo Banco de Livro Todos os Arquivos ATIVOS
	 * @return Lista com Todos os Livros ATIVOS Registrados no Banco
	 * @throws IOException
	 */
	public Livro[] listaLivros() throws IOException;
	
	/**
	 * Classe que Retorna os 4 Últimos Livros Adicionados no Banco,
	 * Para que Funcione é Necessário ter no Mín 4 Livros Ativos No Banco
	 * @return Lista com os 4 Últimos Livros Adicionados no Banco
	 * @throws IOException 
	 */
	public Livro[] ultimosLivros() throws IOException;
	
	/**
	 * Método que Gera Números de Ids Aletórios
	 * @return 4 Livros Aleatórios
	 * @throws IOException
	 */
	public Livro[] recomendaLivros() throws IOException;
	
	/**
	 * Método que Organiza A Lista de Arquivos ATIVOS do Banco
	 * Pelo Título em Ordem Alfábetica ou o Inverso
	 * @param alfa = (FALSE) Ordem Alfabética ou (TRUE) Ordem Inversa da Alfabética
	 * @return Lista Organizada em Ordem Alfabética ou Inverso
	 * @throws IOException
	 */
	public ArrayList<Livro> organizaTitulo(boolean alfa) throws IOException;
	
	/**
	 * Método que Organiza A Lista de Arquivos ATIVOS do Banco
	 * Pela Nota em Ordem Decrescente ou Crescente
	 * @param cresc = (TRUE)Em Ordem Crescente ou (FALSE)Em Ordem Decrescente
	 * @return Lista Organizada em Ordem Decrescente ou Crescente
	 * @throws IOException
	 */
	public ArrayList<Livro> organizaNota(boolean cresc) throws IOException;
	
	public Livro buscarLivroPorId(long id)throws IOException;
	
	/**
	 * Método realiza varredura no banco e retorna um array de livros do mesmo título
	 * @param titulo
	 * @return
	 * @throws IOException
	 */
	public Livro[] buscarLivro(String titulo) throws IOException;
	
	/**
	 * Busca o Livro Pelas Suas Palavras que Fazem Parte do Seu Título
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
	 * Adiciona uma Crítica de uma Aluno a um Livro
	 * @param critica = Critica a ser Adicionada
	 * @param l = Livro e que a Crítica será Adicionada
	 * @throws IOException
	 */
	public void adicionarCritica(String critica,Livro l) throws IOException;
	
	/**
	 * Arquivos Padrão Básicos de Livros para o Funcionamento Perfeito do Aplicativo
	 * @throws IOException
	 */
	public void arquivosBásicos() throws IOException;

}
