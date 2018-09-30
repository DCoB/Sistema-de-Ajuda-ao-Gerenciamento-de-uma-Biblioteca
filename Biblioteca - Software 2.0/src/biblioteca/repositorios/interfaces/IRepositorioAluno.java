package biblioteca.repositorios.interfaces;

import java.io.IOException;

import biblioteca.servicos.basicas.Aluno;

public interface IRepositorioAluno {

	
	/**
	 * Método que Cria o Banco(Pasta) Onde Ficarão Todos os Arquivos de ALunos.
	 * Também Cria o Aluno 'Sistema' com ID = 0
	 * @throws IOException
	 */
	public abstract void criarBancoAluno() throws IOException;
	
	/**
	 * Método que Excluí Todos os Arquivos do Banco 'Aluno'. 
	 * Deixando Somente o Arquivo com id = 0 (Arquivo de Sistema)
	 * @throws IOException
	 */
	public abstract void limparBancoAluno() throws IOException;
	
	/**
	 * Método que Faz a Adição de um Novo Aluno no Banco
	 * @param aluno = Aluno a ser Adicionado
	 * @param x = 'id' do Aluno a Ser Adicionado
	 * @return Aluno Adicionado
	 * @throws IOException
	 */
	public Aluno adicionarAluno(Aluno aluno,long x) throws IOException;
	
	/**
	 * Método que Edita um Aluno no Banco
	 * @param id = 'id' do Aluno a Ser Editado
	 * @param aluno = Aluno já com As Novas Informações
	 * @return Aluno Editado
	 * @throws IOException
	 */
	public Aluno editarAluno(long id,Aluno aluno) throws IOException;
	
	/**
	 * Método que Seta um ALuno como Excluído no Banco
	 * @param a = Aluno a Ser Excluído
	 * @param id = 'id' do Aluno a ser Excluído
	 * @return Aluno Excluído
	 * @throws IOException
	 */
	public Aluno excluirAluno(Aluno a, long id) throws IOException;
	
	/**
	 * Método que Busca um Aluno no Banco Identificado Pelo seu 'id'
	 * @param id = 'id' do Aluno Buscado
	 * @return Aluno Buscado ou NULL(CASO NÃO HAJA ALUNO COM ESSE ID)
	 * @throws IOException
	 */
	public Aluno buscarAlunoPorId(long id) throws IOException;
	
	/**
	 * Método que Checa se o Login Está Disponível ou já Existe Alguém com o Mesmo Login
	 * @param login = Login a Se Checado
	 * @return (TRUE)Caso o Login Esteja Disponível, (FALSE)Caso o Login Não Esteja Disponível
	 * @throws IOException
	 */
	public boolean checarLoginDisponivel(String login) throws IOException;
	
}
