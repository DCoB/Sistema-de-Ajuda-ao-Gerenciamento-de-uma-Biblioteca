package biblioteca.testes.testesGerais;

import java.io.IOException;

import biblioteca.servicos.ServicoLivro;
import biblioteca.servicos.basicas.Livro;

public class BancoRetornaLivro {

	public static void main(String[] args) throws IOException {
		ServicoLivro sisL = new ServicoLivro();//Sistema direcionado às operações com livro
		
		
		
		Livro aa = new Livro("Jeremias","Phelipe","Alves","",2008);

		sisL.cadastrarLivro(aa);
		
		Livro[] a = sisL.buscarLivro("Jeremias");//recebe lista de livros do sistema
		
		System.out.println(a[0].getAno());//impressão para verificar validade do objeto retornado
		
		
		
		
		
		
		
	}
	
}
