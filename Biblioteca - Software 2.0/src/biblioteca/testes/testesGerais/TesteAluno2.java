package biblioteca.testes.testesGerais;

import biblioteca.servicos.basicas.*;
public class TesteAluno2 {
	
	public static void main(String[] args) {
		Aluno a = new Aluno("Matheus","mpap","123",123,"10");
		
		Livro[] l = a.getLivros();
		
		System.out.println(l[10]);
		
	}

}
