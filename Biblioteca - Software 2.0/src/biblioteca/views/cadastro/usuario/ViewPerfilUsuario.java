package biblioteca.views.cadastro.usuario;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import biblioteca.controllers.cadastros.ControllerPerfilUsuario;
import biblioteca.views.Layout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ViewPerfilUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPanePerfilUsuario;
	private JLabel labelName = new JLabel("NOME");
	private JLabel lblLoginn = new JLabel("LOGIN");
	private JLabel lblCpff = new JLabel("CPF");
	private JLabel lblSex = new JLabel("SEXO");
	private JLabel lblMatriculaa = new JLabel("MATR\u00CDCULA");
	private JLabel labelCursoo = new JLabel("CURSO");
	
	private JLabel lblLivro11 = new JLabel("Livro 1");
	private JLabel lblLivro22 = new JLabel("Livro 2");
	private JLabel lblLivro32 = new JLabel("Livro 3");
	
	private JButton btnDevolver1 = new JButton("Devolver");
	private JButton buttonDevolver2 = new JButton("Devolver");
	private JButton buttonDevolver3 = new JButton("Devolver");
	
	private JTextArea txtrHistricoEmBranco = new JTextArea();
	private final JLabel lblNewLabel = new JLabel("Perfil de Usu\u00E1rio");
	private final JLabel textTipoUsuario = new JLabel("");
	private final JLabel lblListadeLivros = new JLabel("Lista de Livros no Hist\u00F3rico");
	private final JLabel lblSaldoMultas = new JLabel("Saldo das Multas:");
	private final JLabel textSaldoMultas = new JLabel("saldo multas");
	private  JPanel painelALuno = new JPanel();
	private JPanel PainelLivrosEmPosse = new JPanel();
	private final JLabel lblPainelAluno = new JLabel("Painel do Aluno");
	private JLabel lblLivrosEmPosse = new JLabel("LIVROS EM POSSE:");
	private JScrollPane scrollPaneLivrosHistóricos = new JScrollPane();
	private final JTextArea textAreaLogs = new JTextArea();
	private final JScrollPane scrollPaneLogs = new JScrollPane();
	private final JLabel lblListadeLogs = new JLabel("Lista de Logs do Usu\u00E1rio");
	private JButton btnPagarMultas = new JButton("Pagar Todas as Multas");

	public JLabel getLblLivrosEmPosse() {
		return lblLivrosEmPosse;
	}




	public void setLblLivrosEmPosse(JLabel lblLivrosEmPosse) {
		this.lblLivrosEmPosse = lblLivrosEmPosse;
	}




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPerfilUsuario frame = new ViewPerfilUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	public JLabel getLabelName() {
		return labelName;
	}




	public void setLabelName(JLabel labelName) {
		this.labelName = labelName;
	}




	public JLabel getLblLoginn() {
		return lblLoginn;
	}




	public void setLblLoginn(JLabel lblLoginn) {
		this.lblLoginn = lblLoginn;
	}




	public JLabel getLblCpff() {
		return lblCpff;
	}




	public void setLblCpff(JLabel lblCpff) {
		this.lblCpff = lblCpff;
	}




	public JLabel getLblSex() {
		return lblSex;
	}




	public void setLblSex(JLabel lblSex) {
		this.lblSex = lblSex;
	}




	public JLabel getLblMatriculaa() {
		return lblMatriculaa;
	}




	public void setLblMatriculaa(JLabel lblMatriculaa) {
		this.lblMatriculaa = lblMatriculaa;
	}
	

	public JLabel getLabelCursoo() {
		return labelCursoo;
	}




	public void setLabelCursoo(JLabel labelCursoo) {
		this.labelCursoo = labelCursoo;
	}

	public JLabel getLblLivro11() {
		return lblLivro11;
	}




	public void setLblLivro11(JLabel lblLivro11) {
		this.lblLivro11 = lblLivro11;
	}




	public JLabel getLblLivro22() {
		return lblLivro22;
	}




	public void setLblLivro22(JLabel lblLivro22) {
		this.lblLivro22 = lblLivro22;
	}




	public JLabel getLblLivro32() {
		return lblLivro32;
	}




	public void setLblLivro32(JLabel lblLivro32) {
		this.lblLivro32 = lblLivro32;
	}
	
	




	public JButton getBtnDevolver1() {
		return btnDevolver1;
	}




	public void setBtnDevolver1(JButton btnDevolver1) {
		this.btnDevolver1 = btnDevolver1;
	}




	public JButton getButtonDevolver2() {
		return buttonDevolver2;
	}




	public void setButtonDevolver2(JButton buttonDevolver2) {
		this.buttonDevolver2 = buttonDevolver2;
	}




	public JButton getButtonDevolver3() {
		return buttonDevolver3;
	}




	public void setButtonDevolver3(JButton buttonDevolver3) {
		this.buttonDevolver3 = buttonDevolver3;
	}


	public JTextArea getTxtrHistricoEmBranco() {
		return txtrHistricoEmBranco;
	}

	public void setTxtrHistricoEmBranco(JTextArea txtrHistricoEmBranco) {
		this.txtrHistricoEmBranco = txtrHistricoEmBranco;
	}
	

	public JPanel getPainelALuno() {
		return painelALuno;
	}




	public void setPainelALuno(JPanel painelALuno) {
		this.painelALuno = painelALuno;
	}




	public JPanel getPainelLivrosEmPosse() {
		return PainelLivrosEmPosse;
	}




	public void setPainelLivrosEmPosse(JPanel painelLivrosEmPosse) {
		PainelLivrosEmPosse = painelLivrosEmPosse;
	}




	public JLabel getTextTipoUsuario() {
		return textTipoUsuario;
	}




	public JLabel getLblSaldoMultas() {
		return lblSaldoMultas;
	}




	public JLabel getTextSaldoMultas() {
		return textSaldoMultas;
	}

	public JLabel getLblListadeLivros() {
		return lblListadeLivros;
	}




	public JLabel getLblPainelAluno() {
		return lblPainelAluno;
	}


	public JTextArea getTextAreaLogs() {
		return textAreaLogs;
	}




	public JScrollPane getScrollPaneLogs() {
		return scrollPaneLogs;
	}

	public JScrollPane getScrollPaneLivrosHistóricos() {
		return scrollPaneLivrosHistóricos;
	}




	public void setScrollPaneLivrosHistóricos(JScrollPane scrollPaneLivrosHistóricos) {
		this.scrollPaneLivrosHistóricos = scrollPaneLivrosHistóricos;
	}

	public JLabel getLblListadeLogs() {
		return lblListadeLogs;
	}

	public JButton getBtnPagarMultas() {
		return btnPagarMultas;
	}




	public void setBtnPagarMultas(JButton btnPagarMultas) {
		this.btnPagarMultas = btnPagarMultas;
	}




	/**
	 * Create the frame.
	 */
	public ViewPerfilUsuario() {
		setForeground(new Color(0, 255, 255));
		setBackground(new Color(25, 25, 112));
		setTitle("BookSky - Vers\u00E3o 2.0 Perfil de Usuário");
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Biblioteca - Software 2.0/Imagens/Logo1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 789);
		setResizable(false);
		contentPanePerfilUsuario = new JPanel();
		contentPanePerfilUsuario.setBackground(new Color(240, 248, 255));
		contentPanePerfilUsuario.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanePerfilUsuario);
		contentPanePerfilUsuario.setLayout(null);
		JFrame window = this;
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 153, 204), 3));
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(44, 138, 1274, 589);
		contentPanePerfilUsuario.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(12, 179, 94, 36);
		panel.add(lblNome);
		lblNome.setFont(new Font("Rockwell", Font.BOLD, 25));
		labelName.setBounds(114, 179, 397, 36);
		panel.add(labelName);
		
		//JLabel labelName = new JLabel("NOME");
		labelName.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblLogin = new JLabel("LOGIN:");
		lblLogin.setBounds(12, 229, 100, 36);
		panel.add(lblLogin);
		lblLogin.setFont(new Font("Rockwell", Font.BOLD, 25));
		lblLoginn.setBounds(124, 228, 397, 36);
		panel.add(lblLoginn);
		
		//JLabel lblLoginn = new JLabel("LOGIN");
		lblLoginn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCpff.setBounds(91, 280, 320, 36);
		panel.add(lblCpff);
		
		//JLabel lblCpff = new JLabel("CPF");
		lblCpff.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(12, 278, 70, 36);
		panel.add(lblCpf);
		lblCpf.setFont(new Font("Rockwell", Font.BOLD, 25));
		
		JLabel lblSexo = new JLabel("SEXO:");
		lblSexo.setBounds(12, 328, 80, 36);
		panel.add(lblSexo);
		lblSexo.setFont(new Font("Rockwell", Font.BOLD, 25));
		lblSex.setBounds(101, 329, 199, 36);
		panel.add(lblSex);
		
		//JLabel lblSex = new JLabel("SEXO");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 18));
			
			
			//JLabel lblLivrosEmPosse = new JLabel("LIVROS EM POSSE:");
			lblLivrosEmPosse.setBounds(905, 50, 209, 36);
			panel.add(lblLivrosEmPosse);
			lblLivrosEmPosse.setFont(new Font("Tahoma", Font.BOLD, 20));
			
			//JScrollPane scrollPane = new JScrollPane();
			scrollPaneLivrosHistóricos.setBounds(653, 282, 611, 285);
			panel.add(scrollPaneLivrosHistóricos);
			txtrHistricoEmBranco.setForeground(new Color(0, 0, 0));
			txtrHistricoEmBranco.setBounds(653, 282, 609, 283);
			
			//JTextArea txtrHistricoEmBranco = new JTextArea();
			txtrHistricoEmBranco.setText("Hist\u00F3rico em branco.");
			txtrHistricoEmBranco.setLineWrap(true);
			txtrHistricoEmBranco.setFont(new Font("Calibri", Font.BOLD, 22));
			textTipoUsuario.setFont(new Font("Rockwell", Font.PLAIN, 60));
			scrollPaneLivrosHistóricos.setViewportView(txtrHistricoEmBranco);
			textTipoUsuario.setBounds(65, 50, 333, 95);
			
			panel.add(textTipoUsuario);
			
			//JPanel PainelLivrosEmPosse = new JPanel();
			PainelLivrosEmPosse.setBackground(new Color(0, 153, 255));
			PainelLivrosEmPosse.setBounds(905, 82, 357, 146);
			panel.add(PainelLivrosEmPosse);
			PainelLivrosEmPosse.setLayout(null);
			lblLivro11.setBounds(12, 10, 231, 32);
			PainelLivrosEmPosse.add(lblLivro11);
			lblLivro11.setForeground(Color.BLACK);
			
			//JLabel lblLivro = new JLabel("Livro 1");
			lblLivro11.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblLivro22.setBounds(12, 55, 231, 32);
			PainelLivrosEmPosse.add(lblLivro22);
			
			//JLabel lblLivro_1 = new JLabel("Livro 2");
			lblLivro22.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblLivro32.setBounds(12, 100, 231, 32);
			PainelLivrosEmPosse.add(lblLivro32);
			
			//JLabel lblLivro_2 = new JLabel("Livro 3");
			lblLivro32.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnDevolver1.setBounds(250, 10, 95, 23);
			PainelLivrosEmPosse.add(btnDevolver1);
			btnDevolver1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						ControllerPerfilUsuario.devolverLivro(lblLivro11.getText(), 10);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			
			//JButton btnDevolver = new JButton("Devolver");
			btnDevolver1.setFont(new Font("Tahoma", Font.BOLD, 11));
			buttonDevolver2.setBounds(250, 55, 95, 23);
			PainelLivrosEmPosse.add(buttonDevolver2);
			buttonDevolver2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						ControllerPerfilUsuario.devolverLivro(lblLivro22.getText(), 10);
					} catch (IOException a) {
						// TODO Auto-generated catch block
						a.printStackTrace();
					}
					
				}
			});
			
			//JButton button = new JButton("Devolver");
			buttonDevolver2.setFont(new Font("Tahoma", Font.BOLD, 11));
			buttonDevolver3.setBounds(250, 100, 95, 23);
			PainelLivrosEmPosse.add(buttonDevolver3);
			buttonDevolver3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						ControllerPerfilUsuario.devolverLivro(lblLivro32.getText(), 10);
					} catch (IOException a) {
						// TODO Auto-generated catch block
						a.printStackTrace();
					}
				}
			});
			
			//JButton button_1 = new JButton("Devolver");
			buttonDevolver3.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblListadeLivros.setFont(new Font("Rockwell", Font.BOLD, 25));
			lblListadeLivros.setBounds(653, 248, 363, 45);
			
			panel.add(lblListadeLivros);
			painelALuno.setBackground(new Color(0, 153, 255));
			painelALuno.setBounds(52, 415, 532, 146);
			
			panel.add(painelALuno);
			painelALuno.setLayout(null);
				lblSaldoMultas.setBounds(49, 0, 269, 50);
				painelALuno.add(lblSaldoMultas);
				lblSaldoMultas.setFont(new Font("Rockwell", Font.BOLD, 30));
				textSaldoMultas.setBounds(335, 10, 162, 36);
				painelALuno.add(textSaldoMultas);
				textSaldoMultas.setFont(new Font("Tahoma", Font.BOLD, 18));
					
					
					JLabel lblMatricula = new JLabel("MATR\u00CDCULA:");
					lblMatricula.setBounds(12, 62, 171, 36);
					painelALuno.add(lblMatricula);
					lblMatricula.setFont(new Font("Rockwell", Font.BOLD, 25));
				lblMatriculaa.setBounds(184, 62, 336, 36);
				painelALuno.add(lblMatriculaa);
				
				//JLabel lblMatriculaa = new JLabel("MATR\u00CDCULA");
				lblMatriculaa.setFont(new Font("Tahoma", Font.BOLD, 18));
				
				JLabel labelCurso = new JLabel("CURSO:");
				labelCurso.setBounds(12, 97, 106, 36);
				painelALuno.add(labelCurso);
				labelCurso.setFont(new Font("Tahoma", Font.BOLD, 25));
				labelCursoo.setBounds(113, 97, 407, 36);
				painelALuno.add(labelCursoo);
				
				//JLabel labelCursoo = new JLabel("CURSO");
				labelCursoo.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblPainelAluno.setFont(new Font("Rockwell", Font.BOLD, 30));
				lblPainelAluno.setBounds(53, 379, 247, 36);
				
				panel.add(lblPainelAluno);
				textAreaLogs.setFont(new Font("Monospaced", Font.PLAIN, 18));
				textAreaLogs.setEditable(false);
				textAreaLogs.setBounds(452, 81, 810, 495);
				
				scrollPaneLogs.setBounds(450, 84, 812, 492);
				scrollPaneLogs.setViewportView(textAreaLogs);
				
				panel.add(scrollPaneLogs);
				lblListadeLogs.setFont(new Font("Rockwell", Font.BOLD, 30));
				lblListadeLogs.setBounds(454, 39, 408, 53);
				
				panel.add(lblListadeLogs);
				btnPagarMultas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							ControllerPerfilUsuario.charmarTelaPagarMultas(window);
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				//JButton btnPagarMultas = new JButton("Pagar Todas as Multas");
				btnPagarMultas.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btnPagarMultas.setBounds(1080, 13, 184, 36);
				panel.add(btnPagarMultas);
			
				
		Layout.view(contentPanePerfilUsuario,this);
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 40));
		lblNewLabel.setBounds(44, 91, 462, 58);
		
		contentPanePerfilUsuario.add(lblNewLabel);

	}
}
