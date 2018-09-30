package biblioteca.repositorios;

import java.io.IOException;

import biblioteca.dados.Banco;
import biblioteca.repositorios.interfaces.IRepositorioAluno;
import biblioteca.servicos.ServicoLog;
import biblioteca.servicos.basicas.Aluno;

/**
 * Classe Reponsável por Fazer TODAS as Alterações nos Arquivos do Banco 'Aluno'
 * @version 2.0
 */
public class RepositorioAluno extends Banco implements IRepositorioAluno{
	private RepositorioAuxiliar repAux = new RepositorioAuxiliar();
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor Usado Somente para a Criação de Objetos para a Chamada de Métodos
	 */
	public RepositorioAluno() {
		super(0);
		this.setBanco("Banco_Alunos\\");
		this.setArquivo("Aluno");
	}
	

	public void criarBancoAluno() throws IOException
	{
		
		Aluno aluno = new Aluno("Sistema", "SisAlun", "/5gwxCZgwd0ZQoRPgGm3Sg==",0,"0");
		criarBanco();
		criarArquivo(aluno, 0);
	}
	

	public void limparBancoAluno() throws IOException
	{
		ServicoLog serlog = new ServicoLog();
		
		limparBanco();//EXCLUÍ O BANCO(PASTA) COM TODOS OS ARQUIVOS DENTRO
		criarBancoAluno();//CRIA O BANCO(PASTA) NOVAMENTE
		serlog.adicionarLog("Banco 'Alunos' Resetado para o Seu Estado Inicial ! Todos os Arquivos Perdidos");//CHAMADA DE ADIÇÃO DE LOG
	}
	

	public Aluno adicionarAluno(Aluno aluno,long x) throws IOException
	{
		aluno = (Aluno)criarArquivo(aluno, x);//INVOCA O MÉTODO DE CRIAR ARQUIVOS DO BANCO, E TRANSFORMA O OBJETO RETORNADO NO BANCO EM UM OBJETO DA CLASSE ALUNO
		return aluno;
	}
	

	public Aluno editarAluno(long id,Aluno aluno) throws IOException
	{
		aluno = (Aluno)editarArquivo(aluno.getIdPessoa(), aluno);
		return aluno;
	}
	

	public Aluno excluirAluno(Aluno a, long id) throws IOException
	{
		a.setExcluido(true);
		a = (Aluno)editarArquivo(a.getIdPessoa(), a);
		return a;
	}
	

	public Aluno buscarAlunoPorId(long id) throws IOException 
	{
		Aluno a = new Aluno();
		
		a = (Aluno)buscarArquivoPorId(id);
		
		return a;		
	}
	

	public boolean checarLoginDisponivel(String login) throws IOException
	{
		Aluno a = new Aluno();
		repAux = repAux.buscarArquivoAuxiliar();//RECEBE O ARQUIVO AUXILIAR
		
		for(int x = 1;x<=repAux.getUltimoIdAluno();x++)
		{
			a = buscarAlunoPorId(x);
			
			if(a.getLogin().equals(login))//CHECA SE JÁ EXISTE ALGUM USUÁRIO COM ESSE LOGIN
			{
				return false;
			}
		}
		return true;
	}
		
}
