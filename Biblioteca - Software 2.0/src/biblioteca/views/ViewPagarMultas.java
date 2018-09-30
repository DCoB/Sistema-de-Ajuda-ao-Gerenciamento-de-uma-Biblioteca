package biblioteca.views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteca.controllers.cadastros.ControllerPerfilLivro;
import biblioteca.servicos.basicas.Aluno;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ViewPagarMultas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPagarMultas frame = new ViewPagarMultas(null,null,null);
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
	public ViewPagarMultas(String nome, String Titulo,Aluno a) {
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
		
		JLabel txtNome = new JLabel("Pagar Multas De:"+ Double.toString(a.getSaldoMultas()) + "Para:");
		txtNome.setFont(new Font("Rockwell", Font.PLAIN, 30));
		txtNome.setBounds(35, 10, 259, 36);
		txtNome.setText("Pagar Multas de:");
		contentPane.add(txtNome);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelar.setBounds(229, 162, 183, 73);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(94, 97, 85, 21);
		lblNewLabel.setText(nome);
		contentPane.add(lblNewLabel);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerPerfilLivro l = new ControllerPerfilLivro();
				
				try {
					l.continuarLocacaoLivro(Titulo,window,a);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConfirmar.setBounds(24, 162, 154, 73);
		contentPane.add(btnConfirmar);
	}

}
