package biblioteca.testes.testesGerais;

import java.io.IOException;

import biblioteca.servicos.ServicoAluno;
import biblioteca.servicos.ServicoLivro;
import biblioteca.servicos.basicas.Aluno;

public class TesteAddLivroAluno {
	
	private static Aluno a;
	private static ServicoLivro servL;

	public static void main(String[] args) throws IOException {
		
		ServicoAluno servA = new ServicoAluno(); //operações realizadas pelo sistema ao aluno
		
		setServL(new ServicoLivro());
		
		setA(new Aluno("Matheus","mpap","123",123,"1010"));
		
		//servA.cadastrarAluno(a);//sistema cadastra o aluno
		Aluno[] a1 = servA.listaAlunos();
		
		servA = new ServicoAluno(a1[1]); //sistema recebe aluno para efetuar operações relacionadas à ele
		
		//servA.addLivroPerfil(0, "Geometria", 0);
		
		
		System.out.println(servA.buscarLivroAluno("Cálculo"));
	}

	public static Aluno getA() {
		return a;
	}

	public static void setA(Aluno a) {
		TesteAddLivroAluno.a = a;
	}

	public static ServicoLivro getServL() {
		return servL;
	}

	public static void setServL(ServicoLivro servL) {
		TesteAddLivroAluno.servL = servL;
	}
	
	

}
