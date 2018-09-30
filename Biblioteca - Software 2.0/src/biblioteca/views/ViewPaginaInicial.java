package biblioteca.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import biblioteca.controllers.cadastros.ControllerPerfilLivro;
import biblioteca.controllers.cadastros.ControllerPerfilUsuario;
import biblioteca.servicos.ServicoAuxiliar;
import biblioteca.servicos.basicas.Aluno;
import biblioteca.servicos.basicas.Livro;
import biblioteca.servicos.basicas.Log;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;


public class ViewPaginaInicial extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPaginaInicial frame = new ViewPaginaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ViewPaginaInicial(Object[] lista) {
		setForeground(new Color(0, 255, 255));
		setBackground(new Color(25, 25, 112));
		setTitle("BookSky - Vers\u00E3o 2.0 Página Inicial");
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Biblioteca - Software 2.0/Imagens/Logo1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 789);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JFrame window = this;
		ControllerPerfilLivro l = new ControllerPerfilLivro();
				
		Layout.view(contentPane,this);
		
		Livro[] livro = new Livro[8];
		for(int y = 0;y < 8;y++)
		{
			livro[y] = (Livro)lista[y];
		}
		Aluno[] aluno = new Aluno[4];
		for(int y = 0; y < 4;y++)
		{
			aluno[y] = (Aluno)lista[y+8];
		}
		
		
		//INÍCIO LIVROS RECOMENDADOS
		JLabel TextLivRec = new JLabel("Livros Recomendados");
		TextLivRec.setForeground(new Color(0, 0, 0));
		TextLivRec.setFont(new Font("Rockwell", Font.BOLD, 27));
		TextLivRec.setBounds(34, 88, 305, 27);
		contentPane.add(TextLivRec);
		
		JPanel PLivrosRecomendados = new JPanel();
		PLivrosRecomendados.setBackground(new Color(245, 245, 220));
		PLivrosRecomendados.setBounds(22, 117, 647, 304);
		PLivrosRecomendados.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		contentPane.add(PLivrosRecomendados);
		PLivrosRecomendados.setLayout(null);
		
		
		//INICIO DO PRIMEIRO LIVRO
		JLabel PainelSelecao1 = new JLabel("");
		PainelSelecao1.setBounds(12, 13, 623, 60);
		PLivrosRecomendados.add(PainelSelecao1);
		PainelSelecao1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				try {
					l.iniciarTelaPerfilLivro(livro[0].getIdLivro(), window);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		PainelSelecao1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		PainelSelecao1.setToolTipText(livro[0].getTitulo());
		
		JLabel PainelSelecao2 = new JLabel("");
		PainelSelecao2.setBounds(12, 85, 623, 60);
		PLivrosRecomendados.add(PainelSelecao2);
		PainelSelecao2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					l.iniciarTelaPerfilLivro(livro[1].getIdLivro(), window);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		PainelSelecao2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		PainelSelecao2.setToolTipText(livro[1].getTitulo());
		
		JLabel PainelSelecao3 = new JLabel("");
		PainelSelecao3.setBounds(12, 156, 623, 60);
		PLivrosRecomendados.add(PainelSelecao3);
		PainelSelecao3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					l.iniciarTelaPerfilLivro(livro[2].getIdLivro(), window);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		PainelSelecao3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		PainelSelecao3.setToolTipText(livro[2].getTitulo());
		
		JLabel PainelSelecao4 = new JLabel("");
		PainelSelecao4.setBounds(12, 229, 623, 60);
		PLivrosRecomendados.add(PainelSelecao4);
		PainelSelecao4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					l.iniciarTelaPerfilLivro(livro[3].getIdLivro(), window);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		PainelSelecao4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		PainelSelecao4.setToolTipText(livro[3].getTitulo());
		
		JTextArea TextosLivrosRecomendados = new JTextArea();
		TextosLivrosRecomendados.setBounds(257, 13, 378, 274);
		TextosLivrosRecomendados.setOpaque(false);
		PLivrosRecomendados.add(TextosLivrosRecomendados);
		TextosLivrosRecomendados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.out.println("Livros Recomendados - Livro 1");
			}
		});
		TextosLivrosRecomendados.setLineWrap(true);
		TextosLivrosRecomendados.setBackground(new Color(102, 153, 255));
		TextosLivrosRecomendados.setEditable(false);
		TextosLivrosRecomendados.setFont(new Font("Rockwell", Font.PLAIN, 20));
		TextosLivrosRecomendados.setText("|Ano:\t   G\u00EAnero:\r\n|Autor:\t\tNota:\r\n\r\n|Ano:\t   G\u00EAnero:\r\n|Autor:\t\tNota:\r\n\r\n|Ano:\t   G\u00EAnero:\r\n|Autor:\t\tNota:\r\n\r\n|Ano:\t   G\u00EAnero:\r\n|Autor:\t\tNota:");
		
		JPanel LabelLivro1 = new JPanel();
		LabelLivro1.setBackground(new Color(102, 153, 255));
		LabelLivro1.setBounds(12, 13, 623, 61);
		PLivrosRecomendados.add(LabelLivro1);
		LabelLivro1.setLayout(null);	
		
		//INICIO LIVROS RECOMENDADOS LIVRO 1
		JLabel Titulo1 = new JLabel("Livro1");
		Titulo1.setText(livro[0].getTitulo());
		Titulo1.setForeground(new Color(255, 255, 255));
		Titulo1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Titulo1.setBounds(12, 13, 234, 35);
		LabelLivro1.add(Titulo1);
		
		JLabel Ano1 = new JLabel("2345");
		Ano1.setText(String.valueOf(livro[0].getAno()));
		Ano1.setForeground(new Color(255, 255, 255));
		Ano1.setHorizontalAlignment(SwingConstants.CENTER);
		Ano1.setFont(new Font("Tahoma", Font.BOLD, 17));
		Ano1.setBounds(287, 4, 93, 21);
		LabelLivro1.add(Ano1);
		
		JLabel Autor1 = new JLabel("Daniel Barbosa");
		Autor1.setText(livro[0].getAutor());
		Autor1.setHorizontalAlignment(SwingConstants.CENTER);
		Autor1.setForeground(new Color(255, 255, 255));
		Autor1.setFont(new Font("Tahoma", Font.BOLD, 15));
		Autor1.setBounds(315, 30, 196, 21);
		LabelLivro1.add(Autor1);
		
		JLabel Genero1 = new JLabel("A\u00E7\u00E3o");
		Genero1.setText(livro[0].getGenero());
		Genero1.setHorizontalAlignment(SwingConstants.CENTER);
		Genero1.setForeground(new Color(255, 255, 255));
		Genero1.setFont(new Font("Tahoma", Font.BOLD, 17));
		Genero1.setBounds(481, 6, 130, 21);
		LabelLivro1.add(Genero1);
		
		JLabel Nota1 = new JLabel("4,8");
		Nota1.setText(String.valueOf(livro[0].getMediaAvaliacao()));
		Nota1.setHorizontalAlignment(SwingConstants.CENTER);
		Nota1.setForeground(new Color(255, 255, 255));
		Nota1.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nota1.setBounds(561, 30, 62, 17);
		LabelLivro1.add(Nota1);
		//FIM LIVROS RECOMENDADOS LIVRO 1
		
		
		JPanel LabelLivro2 = new JPanel();
		LabelLivro2.setBackground(new Color(51, 153, 255));
		LabelLivro2.setBounds(12, 84, 623, 61);
		PLivrosRecomendados.add(LabelLivro2);
		LabelLivro2.setLayout(null);
		
		JLabel Titulo2 = new JLabel("Livro1");
		Titulo2.setText(livro[1].getTitulo());
		Titulo2.setForeground(new Color(255, 255, 255));
		Titulo2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Titulo2.setBounds(12, 13, 230, 35);
		LabelLivro2.add(Titulo2);
		
		JLabel Ano2 = new JLabel("2345");
		Ano2.setHorizontalAlignment(SwingConstants.CENTER);
		Ano2.setText(String.valueOf(livro[1].getAno()));
		Ano2.setForeground(Color.WHITE);
		Ano2.setFont(new Font("Tahoma", Font.BOLD, 17));
		Ano2.setBounds(290, 6, 105, 21);
		LabelLivro2.add(Ano2);
		
		JLabel Autor2 = new JLabel("Daniel Barbosa");
		Autor2.setHorizontalAlignment(SwingConstants.CENTER);
		Autor2.setText(livro[1].getAutor());
		Autor2.setForeground(Color.WHITE);
		Autor2.setFont(new Font("Tahoma", Font.BOLD, 15));
		Autor2.setBounds(317, 30, 194, 21);
		LabelLivro2.add(Autor2);
		
		JLabel Genero2 = new JLabel("A\u00E7\u00E3o");
		Genero2.setText(livro[1].getGenero());
		Genero2.setHorizontalAlignment(SwingConstants.CENTER);
		Genero2.setForeground(Color.WHITE);
		Genero2.setFont(new Font("Tahoma", Font.BOLD, 17));
		Genero2.setBounds(481, 6, 130, 21);
		LabelLivro2.add(Genero2);
		
		JLabel Nota2 = new JLabel("4,8");
		Nota2.setText(String.valueOf(livro[1].getMediaAvaliacao()));
		Nota2.setHorizontalAlignment(SwingConstants.CENTER);
		Nota2.setForeground(Color.WHITE);
		Nota2.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nota2.setBounds(561, 30, 62, 17);
		LabelLivro2.add(Nota2);
		
		JPanel LabelLivro3 = new JPanel();
		LabelLivro3.setBackground(new Color(102, 153, 255));
		LabelLivro3.setBounds(12, 155, 623, 61);
		PLivrosRecomendados.add(LabelLivro3);
		LabelLivro3.setLayout(null);
		
		JLabel Titulo3 = new JLabel("Livro1");
		Titulo3.setText(livro[2].getTitulo());
		Titulo3.setForeground(new Color(255, 255, 255));
		Titulo3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Titulo3.setBounds(12, 13, 233, 35);
		LabelLivro3.add(Titulo3);
		
		JLabel Ano3 = new JLabel("2345");
		Ano3.setText(String.valueOf(livro[2].getAno()));
		Ano3.setHorizontalAlignment(SwingConstants.CENTER);
		Ano3.setForeground(Color.WHITE);
		Ano3.setFont(new Font("Tahoma", Font.BOLD, 17));
		Ano3.setBounds(290, 6, 105, 21);
		LabelLivro3.add(Ano3);
		
		JLabel Autor3 = new JLabel("Daniel Barbosa");
		Autor3.setText(livro[2].getAutor());
		Autor3.setHorizontalAlignment(SwingConstants.CENTER);
		Autor3.setForeground(Color.WHITE);
		Autor3.setFont(new Font("Tahoma", Font.BOLD, 15));
		Autor3.setBounds(317, 30, 194, 21);
		LabelLivro3.add(Autor3);
		
		JLabel Genero3 = new JLabel("A\u00E7\u00E3o");
		Genero3.setText(livro[2].getGenero());
		Genero3.setHorizontalAlignment(SwingConstants.CENTER);
		Genero3.setForeground(Color.WHITE);
		Genero3.setFont(new Font("Tahoma", Font.BOLD, 17));
		Genero3.setBounds(481, 6, 130, 21);
		LabelLivro3.add(Genero3);
			
		JLabel Nota3 = new JLabel("4,8");
		Nota3.setText(String.valueOf(livro[2].getMediaAvaliacao()));
		Nota3.setHorizontalAlignment(SwingConstants.CENTER);
		Nota3.setForeground(Color.WHITE);
		Nota3.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nota3.setBounds(561, 30, 62, 17);
		LabelLivro3.add(Nota3);
		
		JPanel LabelLivro4 = new JPanel();
		LabelLivro4.setBackground(new Color(51, 153, 255));
		LabelLivro4.setBounds(12, 229, 623, 61);
		PLivrosRecomendados.add(LabelLivro4);
		LabelLivro4.setLayout(null);
		
		JLabel Titulo4 = new JLabel("Livro1");
		Titulo4.setText(livro[3].getTitulo());
		Titulo4.setForeground(new Color(255, 255, 255));
		Titulo4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Titulo4.setBounds(12, 13, 231, 35);
		LabelLivro4.add(Titulo4);
		
		JLabel Ano4 = new JLabel("2345");
		Ano4.setText(String.valueOf(livro[3].getAno()));
		Ano4.setHorizontalAlignment(SwingConstants.CENTER);
		Ano4.setForeground(Color.WHITE);
		Ano4.setFont(new Font("Tahoma", Font.BOLD, 17));
		Ano4.setBounds(290, 6, 105, 21);
		LabelLivro4.add(Ano4);
		
		JLabel Autor4 = new JLabel("Daniel Barbosa");
		Autor4.setText(livro[3].getAutor());
		Autor4.setHorizontalAlignment(SwingConstants.CENTER);
		Autor4.setForeground(Color.WHITE);
		Autor4.setFont(new Font("Tahoma", Font.BOLD, 15));
		Autor4.setBounds(319, 30, 192, 21);
		LabelLivro4.add(Autor4);
		
		JLabel Genero4 = new JLabel("A\u00E7\u00E3o");
		Genero4.setText(livro[3].getGenero());
		Genero4.setHorizontalAlignment(SwingConstants.CENTER);
		Genero4.setForeground(Color.WHITE);
		Genero4.setFont(new Font("Tahoma", Font.BOLD, 17));
		Genero4.setBounds(481, 6, 130, 21);
		LabelLivro4.add(Genero4);
		
		JLabel Nota4 = new JLabel("4,8");
		Nota4.setText(String.valueOf(livro[3].getMediaAvaliacao()));
		Nota4.setHorizontalAlignment(SwingConstants.CENTER);
		Nota4.setForeground(Color.WHITE);
		Nota4.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nota4.setBounds(561, 30, 62, 17);
		LabelLivro4.add(Nota4);
		
		JLabel TextLivMRece = new JLabel("Livros Mais Recentes");
		TextLivMRece.setForeground(Color.BLACK);
		TextLivMRece.setFont(new Font("Rockwell", Font.BOLD, 27));
		TextLivMRece.setBounds(720, 88, 305, 27);
		contentPane.add(TextLivMRece);
		
		JPanel PLivrosRecentes = new JPanel();
		PLivrosRecentes.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		PLivrosRecentes.setBackground(new Color(245, 245, 220));
		PLivrosRecentes.setBounds(715, 117, 647, 304);
		contentPane.add(PLivrosRecentes);
		PLivrosRecentes.setLayout(null);
		
		JPanel LabelLivro5 = new JPanel();
		
		JLabel PainelSelecao5 = new JLabel("");
		PainelSelecao5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					l.iniciarTelaPerfilLivro(livro[4].getIdLivro(), window);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		PainelSelecao5.setBounds(12, 15, 623, 60);
		PainelSelecao5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		PainelSelecao5.setToolTipText(livro[4].getTitulo());
		PLivrosRecentes.add(PainelSelecao5);
		
		JLabel PainelSelecao6 = new JLabel("");
		PainelSelecao6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					l.iniciarTelaPerfilLivro(livro[5].getIdLivro(), window);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		PainelSelecao6.setBounds(12, 86, 623, 60);
		PainelSelecao6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		PainelSelecao6.setToolTipText(livro[5].getTitulo());
		PLivrosRecentes.add(PainelSelecao6);
		
		JLabel PainelSelecao7 = new JLabel("");
		PainelSelecao7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					l.iniciarTelaPerfilLivro(livro[6].getIdLivro(), window);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
			}
		});
		PainelSelecao7.setBounds(12, 155, 623, 60);
		PainelSelecao7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		PainelSelecao7.setToolTipText(livro[6].getTitulo());
		PLivrosRecentes.add(PainelSelecao7);
		
		JLabel PainelSelecao8 = new JLabel("");
		PainelSelecao8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					l.iniciarTelaPerfilLivro(livro[7].getIdLivro(), window);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		PainelSelecao8.setBounds(12, 229, 623, 60);
		PainelSelecao8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		PainelSelecao8.setToolTipText(livro[7].getTitulo());
		PLivrosRecentes.add(PainelSelecao8);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(257, 15, 378, 274);
		PLivrosRecentes.add(textArea);
		textArea.setText("|Ano:\t   G\u00EAnero:\r\n|Autor:\t\tNota:\r\n\r\n|Ano:\t   G\u00EAnero:\r\n|Autor:\t\tNota:\r\n\r\n|Ano:\t   G\u00EAnero:\r\n|Autor:\t\tNota:\r\n\r\n|Ano:\t   G\u00EAnero:\r\n|Autor:\t\tNota:");
		textArea.setOpaque(false);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Rockwell", Font.PLAIN, 20));
		textArea.setEditable(false);
		textArea.setBackground(new Color(102, 153, 255));
		LabelLivro5.setLayout(null);
		LabelLivro5.setBackground(new Color(102, 153, 255));
		LabelLivro5.setBounds(12, 13, 623, 61);
		PLivrosRecentes.add(LabelLivro5);
		
		JLabel Titulo5 = new JLabel("Livro1");
		Titulo5.setText(livro[4].getTitulo());
		Titulo5.setForeground(Color.WHITE);
		Titulo5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Titulo5.setBounds(12, 12, 234, 35);
		LabelLivro5.add(Titulo5);
		
		JLabel Ano5 = new JLabel("2345");
		Ano5.setText(String.valueOf(livro[4].getAno()));
		Ano5.setHorizontalAlignment(SwingConstants.CENTER);
		Ano5.setForeground(Color.WHITE);
		Ano5.setFont(new Font("Tahoma", Font.BOLD, 17));
		Ano5.setBounds(287, 5, 93, 21);
		LabelLivro5.add(Ano5);
		
		JLabel Autor5 = new JLabel("Daniel Barbosa");
		Autor5.setText(livro[3].getAutor());
		Autor5.setHorizontalAlignment(SwingConstants.CENTER);
		Autor5.setForeground(Color.WHITE);
		Autor5.setFont(new Font("Tahoma", Font.BOLD, 15));
		Autor5.setBounds(320, 29, 191, 21);
		LabelLivro5.add(Autor5);
		
		JLabel Genero5 = new JLabel("A\u00E7\u00E3o");
		Genero5.setText(livro[4].getGenero());
		Genero5.setHorizontalAlignment(SwingConstants.CENTER);
		Genero5.setForeground(Color.WHITE);
		Genero5.setFont(new Font("Tahoma", Font.BOLD, 17));
		Genero5.setBounds(481, 5, 130, 21);
		LabelLivro5.add(Genero5);
		
		JLabel Nota5 = new JLabel("4,8");
		Nota5.setText(String.valueOf(livro[4].getMediaAvaliacao()));
		Nota5.setHorizontalAlignment(SwingConstants.CENTER);
		Nota5.setForeground(Color.WHITE);
		Nota5.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nota5.setBounds(561, 29, 62, 17);
		LabelLivro5.add(Nota5);
		
		JPanel LabelLivro6 = new JPanel();
		LabelLivro6.setLayout(null);
		LabelLivro6.setBackground(SystemColor.textHighlight);
		LabelLivro6.setBounds(12, 84, 623, 61);
		PLivrosRecentes.add(LabelLivro6);
		
		JLabel Titulo6 = new JLabel("Livro1");
		Titulo6.setText(livro[5].getTitulo());
		Titulo6.setForeground(Color.WHITE);
		Titulo6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Titulo6.setBounds(12, 12, 234, 35);
		LabelLivro6.add(Titulo6);
		
		JLabel Ano6 = new JLabel("2345");
		Ano6.setText(String.valueOf(livro[5].getAno()));
		Ano6.setHorizontalAlignment(SwingConstants.CENTER);
		Ano6.setForeground(Color.WHITE);
		Ano6.setFont(new Font("Tahoma", Font.BOLD, 17));
		Ano6.setBounds(287, 5, 93, 21);
		LabelLivro6.add(Ano6);
		
		JLabel Autor6 = new JLabel("Daniel Barbosa");
		Autor6.setText(livro[5].getAutor());;
		Autor6.setHorizontalAlignment(SwingConstants.CENTER);
		Autor6.setForeground(Color.WHITE);
		Autor6.setFont(new Font("Tahoma", Font.BOLD, 15));
		Autor6.setBounds(318, 29, 193, 21);
		LabelLivro6.add(Autor6);
		
		JLabel Genero6 = new JLabel("A\u00E7\u00E3o");
		Genero6.setText(livro[5].getGenero());
		Genero6.setHorizontalAlignment(SwingConstants.CENTER);
		Genero6.setForeground(Color.WHITE);
		Genero6.setFont(new Font("Tahoma", Font.BOLD, 17));
		Genero6.setBounds(481, 5, 130, 21);
		LabelLivro6.add(Genero6);
		
		JLabel Nota6 = new JLabel("4,8");
		Nota6.setText(String.valueOf(livro[5].getMediaAvaliacao()));
		Nota6.setHorizontalAlignment(SwingConstants.CENTER);
		Nota6.setForeground(Color.WHITE);
		Nota6.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nota6.setBounds(561, 29, 62, 17);
		LabelLivro6.add(Nota6);
		
		JPanel LabelLivro7 = new JPanel();
		LabelLivro7.setLayout(null);
		LabelLivro7.setBackground(new Color(102, 153, 255));
		LabelLivro7.setBounds(12, 155, 623, 61);
		PLivrosRecentes.add(LabelLivro7);
		
		JLabel Titulo7 = new JLabel("Livro1");
		Titulo7.setText(livro[6].getTitulo());;
		Titulo7.setForeground(Color.WHITE);
		Titulo7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Titulo7.setBounds(12, 12, 234, 35);
		LabelLivro7.add(Titulo7);
		
		JLabel Ano7 = new JLabel("2345");
		Ano7.setText(String.valueOf(livro[6].getAno()));
		Ano7.setHorizontalAlignment(SwingConstants.CENTER);
		Ano7.setForeground(Color.WHITE);
		Ano7.setFont(new Font("Tahoma", Font.BOLD, 17));
		Ano7.setBounds(287, 5, 93, 21);
		LabelLivro7.add(Ano7);
		
		JLabel Autor7 = new JLabel("Daniel Barbosa");
		Autor7.setText(livro[6].getAutor());
		Autor7.setHorizontalAlignment(SwingConstants.CENTER);
		Autor7.setForeground(Color.WHITE);
		Autor7.setFont(new Font("Tahoma", Font.BOLD, 15));
		Autor7.setBounds(320, 29, 191, 21);
		LabelLivro7.add(Autor7);
		
		JLabel Genero7 = new JLabel("A\u00E7\u00E3o");
		Genero7.setText(livro[6].getGenero());;
		Genero7.setHorizontalAlignment(SwingConstants.CENTER);
		Genero7.setForeground(Color.WHITE);
		Genero7.setFont(new Font("Tahoma", Font.BOLD, 17));
		Genero7.setBounds(481, 5, 130, 21);
		LabelLivro7.add(Genero7);
		
		JLabel Nota7 = new JLabel("4,8");
		Nota7.setText(String.valueOf(livro[6].getMediaAvaliacao()));
		Nota7.setHorizontalAlignment(SwingConstants.CENTER);
		Nota7.setForeground(Color.WHITE);
		Nota7.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nota7.setBounds(561, 29, 62, 17);
		LabelLivro7.add(Nota7);
		
		JPanel LabelLivro8 = new JPanel();
		LabelLivro8.setLayout(null);
		LabelLivro8.setBackground(SystemColor.textHighlight);
		LabelLivro8.setBounds(12, 229, 623, 61);
		PLivrosRecentes.add(LabelLivro8);
		
		JLabel Titulo8 = new JLabel("Livro1");
		Titulo8.setText(livro[7].getTitulo());
		Titulo8.setForeground(Color.WHITE);
		Titulo8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Titulo8.setBounds(12, 12, 234, 35);
		LabelLivro8.add(Titulo8);
		
		JLabel Ano8 = new JLabel("2345");
		Ano6.setText(String.valueOf(livro[7].getAno()));
		Ano8.setHorizontalAlignment(SwingConstants.CENTER);
		Ano8.setForeground(Color.WHITE);
		Ano8.setFont(new Font("Tahoma", Font.BOLD, 17));
		Ano8.setBounds(287, 5, 93, 21);
		LabelLivro8.add(Ano8);
		
		JLabel Autor8 = new JLabel("Daniel Barbosa");
		Autor8.setText(livro[7].getAutor());
		Autor8.setHorizontalAlignment(SwingConstants.CENTER);
		Autor8.setForeground(Color.WHITE);
		Autor8.setFont(new Font("Tahoma", Font.BOLD, 15));
		Autor8.setBounds(316, 29, 195, 21);
		LabelLivro8.add(Autor8);
		
		JLabel Genero8 = new JLabel("A\u00E7\u00E3o");
		Genero8.setText(livro[7].getGenero());
		Genero8.setHorizontalAlignment(SwingConstants.CENTER);
		Genero8.setForeground(Color.WHITE);
		Genero8.setFont(new Font("Tahoma", Font.BOLD, 17));
		Genero8.setBounds(481, 5, 130, 21);
		LabelLivro8.add(Genero8);
		
		JLabel Nota8 = new JLabel("4,8");
		Nota8.setText(String.valueOf(livro[7].getMediaAvaliacao()));
		Nota8.setHorizontalAlignment(SwingConstants.CENTER);
		Nota8.setForeground(Color.WHITE);
		Nota8.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nota8.setBounds(561, 29, 62, 17);
		LabelLivro8.add(Nota8);
		
		JLabel TextMAt = new JLabel("Alunos Recentemente Adicionados");
		TextMAt.setForeground(Color.BLACK);
		TextMAt.setFont(new Font("Rockwell", Font.BOLD, 27));
		TextMAt.setBounds(22, 434, 469, 27);
		contentPane.add(TextMAt);
		
		if(Short.parseShort(System.getProperty("TipoPessoa")) < 2)
		{
			JLabel PainelSelecao9 = new JLabel("");
			PainelSelecao9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						ControllerPerfilUsuario.iniciaTelaPerfil(window,aluno[0].getIdPessoa(),2);
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("Usuários em Destaque - Aluno 1");
				}
			});
			PainelSelecao9.setCursor(new Cursor(Cursor.HAND_CURSOR));
			PainelSelecao9.setToolTipText(aluno[0].getNome());
			PainelSelecao9.setBounds(12, 461, 324, 134);
			contentPane.add(PainelSelecao9);
		}
		
		ServicoAuxiliar servA = new ServicoAuxiliar();
		JPanel PainelUsuario1 = new JPanel();
		PainelUsuario1.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		PainelUsuario1.setBackground(new Color(245, 245, 220));
		PainelUsuario1.setBounds(12, 461, 327, 134);
		contentPane.add(PainelUsuario1);
		PainelUsuario1.setLayout(null);
		
		JLabel ImagemUsuario1 = new JLabel("");
		if(aluno[0].getSex().equals("Feminino"))
		{
			ImagemUsuario1.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/IconUserMiniFem.png"));
		}
		else
		{
			ImagemUsuario1.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/IconUserMini.png"));
		}
		ImagemUsuario1.setBounds(3, 23, 100, 107);
		PainelUsuario1.add(ImagemUsuario1);
		
		JLabel NomeUsuario1 = new JLabel("Daniel Correia Barbosa");
		NomeUsuario1.setText(aluno[0].getNome());
		NomeUsuario1.setHorizontalAlignment(SwingConstants.CENTER);
		NomeUsuario1.setForeground(new Color(0, 0, 153));
		NomeUsuario1.setBackground(new Color(51, 153, 204));
		NomeUsuario1.setFont(new Font("Tahoma", Font.BOLD, 20));
		NomeUsuario1.setBounds(84, 13, 243, 27);
		PainelUsuario1.add(NomeUsuario1);
		
		JTextPane CursoUsuario1 = new JTextPane();
		CursoUsuario1.setForeground(new Color(0, 0, 153));
		CursoUsuario1.setEditable(false);
		CursoUsuario1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CursoUsuario1.setText("Engenharia da Computa\u00E7\u00E3o");
		CursoUsuario1.setText(aluno[0].getCurso());
		CursoUsuario1.setBounds(119, 42, 196, 56);
		CursoUsuario1.setOpaque(false);
		PainelUsuario1.add(CursoUsuario1);
		
		JLabel MatriculaUsuario1 = new JLabel("312312312312321");
		MatriculaUsuario1.setHorizontalAlignment(SwingConstants.CENTER);
		MatriculaUsuario1.setText(servA.formatarMatricula(aluno[0].getMatricula()));
		MatriculaUsuario1.setForeground(new Color(0, 0, 0));
		MatriculaUsuario1.setFont(new Font("Tahoma", Font.BOLD, 15));
		MatriculaUsuario1.setBounds(111, 105, 169, 25);
		PainelUsuario1.add(MatriculaUsuario1);
		
		if(Short.parseShort(System.getProperty("TipoPessoa")) < 2)
		{
			JLabel PainelSelecao10 = new JLabel("");
			PainelSelecao10.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						ControllerPerfilUsuario.iniciaTelaPerfil(window,aluno[1].getIdPessoa(),2);
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			PainelSelecao10.setBounds(15, 608, 324, 134);
			PainelSelecao10.setCursor(new Cursor(Cursor.HAND_CURSOR));
			PainelSelecao10.setToolTipText(aluno[1].getNome());
			contentPane.add(PainelSelecao10);
		}
		
		JPanel PainelUsuario2 = new JPanel();
		PainelUsuario2.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		PainelUsuario2.setBackground(new Color(245, 245, 220));
		PainelUsuario2.setBounds(12, 608, 327, 134);
		contentPane.add(PainelUsuario2);
		PainelUsuario2.setLayout(null);
		
		JLabel ImagemUsuario2 = new JLabel("");
		if(aluno[1].getSex().equals("Feminino"))
		{
			ImagemUsuario2.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/IconUserMiniFem.png"));
		}
		else
		{
			ImagemUsuario2.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/IconUserMini.png"));
		}
		ImagemUsuario2.setBounds(0, 23, 100, 107);
		PainelUsuario2.add(ImagemUsuario2);
		
		JLabel NomeUsuario2 = new JLabel("Daniel Correia Barbosa");
		NomeUsuario2.setText(aluno[1].getNome());
		NomeUsuario2.setHorizontalAlignment(SwingConstants.CENTER);
		NomeUsuario2.setForeground(new Color(0, 0, 153));
		NomeUsuario2.setFont(new Font("Tahoma", Font.BOLD, 20));
		NomeUsuario2.setBackground(new Color(51, 153, 204));
		NomeUsuario2.setBounds(81, 13, 243, 27);
		PainelUsuario2.add(NomeUsuario2);
		
		JTextPane CursoUsuario2 = new JTextPane();
		CursoUsuario2.setText("Engenharia da Computa\u00E7\u00E3o");
		CursoUsuario2.setText(aluno[1].getCurso());
		CursoUsuario2.setOpaque(false);
		CursoUsuario2.setForeground(new Color(0, 0, 153));
		CursoUsuario2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CursoUsuario2.setEditable(false);
		CursoUsuario2.setBounds(116, 42, 196, 56);
		PainelUsuario2.add(CursoUsuario2);
		
		JLabel MatriculaUsuario2 = new JLabel("312312312312321");
		MatriculaUsuario2.setHorizontalAlignment(SwingConstants.CENTER);
		MatriculaUsuario2.setText(servA.formatarMatricula(aluno[1].getMatricula()));
		MatriculaUsuario2.setForeground(Color.BLACK);
		MatriculaUsuario2.setFont(new Font("Tahoma", Font.BOLD, 15));
		MatriculaUsuario2.setBounds(108, 105, 169, 25);
		PainelUsuario2.add(MatriculaUsuario2);
		
		if(Short.parseShort(System.getProperty("TipoPessoa")) < 2)
		{
			JLabel PainelSelecao11 = new JLabel("");
			PainelSelecao11.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						ControllerPerfilUsuario.iniciaTelaPerfil(window,aluno[2].getIdPessoa(),2);
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			PainelSelecao11.setBounds(350, 461, 324, 134);
			PainelSelecao11.setCursor(new Cursor(Cursor.HAND_CURSOR));
			PainelSelecao11.setToolTipText(aluno[2].getNome());
			contentPane.add(PainelSelecao11);
		}
		
		JPanel PainelUsuario3 = new JPanel();
		PainelUsuario3.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		PainelUsuario3.setBackground(new Color(245, 245, 220));
		PainelUsuario3.setBounds(350, 461, 327, 134);
		contentPane.add(PainelUsuario3);
		PainelUsuario3.setLayout(null);
		
		JLabel ImagemUsuario3 = new JLabel("");
		if(aluno[2].getSex().equals("Feminino"))
		{
			ImagemUsuario3.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/IconUserMiniFem.png"));
		}
		else
		{
			ImagemUsuario3.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/IconUserMini.png"));
		}
		ImagemUsuario3.setBounds(0, 23, 100, 107);
		PainelUsuario3.add(ImagemUsuario3);
		
		JLabel NomeUsuario3 = new JLabel("Daniel Correia Barbosa");
		NomeUsuario3.setText(aluno[2].getNome());
		NomeUsuario3.setHorizontalAlignment(SwingConstants.CENTER);
		NomeUsuario3.setForeground(new Color(0, 0, 153));
		NomeUsuario3.setFont(new Font("Tahoma", Font.BOLD, 20));
		NomeUsuario3.setBackground(new Color(51, 153, 204));
		NomeUsuario3.setBounds(81, 13, 243, 27);
		PainelUsuario3.add(NomeUsuario3);
		
		JTextPane CursoUsuario3 = new JTextPane();
		CursoUsuario3.setText("Engenharia da Computa\u00E7\u00E3o");
		CursoUsuario3.setText(aluno[2].getCurso());
		CursoUsuario3.setOpaque(false);
		CursoUsuario3.setForeground(new Color(0, 0, 153));
		CursoUsuario3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CursoUsuario3.setEditable(false);
		CursoUsuario3.setBounds(116, 42, 196, 56);
		PainelUsuario3.add(CursoUsuario3);
		
		JLabel MatriculaUsuario3 = new JLabel("312312312312321");
		MatriculaUsuario3.setHorizontalAlignment(SwingConstants.CENTER);
		MatriculaUsuario3.setText(servA.formatarMatricula(aluno[2].getMatricula()));
		MatriculaUsuario3.setForeground(Color.BLACK);
		MatriculaUsuario3.setFont(new Font("Tahoma", Font.BOLD, 15));
		MatriculaUsuario3.setBounds(108, 105, 169, 25);
		PainelUsuario3.add(MatriculaUsuario3);
		
		if(Short.parseShort(System.getProperty("TipoPessoa")) < 2)
		{
			JLabel PainelSelecao12 = new JLabel("");
			PainelSelecao12.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						ControllerPerfilUsuario.iniciaTelaPerfil(window,aluno[3].getIdPessoa(),2);
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			PainelSelecao12.setBounds(351, 608, 324, 134);
			PainelSelecao12.setCursor(new Cursor(Cursor.HAND_CURSOR));
			PainelSelecao12.setToolTipText(aluno[3].getNome());
			contentPane.add(PainelSelecao12);
		}
		
		JPanel PainelUsuario4 = new JPanel();
		PainelUsuario4.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		PainelUsuario4.setBackground(new Color(245, 245, 220));
		PainelUsuario4.setBounds(351, 608, 327, 134);
		contentPane.add(PainelUsuario4);
		PainelUsuario4.setLayout(null);
		
		JLabel ImaegmUsuario4 = new JLabel("");
		if(aluno[3].getSex().equals("Feminino"))
		{
			ImaegmUsuario4.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/IconUserMiniFem.png"));
		}
		else
		{
			ImaegmUsuario4.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/IconUserMini.png"));
		}
		ImaegmUsuario4.setBounds(0, 23, 100, 107);
		PainelUsuario4.add(ImaegmUsuario4);
		
		JLabel NomeUsuario4 = new JLabel("Daniel Correia Barbosa");
		NomeUsuario4.setText(aluno[3].getNome());
		NomeUsuario4.setHorizontalAlignment(SwingConstants.CENTER);
		NomeUsuario4.setForeground(new Color(0, 0, 153));
		NomeUsuario4.setFont(new Font("Tahoma", Font.BOLD, 20));
		NomeUsuario4.setBackground(new Color(51, 153, 204));
		NomeUsuario4.setBounds(81, 13, 243, 27);
		PainelUsuario4.add(NomeUsuario4);
		
		JTextPane CursoUsuario4 = new JTextPane();
		CursoUsuario4.setText("Engenharia da Computa\u00E7\u00E3o");
		CursoUsuario4.setText(aluno[3].getCurso());
		CursoUsuario4.setOpaque(false);
		CursoUsuario4.setForeground(new Color(0, 0, 153));
		CursoUsuario4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CursoUsuario4.setEditable(false);
		CursoUsuario4.setBounds(116, 42, 196, 56);
		PainelUsuario4.add(CursoUsuario4);
		
		JLabel MatriculaUsuario4 = new JLabel("312312312312321");
		MatriculaUsuario4.setHorizontalAlignment(SwingConstants.CENTER);
		MatriculaUsuario4.setText(servA.formatarMatricula(aluno[3].getMatricula()));
		MatriculaUsuario4.setForeground(Color.BLACK);
		MatriculaUsuario4.setFont(new Font("Tahoma", Font.BOLD, 15));
		MatriculaUsuario4.setBounds(108, 105, 169, 25);
		PainelUsuario4.add(MatriculaUsuario4);
		
		JLabel TextUlLogs = new JLabel("\u00DAltimos Logs do Usu\u00E1rio");
		TextUlLogs.setForeground(Color.BLACK);
		TextUlLogs.setFont(new Font("Rockwell", Font.BOLD, 27));
		TextUlLogs.setBounds(704, 434, 335, 27);
		contentPane.add(TextUlLogs);
		
		
		JPanel PainelLog1 = new JPanel();
		PainelLog1.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		PainelLog1.setBackground(new Color(245, 245, 220));
		PainelLog1.setBounds(689, 461, 673, 78);
		contentPane.add(PainelLog1);
		PainelLog1.setLayout(null);
		
		
		JTextPane Log1 = new JTextPane();	
		Log1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Log1.setEditable(false);
		Log1.setBounds(12, 13, 649, 52);
		Log1.setOpaque(false);
		PainelLog1.add(Log1);
		
		JPanel PainelLogs2 = new JPanel();
		PainelLogs2.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		PainelLogs2.setBackground(new Color(245, 245, 220));
		PainelLogs2.setBounds(689, 562, 673, 78);
		contentPane.add(PainelLogs2);
		PainelLogs2.setLayout(null);
		
		
		JTextPane Log2 = new JTextPane();	
		Log2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Log2.setEditable(false);
		Log2.setBounds(12, 13, 649, 52);
		Log2.setOpaque(false);
		PainelLogs2.add(Log2);	
		JPanel PainelLogs3 = new JPanel();
		PainelLogs3.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		PainelLogs3.setBackground(new Color(245, 245, 220));
		PainelLogs3.setBounds(689, 664, 673, 78);
		contentPane.add(PainelLogs3);
		PainelLogs3.setLayout(null);
		
		
		JTextPane Log3 = new JTextPane();	
		Log3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Log3.setEditable(false);
		Log3.setBounds(12, 13, 649, 52);
		Log3.setOpaque(false);
		PainelLogs3.add(Log3);
		
		
		if(lista[12] != null)
		{
			Log log1 =  (Log)lista[12];	
			Log1.setText(log1.getMensagem() + " Em: " + String.valueOf(log1.getHoraData()));
					
		}
		if(lista[13] != null)
		{
			Log log2 =  (Log)lista[13];
			Log2.setText(log2.getMensagem() + " Em: " + String.valueOf(log2.getHoraData()));
		}
		if(lista[14] != null)
		{
			Log log3 =  (Log)lista[14];
			Log3.setText(log3.getMensagem() + " Em: " + String.valueOf(log3.getHoraData()));
		}
	}
}
