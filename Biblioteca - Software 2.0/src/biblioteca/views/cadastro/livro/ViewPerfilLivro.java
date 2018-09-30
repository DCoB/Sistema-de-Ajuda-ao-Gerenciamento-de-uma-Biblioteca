package biblioteca.views.cadastro.livro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteca.controllers.cadastros.ControllerPerfilLivro;
import biblioteca.servicos.basicas.Livro;
import biblioteca.views.Layout;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPerfilLivro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.setProperty("IdPessoa", String.valueOf(0));//ESSA LINHA É NECESSÁRIA PARA SETAR O ID "0" COMO O PADRÃO
		System.setProperty("LogTemporario", String.valueOf(0));//ESSA LINHA É NECESSÁRIA PARA SETAR O LOG TEMPORARIO "0" COMO O PADRÃO
		System.setProperty("TipoPessoa", String.valueOf(0)); 
			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPerfilLivro frame = new ViewPerfilLivro(null,null);
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
	public ViewPerfilLivro(Livro livro,String criticas) {
		setTitle("BookSky - Vers\u00E3o 2.0 Perfil de Livro");
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Biblioteca - Software 2.0/Imagens/Logo1.png"));//CAMINHO DO PROJETO
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1367, 775);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//JFrame window = this;
		
		Layout.view(contentPane,this);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 153, 204), 3));
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(44, 138, 1274, 589);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(12, 13, 126, 61);
		lblTtulo.setFont(new Font("Rockwell", Font.PLAIN, 35));
		panel.add(lblTtulo);
		
		JLabel textTitulo = new JLabel("AQUI \u00C9 PARA SER O T\u00CDTULO DO LIVRO E SOMENTE ELE");
		textTitulo.setBounds(121, 17, 580, 61);
		textTitulo.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		textTitulo.setText(livro.getTitulo());
		textTitulo.setToolTipText(livro.getTitulo());
		panel.add(textTitulo);
		
		JLabel lblSinopse = new JLabel("Sinopse:");
		lblSinopse.setBounds(264, 246, 123, 35);
		lblSinopse.setFont(new Font("Rockwell", Font.PLAIN, 30));
		panel.add(lblSinopse);
			
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(37, 76, 77, 44);
		lblAutor.setFont(new Font("Rockwell", Font.PLAIN, 25));
		panel.add(lblAutor);
		
		JLabel textAutor = new JLabel("AQUI \u00C9 PARA SER O(S) AUTORES DO LIVRO");
		textAutor.setBounds(115, 78, 418, 44);
		textAutor.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 22));
		textAutor.setText(livro.getAutor());
		panel.add(textAutor);
		
		JLabel lblGenero = new JLabel("G\u00EAnero:");
		lblGenero.setBounds(37, 135, 101, 44);
		lblGenero.setFont(new Font("Rockwell", Font.PLAIN, 25));
		panel.add(lblGenero);
		
		JLabel textGenero = new JLabel("AQUI \u00C9 PARA SER O G\u00CANERO");
		textGenero.setBounds(135, 135, 283, 44);
		textGenero.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 22));
		textGenero.setText(livro.getGenero());
		panel.add(textGenero);
		
		if(Short.parseShort(System.getProperty("TipoPessoa")) < 2 && livro.isDisponivel() == true)
		{
			JButton btnLocarLivro = new JButton("Locar Livro");
			btnLocarLivro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ControllerPerfilLivro c = new ControllerPerfilLivro();
					c.chamarViewAlugarLivro(livro.getTitulo());
				}
			});
			btnLocarLivro.setBounds(1121, 8, 148, 39);
			panel.add(btnLocarLivro);
		}
		
		JLabel txtDisponivel = new JLabel("Dispon\u00EDvel");
		txtDisponivel.setBounds(887, 4, 222, 43);
		txtDisponivel.setHorizontalAlignment(SwingConstants.CENTER);
		txtDisponivel.setForeground(new Color(0, 102, 0));
		txtDisponivel.setFont(new Font("Rockwell", Font.PLAIN, 35));
		
		if(livro.isDisponivel() == false)
		{
			int x = livro.getDiasRestantes();
			
			txtDisponivel.setBounds(1040, 13, 222, 43);
			txtDisponivel.setForeground(Color.RED);
			txtDisponivel.setText("Indisponível");
					
			JLabel lblDiasRestantes = new JLabel("Dias Restantes:");
			lblDiasRestantes.setFont(new Font("Rockwell", Font.BOLD, 20));
			lblDiasRestantes.setBounds(837, 17, 160, 28);
			panel.add(lblDiasRestantes);
			
			JLabel textDiasRestantes = new JLabel("123");
			textDiasRestantes.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textDiasRestantes.setHorizontalAlignment(SwingConstants.CENTER);
			textDiasRestantes.setBounds(988, 18, 53, 28);			
			if (x > 5)
			{
				textDiasRestantes.setForeground(Color.WHITE);
			}
			else if (x > 0)
			{
				textDiasRestantes.setForeground(Color.BLUE);
			}
			else if (x < 0)
			{
				textDiasRestantes.setForeground(Color.RED);
			}
			textDiasRestantes.setText(Integer.toString(x));
			
			panel.add(textDiasRestantes);
		}
		panel.add(txtDisponivel);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(37, 192, 58, 44);
		lblAno.setFont(new Font("Rockwell", Font.PLAIN, 25));
		panel.add(lblAno);
		
		JLabel textAno = new JLabel("ANO");
		textAno.setBounds(97, 204, 77, 24);
		textAno.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 25));
		textAno.setText(Integer.toString(livro.getAno()));
		panel.add(textAno);
			
		JLabel lblMdiaDeAvaliao = new JLabel("M\u00E9dia de Avalia\u00E7\u00E3o:");
		lblMdiaDeAvaliao.setBounds(777, 152, 337, 61);
		lblMdiaDeAvaliao.setFont(new Font("Rockwell", Font.PLAIN, 35));
		panel.add(lblMdiaDeAvaliao);
		
		JLabel textMediaAvaliacao = new JLabel("4.5 *");
		textMediaAvaliacao.setBounds(1126, 166, 101, 39);
		textMediaAvaliacao.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 25));
		textMediaAvaliacao.setText(Double.toString(livro.getMediaAvaliacao()));
		panel.add(textMediaAvaliacao);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(706, 330, 545, 246);
		scrollPane.setOpaque(false);
		panel.add(scrollPane);
		
		JLabel lblCriticas = new JLabel("Cr\u00EDticas:");
		lblCriticas.setBounds(693, 293, 123, 39);
		lblCriticas.setFont(new Font("Rockwell", Font.PLAIN, 30));
		panel.add(lblCriticas);
		
		JTextArea textAreaCriticas = new JTextArea();
		textAreaCriticas.setEditable(false);
		textAreaCriticas.setFont(new Font("Calibri", Font.BOLD, 22));
		textAreaCriticas.setText(criticas);
		textAreaCriticas.setLineWrap(true);
		scrollPane.setViewportView(textAreaCriticas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 289, 600, 287);
		scrollPane_1.setOpaque(false);
		panel.add(scrollPane_1);
		
		JTextArea textSinopse = new JTextArea();
		scrollPane_1.setViewportView(textSinopse);
		textSinopse.setText(livro.getSinopse());
		textSinopse.setWrapStyleWord(true);
		textSinopse.setLineWrap(true);
		textSinopse.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textSinopse.setEditable(false);
		scrollPane_1.setViewportView(textSinopse);
			
		JLabel lblPerfildoLivro = new JLabel("Perfil do Livro");
		lblPerfildoLivro.setFont(new Font("Rockwell", Font.BOLD, 40));
		lblPerfildoLivro.setBounds(44, 92, 297, 49);
		contentPane.add(lblPerfildoLivro);
		
		
		
	}
}
