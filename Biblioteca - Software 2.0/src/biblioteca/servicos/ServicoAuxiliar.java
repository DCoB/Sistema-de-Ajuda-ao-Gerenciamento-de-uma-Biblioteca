package biblioteca.servicos;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.text.Normalizer;
import java.util.regex.Pattern;

import biblioteca.repositorios.*;
import biblioteca.servicos.basicas.*;
import biblioteca.servicos.interfaces.IServicoAuxiliar;
import sun.misc.BASE64Encoder;

public class ServicoAuxiliar implements IServicoAuxiliar{

	private RepositorioLivro repLivro = new RepositorioLivro();
	private RepositorioLog repLog= new RepositorioLog(0);
	private ServicoLog servLog = new ServicoLog();
	private RepositorioAluno repAluno = new RepositorioAluno();
	private RepositorioFuncionario repFunc = new RepositorioFuncionario();
	private RepositorioGerente repGen = new RepositorioGerente();
	private RepositorioAuxiliar repAux = new RepositorioAuxiliar();
	
	
	public ServicoAuxiliar() {
		
	}
	
	
	public boolean login(String login, String senha, int tipoPessoa) throws IOException, NoSuchAlgorithmException
	{
		
		repAux = repAux.buscarArquivoAuxiliar();
		senha = criptografarSenha(senha);
		boolean a = false;
		
		if(tipoPessoa == 2)//ALUNO
		{
			ServicoAluno servA = new ServicoAluno();
			
			Aluno[] alunos = servA.listaAlunos();
			
			for(int i=0;i<alunos.length;i++)
			{
				if(alunos[i].getLogin().equals(login)&&alunos[i].getSenha().equals(senha))
				{
					System.setProperty("IdPessoa", String.valueOf(alunos[i].getIdPessoa()));//SALVAR O ID DA PESSOA LOGADA EM UMA PROPRIEDADE DO SISTEMA
					System.setProperty("TipoPessoa", "2");//SALVAR O TIPO ALUNO COMO O TIPO DE PESSOA LOGADA
					System.setProperty("LoginPessoa",alunos[i].getLogin());//SALVAR O LOGIN DA PESSOA LOGADA
					
					
					servLog.adicionarLog("Aluno " + alunos[i].getNome() + " Efetuou Login com Sucesso !");
					
					a = true;
					break;
				}
			}
			
			if(a == false)
			{
				servLog.adicionarLogTemporario("Erro ao Tentar Logar, Senha ou Usuário Incorretos");
			}
		}
		else if(tipoPessoa == 1)//FUNCIONARIO
		{
			ServicoFuncionario servF = new ServicoFuncionario();
			
			Funcionario[] funcionarios = servF.listaFuncionarios();
			
			for(int i=0;i<funcionarios.length;i++)
			{
				if(funcionarios[i].getLogin().equals(login)&&funcionarios[i].getSenha().equals(senha))
				{
					System.setProperty("IdPessoa", String.valueOf(funcionarios[i].getIdPessoa()));//SALVAR O ID DA PESSOA LOGADA EM UMA PROPRIEDADE DO SISTEMA
					System.setProperty("TipoPessoa", "1");//SALVAR O TIPO FUNCIONÁRIO COMO O TIPO DE PESSOA LOGADA
					System.setProperty("LoginPessoa",funcionarios[i].getLogin());//SALVAR O LOGIN DA PESSOA LOGADA
					
					servLog.adicionarLog("Funcionário " + funcionarios[i].getNome() + " Efetuou Login com Sucesso !");
					
					a = true;
					break;
				}
			}
			
			if(a == false)
			{
				servLog.adicionarLogTemporario("Erro ao Tentar Logar, Senha ou Usuário Incorretos");
			}
		}
		else if(tipoPessoa == 0)//GERENTE
		{
			ServicoGerente servG = new ServicoGerente();
			
			Gerente[] gerentes = servG.listaGerentes();
			
			for(int i=0;i<gerentes.length;i++)
			{
				if(gerentes[i].getLogin().equals(login)&&gerentes[i].getSenha().equals(senha))
				{
					System.setProperty("IdPessoa", String.valueOf(gerentes[i].getIdPessoa()));//SALVAR O ID DA PESSOA LOGADA EM UMA PROPRIEDADE DO SISTEMA
					System.setProperty("TipoPessoa", "0");//SALVAR O TIPO GERENTE COMO O TIPO DE PESSOA LOGADA
					System.setProperty("LoginPessoa",gerentes[i].getLogin());//SALVAR O LOGIN DA PESSOA LOGADA
					
					servLog.adicionarLog("Gerente " + gerentes[i].getNome() + " Efetuou Login com Sucesso !");
					
					a = true;
					break;
				}
			}
			
			if(a == false)
			{
				servLog.adicionarLogTemporario("Erro ao Tentar Logar, Senha ou Usuário Incorretos");
			}
		}
		
		return a;
	}
	
	/**
	 * Método que Executa Todoas as Configurações Iniciais Necessárias para Rodas as Aplicações Posteriores
	 * @throws IOException
	 */
	public void primeiraExecucao() throws IOException
	{
		//repLog.criarDiretorio();
		//CRIAR TODOS OS BANCOS DO PROGRAMA
		repLog.criarBanco();
		repAux.iniciarArquivoAuxiliar();
		
		repLivro.criarBancoLivro();
		ServicoLivro servLi = new ServicoLivro();
		servLi.arquivosBásicos();
		
		repAluno.criarBancoAluno();
		ServicoAluno servA = new ServicoAluno();
		servA.arquivosBasicos();
		
		repFunc.criarBancoFuncionario();
		repGen.criarBancoGerente();
		
		servLog.adicionarLog("Programa Iniciado Pela Primeira Vez ! Configurações Iniciais Efetuadas");
	}
	
	
	/**
	 * Método que Limpa Todos os Bancos 
	 * @throws IOException
	 */
	public void limparTodosOsBancos() throws IOException
	{
		repLivro.limparBancoLivro();
		ServicoLivro servLi = new ServicoLivro();
		servLi.arquivosBásicos();
		repAluno.limparBancoAluno();
		ServicoAluno servA = new ServicoAluno();
		servA.arquivosBasicos();
		repFunc.limparBancoFuncionario();
		repGen.limparBancoGerente();
		
		repAux.setUltimoIdAluno(0);
		repAux.setUltimoIdFuncionario(0);
		repAux.setUltimoIdGerente(0);
		repAux.setUltimoIdLivro(0);
		repAux.atualizarArquivoAuxiliar(repAux);
		
		servLog.adicionarLog("Todos os Banco Foram Resetados ! Todos os Arquivos Foram Perdidos !");
	}
	
	/**
	 * Método que Criptografa a Senha
	 * @param senha = Senha a ser Criptografada
	 * @return Senha Criptografada
	 * @throws NoSuchAlgorithmException
	 */
	public String criptografarSenha(String senha) throws NoSuchAlgorithmException {
	    try {
	               MessageDigest digest = MessageDigest.getInstance("MD5");
	               digest.update(senha.getBytes());
	               BASE64Encoder encoder = new BASE64Encoder ();
	               return encoder.encode (digest.digest ());
	          } catch (NoSuchAlgorithmException ns) {
	               ns.printStackTrace ();
	               return senha;
	          }
	}
	
	/**
	 * Método que Salva no ArquivoAuxiliar o Login e a Senha de uma Usuário
	 * @param login = login a Ser Salvo
	 * @param senha = senha a Ser Salva
	 * @throws IOException
	 */
	public void manterConectado(String login, String senha) throws IOException
	{
		repAux = repAux.buscarArquivoAuxiliar();
		
		repAux.setLoginSalvo(login);
		repAux.setSenhaSalvo(senha);
		
		repAux.atualizarArquivoAuxiliar(repAux);
	}
	
	/**
	 * Método que busca no Arquivo Auxiliar o Login Salvo
	 * @return Login Salvo
	 * @throws IOException
	 */
	public String getLoginSalvo() throws IOException
	{
		repAux = repAux.buscarArquivoAuxiliar();
		return repAux.getLoginSalvo();
	}
	
	/**
	 * * Método que busca no Arquivo Auxiliar a Senha Salvo
	 * @return Senha Salva
	 * @throws IOException
	 */
	public String getSenhaSalvo() throws IOException
	{
		repAux = repAux.buscarArquivoAuxiliar();
		return repAux.getSenhaSalvo();
	}	
	
	public String deAccent(String str) {
	    String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
	    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	    return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
	
	public String formatarMatricula(int i)
	{
		String matriculaString  = Integer.toString(i);
		char[] matriculaFormatada = new char[matriculaString.length()];
		
		for(int y = 0 ; y < matriculaString.length();y++)
		{
			matriculaFormatada[y] = matriculaString.charAt(y);
		}
		
		if(matriculaString.length() == 8)
		{
			matriculaString = "" + matriculaFormatada[0] + matriculaFormatada[1] + matriculaFormatada[2] + "." + matriculaFormatada[3] 
				+ matriculaFormatada[4] + matriculaFormatada[5] + "-" + matriculaFormatada[6] + matriculaFormatada[7];
		}
		
		return matriculaString;
	}

}
