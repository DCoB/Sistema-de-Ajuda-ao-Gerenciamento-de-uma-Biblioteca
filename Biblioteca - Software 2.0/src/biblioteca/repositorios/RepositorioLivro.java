package biblioteca.repositorios;

import java.io.IOException;

import biblioteca.dados.Banco;
import biblioteca.repositorios.interfaces.IRepositorioLivro;
import biblioteca.servicos.ServicoLog;
import biblioteca.servicos.basicas.Livro;

/**
 * Classe Reponsável por Fazer TODAS as Alterações nos Arquivos do Banco 'Livro'
 * @version 2.0
 */
public class RepositorioLivro extends Banco implements IRepositorioLivro {
	private RepositorioAuxiliar repAux = new RepositorioAuxiliar();
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor Usado Somente para a Criação de Objetos para a Chamada de Métodos
	 */
	public RepositorioLivro() {
		super(0);
		setBanco("Banco_Livros\\");
		setArquivo("Livro");
	}
	

	public void criarBancoLivro() throws IOException
	{
		Livro livro = new Livro("Sistema", "Sistema", "Sistema","",2018);
		criarBanco();
		criarArquivo(livro, 0);
	}

	public void limparBancoLivro() throws IOException
	{
		ServicoLog serlog = new ServicoLog();
		
		limparBanco();
		criarBancoLivro();
		serlog.adicionarLog("Banco 'Livros' Resetado para o Seu Estado Inicial ! Todos os Arquivos Perdidos");
	}
	

	public Livro adicionarLivro(Livro livro, long x) throws IOException
	{
		livro = (Livro)criarArquivo(livro, x);
		return livro;
	}
	

	public Livro editarLivro(long id,Livro livro)throws IOException
	{
		livro = (Livro)editarArquivo(livro.getIdLivro(), livro);
		return livro;
	}
	

	public Livro excluirLivro(Livro l,long id)throws IOException
	{
		l.setExcluido(true);
		l = (Livro)editarArquivo(l.getIdLivro(), l);
		return l;
	}
	

	public Livro buscarLivroPorId(long id)throws IOException
	{
		Livro l = new Livro();
		
		l = (Livro)buscarArquivoPorId(id);
		
		return l;
	}


	public RepositorioAuxiliar getRepAux() {
		return repAux;
	}


	public void setRepAux(RepositorioAuxiliar repAux) {
		this.repAux = repAux;
	}
	

}
