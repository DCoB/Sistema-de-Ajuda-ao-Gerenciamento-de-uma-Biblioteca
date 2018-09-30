package biblioteca.repositorios.interfaces;

import java.io.IOException;

import biblioteca.servicos.basicas.Aluno;

public interface IRepositorioAluno {

	
	/**
	 * M�todo que Cria o Banco(Pasta) Onde Ficar�o Todos os Arquivos de ALunos.
	 * Tamb�m Cria o Aluno 'Sistema' com ID = 0
	 * @throws IOException
	 */
	public abstract void criarBancoAluno() throws IOException;
	
	/**
	 * M�todo que Exclu� Todos os Arquivos do Banco 'Aluno'. 
	 * Deixando Somente o Arquivo com id = 0 (Arquivo de Sistema)
	 * @throws IOException
	 */
	public abstract void limparBancoAluno() throws IOException;
	
	/**
	 * M�todo que Faz a Adi��o de um Novo Aluno no Banco
	 * @param aluno = Aluno a ser Adicionado
	 * @param x = 'id' do Aluno a Ser Adicionado
	 * @return Aluno Adicionado
	 * @throws IOException
	 */
	public Aluno adicionarAluno(Aluno aluno,long x) throws IOException;
	
	/**
	 * M�todo que Edita um Aluno no Banco
	 * @param id = 'id' do Aluno a Ser Editado
	 * @param aluno = Aluno j� com As Novas Informa��es
	 * @return Aluno Editado
	 * @throws IOException
	 */
	public Aluno editarAluno(long id,Aluno aluno) throws IOException;
	
	/**
	 * M�todo que Seta um ALuno como Exclu�do no Banco
	 * @param a = Aluno a Ser Exclu�do
	 * @param id = 'id' do Aluno a ser Exclu�do
	 * @return Aluno Exclu�do
	 * @throws IOException
	 */
	public Aluno excluirAluno(Aluno a, long id) throws IOException;
	
	/**
	 * M�todo que Busca um Aluno no Banco Identificado Pelo seu 'id'
	 * @param id = 'id' do Aluno Buscado
	 * @return Aluno Buscado ou NULL(CASO N�O HAJA ALUNO COM ESSE ID)
	 * @throws IOException
	 */
	public Aluno buscarAlunoPorId(long id) throws IOException;
	
	/**
	 * M�todo que Checa se o Login Est� Dispon�vel ou j� Existe Algu�m com o Mesmo Login
	 * @param login = Login a Se Checado
	 * @return (TRUE)Caso o Login Esteja Dispon�vel, (FALSE)Caso o Login N�o Esteja Dispon�vel
	 * @throws IOException
	 */
	public boolean checarLoginDisponivel(String login) throws IOException;
	
}
