package biblioteca.comparadores;

import java.util.Comparator;

import biblioteca.servicos.basicas.Gerente;

/**
 * Classe que Realiza a Comparação e Ordenação dos Nomes dos Gerentes
 * @version 1.0
 */
public class GerenteNomeComparator implements Comparator <Gerente>{

	@Override
	public int compare(Gerente o1, Gerente o2) {
		String n1 = o1.getNome().toUpperCase();//TRANSFORMA TUDO EM MAÍUSCULO
		String n2 = o2.getNome().toUpperCase();//TRANSFORMA TUDO EM MAÍUSCULO
		
		return n1.compareTo(n2);
	}

}
