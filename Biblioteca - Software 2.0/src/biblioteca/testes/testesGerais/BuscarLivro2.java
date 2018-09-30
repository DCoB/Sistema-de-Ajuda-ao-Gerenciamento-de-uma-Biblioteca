package biblioteca.testes.testesGerais;

import java.io.IOException;

import biblioteca.servicos.ServicoLivro;

public class BuscarLivro2 {
	
	public static void main(String[] args) throws IOException {
		ServicoLivro servL = new ServicoLivro();
		
		System.out.println(servL.buscarLivro("Cálculo").length);
		
	}
	

}
