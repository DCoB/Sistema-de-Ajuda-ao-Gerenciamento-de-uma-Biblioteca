package biblioteca.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import biblioteca.controllers.*;
import biblioteca.controllers.cadastros.*;


/**
 * Método que Faz a Construção do Menu que é Padrão para Todas as Telas
 * @version 2.0
 */
public class Layout {
		
	//ControllerGeral Cg = new ControllerGeral();
	
	/**
	 * Método que Mostra o Menu em uma Tela
	 * @param contentPane = Painel que o Menu Será Printado
	 */
	public static void view(JPanel contentPane,JFrame window)
	{
			
		//VIEW LAYOUT
		JPanel PaLayout = new JPanel();
		PaLayout.setBackground(new Color(51, 204, 255));
		PaLayout.setBounds(108, 17, 1242, 49);
		PaLayout.setBorder(new LineBorder(null, 2, true));
		contentPane.add(PaLayout);
		PaLayout.setLayout(null);
		
		JButton BtHome = new JButton("Home");
		BtHome.setForeground(Color.BLACK);
		BtHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {//PASSAR O MOUSE EM CIMA D BOTÃO
				BtHome.setFont(new Font("Rockwell", Font.ITALIC, 28));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				BtHome.setFont(new Font("Rockwell", Font.BOLD, 25));
			}
		});
		BtHome.setFont(new Font("Rockwell", Font.BOLD, 25));
		BtHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ControllerGeral.pageInicial(window,Long.parseLong(System.getProperty("IdPessoa")),Short.parseShort(System.getProperty("TipoPessoa")));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		BtHome.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/IconMenuHome.png"));
		BtHome.setContentAreaFilled(false);
		BtHome.setFocusPainted(false);
		BtHome.setBorderPainted(false);
		BtHome.setBounds(-14, 4, 150, 42);
		BtHome.setToolTipText("Voltar Para a Página Inicial");
		PaLayout.add(BtHome);
		
		
				
		JButton BtUser = new JButton("Perfil");
		BtUser.setBounds(109, 4, 150, 42);
		PaLayout.add(BtUser);
		BtUser.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//CHAMA A VIEW PRINCIPAL DE ALUNO, FUNCIONÁRIO OU GERENTE DE ACORDO COM O TIPO DE PESSOA LOGADA
			try {
				ControllerPerfilUsuario.iniciaTelaPerfil(window,Short.parseShort(System.getProperty("IdPessoa")),
						Short.parseShort(System.getProperty("TipoPessoa")));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

				}
		});
		BtUser.setForeground(Color.BLACK);
		BtUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {//PASSAR O MOUSE EM CIMA D BOTÃO
			BtUser.setFont(new Font("Rockwell", Font.ITALIC, 28));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				BtUser.setFont(new Font("Rockwell", Font.BOLD, 25));
			}
		});
		BtUser.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/IconMenuPerfil.png"));
		BtUser.setFont(new Font("Rockwell", Font.BOLD, 25));
		BtUser.setContentAreaFilled(false);
		BtUser.setBorderPainted(false);
		BtUser.setToolTipText("Perfil do Usuário");
		
		JButton BtListaLivros = new JButton("Livros");
		BtListaLivros.setBounds(245, 4, 150, 42);
		PaLayout.add(BtListaLivros);
		BtListaLivros.setForeground(Color.BLACK);
		BtListaLivros.addMouseListener(new MouseAdapter() {		
			@Override
			public void mouseEntered(MouseEvent e) {//PASSAR O MOUSE EM CIMA D BOTÃO
				BtListaLivros.setFont(new Font("Rockwell", Font.ITALIC, 28));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				BtListaLivros.setFont(new Font("Rockwell", Font.BOLD, 25));
			}
		});
			BtListaLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerListaLivros c = new ControllerListaLivros();
				try {
					c.listaLivro(window);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//CHAMAR A VIEW DA LISTA DE LIVROS
			}
		});
		BtListaLivros.setFont(new Font("Rockwell", Font.BOLD, 25));
		BtListaLivros.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/IconMenuBooks.png"));
		BtListaLivros.setContentAreaFilled(false);
		BtListaLivros.setFocusPainted(false);
		BtListaLivros.setBorderPainted(false);
		BtListaLivros.setToolTipText("Lista de Livros Cadastrados");
		
		if(Short.parseShort(System.getProperty("TipoPessoa")) < 2)
		{
			JButton BtListaPessoa = new JButton("Pessoas");
			BtListaPessoa.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/IconMenuUsers.png"));
			BtListaPessoa.setForeground(Color.BLACK);
			BtListaPessoa.setContentAreaFilled(false);
			BtListaPessoa.setFocusPainted(false);
			BtListaPessoa.setBorderPainted(false);
			BtListaPessoa.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					BtListaPessoa.setFont(new Font("Rockwell", Font.ITALIC, 28));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					BtListaPessoa.setFont(new Font("Rockwell", Font.BOLD, 25));
				}
			});
			BtListaPessoa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControllerListaAlunos a = new ControllerListaAlunos();
					try {
						a.listaAlunos(window);;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//CHAMAR A VIEW DA LISTA DE LIVROS
				}
			});
			BtListaPessoa.setFont(new Font("Rockwell", Font.BOLD, 25));
			BtListaPessoa.setBounds(370, 4, 187, 42);
			BtListaPessoa.setToolTipText("Lista de Pessoas Cadastradas");
			PaLayout.add(BtListaPessoa);
		}
		
		if(Short.parseShort(System.getProperty("TipoPessoa")) < 2)
		{
			JButton BtNovaPessoa = new JButton("Novo(a) Pessoa");
			BtNovaPessoa.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {//PASSAR O MOUSE EM CIMA D BOTÃO
					BtNovaPessoa.setFont(new Font("Tahoma", Font.ITALIC, 26));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					BtNovaPessoa.setFont(new Font("Tahoma", Font.BOLD, 22));
				}
			});
			BtNovaPessoa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ControllerCadastroUsuario.iniciaTelaCadastro();
				}
			});
		
			BtNovaPessoa.setFont(new Font("Tahoma", Font.BOLD, 22));
			BtNovaPessoa.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/IconMenuAddPessoa.png"));
			BtNovaPessoa.setForeground(Color.BLACK);
			BtNovaPessoa.setContentAreaFilled(false);
			BtNovaPessoa.setBorderPainted(false);
			BtNovaPessoa.setBounds(512, 4, 263, 42);
			BtNovaPessoa.setToolTipText("Adicionar uma Nova Pessoa no Banco");
			PaLayout.add(BtNovaPessoa);
		}
		
		if(Short.parseShort(System.getProperty("TipoPessoa")) < 2)
		{
			JButton BtLogs = new JButton("Logs");
			BtLogs.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					BtLogs.setFont(new Font("Rockwell", Font.ITALIC, 30));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					BtLogs.setFont(new Font("Rockwell", Font.BOLD, 25));
				}
			});
			
			BtLogs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						ControllerLogs.iniciaTelaLog(window);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			BtLogs.setFont(new Font("Rockwell", Font.BOLD, 25));
			BtLogs.setForeground(Color.BLACK);
			BtLogs.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/IconMenuLogs.png"));
			BtLogs.setBounds(739, 4, 141, 42);
			BtLogs.setContentAreaFilled(false);
			BtLogs.setBorderPainted(false);
			BtLogs.setToolTipText("Lista de Alterações Feitas no Aplicativo");
			PaLayout.add(BtLogs);
		}	
		
		
		JLabel Ola = new JLabel("");
		Ola.setHorizontalAlignment(SwingConstants.RIGHT);
		Ola.setFont(new Font("Rockwell", Font.PLAIN, 30));
		Ola.setBounds(770, 2, 320, 42);
		Ola.setText("Olá, " + System.getProperty("LoginPessoa"));
		PaLayout.add(Ola);	
		
		JButton BtLogout = new JButton("Logout");
		BtLogout.setForeground(Color.BLACK);
		BtLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {//PASSAR O MOUSE EM CIMA D BOTÃO
				BtLogout.setFont(new Font("Rockwell", Font.ITALIC, 29));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				BtLogout.setFont(new Font("Rockwell", Font.BOLD, 25));
			}
		});
		BtLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControllerGeral.Logout(window);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		BtLogout.setFont(new Font("Rockwell", Font.BOLD, 25));
		BtLogout.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/IconMenuLogout.png"));
		BtLogout.setContentAreaFilled(false);
		BtLogout.setBorderPainted(false);
		BtLogout.setBounds(1072, 4, 170, 42);
		BtLogout.setToolTipText("Deslogar da Conta Atual");
		
		PaLayout.add(BtLogout);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("../Biblioteca - Software 2.0/Imagens/LogoMin.png"));
		lblNewLabel.setBounds(5, -6, 105, 95);
		contentPane.add(lblNewLabel);
		
		//FIM DA VIEW LAYOUT

		
	}

}
