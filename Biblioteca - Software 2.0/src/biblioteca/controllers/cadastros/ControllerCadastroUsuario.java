package biblioteca.controllers.cadastros;

import java.awt.Component;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import biblioteca.controllers.ControllerComplementar;
import biblioteca.exceptions.CampoInvalidoException;
import biblioteca.servicos.*;
import biblioteca.servicos.basicas.Funcionario;
import biblioteca.servicos.basicas.Gerente;
import biblioteca.views.cadastro.usuario.ViewCadastroUsuario;
import biblioteca.views.cadastro.usuario.ViewCursoAluno;

public class ControllerCadastroUsuario {//CLASSE RESPONS�VEL PELO CONTROLE DO VIEW CADASTRO DE USU�RIO

	private static Component frame = null; 
	private static Object[] options = {"Sim","N�o",};
	private static int n =-1;
	
	private static ServicoFuncionario serF = new ServicoFuncionario();
	private static ServicoGerente serG = new ServicoGerente();
	private static ServicoLog serLog = new ServicoLog();
	
	
	private static ViewCadastroUsuario frameUsuario = new ViewCadastroUsuario(0);
	
	private static boolean statusView=false;
	
	
	
	
	//Para realizar um cadastro, basta chamar este m�todo
	
	public static boolean isStatusView() {
		return statusView;
	}



	public static void setStatusView(boolean statusView) {
		ControllerCadastroUsuario.statusView = statusView;
	}



	public static void iniciaTelaCadastro() {
		frameUsuario = new ViewCadastroUsuario(0);
		frameUsuario.setLocationRelativeTo(null);//exibi��o de janela centralizada
		frameUsuario.setVisible(true);
	}
	
	public static void iniciaTelaCadastro(JFrame window) {
		window.dispose();
		frameUsuario = new ViewCadastroUsuario(0);
		frameUsuario.setLocationRelativeTo(null);//exibi��o de janela centralizada
		frameUsuario.setVisible(true);
	}
	
	
	public static void statusFrame() {
		
		if(ControllerCadastroUsuario.statusView==true) {
			frameUsuario.setVisible(false);
		}else {
			frameUsuario.setVisible(true);
		}
		
	}
	
	
	
	/**
	 * M�todo realiza checagem dos dados informados na ViewCadastroUsuario.
	 * Os campos devem ser respeitados para que cadastro prossiga 
	 * @param nome
	 * @param cpf
	 * @param login
	 * @param senha
	 * @param repetirSenha
	 * @param tipoUsuario
	 * @return true para cadastro aceito ou false para cadastro negado
	 * @throws IOException
	 * @throws CampoInvalidoException 
	 */
	@SuppressWarnings("deprecation")
	public static boolean iniciaCadastroUsuario(String nome, String cpf, String login, String senha, 
			String repetirSenha, int tipoUsuario, String sexo) throws IOException, CampoInvalidoException {
		boolean resultado=false;
		//VERIFICA SE TODOS OS DADOS FORAM PREENCHIDOS
		
		if(!nome.trim().isEmpty()&&!cpf.trim().isEmpty()&&!login.trim().isEmpty()&&
				!senha.trim().isEmpty()&&!repetirSenha.trim().isEmpty()&&!sexo.equals("selecione um sexo")) {
			
			
			if(ControllerComplementar.validarCampos(nome,0)&&ControllerComplementar.validarCampos(cpf,1)) {
				//Verifica se campos nome e CPF est�o v�lidos
				
				if(senha.equals(repetirSenha)) {//verifica se senha s�o iguais
					
					n = JOptionPane.showOptionDialog(frame,"Voc� deseja prosseguir?","Aviso", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
					
					
					//Verifica��o no banco se o usu�rio j� est� cadastrado
					try {
						if(ControllerComplementar.usuarioCadastrado(login,senha,cpf, tipoUsuario)==true) {
							n=-1;
							serLog.adicionarLog("Usu�rio j� cadastrado. Favor fazer login.");
							JOptionPane.showMessageDialog(frame,
								    "Usu�rio j� cadastrado. Favor fazer login.","",JOptionPane.ERROR_MESSAGE);
							
						}else {
							resultado=true; //ap�s todas estas checagens, o funcion�rio dar� continuidade ao cadastro
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//Ser� implementado Jdialog de acesso ao banco
						serLog.adicionarLog("Falha na verifica��o do banco.");
						JOptionPane.showMessageDialog(frame,
							    "Falha na verifica��o do banco.","",JOptionPane.ERROR_MESSAGE);
						throw new CampoInvalidoException("Falha na verifica��o do banco.");
					}
					
					
				}else {
					serLog.adicionarLog("Senhas digitadas n�o conferem.");
					JOptionPane.showMessageDialog(frame,
						    "Senhas digitadas n�o conferem.","Aviso",JOptionPane.ERROR_MESSAGE);
					//lan�amento da exception
					throw new CampoInvalidoException("Senhas digitadas n�o conferem.");
				}
				
			}else {
				serLog.adicionarLog("H� caracteres inv�lidos no campo NOME ou CPF.");
				JOptionPane.showMessageDialog(frame,
					    "H� caracteres inv�lidos no campo NOME ou CPF.","Aviso",JOptionPane.ERROR_MESSAGE);
				//lan�amento da exception
				throw new CampoInvalidoException("H� caracteres inv�lidos no campo NOME ou CPF.");
			}
			
		}else {
			serLog.adicionarLog("Campos foram deixados em branco.\nFavor preenche-los");
			JOptionPane.showMessageDialog(frame,"Campos foram deixados em branco.\nFavor preenche-los","Aviso",JOptionPane.WARNING_MESSAGE);
			//lan�amento da exception
			throw new CampoInvalidoException("Campos foram deixados em branco.\nFavor preenche-los");
			
		}
		
		return resultado;
}
	
	
	/**
	 * M�todo que inicia cadastro do usu�rio, mediante a aprova��o do m�todo iniciaCadastroUsuario
	 * S�o feito cadastro de Alunos, Funcionarios e Gerentes.
	 * @param nome
	 * @param cpf
	 * @param login
	 * @param senha
	 * @param indiceSelecionado
	 * @return true para sucesso e false para falha no cadastro
	 */
	public static  boolean cadastrarUsuario(String nome, String cpf, String login, String senha, int indiceSelecionado, String sexo) {
		boolean resultado=false;
		
		
		if(n==0) {//Aqui o processo de cadastro � continuado
			if(indiceSelecionado==2) {//Efetua cadastro de Aluno (caso especial)
				
				//aluno precisa informar o curso
				ViewCursoAluno frameAluno = new ViewCursoAluno(frameUsuario,nome, login, senha, cpf, sexo);
				frameAluno.setLocationRelativeTo(null);//exibi��o de janela centralizada
				frameAluno.setVisible(true);
				frameAluno.setAlwaysOnTop(true);
				
			}else if(indiceSelecionado==1) {//Efetua cadastro de Funcionario comum
				
			
				Funcionario f = new Funcionario(nome,login,senha,cpf, sexo);
				
				try {
					serF.cadastrarFuncionario(f);
					JOptionPane.showMessageDialog(frame, "Funcion�rio cadastrado com sucesso.");
					resultado=true;
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(frame, "Falha ao cadastrar funcion�rio.");
				}
			}else {
				
				
				Gerente g = new Gerente (nome,login,senha,cpf, sexo);//Efetua cadastro de gerente
				
				try {
					serG.cadastrarGerente(g);
					JOptionPane.showMessageDialog(frame, "Gerente cadastrado com sucesso.");
					resultado=true;
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(frame, "Falha ao cadastrar gerente.");
				}

			}
		
	}
		
		return resultado;
		//A DEPENDER DO RESULTADO, CHAMAR VIEW DO FUNCIONARIO OU INICIAR NOVO CADASTRO
	}
}
