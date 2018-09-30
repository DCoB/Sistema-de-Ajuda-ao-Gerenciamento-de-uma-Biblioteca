package biblioteca.comparadores;

import java.util.Comparator;

import biblioteca.servicos.basicas.Livro;

/**
 * Classe que Realiza a Compara��o e Ordena��o dos T�tulos dos Livros
 * @version 1.0
 */
public class LivroTituloComparator implements Comparator <Livro>{

	@Override
	public int compare(Livro o1, Livro o2) {
		
		String t1 = o1.getTitulo().toUpperCase();//TRANSFORMA TUDO EM MA�USCULO
		String t2 = o2.getTitulo().toUpperCase();//TRANSFORMA TUDO EM MA�USCULO

		return t1.compareTo(t2);
	}

}
