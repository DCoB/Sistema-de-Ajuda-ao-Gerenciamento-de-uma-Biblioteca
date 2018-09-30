package biblioteca.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.swing.JFrame;

import biblioteca.servicos.*;
import biblioteca.views.*;

/**
 * Classe que Redireciona para as Views que Podem Ser Acessadas por Qualquer tipo de Usu�rio
 */
public class ControllerGeral {
	private static ServicoAuxiliar servAu= new ServicoAuxiliar();
	private static ServicoAluno servA = new ServicoAluno();
	private ServicoFuncionario servF = new ServicoFuncionario();
	private ServicoGerente servG = new ServicoGerente();
	private static ServicoLivro servL = new ServicoLivro();
	
	/**
	 * M�todo que � Acionado ao Usu�rio Fazer a Tentativa de Login e que Redireciona para a Proxima Tela
	 * @param login = Login Oferecido
	 * @param senha = Senha Oferecido
	 * @param tipoPessoa = 0(Gerente), 1(Funcion�rio) e 2(Aluno)
	 * @param lembrarSenha = Lembrar a Senha caso o Login tenha Sido Bem sucedido
	 * @param window = Janela de onde foi Chamado esse M�todo
	 * @throws IOException
	 * @throws NoSuchAlgorithmException 
	 */
	public void Entrar(String login,String senha,int tipoPessoa,boolean lembrarSenha,JFrame window) throws IOException, NoSuchAlgorithmException
	{
		
		ViewLogin viewL = new ViewLogin(true,servAu.getLoginSalvo(),servAu.getSenhaSalvo());
		window.dispose();
		
		
		try {
			if(servAu.login(login, senha, tipoPessoa) ==  true)//LOGIN BEM SUCEDIDO
			{
				if(lembrarSenha == true)//LEMBRAR A SENHA DO LOGIN
				{
					servAu.manterConectado(login, senha);
				}
				
				pageInicial(window, Long.parseLong(System.getProperty("IdPessoa")), tipoPessoa);
			}
			else
			{
				
				viewL.setLocationRelativeTo(null);//exibi��o de janela centralizada
				viewL.setVisible(true);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * M�todo que Desloga o Usu�rio Conectado
	 * @param window = Janela de onde foi Chamado esse M�todo
	 * @throws IOException
	 */
	public static void Logout(JFrame window) throws IOException
	{
		window.dispose();
		ViewLogin viewL = new ViewLogin(false,servAu.getLoginSalvo(),servAu.getSenhaSalvo());
		viewL.setLocationRelativeTo(null);//exibi��o de janela centralizada
		viewL.setVisible(true);
	}
	
	/**
	 * M�todo que Chama a Tela Inicial de Acordo com o Tipo de Pessoa que Efetuou o Login
	 * @param window = Janela de onde foi Chamado esse M�todo
	 * @param id = id de Pessoa que Logou
	 * @param tipoPessoa = tipo de Pessoa que Logou
	 * @throws IOException
	 */
	public static void pageInicial(JFrame window,long id,int tipoPessoa)throws IOException
	{
		ServicoLog servLog =  new ServicoLog();
		
		int x = 0,y = 0;
		window.dispose();
		
		Object[] list =  new Object[15];
		Object[] lista =  new Object[4];
		
		lista = servL.recomendaLivros();//M�TODO QUE RETORNA 4 LIVROS ALEAT�RIOS DO BANCO
		for(y = 0;y < 4;y++)//PREENCHE A LISTA COM OS 4 LIVROS 
		{
			list[x] = lista[y];
			x++;
		}
		
		lista = servL.ultimosLivros();//M�TODO QUE RETORNA OS �LTIMOS 4 LIVROS ADICIONADOS NO BANCO
		for(y = 0;y < 4;y++)//PREENCHE A LISTA COM OS 4 LIVROS 
		{
			list[x] = lista[y];
			x++;
		}
		
		lista = servA.novosAlunos();
		for(y = 0;y < 4;y++)//PREENCHE A LISTA COM OS 4 LIVROS 
		{
			list[x] = lista[y];
			x++;
		}		
		
		lista = servLog.tresUltimoLogUsuario(id,tipoPessoa);
		for(y = 0;y < 3;y++)//PREENCHE A LISTA COM OS 3 USU�RIOS 
		{
			if(lista[y] == null)
			{
				list[x] = null;
			}
			
			list[x] = lista[y];
			x++;
		}
		
		ViewPaginaInicial viewP = new ViewPaginaInicial(list);//CHAMA A TELA INICIAL
		
		viewP.setLocationRelativeTo(null);//exibi��o de janela centralizada
		viewP.setVisible(true);
		
	}

	public ServicoFuncionario getServF() {
		return servF;
	}

	public void setServF(ServicoFuncionario servF) {
		this.servF = servF;
	}

	public ServicoGerente getServG() {
		return servG;
	}

	public void setServG(ServicoGerente servG) {
		this.servG = servG;
	}
	
	
	
}
