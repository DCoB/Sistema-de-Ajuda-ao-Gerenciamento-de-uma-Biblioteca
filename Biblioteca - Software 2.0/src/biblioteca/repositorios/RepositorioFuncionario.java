package biblioteca.repositorios;

import java.io.IOException;

import biblioteca.dados.Banco;
import biblioteca.repositorios.interfaces.IRepositorioFuncionario;
import biblioteca.servicos.ServicoLog;
import biblioteca.servicos.basicas.Funcionario;

/**
 * Classe Responsável por Fazer TODAS as Alterações nos Arquivos do Banco 'Funcinoario'
 * @version 2.0
 */
public class RepositorioFuncionario extends Banco implements IRepositorioFuncionario{
	
	private RepositorioAuxiliar repAux = new RepositorioAuxiliar();
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor Usado Somente para a Criação de Objetos para a Chamada de Métodos
	 */
	public RepositorioFuncionario() {
		super(0);
		setBanco("Banco_Funcionarios\\");
		setArquivo("Funcionario");
	}
	

	public void criarBancoFuncionario() throws IOException
	{
		Funcionario func = new Funcionario("Sistema", "SisFunc", "/5gwxCZgwd0ZQoRPgGm3Sg==", "0","");
		criarBanco();
		criarArquivo(func, 0);
	}
	

	public void limparBancoFuncionario() throws IOException
	{
		ServicoLog serlog = new ServicoLog();
		
		limparBanco();//EXCLUÍ O BANCO(PASTA) COM TODOS OS ARQUIVOS DENTRO
		criarBancoFuncionario();//CRIA O BANCO(PASTA) NOVAMENTE
		serlog.adicionarLog("Banco 'Funcionários' Resetado para o Seu Estado Inicial ! Todos os Arquivos Perdidos");
	}
	

	public Funcionario adicionarFuncionario(Funcionario func,long x) throws IOException
	{
		func = (Funcionario)criarArquivo(func, x);
		return func ;
	}
	

	public Funcionario editarFuncionario(Funcionario func,long id) throws IOException
	{
		func = (Funcionario)editarArquivo(func.getIdPessoa(),func);
		return func;
	}
	

	public Funcionario excluirFuncionario(Funcionario f,long id) throws IOException
	{
		f.setExcluido(true);
		f = (Funcionario)editarArquivo(f.getIdPessoa(),f);

		return f;
	}
	

	public Funcionario buscarFuncionarioPorId(long id) throws IOException
	{
		Funcionario a = new Funcionario();
		
		a = (Funcionario)buscarArquivoPorId(id);
		
		return a;	
	}
	
	
	public boolean checarLoginDisponivel(String login) throws IOException
	{
		Funcionario a = new Funcionario();
		repAux = repAux.buscarArquivoAuxiliar();//RECEBE O ARQUIVO AUXILIAR
		
		for(int x = 1;x<=repAux.getUltimoIdFuncionario();x++)
		{
			a = buscarFuncionarioPorId(x);
			
			if(a.getLogin().equals(login))//CHECA SE JÁ EXISTE ALGUM USUÁRIO COM ESSE LOGIN
			{
				return false;
			}
		}
		return true;
	}

	
}
