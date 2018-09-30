package biblioteca.servicos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import biblioteca.comparadores.GerenteNomeComparator;
import biblioteca.repositorios.RepositorioAuxiliar;
import biblioteca.repositorios.RepositorioGerente;
import biblioteca.servicos.basicas.Gerente;
import biblioteca.servicos.interfaces.IServicoGerente;

/**
 * Classe Responsável por Fazer Todas as Operações de Gerentes e Deixas os Objetos de Gerentes Prontos para ser Alterados no Banco
 * @version 1.0
 */
public class ServicoGerente implements IServicoGerente {
	private RepositorioGerente repG = new RepositorioGerente();
	private ServicoLog serLog = new ServicoLog();
	private RepositorioAuxiliar repAux = new RepositorioAuxiliar();
	private ServicoAuxiliar serAux = new ServicoAuxiliar();
	

	public boolean cadastrarGerente(Gerente g) throws IOException
	{
		if(repG.checarLoginDisponivel(g.getLogin()) == false)
		{
			serLog.adicionarLogTemporario("Login Já Existente, Por favor Selecione outro Login !");
			
			return false;
		}
		else
		{
			try
			{
				repAux = repAux.buscarArquivoAuxiliar();
				long x = repAux.getUltimoIdGerenteAdd();
		
				g.setIdPessoa(x);//PREENCHE O ID DO ARQUIVO QUE SERÁ ADICIONADO COM O ID DO ÚLTIMO ARQUIVO ADICINOADO NO BANCO +1
				g.setSenha(serAux.criptografarSenha(g.getSenha()));//FAZER A CRIPTOGRAFIA DA SENHA
				
				repG.adicionarGerente(g);
				
				//SALVA O LOG DE SUCESSO
				serLog.adicionarLog("Adicionado Funcionário: " + g.getNome() +" ,de CPF: " + g.getCPF() + " ,e de Id: " + g.getIdPessoa());
				
				return true ;
			}
			catch(Exception ex)
			{
				return false;
			}
		}
	}
	

	public boolean alterarGerente(Gerente g,long id) throws IOException
	{
		g.setIdPessoa(id);
		Gerente gerente1 =  repG.buscarGerentePorId(id);//BUSCAR O ALUNO COM AS INFORMAÇÕES ANTES DE SER EDITADO
		
		if(gerente1 == null || gerente1.getExcluido() == true)//CASO NÃO TENHA ENCONTRADO NENHUM ALUNO COM ESSE 'id'
		{
			serLog.adicionarLogTemporario("Aluno Inexistente ou Inativo !");
			return false;
		}
		
		try
		{
			repG.editarGerente(g);//CHAMA O REPOSITÓRIO PARA A EDIÇÃO DO GERENTE
			
			String Log = "Gerente Editado, ";
			
			//PREENCHER O LOG COM A MENSAGEM CORRETA
			if(!g.getNome().equals(gerente1.getNome()))
			{
				Log += "de Nome: " + gerente1.getNome() + " para Nome: " + g.getNome() + " ";
			}
			if(!g.getCPF().equals(gerente1.getCPF()))
			{
				Log += "de CPF: " + gerente1.getCPF() + " para CPF: " + g.getCPF();
			}
			
			serLog.adicionarLog(Log);
			
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	

	public boolean deletarGerente(long id) throws IOException
	{
		Gerente g = new Gerente();
		try
		{
			g = repG.buscarGerentePorId(id);
			if(g.getExcluido() == true || g == null)
			{
				serLog.adicionarLogTemporario("Aluno Inexistente ou Inativo !");
				return false;
			}
			g = repG.excluirGerente(g,id);
		}
		catch(Exception e)//ACONTECEU ALGUM ERRO DURANTE A EXCLUSÃO DA PESSOA NO BANCO
		{
			return false;
		}
		
		serLog.adicionarLog("Excluído Funcionário: " + g.getNome() +" ,de CPF: " + g.getCPF() + " ,e de Id: " + g.getIdPessoa());
	
		return true;
	}
	

	public Gerente[] listaGerentes() throws IOException
	{
		repAux = repAux.buscarArquivoAuxiliar();
		long x = repAux.getUltimoIdGerente();
		
		Gerente[] gerentesFiltrado = new Gerente[(int) x + 1];	
		Gerente[] gerentes = new Gerente[(int) x + 1];			
		Object[] objeto = repG.listaBanco();//LISTA COM TODOS OS ARQUIVOS DO BANCO
		
		for(int y = 0 ; y <= x;y++)
		{
			gerentes[y] = (Gerente)objeto[y];
		}
		
		for(int y = 0 ; y <= x;y++)
		{
			if(gerentes[y].getExcluido() == false)
			{
				gerentesFiltrado[y] = gerentes[y];//PREENCHENDO A LISTA DE FUNCIONÁRIOS COM A LISTA DOS ARQUIVOS DO BANCO
			}
			//SÓ PARA TESTAR SE ESTÁ FUNCIONANDO NA VERSÃO FINAL ESSES PRINTS VÃO SUMIR
			//System.out.println("Id " + gerentesFiltrado[y].getIdPessoa());
			//System.out.println("Nome " + gerentesFiltrado[y].getNome() + "\n");
		}
		
		return gerentes;
	}
	
	

	public ArrayList<Gerente> organizaNome(boolean alfa) throws IOException
	{
		GerenteNomeComparator comp = new GerenteNomeComparator();
		Gerente[] gerentes = listaGerentes();		
		ArrayList<Gerente> lista = new ArrayList<Gerente>();
		
		for(Gerente l : gerentes)
		{
			lista.add(l);
		}
		
		Collections.sort(lista, comp);
		
		if(alfa == true) 
		{
			Collections.reverse(lista);
		}
		
		//VAI SAIR NA VERSÃO FINAL, SÓ ESTÁ AQUI COM A FINALIDADE DE TESTAR O MÉTODO
		for(Gerente l : lista)
		{
			System.out.println(l.getNome());
		}	
		
		return lista;
	}
	
	public Gerente buscarGerente(String dadoInformado) throws IOException {
		
		
		Gerente[] gerentes = this.listaGerentes();
		Gerente resultadoBusca=null;
		
		for(int i = 0 ; i<gerentes.length;i++) {
			gerentes[i]= repG.buscarGerentePorId(i);
		}
		
		for(int i=0; i<gerentes.length;i++) {
			if(gerentes[i].getNome().equalsIgnoreCase(dadoInformado)||gerentes[i].getCPF().equals(dadoInformado)) {
				resultadoBusca = gerentes[i];
			}
		}
		 
		 return resultadoBusca;
			
		}

	
	
}
