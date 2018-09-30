package biblioteca.testes.testesGerais;

import java.io.IOException;

import biblioteca.servicos.ServicoGerente;
import biblioteca.servicos.basicas.Gerente;

public class ListaGerente {
	
	public static void main(String[] args) throws IOException {
		
		ServicoGerente sisG = new ServicoGerente();
		
		Gerente g = new Gerente("b","1","1","1","");
		
		sisG.cadastrarGerente(g);
		
	}

}
