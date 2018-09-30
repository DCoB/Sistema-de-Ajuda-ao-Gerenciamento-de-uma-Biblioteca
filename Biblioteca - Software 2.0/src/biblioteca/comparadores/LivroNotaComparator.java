package biblioteca.comparadores;

import java.util.Comparator;

import biblioteca.servicos.basicas.Livro;

/**
 * Classe que Realiza a Comparação e Ordenação das Notas dos Livros
 * @version 1.0
 */
public class LivroNotaComparator implements Comparator <Livro>{

	@Override
	public int compare(Livro o1, Livro o2) {
		if(o1.getMediaAvaliacao() > o2.getMediaAvaliacao())
		{
			return -1;
		}
		else if(o1.getMediaAvaliacao() < o2.getMediaAvaliacao())
		{
			return 1;
		}
		
		return (int) o1.getMediaAvaliacao();
	}

}
