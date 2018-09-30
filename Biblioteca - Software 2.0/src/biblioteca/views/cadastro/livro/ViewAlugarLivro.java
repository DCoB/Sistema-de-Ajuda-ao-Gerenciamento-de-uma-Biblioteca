package biblioteca.views.cadastro.livro;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteca.controllers.cadastros.ControllerPerfilLivro;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ViewAlugarLivro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAlugarLivro frame = new ViewAlugarLivro(null);
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
	public ViewAlugarLivro(String titulo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setTitle("BookSky - Vers\u00E3o 2.0   -   Confirmação de Locação");
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Biblioteca - Software 2.0/Imagens/Logo1.png"));//CAMINHO DO PROJETO
		setResizable(false);
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JFrame window = this;
		
		contentPane.setLayout(null);
		
		textCPF = new JTextField();
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCPF.setBounds(12, 98, 387, 34);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF do Aluno:");
		lblCPF.setFont(new Font("Rockwell", Font.PLAIN, 25));
		lblCPF.setBounds(12, 70, 170, 27);
		contentPane.add(lblCPF);
		
		JButton btnConfirmar = new JButton("Confirmar Loca\u00E7\u00E3o");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerPerfilLivro l = new ControllerPerfilLivro();
				try {
					l.confirmarAlugarLivro(textCPF.getText(),window,titulo);
					window.dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
			}
		});
		btnConfirmar.setBounds(37, 183, 145, 46);
		contentPane.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar Loca\u00E7\u00E3o");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.dispose();
			}
		});
		btnCancelar.setBounds(220, 183, 145, 46);
		contentPane.add(btnCancelar);
		
		JLabel lblTituloLivro = new JLabel("fasfasfasfas");
		lblTituloLivro.setFont(new Font("Rockwell", Font.PLAIN, 15));
		lblTituloLivro.setBounds(22, 13, 392, 34);
		lblTituloLivro.setText(titulo);
		contentPane.add(lblTituloLivro);
	}
}
