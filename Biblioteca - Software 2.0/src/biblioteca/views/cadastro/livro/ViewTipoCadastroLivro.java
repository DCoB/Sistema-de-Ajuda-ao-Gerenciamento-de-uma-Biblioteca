package biblioteca.views.cadastro.livro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteca.controllers.cadastros.ControllerCadastroLivro;
import biblioteca.controllers.cadastros.ControllerTipoCadastroLivro;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ViewTipoCadastroLivro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLivroBanco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTipoCadastroLivro frame = new ViewTipoCadastroLivro();
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
	public ViewTipoCadastroLivro() {
		setResizable(false);
		setTitle("BookSky - Vers\u00E3o 2.0 Cadastro de Usuário");
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Biblioteca - Software 2.0/Imagens/Logo1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelPergunta = new JPanel();
		
		JLabel lblComoDesejaCadastrar = new JLabel("COMO DESEJA CADASTRAR O LIVRO?");
		lblComoDesejaCadastrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelPergunta.add(lblComoDesejaCadastrar);
		
		JButton btnlLivroExistente = new JButton("LIVRO INEXISTENTE NO SISTEMA");
		btnlLivroExistente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ControllerCadastroLivro.iniciaTelaCadastroLivro();
				dispose();
				
			}
		});
		
		JPanel panelBusca = new JPanel();
		
		JLabel lblBuscarLivroJ = new JLabel("BUSCAR LIVRO J\u00C1 EXISTENTE NO SISTEMA");
		lblBuscarLivroJ.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelBusca.add(lblBuscarLivroJ);
		
		textFieldLivroBanco = new JTextField();
		textFieldLivroBanco.setColumns(10);
		
		JButton btnBuscarLivro = new JButton("BUSCAR");
		btnBuscarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(ControllerTipoCadastroLivro.efetuaCadastro(textFieldLivroBanco.getText())) {
						dispose();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuscarLivro.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelPergunta, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(243)
							.addComponent(btnlLivroExistente))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelBusca, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(textFieldLivroBanco, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBuscarLivro, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(panelPergunta, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(128)
					.addComponent(btnlLivroExistente)
					.addGap(85)
					.addComponent(panelBusca, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldLivroBanco, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscarLivro, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
