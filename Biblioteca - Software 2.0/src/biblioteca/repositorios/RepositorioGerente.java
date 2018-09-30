package biblioteca.repositorios;

import java.io.IOException;

import biblioteca.dados.Banco;
import biblioteca.repositorios.interfaces.IRepositorioGerente;
import biblioteca.servicos.ServicoLog;
import biblioteca.servicos.basicas.Gerente;

/**
 * Classe Reponsável por Fazer TODAS as Alterações nos Arquivos do Banco 'Gerente'
 * @version 2.0
 */
public class RepositorioGerente extends Banco implements IRepositorioGerente{
	private RepositorioAuxiliar repAux = new RepositorioAuxiliar();
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor Usado Somente para a Criação de Objetos para a Chamada de Métodos
	 */
	public RepositorioGerente() {
		super(0);
		setBanco("Banco_Gerentes\\");
		setArquivo("Gerente");
	}
	

	public void criarBancoGerente() throws IOException
	{
		Gerente geren = new Gerente("Sistema", "SisGere", "/5gwxCZgwd0ZQoRPgGm3Sg==", "0","");
		criarBanco();
		criarArquivo(geren, 0);
	}
	

	public void limparBancoGerente() throws IOException
	{
		ServicoLog serlog = new ServicoLog();
		
		limparBanco();
		criarBancoGerente();
		
		serlog.adicionarLog("Banco 'Gerentes' Resetado para o Seu Estado Inicial ! Todos os Arquivos Perdidos");//CHAMADA DE ADIÇÃO DE LOG
	}
	

	public Gerente adicionarGerente(Gerente ge) throws IOException
	{
		ge = (Gerente)criarArquivo(ge,ge.getIdPessoa());
		return ge;
	}
	

	public Gerente editarGerente(Gerente ge) throws IOException
	{
		ge = (Gerente)editarArquivo(ge.getIdPessoa(),ge);
		return ge;
	}
	

	public Gerente excluirGerente(Gerente g,long id) throws IOException
	{
		g.setExcluido(true);
		g  = (Gerente)editarArquivo(g.getIdPessoa(),g);
		
		return g;
	}
	

	public Gerente buscarGerentePorId(long id) throws IOException
	{
		Gerente g = new Gerente();
		
		g = (Gerente)buscarArquivoPorId(id);
		
		return g;
	}
	

	public boolean checarLoginDisponivel(String login) throws IOException
	{
		Gerente a = new Gerente();
		repAux = repAux.buscarArquivoAuxiliar();//RECEBE O ARQUIVO AUXILIAR
		
		for(int x = 1;x<=repAux.getUltimoIdGerente();x++)
		{
			a = buscarGerentePorId(x);
			
			if(a.getLogin().equals(login))//CHECA SE JÁ EXISTE ALGUM USUÁRIO COM ESSE LOGIN
			{
				return false;
			}
		}
		return true;
	}
	
	
}
