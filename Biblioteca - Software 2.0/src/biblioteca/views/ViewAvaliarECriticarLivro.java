package biblioteca.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import biblioteca.controllers.cadastros.ControllerPerfilUsuario;
import biblioteca.exceptions.CampoInvalidoException;

public class ViewAvaliarECriticarLivro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNota;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAvaliarECriticarLivro frame = new ViewAvaliarECriticarLivro(null);
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
	public ViewAvaliarECriticarLivro(String titulo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setTitle("BookSky - Vers\u00E3o 2.0   -  Avaliar e Criticar o Livro");
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Biblioteca - Software 2.0/Imagens/Logo1.png"));//CAMINHO DO PROJETO
		setResizable(false);
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JFrame window = this;
		contentPane.setLayout(null);
		
		JLabel LabelTituloLivro = new JLabel("");
		LabelTituloLivro.setFont(new Font("Rockwell", Font.BOLD, 20));
		LabelTituloLivro.setBounds(12, 13, 408, 43);
		LabelTituloLivro.setText(titulo);
		contentPane.add(LabelTituloLivro);
		
		JLabel LabelNota = new JLabel("Nota:");
		LabelNota.setFont(new Font("Rockwell", Font.PLAIN, 20));
		LabelNota.setBounds(12, 62, 56, 33);
		contentPane.add(LabelNota);
		
		textNota = new JTextField();
		textNota.setBounds(65, 64, 97, 33);
		contentPane.add(textNota);
		textNota.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 131, 408, 109);
		contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 133, 408, 107);
		//scrollPane.setViewportView(textArea);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Cr\u00EDtica:");
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblNewLabel_1.setBounds(12, 104, 207, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					
						ControllerPerfilUsuario.avaliarECriticarLivro(window, titulo, textNota.getText(), textArea.getText());
						dispose();

					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CampoInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnContinuar.setFont(new Font("Rockwell", Font.PLAIN, 25));
		btnContinuar.setBounds(214, 68, 206, 50);
		contentPane.add(btnContinuar);
	}
}
