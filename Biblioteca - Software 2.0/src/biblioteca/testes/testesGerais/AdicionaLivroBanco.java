package biblioteca.testes.testesGerais;

import java.io.IOException;

import biblioteca.servicos.ServicoLivro;
import biblioteca.servicos.basicas.Livro;

public class AdicionaLivroBanco {
	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("IdPessoa", String.valueOf(0));//ESSA LINHA � NECESS�RIA PARA SETAR O ID "0" COMO O PADR�O
		System.setProperty("LogTemporario", String.valueOf(0));//ESSA LINHA � NECESS�RIA PARA SETAR O LOG TEMPORARIO "0" COMO O PADR�O;		
		System.setProperty("TipoPessoa", String.valueOf(0));	
		
		ServicoLivro sisL = new ServicoLivro();
		Livro l = new Livro("Geometria","Stweart","Matem�tica","Olar",1990);
		Livro a = new Livro("Oks","Stweart","Matem�tica","Olar",1990);
		Livro b = new Livro("Oi","Stweart","Matem�tica","Olar",1990);
		Livro c = new Livro("Sei","Stweart","Matem�tica","Olar",1990);
		
		//String titulo, String autor, String genero,String sinopse,int ano
		
		sisL.cadastrarLivro(l);
		sisL.cadastrarLivro(a);
		sisL.cadastrarLivro(b);
		sisL.cadastrarLivro(c);
		
		
		
		
		
		
	}

}
