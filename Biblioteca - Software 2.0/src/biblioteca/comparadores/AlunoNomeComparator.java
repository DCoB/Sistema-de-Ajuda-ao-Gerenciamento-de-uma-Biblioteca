package biblioteca.comparadores;

import java.util.Comparator;

import biblioteca.servicos.basicas.Aluno;

/**
 * Classe que Realiza a Compara��o e Ordena��o dos Nomes dos Alunos
 * @version 1.0
 */
public class AlunoNomeComparator implements Comparator <Aluno>{

	@Override
	public int compare(Aluno o1, Aluno o2) {
		String n1 = o1.getNome().toUpperCase();//TRANSFORMA TUDO EM MA�USCULO
		String n2 = o2.getNome().toUpperCase();//TRANSFORMA TUDO EM MA�USCULO
		
		return n1.compareTo(n2);
	}
	
	
}
