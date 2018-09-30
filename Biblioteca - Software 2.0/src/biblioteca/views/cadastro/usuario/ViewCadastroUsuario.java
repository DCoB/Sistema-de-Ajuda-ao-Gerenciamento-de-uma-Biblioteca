package biblioteca.views.cadastro.usuario;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteca.servicos.ServicoAuxiliar;

import javax.swing.JLabel;


import java.awt.Toolkit;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import biblioteca.controllers.cadastros.ControllerCadastroUsuario;
import biblioteca.controllers.cadastros.ControllerEditarUsuario;
import biblioteca.exceptions.CampoInvalidoException;
import biblioteca.exceptions.ErroOperacaoException;
public class ViewCadastroUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPaneCadastroUsuario;
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldLogin;
	private JPasswordField passwordFieldSenha;
	private JPasswordField passwordFieldRepetirSenha;
	private JLabel lblCadastroDeUsurio = new JLabel("CADASTRO DE USU\u00C1RIO");
	private JComboBox comboBoxTipoDeUsuario = new JComboBox();
	private JComboBox comboBoxSexo = new JComboBox();
	
	//private ControllerCadastroUsuario sceneController = new ControllerCadastroUsuario();

	private static ServicoAuxiliar serAux = new ServicoAuxiliar();
	
	//GETTERS E SETTERS USADOS NOS CONTROLLERS
	public JPanel getContentPaneCadastroUsuario() {
		return contentPaneCadastroUsuario;
	}

	public void setContentPaneCadastroUsuario(JPanel contentPaneCadastroUsuario) {
		this.contentPaneCadastroUsuario = contentPaneCadastroUsuario;
	}

	public JTextField getTextFieldNome() {
		return textFieldNome;
	}

	public void setTextFieldNome(JTextField textFieldNome) {
		this.textFieldNome = textFieldNome;
	}

	public JTextField getTextFieldCpf() {
		return textFieldCpf;
	}

	public void setTextFieldCpf(JTextField textFieldCpf) {
		this.textFieldCpf = textFieldCpf;
	}

	public JTextField getTextFieldLogin() {
		return textFieldLogin;
	}

	public void setTextFieldLogin(JTextField textFieldLogin) {
		this.textFieldLogin = textFieldLogin;
	}

	public JPasswordField getPasswordFieldSenha() {
		return passwordFieldSenha;
	}

	public void setPasswordFieldSenha(JPasswordField passwordFieldSenha) {
		this.passwordFieldSenha = passwordFieldSenha;
	}

	public JPasswordField getPasswordFieldRepetirSenha() {
		return passwordFieldRepetirSenha;
	}

	public void setPasswordFieldRepetirSenha(JPasswordField passwordFieldRepetirSenha) {
		this.passwordFieldRepetirSenha = passwordFieldRepetirSenha;
	}

	public JLabel getLblCadastroDeUsurio() {
		return lblCadastroDeUsurio;
	}

	public void setLblCadastroDeUsurio(JLabel lblCadastroDeUsurio) {
		this.lblCadastroDeUsurio = lblCadastroDeUsurio;
	}

	public JComboBox getComboBoxTipoDeUsuario() {
		return comboBoxTipoDeUsuario;
	}

	public void setComboBoxTipoDeUsuario(JComboBox comboBoxTipoDeUsuario) {
		this.comboBoxTipoDeUsuario = comboBoxTipoDeUsuario;
	}
	
	

	public JComboBox getComboBoxSexo() {
		return comboBoxSexo;
	}

	public void setComboBoxSexo(JComboBox comboBoxSexo) {
		this.comboBoxSexo = comboBoxSexo;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroUsuario frame = new ViewCadastroUsuario(0);
					frame.setLocationRelativeTo(null);//exibição de janela centralizada
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	/**
	 * Create the frame.
	 */
	//Se o tipoTela for 0, novo usuario é criado. Se tipoTela=1, editar usuário
	public ViewCadastroUsuario(int tipoTela) {
		setForeground(new Color(0, 255, 255));
		setBackground(new Color(25, 25, 112));
		setTitle("BookSky - Vers\u00E3o 2.0 Cadastro de Usuário");
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Biblioteca - Software 2.0/Imagens/Logo1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 789);
		setResizable(false);
		contentPaneCadastroUsuario = new JPanel();
		contentPaneCadastroUsuario.setBackground(new Color(240, 248, 255));
		contentPaneCadastroUsuario.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneCadastroUsuario);
		contentPaneCadastroUsuario.setLayout(null);
				
		//Layout.view(contentPaneCadastroUsuario,this);
		
		
		//contentPaneCadastroUsuario = new JPanel();
		//contentPaneCadastroUsuario.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPaneCadastroUsuario);
		
		//Layout.view(contentPaneCadastroUsuario, this);
		
		JPanel panelCadastroUsuario = new JPanel();
		panelCadastroUsuario.setBounds(5, 23, 1364, 58);
		panelCadastroUsuario.setBackground(new Color(0, 153, 255));
		
		JPanel panelNome = new JPanel();
		panelNome.setBounds(37, 208, 107, 22);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(151, 208, 416, 22);
		textFieldNome.setColumns(10);
		
		JPanel panel2Info = new JPanel();
		panel2Info.setBounds(12, 94, 1350, 33);
		panel2Info.setBackground(new Color(0, 153, 255));
		
		JLabel lblInfo = new JLabel("*Prezado, informe todos os dados abaixo para prosseguir com o cadastro.");
		lblInfo.setForeground(new Color(255, 0, 0));
		lblInfo.setHorizontalAlignment(SwingConstants.LEFT);
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel2Info.add(lblInfo);
		
		JPanel panelCpf = new JPanel();
		panelCpf.setBounds(37, 243, 107, 20);
		
		JLabel lblCpf = new JLabel("CPF");
		panelCpf.add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(150, 243, 416, 22);
		textFieldCpf.setColumns(10);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(371, 520, 107, 20);
		
		JLabel lblLogin = new JLabel("LOGIN ");
		panelLogin.add(lblLogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(494, 520, 470, 22);
		textFieldLogin.setColumns(10);
		
		JPanel panel_3DadosPessoais = new JPanel();
		panel_3DadosPessoais.setBounds(37, 164, 165, 33);
		
		JLabel lblDadosPessoais = new JLabel("1. Dados pessoais");
		lblDadosPessoais.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3DadosPessoais.add(lblDadosPessoais);
		
		JPanel panelDadosAcesso = new JPanel();
		panelDadosAcesso.setBounds(325, 474, 165, 33);
		
		JLabel lblDadosDeAcesso = new JLabel("3. Dados de acesso");
		lblDadosDeAcesso.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelDadosAcesso.add(lblDadosDeAcesso);
		
		JPanel panelSenha = new JPanel();
		panelSenha.setBounds(371, 555, 107, 20);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(500, 555, 464, 22);
		
		JPanel panelRepetirSenha = new JPanel();
		panelRepetirSenha.setBounds(371, 590, 107, 20);
		
		JLabel lblRepetirSenha = new JLabel("REPETIR SENHA");
		panelRepetirSenha.add(lblRepetirSenha);
		
		passwordFieldRepetirSenha = new JPasswordField();
		passwordFieldRepetirSenha.setBounds(500, 590, 464, 22);
		
		
		
		JButton btnConcluir = new JButton("CONCLUIR");
		btnConcluir.setBounds(15, 696, 214, 45);
		btnConcluir.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				String senha=null;
				String repetirSenha=null;
				
				
				try {//executa a criptografia das senhas recebidas. Servirá para as futuras checagens
					
					senha = serAux.criptografarSenha(passwordFieldSenha.getText());
					repetirSenha = serAux.criptografarSenha(passwordFieldRepetirSenha.getText());
					
					
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(tipoTela==0) {//tela de cadastro de novo usuário

					
					try {//passos para cadastro do usuário
						if(ControllerCadastroUsuario.iniciaCadastroUsuario(textFieldNome.getText(),textFieldCpf.getText()
								,textFieldLogin.getText() ,senha,
								repetirSenha, comboBoxTipoDeUsuario.getSelectedIndex(), (String) comboBoxSexo.getSelectedItem())==true) {
							//verifica se dados informados são válidos
							
							
							if(ControllerCadastroUsuario.cadastrarUsuario(textFieldNome.getText(),textFieldCpf.getText()
								,textFieldLogin.getText() ,passwordFieldSenha.getText(),comboBoxTipoDeUsuario.getSelectedIndex(), (String)comboBoxSexo.getSelectedItem())) {
								//realiza cadastro do usuario, caso seja true, usuario já foi adicionado.
								dispose(); //janela é fechada
								
								
							}
							
						}
					} catch (IOException | CampoInvalidoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else {//tela de cadastro de usuário já existente
					
					try {
						
						
						if(ControllerCadastroUsuario.iniciaCadastroUsuario(textFieldNome.getText(),textFieldCpf.getText()
								,textFieldLogin.getText() ,senha,
								repetirSenha, comboBoxTipoDeUsuario.getSelectedIndex(),(String)comboBoxSexo.getSelectedItem())==true) {
								ControllerEditarUsuario.editarUsuario(textFieldNome.getText(),textFieldCpf.getText()
										,textFieldLogin.getText() ,senha, (String)comboBoxSexo.getSelectedItem());
	
								
								dispose();
							
							
						}
						
					} catch (IOException | CampoInvalidoException | ErroOperacaoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		btnConcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(264, 696, 214, 45);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//janela é fechada
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panelTipoDeUsuario = new JPanel();
		panelTipoDeUsuario.setBounds(721, 214, 165, 33);
		
		JLabel lblTipoDeUsuario = new JLabel("2. Tipo de usu\u00E1rio");
		lblTipoDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelTipoDeUsuario.add(lblTipoDeUsuario);
		comboBoxTipoDeUsuario.setBounds(721, 260, 376, 22);
		
		//JComboBox comboBoxTipoDeUsuario = new JComboBox();
		comboBoxTipoDeUsuario.setModel(new DefaultComboBoxModel(new String[] {"GERENTE", "FUNCIONARIO", "ALUNO"}));
		
		JPanel panelSexo = new JPanel();
		panelSexo.setBounds(37, 278, 107, 20);
		
		JLabel labelSexo = new JLabel("SEXO");
		panelSexo.add(labelSexo);
		comboBoxSexo.setBounds(151, 278, 415, 22);
		
		
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"selecione um sexo", "MASCULINO", "FEMININO"}));
		
		JLabel lblSenha = new JLabel("SENHA");
		panelSenha.add(lblSenha);
		
		JLabel lblNome = new JLabel("NOME");
		panelNome.add(lblNome);
		contentPaneCadastroUsuario.setLayout(null);
		
		
		lblCadastroDeUsurio.setFont(new Font("Rockwell", Font.BOLD, 40));
		panelCadastroUsuario.add(lblCadastroDeUsurio);
		contentPaneCadastroUsuario.add(panelCadastroUsuario);
		contentPaneCadastroUsuario.add(panelNome);
		contentPaneCadastroUsuario.add(textFieldNome);
		contentPaneCadastroUsuario.add(panel2Info);
		contentPaneCadastroUsuario.add(panel_3DadosPessoais);
		contentPaneCadastroUsuario.add(btnConcluir);
		contentPaneCadastroUsuario.add(btnCancelar);
		contentPaneCadastroUsuario.add(panelTipoDeUsuario);
		contentPaneCadastroUsuario.add(comboBoxTipoDeUsuario);
		contentPaneCadastroUsuario.add(panelSexo);
		contentPaneCadastroUsuario.add(comboBoxSexo);
		contentPaneCadastroUsuario.add(panelDadosAcesso);
		contentPaneCadastroUsuario.add(panelRepetirSenha);
		contentPaneCadastroUsuario.add(passwordFieldRepetirSenha);
		contentPaneCadastroUsuario.add(panelSenha);
		contentPaneCadastroUsuario.add(panelLogin);
		contentPaneCadastroUsuario.add(textFieldLogin);
		contentPaneCadastroUsuario.add(passwordFieldSenha);
		contentPaneCadastroUsuario.add(panelCpf);
		contentPaneCadastroUsuario.add(textFieldCpf);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 204));
		panel.setBounds(22, 151, 574, 189);
		contentPaneCadastroUsuario.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 204));
		panel_1.setBounds(694, 199, 448, 99);
		contentPaneCadastroUsuario.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 153, 204));
		panel_2.setBounds(241, 460, 818, 189);
		contentPaneCadastroUsuario.add(panel_2);
	}
}
