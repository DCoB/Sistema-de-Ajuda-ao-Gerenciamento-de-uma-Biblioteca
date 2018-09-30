package biblioteca.comparadores;

import java.util.Comparator;

import biblioteca.servicos.basicas.Livro;

/**
 * Classe que Realiza a Comparação e Ordenação dos Títulos dos Livros
 * @version 1.0
 */
public class LivroTituloComparator implements Comparator <Livro>{

	@Override
	public int compare(Livro o1, Livro o2) {
		
		String t1 = o1.getTitulo().toUpperCase();//TRANSFORMA TUDO EM MAÍUSCULO
		String t2 = o2.getTitulo().toUpperCase();//TRANSFORMA TUDO EM MAÍUSCULO

		return t1.compareTo(t2);
	}

}
