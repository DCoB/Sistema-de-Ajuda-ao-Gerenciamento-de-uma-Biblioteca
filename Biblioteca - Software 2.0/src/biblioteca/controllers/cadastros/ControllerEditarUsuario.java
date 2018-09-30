package biblioteca.controllers.cadastros;



import biblioteca.views.cadastro.usuario.ViewCadastroUsuario;
import biblioteca.views.cadastro.usuario.ViewCursoAluno;

import java.awt.Component;
import java.io.IOException;

import javax.swing.JOptionPane;

import biblioteca.exceptions.ErroOperacaoException;
import biblioteca.servicos.*;
import biblioteca.servicos.basicas.*;

public class ControllerEditarUsuario {
	
	private static ViewCadastroUsuario frameUsuario = new ViewCadastroUsuario(1);
	private static ServicoAluno servA = new ServicoAluno();
	private static ServicoFuncionario servF = new ServicoFuncionario();
	private static ServicoGerente servG = new ServicoGerente();
	
	
	private static Component frame;
	
	private static Pessoa usuario;
	
	private static long idPessoa;
	
	
	public static void iniciaTelaEdicao(Pessoa ser, int tipoUsuario) throws IOException {
		usuario=ser;
		recebeIdPessoa();
		preencheTelaEditar(usuario, tipoUsuario);
		frameUsuario.setLocationRelativeTo(null);//exibição de janela centralizada
		frameUsuario.setVisible(true);
	}
	
	//criar método para não necessitar informar id do usuario para editar
	public static boolean editarUsuario(String nome, String cpf, String login, String senha, String sexo) throws IOException, ErroOperacaoException {
		boolean resultado = false;
		
	
		try {
			if(usuario instanceof Aluno) {
								
				ViewCursoAluno frameAluno = new ViewCursoAluno(frameUsuario,nome, login, senha, cpf,sexo);
				frameAluno.setLocationRelativeTo(null);//exibição de janela centralizada
				frameAluno.setVisible(true);
				frameAluno.setAlwaysOnTop(true);
				
				Aluno aluno = new Aluno(nome, login, senha,servA.criaMatricula(), cpf,ControllerCadastroAluno.getCursoAluno(),sexo);

				servA.alterarAluno(aluno, idPessoa);
				
				
			}else if(usuario instanceof Funcionario) {
				
				Funcionario funcionario = new Funcionario(nome, login, senha, cpf,sexo);
				servF.alterarFuncionario(funcionario, idPessoa);
				
			}else {
				
				Gerente gerente = new Gerente(nome, login, senha, cpf,sexo);
				servG.alterarGerente(gerente, idPessoa);
				
			}
			resultado=true;
			JOptionPane.showMessageDialog(frame,
				    "Edição realizada com sucesso.","Aviso",JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			resultado=false;
			JOptionPane.showMessageDialog(frame,
				    "Problema ao realizar alterações.","Aviso",JOptionPane.ERROR_MESSAGE);
			throw new ErroOperacaoException ("Problema ao realizar alterações.");
		}
		
		
		return resultado;

	}
	
	public static Pessoa preencheTelaEditar(Pessoa usuario, int tipoBanco) {
		
		frameUsuario.getLblCadastroDeUsurio().setText("Edição de usuário");
		frameUsuario.getComboBoxTipoDeUsuario().setSelectedIndex(usuario.getTipoPessoa());
		frameUsuario.getComboBoxTipoDeUsuario().setEnabled(false);
		frameUsuario.getComboBoxTipoDeUsuario().setEditable(false);
		
		frameUsuario.getTextFieldNome().setText(usuario.getNome());
		frameUsuario.getTextFieldCpf().setText(usuario.getCPF());
		
		if(usuario.getSex().equals("MASCULINO")) {
			frameUsuario.getComboBoxSexo().setSelectedIndex(1);
		}else {
			frameUsuario.getComboBoxSexo().setSelectedIndex(2);
		}
		
		frameUsuario.getComboBoxSexo().setEnabled(false);
		
		frameUsuario.getTextFieldLogin().setText(usuario.getLogin());
		frameUsuario.getTextFieldLogin().setEditable(false);
		frameUsuario.getPasswordFieldSenha().setText(usuario.getSenha());
		frameUsuario.getPasswordFieldRepetirSenha().setText(usuario.getSenha());
		
		return usuario;
	}
	
	public  static void recebeIdPessoa() throws IOException {
		if(usuario instanceof Aluno) {
			
			if(servA.buscarAluno(usuario.getNome())!=null) {
				idPessoa = servA.buscarAluno(usuario.getNome()).getIdPessoa();
			}
			
		}else if(usuario instanceof Funcionario) {
			
			if(servF.buscarFuncionario(usuario.getNome())!=null) {
				idPessoa = servF.buscarFuncionario(usuario.getNome()).getIdPessoa();
			}
			
		}else {
			if(servG.buscarGerente(usuario.getNome())!=null) {
				idPessoa = servG.buscarGerente(usuario.getNome()).getIdPessoa();
			}	
		}
	}

	
}
