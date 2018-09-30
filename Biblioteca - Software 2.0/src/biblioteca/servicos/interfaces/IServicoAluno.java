package biblioteca.servicos.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import biblioteca.servicos.basicas.Aluno;
import biblioteca.servicos.basicas.Livro;

public abstract interface IServicoAluno {
	
	/**
	 * Método que Trata o Objeto Aluno para Ser Adicionado no Banco Pelo Repositório
	 * @param a = Aluno a Ser Adicionado
	 * @return (TRUE)Caso a Adição do Aluno Foi bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Erro na Adição do Aluno
	 * @throws IOException
	 */
	public boolean cadastrarAluno(Aluno a) throws IOException;
	
	/**
	 * Método que Trata as Informações do Aluno para Ser Editado pelo Repositório
	 * @param a = Aluno a Ser Editado
	 * @param id = 'id' do Aluno a Ser Editado
	 * @return (TRUE)Caso a Edição do Aluno Tenha Sido bem Sucedida ou (FALSE)Caso a Edição do Aluno Não Tenha Sida Bem Sucedida
	 * @throws IOException
	 */
	public boolean alterarAluno(Aluno a, long id) throws IOException;
	
	/**
	 * Método que Trata as Informações do Objeto para a Exclusão do Mesmo pelo Repositório
	 * @param id = 'id' do Aluno a Ser Excluído
	 * @return (TRUE)Caso a Excluão Tenha sido Bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Problema na Exclusão do Aluno
	 * @throws IOException
	 */
	public boolean deletarAluno(long id) throws IOException;
	
	/**
	 * Método que Busca em Todo Banco de Aluno Todos os Arquivos ATIVOS
	 * @return Lista com Todos os Alunos ATIVOS Registrados no Banco
	 * @throws IOException
	 */
	public Aluno[] listaAlunos() throws IOException;
	
	/**
	 * Método que Atualiza o Saldo das Multas de todos os alunos Cadastrads no Banco.
	 * Esse Método Somente faz a Adição de valo a multa, não a Subtração
	 * @throws IOException
	 */
	public void atualizarMultasGeral() throws IOException;
	
	/**
	 * Método que Calcula e Atualiza a Nova Média de Notas de um Livro
	 * @param book = Livro que a Média Será Atualizada
	 * @param nota = Nova Nota que Será Feita A Média
	 * @throws IOException
	 */
	public void avaliarLivro(Livro book, double nota) throws IOException;
	
	
	
	/**
	 * Método que Organiza A Lista de Arquivos ATIVOS do Banco
	 * Pelo Nome em Ordem Alfábetica ou o Inverso
	 * @param alfa = (FALSE) Ordem Alfabética ou (TRUE) Ordem Inversa da Alfabética
	 * @return Lista Organizada em Ordem Alfabética ou Inverso
	 * @throws IOException
	 */
	public ArrayList<Aluno> organizaNome(boolean alfa) throws IOException;
	
	/**
	 * Método que realiza varredura no acervo de livros do aluno e busca um determinado livro.
	 * Retorna null caso não encontre o livro. Caso encontrado, livro é retornado.
	 * @param titulo - titulo do livro
	 * @return null ou Livro
	 * @throws IOException
	 */
	public Livro buscarLivroAluno(String titulo) throws IOException;
	
	/**
	 * Realiza adição de novo livro ao perfil do aluno. Algumas condições devem ser respeitadas para que o processo tenha êxito:
	 * 1 - livro deve existir no banco
	 * 2 - usuário não deve ter multas
	 * 3 - usuário não pode adicionar o mesmo livro mais de uma vez
	 * @param idPessoa - id do funcionário que realizou operação no sistema
	 * @param titulo - título do livro a ser adicionado (para futura verificação no banco)
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
	 * Devolve livro ao sistema, setando ele como disponível para outro usuário efetuar a locação. Aluno deve dar nota de avaliação do livro.
	 *O sistema também checa se aluno já devolveu o livro
	 * @param idPessoa - id do funcionario que efetuou processo
	 * @param titulo - título do livro
	 * @param nota - nota informada pelo aluno
	 * @param id - em desuso
	 * @return 
	 * @throws IOException
	 */
	public boolean devolverLivroPerfil(long idPessoa,String titulo, double nota,long id) throws IOException;
	
	/**
	 * Realiza varredura no banco dos livros em busca do titulo informado. Caso haja livro e ele esteja disponível, retorna o objeto buscado.
	 * Caso não, retorna o valor null
	 * @param titulo
	 * @return null ou objeto livro
	 * @throws IOException
	 */
	public Livro disponibilidadeLivro(String titulo) throws IOException;
	
	/**
	 * Realiza varredura nos livros do aluno e procura aqueles que estão pegos. Ou seja, não estão atrasados nem no histórico
	 * @return null ou lista de livros pegos
	 * @throws IOException
	 */
	public Livro[] buscaLivroPego() throws IOException;
	
	/**
 	* Realiza varredura nos livros do aluno e procura aqueles que estão atrasados.
 	* @return null ou lista de livros atrasados
 	* @throws IOException
 	*/
	public Livro[] buscaLivroAtrasado();
	
	/**
	 * Realiza varredura nos livros do aluno e procura aqueles que estão no histórico.
	 * @return null ou lista de livros no histórico
	 * @throws IOException
	 */
	public Livro[] buscaLivroHistorico();
	
	/**
	 * Atualiza as Multas de Um ALuno Escolhido
	 * @param CPF = CPF do ALuno que as Multas Serão Atualizadas
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
	 * @param CPF = CPF do ALuno em que a Checagem e Atualização será Realizada
	 * @throws IOException
	 */
	public void setarLivrosAlunoAtrasado(String CPF) throws IOException;
	
	
	/**
	 * Método checa se aluno já possui os 3 livros pegos. Caso sim, retorna false (não pode adicionar novo livro)
	 * @return boolean resultado
	 */
	public boolean livrosPegos();
	
	/**
	 * Método corre o banco e busca um aluno. Retorna ele caso seja encontrado.
	 * @param dadoInformado
	 * @return Aluno
	 * @throws IOException
	 */
	public Aluno buscarAluno(String dadoInformado) throws IOException;
	
	/**
	 * Método que Busca um Aluno no Banco de Acordo com as Inicias do Seu nome
	 * @param dadoInformado = Nome do ALuno
	 * @return Aluno Buscado
	 * @throws IOException
	 */
	public Aluno BuscarAlunoIniciais(String dadoInformado) throws IOException;
	
	/**
	 * Reseta o Saldo das Multas do Aluno
	 * @param CPF = CPF do ALuno que as Multas Serão Resetadas
	 * @throws IOException
	 */
	public void pagarTodasMultas(String CPF) throws IOException;
	
	/**
	 * Metodo que Possui Arquivos Básicos de ALunos Padrão para Serem Cadastrados
	 * @throws IOException
	 */
	public void arquivosBasicos() throws IOException;
	

}
