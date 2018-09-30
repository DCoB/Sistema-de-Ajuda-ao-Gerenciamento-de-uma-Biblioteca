package biblioteca.testes.testesController;

import java.io.IOException;

import biblioteca.controllers.cadastros.ControllerEditarLivro;
import biblioteca.exceptions.ErroOperacaoException;
import biblioteca.servicos.ServicoLivro;
import biblioteca.servicos.basicas.Livro;

public class TesteControllerEditarLivro {
	
	public static void main(String[] args) throws IOException, ErroOperacaoException {
		
		ServicoLivro ser = new ServicoLivro();
		
		Livro[] a = ser.listaLivros();
		
		
		//System.out.println(a[2].getSinopse());
		
		ControllerEditarLivro.iniciaTelaEdicaoLivro(a[3]);
		
	}

}
