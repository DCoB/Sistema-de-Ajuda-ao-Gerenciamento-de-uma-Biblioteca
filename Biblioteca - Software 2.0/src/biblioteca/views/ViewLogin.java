package biblioteca.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import biblioteca.controllers.ControllerGeral;
import biblioteca.servicos.ServicoAuxiliar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class ViewLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textLogin;
	private JTextField textSenha;
	int tipoLogin = 2;
	boolean lembrarSenha = true;
	ControllerGeral Cg = new ControllerGeral();
	
	
	public static void main(String[] args) {
		System.setProperty("IdPessoa", String.valueOf(0));//ESSA LINHA É NECESSÁRIA PARA SETAR O ID "0" COMO O PADRÃO
		System.setProperty("LogTemporario", String.valueOf(0));//ESSA LINHA É NECESSÁRIA PARA SETAR O LOG TEMPORARIO "0" COMO O PADRÃO
		System.setProperty("TipoPessoa", String.valueOf(0)); 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServicoAuxiliar servAu = new ServicoAuxiliar();
					
					ViewLogin frame = new ViewLogin(false,servAu.getLoginSalvo(),servAu.getSenhaSalvo());
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
	public ViewLogin(boolean erro,String loginSalvo,String senhaSalvo) {// atributo boolean determinará a exibição da mensagem de erro ou não
		System.setProperty("LogTemporario", String.valueOf(0));//ESSA LINHA É NECESSÁRIA PARA SETAR O LOG TEMPORARIO "0" COMO O PADRÃO;		
		
		setTitle("BookSky - Vers\u00E3o 2.0");
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Daniel the God\\Desktop\\UAL\\Universidade\\TRabalhos\\Imagens Trabalho Biblioteca\\Logo1.png"));//CAMINHO PARA VER NA PRÉ VISUALIZAÇÃO
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Biblioteca - Software 2.0/Imagens/Logo1.png"));//CAMINHO DO PROJETO
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1367, 775);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JFrame window = this;
		
		JRadioButton rbFuncionario = new JRadioButton("Funcion\u00E1rio");		
		rbFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JRadioButton rbAluno = new JRadioButton("Aluno");
		rbAluno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JRadioButton rbGerente = new JRadioButton("Gerente");
		rbGerente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton bEntrar = new JButton("Entrar");
		bEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				bEntrar.setForeground(new Color(255, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				bEntrar.setForeground(new Color(0, 0, 0));
			}
		});
		bEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try
				{
					Cg.Entrar(textLogin.getText(), textSenha.getText(), tipoLogin,lembrarSenha,window);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		rbFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbAluno.setSelected(false);
				rbGerente.setSelected(false);
				tipoLogin = 1;
			}
		});
		
		JLabel lErro = new JLabel("Login ou Senha Incorretos");
		lErro.setForeground(new Color(255, 0, 0));
		lErro.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lErro.setBounds(502, 433, 355, 25);
		if(erro == true)
		{
			contentPane.add(lErro);
		}

		JRadioButton rbManterConectado = new JRadioButton("Manter Conectado");
		rbManterConectado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbManterConectado.isSelected() == true)
				{
					lembrarSenha = true;
				}
				if(rbManterConectado.isSelected() == false)
				{
					lembrarSenha = false;
				}
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Escola Polit\u00E9cnica de Pernambuco UPE - Todos os Direitos Reservados");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(12, 710, 499, 30);
		contentPane.add(lblNewLabel_1);
		
		JTextArea txtrAlunos = new JTextArea();
		txtrAlunos.setEditable(false);
		txtrAlunos.setFont(new Font("Rockwell", Font.BOLD, 15));
		txtrAlunos.setText("\tAlunos:\r\n\r\n\tSilas Nunes\r\n\tMatheus Alves\r\n\tDaniel Correia\r\n");
		txtrAlunos.setBounds(1054, 624, 309, 116);
		txtrAlunos.setOpaque(false);
		contentPane.add(txtrAlunos);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(433, 546, 494, 28);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		textSenha.setText(senhaSalvo);
		
		textLogin = new JTextField();
		textLogin.setBounds(433, 471, 494, 25);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		textLogin.setText(loginSalvo);
		rbManterConectado.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rbManterConectado.setSelected(true);
		rbManterConectado.setOpaque(false);
		rbManterConectado.setBackground(Color.WHITE);
		rbManterConectado.setBounds(422, 590, 207, 25);
		contentPane.add(rbManterConectado);
		rbFuncionario.setOpaque(false);
		rbFuncionario.setBackground(Color.WHITE);
		rbFuncionario.setBounds(607, 410, 131, 25);
		contentPane.add(rbFuncionario);
		
		
		rbGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rbAluno.setSelected(false);
				rbFuncionario.setSelected(false);
				tipoLogin = 0;
			}
		});
		rbGerente.setOpaque(false);
		rbGerente.setBackground(Color.WHITE);
		rbGerente.setBounds(738, 410, 105, 25);
		contentPane.add(rbGerente);
		
		
		rbAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbGerente.setSelected(false);
				rbFuncionario.setSelected(false);
				tipoLogin = 2;
			}
		});
		rbAluno.setBackground(new Color(255, 255, 255));
		rbAluno.setSelected(true);
		rbAluno.setBounds(520, 410, 79, 25);
		rbAluno.setOpaque(false);
		contentPane.add(rbAluno);
		
		bEntrar.setToolTipText("");
		bEntrar.setFont(new Font("Tahoma", Font.BOLD, 30));
		bEntrar.setForeground(new Color(0, 0, 0));
		bEntrar.setBackground(new Color(255, 255, 255));
		bEntrar.setBounds(597, 624, 131, 49);
		bEntrar.setContentAreaFilled(false);
		bEntrar.setBorderPainted(false);
		contentPane.add(bEntrar);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		//lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Daniel the God\\Desktop\\UAL\\Universidade\\TRabalhos\\Imagens Trabalho Biblioteca\\Exemplos de Telas\\Tela Login 2.1.png"));//CAMINHO PARA VER NA PRÉ VISUALIZAÇÃO
		lblNewLabel.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/Tela Login 2.1.png"));//CAMINHO DO PROJETO
		lblNewLabel.setBounds(0, 0, 1363, 740);
		contentPane.add(lblNewLabel);
	}
}
