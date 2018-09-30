package biblioteca.controllers.cadastros;

import java.awt.Component;
import java.io.IOException;

import javax.swing.JOptionPane;

import biblioteca.servicos.ServicoAluno;
import biblioteca.servicos.basicas.Aluno;
/**
 * Classe Responsàvel por Fazer Todas as Operações que Acontecem na View Cadastro de Aluno
 */
public class ControllerCadastroAluno {
	
	private static Component frameAluno = null;
	private static ServicoAluno sisA = new ServicoAluno();
	private static boolean status;
	private static String cursoAluno;
	
	
	public static String getCursoAluno() {
		return cursoAluno;
	}

	public static void setCursoAluno(String cursoAluno) {
		ControllerCadastroAluno.cursoAluno = cursoAluno;
	}


	/**
	 * Método efetua o cadastro do aluno recebendo dados da view
	 * @param nome
	 * @param login
	 * @param senha
	 * @param cpf
	 * @param curso
	 * @param sexo
	 * @return true or false
	 * @throws IOException 
	 */
	public static boolean cadastrarAluno(String nome, String login, String senha, String cpf, String curso, String sexo) throws IOException {
		boolean resultado = false;
		//essa atribuição serve para a edição do aluno, para saber qual o novo curso editado

		Aluno a = new Aluno(nome, login, senha,sisA.criaMatricula(),cpf, curso, sexo); //aluno é instanciado
		
		if(!curso.equals("selecione um curso")) {
			
			try {
				sisA.cadastrarAluno(a);
				JOptionPane.showMessageDialog(frameAluno, "Aluno cadastrado com sucesso.");
				resultado = true;
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(frameAluno, "Você precisa informar um curso para prosseguir.");
		}
		return resultado;
	}

	public static boolean isStatus() {
		return status;
	}

	public static void setStatus(boolean status) {
		ControllerCadastroAluno.status = status;
	}

}
