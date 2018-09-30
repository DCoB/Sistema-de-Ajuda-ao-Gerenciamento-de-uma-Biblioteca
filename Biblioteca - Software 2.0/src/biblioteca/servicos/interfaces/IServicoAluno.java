package biblioteca.servicos.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import biblioteca.servicos.basicas.Aluno;
import biblioteca.servicos.basicas.Livro;

public abstract interface IServicoAluno {
	
	/**
	 * M�todo que Trata o Objeto Aluno para Ser Adicionado no Banco Pelo Reposit�rio
	 * @param a = Aluno a Ser Adicionado
	 * @return (TRUE)Caso a Adi��o do Aluno Foi bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Erro na Adi��o do Aluno
	 * @throws IOException
	 */
	public boolean cadastrarAluno(Aluno a) throws IOException;
	
	/**
	 * M�todo que Trata as Informa��es do Aluno para Ser Editado pelo Reposit�rio
	 * @param a = Aluno a Ser Editado
	 * @param id = 'id' do Aluno a Ser Editado
	 * @return (TRUE)Caso a Edi��o do Aluno Tenha Sido bem Sucedida ou (FALSE)Caso a Edi��o do Aluno N�o Tenha Sida Bem Sucedida
	 * @throws IOException
	 */
	public boolean alterarAluno(Aluno a, long id) throws IOException;
	
	/**
	 * M�todo que Trata as Informa��es do Objeto para a Exclus�o do Mesmo pelo Reposit�rio
	 * @param id = 'id' do Aluno a Ser Exclu�do
	 * @return (TRUE)Caso a Exclu�o Tenha sido Bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Problema na Exclus�o do Aluno
	 * @throws IOException
	 */
	public boolean deletarAluno(long id) throws IOException;
	
	/**
	 * M�todo que Busca em Todo Banco de Aluno Todos os Arquivos ATIVOS
	 * @return Lista com Todos os Alunos ATIVOS Registrados no Banco
	 * @throws IOException
	 */
	public Aluno[] listaAlunos() throws IOException;
	
	/**
	 * M�todo que Atualiza o Saldo das Multas de todos os alunos Cadastrads no Banco.
	 * Esse M�todo Somente faz a Adi��o de valo a multa, n�o a Subtra��o
	 * @throws IOException
	 */
	public void atualizarMultasGeral() throws IOException;
	
	/**
	 * M�todo que Calcula e Atualiza a Nova M�dia de Notas de um Livro
	 * @param book = Livro que a M�dia Ser� Atualizada
	 * @param nota = Nova Nota que Ser� Feita A M�dia
	 * @throws IOException
	 */
	public void avaliarLivro(Livro book, double nota) throws IOException;
	
	
	
	/**
	 * M�todo que Organiza A Lista de Arquivos ATIVOS do Banco
	 * Pelo Nome em Ordem Alf�betica ou o Inverso
	 * @param alfa = (FALSE) Ordem Alfab�tica ou (TRUE) Ordem Inversa da Alfab�tica
	 * @return Lista Organizada em Ordem Alfab�tica ou Inverso
	 * @throws IOException
	 */
	public ArrayList<Aluno> organizaNome(boolean alfa) throws IOException;
	
	/**
	 * M�todo que realiza varredura no acervo de livros do aluno e busca um determinado livro.
	 * Retorna null caso n�o encontre o livro. Caso encontrado, livro � retornado.
	 * @param titulo - titulo do livro
	 * @return null ou Livro
	 * @throws IOException
	 */
	public Livro buscarLivroAluno(String titulo) throws IOException;
	
	/**
	 * Realiza adi��o de novo livro ao perfil do aluno. Algumas condi��es devem ser respeitadas para que o processo tenha �xito:
	 * 1 - livro deve existir no banco
	 * 2 - usu�rio n�o deve ter multas
	 * 3 - usu�rio n�o pode adicionar o mesmo livro mais de uma vez
	 * @param idPessoa - id do funcion�rio que realizou opera��o no sistema
	 * @param titulo - t�tulo do livro a ser adicionado (para futura verifica��o no banco)
	 * @param id - em desuso
	 * @return 
	 * @throws IOException
	 */
	public boolean addLivroPerfil(long idPessoa,String titulo, long id) throws IOException;
	
	/**
	 * Realiza varredura no acervo do aluno e retorna o tipo de livro da busca. (Pego, Atrasado, Historico)
	 * @param titulo
	 * @return
	 */
	public int buscarClassificadorLivroAluno(String titulo);
	
	/**
	 * Devolve livro ao sistema, setando ele como dispon�vel para outro usu�rio efetuar a loca��o. Aluno deve dar nota de avalia��o do livro.
	 *O sistema tamb�m checa se aluno j� devolveu o livro
	 * @param idPessoa - id do funcionario que efetuou processo
	 * @param titulo - t�tulo do livro
	 * @param nota - nota informada pelo aluno
	 * @param id - em desuso
	 * @return 
	 * @throws IOException
	 */
	public boolean devolverLivroPerfil(long idPessoa,String titulo, double nota,long id) throws IOException;
	
	/**
	 * Realiza varredura no banco dos livros em busca do titulo informado. Caso haja livro e ele esteja dispon�vel, retorna o objeto buscado.
	 * Caso n�o, retorna o valor null
	 * @param titulo
	 * @return null ou objeto livro
	 * @throws IOException
	 */
	public Livro disponibilidadeLivro(String titulo) throws IOException;
	
	/**
	 * Realiza varredura nos livros do aluno e procura aqueles que est�o pegos. Ou seja, n�o est�o atrasados nem no hist�rico
	 * @return null ou lista de livros pegos
	 * @throws IOException
	 */
	public Livro[] buscaLivroPego() throws IOException;
	
	/**
 	* Realiza varredura nos livros do aluno e procura aqueles que est�o atrasados.
 	* @return null ou lista de livros atrasados
 	* @throws IOException
 	*/
	public Livro[] buscaLivroAtrasado();
	
	/**
	 * Realiza varredura nos livros do aluno e procura aqueles que est�o no hist�rico.
	 * @return null ou lista de livros no hist�rico
	 * @throws IOException
	 */
	public Livro[] buscaLivroHistorico();
	
	/**
	 * Atualiza as Multas de Um ALuno Escolhido
	 * @param CPF = CPF do ALuno que as Multas Ser�o Atualizadas
	 * @throws IOException
	 */
	public void atualizarMultaAluno(String CPF) throws IOException;
	
	/**
	 * Atualiza a Lista de Livros do Banco Setando o Livros como Atrasado se ele Estiver Atrasado
	 * @throws IOException
	 */
	public void setarTodosLivrosAtrasados() throws IOException;
	
	/**
	 * Atualiza a Lista de Livros do Aluno Setando o Livro como Atrasado casa Esteja Atrasado
	 * @param CPF = CPF do ALuno em que a Checagem e Atualiza��o ser� Realizada
	 * @throws IOException
	 */
	public void setarLivrosAlunoAtrasado(String CPF) throws IOException;
	
	
	/**
	 * M�todo checa se aluno j� possui os 3 livros pegos. Caso sim, retorna false (n�o pode adicionar novo livro)
	 * @return boolean resultado
	 */
	public boolean livrosPegos();
	
	/**
	 * M�todo corre o banco e busca um aluno. Retorna ele caso seja encontrado.
	 * @param dadoInformado
	 * @return Aluno
	 * @throws IOException
	 */
	public Aluno buscarAluno(String dadoInformado) throws IOException;
	
	/**
	 * M�todo que Busca um Aluno no Banco de Acordo com as Inicias do Seu nome
	 * @param dadoInformado = Nome do ALuno
	 * @return Aluno Buscado
	 * @throws IOException
	 */
	public Aluno BuscarAlunoIniciais(String dadoInformado) throws IOException;
	
	/**
	 * Reseta o Saldo das Multas do Aluno
	 * @param CPF = CPF do ALuno que as Multas Ser�o Resetadas
	 * @throws IOException
	 */
	public void pagarTodasMultas(String CPF) throws IOException;
	
	/**
	 * Metodo que Possui Arquivos B�sicos de ALunos Padr�o para Serem Cadastrados
	 * @throws IOException
	 */
	public void arquivosBasicos() throws IOException;
	

}
