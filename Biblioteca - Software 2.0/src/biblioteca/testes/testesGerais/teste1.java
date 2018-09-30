package biblioteca.testes.testesGerais;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;


import biblioteca.repositorios.RepositorioAuxiliar;
import biblioteca.servicos.ServicoAluno;

import biblioteca.servicos.ServicoLivro;
import biblioteca.servicos.ServicoLog;
import biblioteca.servicos.basicas.Aluno;
import biblioteca.servicos.basicas.Livro;

public class teste1 {
	
	private static Aluno a;
	private static Livro l;
	private static Aluno a1;
	private static ServicoAluno servA;
	private static ServicoLivro servLi;
	private static RepositorioAuxiliar repAux;
	
	
	

	public static Aluno getA() {
		return a;
	}




	public static void setA(Aluno a) {
		teste1.a = a;
	}




	public static Livro getL() {
		return l;
	}




	public static void setL(Livro l) {
		teste1.l = l;
	}




	public static Aluno getA1() {
		return a1;
	}




	public static void setA1(Aluno a1) {
		teste1.a1 = a1;
	}




	public static ServicoAluno getServA() {
		return servA;
	}




	public static void setServA(ServicoAluno servA) {
		teste1.servA = servA;
	}




	public static ServicoLivro getServLi() {
		return servLi;
	}




	public static void setServLi(ServicoLivro servLi) {
		teste1.servLi = servLi;
	}




	public static RepositorioAuxiliar getRepAux() {
		return repAux;
	}




	public static void setRepAux(RepositorioAuxiliar repAux) {
		teste1.repAux = repAux;
	}




	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		System.setProperty("IdPessoa", String.valueOf(0));//ESSA LINHA � NECESS�RIA PARA SETAR O ID "0" COMO O PADR�O
		System.setProperty("LogTemporario", String.valueOf(0));//ESSA LINHA � NECESS�RIA PARA SETAR O LOG TEMPORARIO "0" COMO O PADR�O;		
		System.setProperty("TipoPessoa", String.valueOf(0));		
		
		//ServicoAuxiliar servAux = new ServicoAuxiliar();
		a = new Aluno("Jos� Malafaia", "teste3", "1234", 123, "112321312","Engenharia Civil","");
		l = new Livro("Homo Deus", "Harari, Yuval Noah", "Ci�ncias Humanas e Sociais", "Neste �Homo Deus�: uma breve hist�ria do amanh�, Yuval Noah Harari, autor do estrondoso best-seller Sapiens: uma breve hist�ria da humanidade, volta a combinar ci�ncia, hist�ria e filosofia, desta vez para entender quem somos e descobrir para onde vamos. Sempre com um olhar no passado e nas nossas origens, Harari investiga o futuro da humanidade em busca de uma resposta t�o dif�cil quanto essencial: depois de s�culos de guerras, fome e pobreza, qual ser� nosso destino na Terra? A partir de uma vis�o absolutamente original de nossa hist�ria, ele combina pesquisas de ponta e os mais recentes avan�os cient�ficos � sua conhecida capacidade de observar o passado de uma maneira inteiramente nova. Assim, descobrir os pr�ximos passos da evolu��o humana ser� tamb�m redescobrir quem fomos e quais caminhos tomamos para chegar at� aqui.", 2016);
		a1 = new Aluno();
		servA = new ServicoAluno();
		servLi = new ServicoLivro();
		ServicoLog serL = new ServicoLog();
		repAux = new RepositorioAuxiliar();
	
		//a1 = servA.buscarAluno("754-823-423-42");
		//a1.setSaldoMultas(-5);
		//servA.alterarAluno(a1, a1.getIdPessoa());
		
		//repAux.diferencaDiasDatas();
		//servAux.primeiraExecucao();
		//servAux.limparTodosOsBancos();
		//servLi.buscarLivroPorId(0);
		//servA.cadastrarAluno(a);
		//servA.alterarAluno(a, 2);
		//servA.deletarAluno(7);
		//servA.buscarAluno("JOSe per");
		///servA.formatarMatricula(98745621);
		
		//servLi.cadastrarLivro(l);
		//servLi.recomendaLivros();
		//servLi.organizaTitulo(false);
		//servLi.organizaNota(false);
		//servLi.buscarLivrosInciais("Engenharia");
		
		//ViewLogin viewL = new ViewLogin(false,"","");
		//viewL.setLocationRelativeTo(null);//exibi��o de janela centralizada
		//.setVisible(true);
		
		//servAux.login("tes", "1234", 2);
		
		System.out.println(serL.UltimoLog());
		System.out.println("\nTeste Realizado Com Sucesso !");
		
		
	    }
	
	
}

