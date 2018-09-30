package biblioteca.views.cadastro.usuario;

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

import biblioteca.controllers.cadastros.ControllerListaAlunos;
import biblioteca.dados.TableAlunos;
import biblioteca.views.Layout;

public class ViewListaAlunos extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JTable TabelaAlunos;
	private JTextField txtBuscar;
	private boolean alfa = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewListaAlunos frame = new ViewListaAlunos(null);
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
	public ViewListaAlunos(ControllerListaAlunos tableModel) {
		setTitle("BookSky - Vers\u00E3o 2.0 Lista de Alunos");
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
		ControllerListaAlunos a = new ControllerListaAlunos();
		try {
			a.atualizarListaAlunos();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Layout.view(contentPane,this);
		contentPane.setLayout(null);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBuscar.setText("Pesquisar por Nome");
		txtBuscar.setBounds(851, 90, 304, 32);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Lista de Alunos");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 30));
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(64, 83, 240, 46);
		contentPane.add(lblNewLabel);
		
		JButton ButtonBuscar = new JButton("Buscar");
		ButtonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				try {
					TabelaAlunos.setModel(a.buscarNome(txtBuscar.getText()));
					TabelaAlunos.revalidate();
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
					TabelaAlunos.setModel(a.buscarNome(txtBuscar.getText()));
					TabelaAlunos.revalidate();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		ButtonBuscar.setBounds(1174, 83, 118, 40);
		contentPane.add(ButtonBuscar);
		getRootPane().setDefaultButton(ButtonBuscar);
		

			JButton btnExcluirAluno = new JButton("Excluir Aluno");
			btnExcluirAluno.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					try {
						TabelaAlunos.setModel(a.deletarAluno(TabelaAlunos.getSelectedRow(), window));
						TabelaAlunos.revalidate();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
				}
			});
			btnExcluirAluno.setBounds(698, 91, 122, 32);
			contentPane.add(btnExcluirAluno);


			JButton btnEditarAluno = new JButton("Editar Aluno");
			btnEditarAluno.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
									
					if(TabelaAlunos.getSelectedRow() != -1)
					{
						try {
							a.charmarTelaEditarAluno(TabelaAlunos.getSelectedRow());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			btnEditarAluno.setBounds(574, 92, 111, 32);
			contentPane.add(btnEditarAluno);
		
		TabelaAlunos = new JTable();
		TabelaAlunos.setShowHorizontalLines(false);
		TabelaAlunos.setShowVerticalLines(false);
		TabelaAlunos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TabelaAlunos.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		TabelaAlunos.setBounds(145, 149, 1086, 538);
		TabelaAlunos.setModel(tableModel);
		
		contentPane.add(TabelaAlunos);
		
		scrollPane.setBounds(145, 139, 1086, 548);
		scrollPane.setViewportView(TabelaAlunos);
		contentPane.add(scrollPane);
		
			
			JButton btnPerfildoAluno = new JButton("Perfil do Aluno");
			btnPerfildoAluno.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						//ControllerPerfilUsuario.iniciaTelaPerfil(window, a.buscarIdLivroSelecionado(TabelaAlunos.getSelectedRow()), 2);
						
						a.charmarTelaPerfilALuno(TabelaAlunos.getSelectedRow(), window);
					} catch (NumberFormatException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			btnPerfildoAluno.setBounds(155, 700, 121, 32);
			contentPane.add(btnPerfildoAluno);
		
		TableAlunos t = new TableAlunos();
		TabelaAlunos.setDefaultRenderer(Object.class, t);
		
		JTableHeader titulo = TabelaAlunos.getTableHeader();
		titulo.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				TableColumnModel colModel = TabelaAlunos.getColumnModel();
				int vColIndex = colModel.getColumnIndexAtX(e.getX());
				if(vColIndex != -1)
				{
					if(vColIndex == 1)
					{
						try {
							TabelaAlunos.setModel(a.listaOrganizadaNome(alfa));
							TabelaAlunos.revalidate();
							
							if(alfa == true)
							{
								TabelaAlunos.getColumnModel().getColumn(1).setHeaderValue("Nome -");
								alfa = false;
							}
							else if (alfa == false)
							{
								TabelaAlunos.getColumnModel().getColumn(1).setHeaderValue("Nome ^");
								alfa = true;
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
