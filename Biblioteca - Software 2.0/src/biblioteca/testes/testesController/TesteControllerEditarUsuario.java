package biblioteca.testes.testesController;

import biblioteca.controllers.cadastros.ControllerEditarUsuario;
import biblioteca.servicos.ServicoAluno;
import biblioteca.servicos.ServicoFuncionario;
import biblioteca.servicos.basicas.*;

import java.io.IOException;

public class TesteControllerEditarUsuario {
	
	private static ServicoFuncionario f;

	public static void main(String[] args) throws IOException {
		
		
		ServicoAluno servA = new ServicoAluno();
		setF(new ServicoFuncionario());
		
		Aluno[] a = servA.listaAlunos();
		
		
		ControllerEditarUsuario.iniciaTelaEdicao(a[5], 2);
	}

	public static ServicoFuncionario getF() {
		return f;
	}

	public static void setF(ServicoFuncionario f) {
		TesteControllerEditarUsuario.f = f;
	}

}
