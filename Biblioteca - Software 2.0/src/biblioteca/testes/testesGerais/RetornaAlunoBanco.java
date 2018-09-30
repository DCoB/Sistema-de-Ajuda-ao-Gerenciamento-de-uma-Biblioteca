package biblioteca.testes.testesGerais;

import java.io.IOException;

import biblioteca.servicos.ServicoAluno;
import biblioteca.servicos.basicas.*;
public class RetornaAlunoBanco {
	
	public static void main(String[] args) throws IOException {
		
		Aluno a = new Aluno("Matheus","mpap","123",20,"20");
		Aluno b = new Aluno("Creuza","jkb","123",20,"20");
		Aluno c = new Aluno("George","gbb","123",20,"20");
		ServicoAluno sisA = new ServicoAluno();
		
		sisA.cadastrarAluno(a);
		sisA.cadastrarAluno(b);
		sisA.cadastrarAluno(c);
		
		
		
		Aluno[] alunos;
		
		alunos = sisA.listaAlunos();
		
		System.out.println(alunos[1].getSenha());
		
	}

}
