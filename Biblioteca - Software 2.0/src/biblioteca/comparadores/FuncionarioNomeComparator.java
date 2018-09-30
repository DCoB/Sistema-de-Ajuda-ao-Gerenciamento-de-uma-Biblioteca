package biblioteca.comparadores;

import java.util.Comparator;

import biblioteca.servicos.basicas.Funcionario;

/**
 * Classe que Realiza a Comparação e Ordenação dos Nomes dos Funcionários
 * @version 1.0
 */
public class FuncionarioNomeComparator implements Comparator <Funcionario>{

	@Override
	public int compare(Funcionario o1, Funcionario o2) {
		String n1 = o1.getNome().toUpperCase();//TRANSFORMA TUDO EM MAÍUSCULO
		String n2 = o2.getNome().toUpperCase();//TRANSFORMA TUDO EM MAÍUSCULO
		
		return n1.compareTo(n2);
	}

}
