package biblioteca.views.cadastro.livro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import biblioteca.controllers.cadastros.ControllerCadastroLivro;
import biblioteca.controllers.cadastros.ControllerListaLivros;
import biblioteca.dados.TableLivros;
import biblioteca.exceptions.ErroOperacaoException;
import biblioteca.views.Layout;

public class ViewListaLivros extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable TabelaLivros;
	private JTextField txtBuscar;
	private boolean alfa = false;
	private boolean cresc = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewListaLivros frame = new ViewListaLivros(null);
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
	public ViewListaLivros(ControllerListaLivros tableModel) {
		setTitle("BookSky - Vers\u00E3o 2.0 Lista de Livros");
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Biblioteca - Software 2.0/Imagens/Logo1.png"));//CAMINHO DO PROJETO
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1367, 775);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JFrame window = this;;
		JScrollPane scrollPane = new JScrollPane();
		
		
		ControllerListaLivros l = new ControllerListaLivros();
		try {
			l.atualizarListaLivros();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Layout.view(contentPane,this);
		contentPane.setLayout(null);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBuscar.setText("Pesquisar por T\u00EDtulo");
		txtBuscar.setBounds(851, 90, 304, 32);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Lista de Livros");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 30));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(64, 83, 224, 46);
		contentPane.add(lblNewLabel);
		
		JButton ButtonBuscar = new JButton("Buscar");
		ButtonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				try {
					TabelaLivros.setModel(l.buscarTitulo(txtBuscar.getText()));
					TabelaLivros.revalidate();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ButtonBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					TabelaLivros.setModel(l.buscarTitulo(txtBuscar.getText()));
					TabelaLivros.revalidate();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ButtonBuscar.setBounds(1174, 83, 118, 40);
		contentPane.add(ButtonBuscar);
		getRootPane().setDefaultButton(ButtonBuscar);

		if(Short.parseShort(System.getProperty("TipoPessoa")) < 2)
		{
			JButton btnExcluirLivro = new JButton("Excluir Livro");
			btnExcluirLivro.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(TabelaLivros.getSelectedRow() != -1)
						{
						try {
							TabelaLivros.setModel(l.deletarLivro(TabelaLivros.getSelectedRow(), window));
							TabelaLivros.revalidate();
						} catch (IOException e) {
						// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			btnExcluirLivro.setBounds(718, 91, 102, 32);
			contentPane.add(btnExcluirLivro);
		}
		
		if(Short.parseShort(System.getProperty("TipoPessoa")) < 2)
		{
			JButton btnEditarLivro = new JButton("Editar Livro");
			btnEditarLivro.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(TabelaLivros.getSelectedRow() != -1)
					{
						try {
							l.chamarTelaEditarLivro(TabelaLivros.getSelectedRow());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ErroOperacaoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			btnEditarLivro.setBounds(604, 91, 102, 32);
			contentPane.add(btnEditarLivro);
		}
		
		TabelaLivros = new JTable();
		TabelaLivros.setShowHorizontalLines(false);
		TabelaLivros.setShowVerticalLines(false);
		TabelaLivros.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TabelaLivros.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		TabelaLivros.setBounds(191, 146, 952, 538);
		TabelaLivros.setModel(tableModel);
		
		contentPane.add(TabelaLivros);
		
		
		scrollPane.setBounds(191, 136, 952, 548);
		scrollPane.setViewportView(TabelaLivros);
		contentPane.add(scrollPane);
		
		if(Short.parseShort(System.getProperty("TipoPessoa")) < 2)
		{
			JButton btnAdicionarLivro = new JButton("Adicionar Livro");
			btnAdicionarLivro.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ControllerCadastroLivro.iniciaTelaCadastroLivro();
				}
			});
			btnAdicionarLivro.setBounds(300, 91, 128, 32);
			contentPane.add(btnAdicionarLivro);
		}
			
		JButton btnPerfildoLivro = new JButton("Perfil do Livro");
		btnPerfildoLivro.setBounds(51, 136, 128, 32);
		btnPerfildoLivro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try {
					l.chamarTelaPefilLivro(TabelaLivros.getSelectedRow(), window);				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnPerfildoLivro);

		
		TableLivros t = new TableLivros();
		TabelaLivros.setDefaultRenderer(Object.class, t);
		
		JTableHeader titulo = TabelaLivros.getTableHeader();
		titulo.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				TableColumnModel colModel = TabelaLivros.getColumnModel();
				int vColIndex = colModel.getColumnIndexAtX(e.getX());
				if (vColIndex != -1) {
                    
					if(vColIndex == 1)
					{
						try {
							TabelaLivros.setModel(l.listaOraganizadaAlfa(alfa));
							TabelaLivros.revalidate();
						
							if(alfa == true)
							{
								TabelaLivros.getColumnModel().getColumn(1).setHeaderValue("Título -");
								alfa = false;
							}
							else if (alfa == false)
							{
								TabelaLivros.getColumnModel().getColumn(1).setHeaderValue("Título ^");
								alfa = true;
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(vColIndex == 5)
					{
						try {
							TabelaLivros.setModel(l.listaOrganizaNota(cresc));
							TabelaLivros.revalidate();
						
							if(cresc == true)
							{
								TabelaLivros.getColumnModel().getColumn(5).setHeaderValue("Nota -");
								cresc = false;
							}
							else if (alfa == false)
							{
								TabelaLivros.getColumnModel().getColumn(5).setHeaderValue("Nota ^");
								cresc = true;
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
                }
								
			}
		});
		
	}
}
