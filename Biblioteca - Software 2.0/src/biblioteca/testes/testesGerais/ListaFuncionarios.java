package biblioteca.testes.testesGerais;

import java.io.IOException;

import biblioteca.servicos.ServicoFuncionario;
import biblioteca.servicos.basicas.Funcionario;

public class ListaFuncionarios {
	
	public static void main(String[] args) throws IOException {
		ServicoFuncionario f = new ServicoFuncionario();
		
		Funcionario ff = new Funcionario("b","1","1","1","");
		
		f.cadastrarFuncionario(ff);
		
		//Funcionario[] f1 = f.listaFuncionarios();
	
	}

}
