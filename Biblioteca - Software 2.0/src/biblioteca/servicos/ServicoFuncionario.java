package biblioteca.servicos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import biblioteca.comparadores.FuncionarioNomeComparator;
import biblioteca.repositorios.RepositorioAuxiliar;
import biblioteca.repositorios.RepositorioFuncionario;
import biblioteca.servicos.basicas.Funcionario;
import biblioteca.servicos.interfaces.IServicoFuncionario;

/**
 * Classe Respons�vel por Fazer Todas as Opera��es de Funcion�rios e Deixas os Objetos de 
 * Funcion�rios Prontos para ser Alterados no Banco
 * @version 1.0
 */
public class ServicoFuncionario implements IServicoFuncionario {
	private RepositorioFuncionario repF = new RepositorioFuncionario();
	private ServicoLog serLog = new ServicoLog();
	private RepositorioAuxiliar repAux = new RepositorioAuxiliar();
	private ServicoAuxiliar serAux = new ServicoAuxiliar();
	

	public boolean cadastrarFuncionario(Funcionario f) throws IOException
	{
		if(repF.checarLoginDisponivel(f.getLogin()) == false)//CHECA SE O LOGIN EST� DISPON�VEL PARA O CADASTRO OU SE J� EXISTE UM LOGIN IGUAL
		{
			serLog.adicionarLogTemporario("Login J� Existente, Por favor Selecione outro Login !");
			
			return false;
		}
		else
		{
			try
			{
				repAux = repAux.buscarArquivoAuxiliar();
				long x = repAux.getUltimoIdFuncionarioAdd();//PREENCHE O ID DO ARQUIVO QUE SER� ADICIONADO COM O ID DO �LTIMO ARQUIVO ADICINOADO NO BANCO +1
				
				f.setIdPessoa(x);
				
				f.setSenha(serAux.criptografarSenha(f.getSenha()));//FAZER A CRIPTOGRAFIA DA SENHA
				
				repF.adicionarFuncionario(f, x);//INVOCA O M�TODO DE ADICIONAR ALUNO PELO REPOSIT�RIO
				
				//SALVA O LOG DE SUCESSO
				serLog.adicionarLog("Adicionado Funcion�rio: " + f.getNome() +" ,de CPF: " + f.getCPF() + " ,e de Id: " + x);
				
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
	}
	
	

	public boolean alterarFuncionario(Funcionario f,long id) throws IOException
	{
		f.setIdPessoa(id);
		Funcionario func1 = repF.buscarFuncionarioPorId(id);//BUSCAR O ALUNO COM AS INFORMA��ES ANTES DE SER EDITADO
		
		if(func1 == null || func1.getExcluido() == true)//CASO N�O TENHA ENCONTRADO NENHUM ALUNO COM ESSE 'id' OU O FUNCION�RIO FOI EXCLU�DO
		{
			serLog.adicionarLogTemporario("Funcion�rio Inexistente ou Inativo !");
			return false;
		}
		try
		{
			repF.editarFuncionario(f, id);
		
			String Log = "Funcion�rio Editado, ";
			
			//PREENCHER O LOG COM A MENSAGEM CORRETA
			if(!f.getNome().equals(func1.getNome()))
			{
				Log += "de Nome: " + func1.getNome() + " para Nome: " + f.getNome() + " ";
			}
			if(!f.getCPF().equals(func1.getCPF()))
			{
				Log += "de CPF: " + func1.getCPF() + " para CPF: " + f.getCPF();
			}
		
			serLog.adicionarLog(Log);
		
			return true;
		}
		catch(Exception e)//ACONTECEU ALGUM ERRO DURANTE A ALTERA��O DA PESSOA NO BANCO
		{
			return false;
		}
	}
	

	public boolean deletarFuncionario(long id) throws IOException
	{
		Funcionario f = new Funcionario();
		try
		{
			f = repF.buscarFuncionarioPorId(id);
			if(f.getExcluido() == true ||f == null)
			{
				serLog.adicionarLogTemporario("Aluno Inexistente ou Inativo !");
				return false;
			}
			
			f = repF.excluirFuncionario(f,id);
		}
		catch(Exception e)
		{
			
		}
		
		serLog.adicionarLog("Exclu�do Funcion�rio: " + f.getNome() +" ,de CPF: " + f.getCPF() + " ,e de Id: " + f.getIdPessoa());
		
		return true;
	}
	

	public Funcionario[] listaFuncionarios() throws IOException
	{
		repAux = repAux.buscarArquivoAuxiliar();
		long x = repAux.getUltimoIdFuncionario();
		
		Funcionario[] funcionariosFiltrado = new Funcionario[(int) x + 1];
		Funcionario[] funcionarios = new Funcionario[(int) x + 1];	
		Object[] objeto = repF.listaBanco();//LISTA COM TODOS OS ARQUIVOS DO BANCO
		
		for(int y = 0 ; y <= x;y++)
		{
			funcionarios[y] = (Funcionario)objeto[y];
		}
		
		for(int y = 0 ; y <= x;y++)
		{
			if(funcionarios[y].getExcluido() == false)
			{
				funcionariosFiltrado[y] = funcionarios[y];//PREENCHENDO A LISTA DE FUNCION�RIOS COM A LISTA DOS ARQUIVOS DO BANCO
			}
			//S� PARA TESTAR SE EST� FUNCIONANDO NA VERS�O FINAL ESSES PRINTS V�O SUMIR
			//System.out.println("Id " + funcionariosFiltrado[y].getIdPessoa());
			//System.out.println("Nome " + funcionariosFiltrado[y].getNome() + "\n");
		}
		
		return funcionarios;
	}
	

	public ArrayList<Funcionario> organizaNome(boolean alfa) throws IOException
	{
		FuncionarioNomeComparator comp = new FuncionarioNomeComparator();
		Funcionario[] funcionarios = listaFuncionarios();		
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
		
		for(Funcionario l : funcionarios)
		{
			lista.add(l);
		}
		
		Collections.sort(lista, comp);
		
		if(alfa == true) 
		{
			Collections.reverse(lista);
		}
		
		//VAI SAIR NA VERS�O FINAL, S� EST� AQUI COM A FINALIDADE DE TESTAR O M�TODO
		for(Funcionario l : lista)
		{
			System.out.println(l.getNome());
		}	
		
		return lista;
	}
	
	public Funcionario buscarFuncionario(String dadoInformado) throws IOException {
		
		
		Funcionario[] funcionarios = this.listaFuncionarios();
		Funcionario resultadoBusca=null;
		
		for(int i = 0 ; i<funcionarios.length;i++) {
			funcionarios[i]= repF.buscarFuncionarioPorId(i);
		}
		
		for(int i=0; i<funcionarios.length;i++) {
			if(funcionarios[i].getNome().equalsIgnoreCase(dadoInformado)||funcionarios[i].getCPF().equals(dadoInformado)) {
				resultadoBusca = funcionarios[i];
			}
		}
		 
		 return resultadoBusca;
			
		}

}
