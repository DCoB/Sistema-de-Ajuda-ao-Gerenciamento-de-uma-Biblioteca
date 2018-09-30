package biblioteca.views.cadastro.livro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteca.controllers.cadastros.ControllerCadastroLivro;
import biblioteca.controllers.cadastros.ControllerEditarLivro;
import biblioteca.exceptions.CampoInvalidoException;
import biblioteca.exceptions.ErroOperacaoException;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ViewLivro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int tipoTela;
	
	private JPanel contentPaneNumeroCopias;
	private JTextField textFieldTitulo;
	private JTextField textFieldAutor;
	private JTextField textFieldGenero;
	
	
	private JPanel panelStatusSinopse = new JPanel();
	
	private JLabel labelStatusSinopse = new JLabel("N\u00C3O INFORMADO");
	private JLabel lblCadastroDeLivro = new JLabel("CADASTRO DE LIVRO");
	
	private JSpinner spinnerAno = new JSpinner();
	
	private JButton btnInserirSinopse = new JButton("Inserir sinopse");
	
	JSpinner spinnerQtdeLivros = new JSpinner();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLivro frame = new ViewLivro(0);
					frame.setLocationRelativeTo(null);//exibição de janela centralizada
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame. Se tipoTela=0, cadastra novo livro. Caso tipoTela=1, tela de edição
	 */
	public ViewLivro(int tipoTela) {
		this.setTipoTela(tipoTela);
		setBackground(new Color(25, 25, 112));
		setTitle("BookSky - Vers\u00E3o 2.0 Cadastro de Livro");
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Biblioteca - Software 2.0/Imagens/Logo1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 789);
		setResizable(false);
		contentPaneNumeroCopias = new JPanel();
		contentPaneNumeroCopias.setBackground(new Color(240, 248, 255));
		contentPaneNumeroCopias.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneNumeroCopias);
		contentPaneNumeroCopias.setLayout(null);
				
		//Layout.view(contentPaneNumeroCopias,this);
		
		JPanel panelCadastroLivro = new JPanel();
		panelCadastroLivro.setBounds(12, 27, 1350, 62);
		panelCadastroLivro.setBackground(new Color(0, 153, 255));
		
		
		lblCadastroDeLivro.setFont(new Font("Rockwell", Font.BOLD, 40));
		panelCadastroLivro.add(lblCadastroDeLivro);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(17, 102, 1333, 33);
		panelInfo.setBackground(new Color(0, 153, 255));
		
		JLabel label = new JLabel("*Prezado, informe todos os dados abaixo para prosseguir com o cadastro.");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelInfo.add(label);
		
		JPanel panelDadosLivro = new JPanel();
		panelDadosLivro.setBounds(17, 182, 165, 33);
		
		JLabel lblDadosDo = new JLabel("1. Dados do livro");
		lblDadosDo.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelDadosLivro.add(lblDadosDo);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(17, 233, 107, 20);
		
		JLabel lblTtulo = new JLabel("T\u00CDTULO");
		panelTitulo.add(lblTtulo);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(179, 233, 1164, 22);
		textFieldTitulo.setColumns(10);
		
		JPanel panelAutor = new JPanel();
		panelAutor.setBounds(17, 271, 107, 20);
		
		JLabel lblAutor = new JLabel("AUTOR");
		panelAutor.add(lblAutor);
		
		textFieldAutor = new JTextField();
		textFieldAutor.setBounds(179, 273, 1164, 22);
		textFieldAutor.setColumns(10);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setBounds(179, 313, 1164, 22);
		textFieldGenero.setColumns(10);
		
		JPanel panelGenero = new JPanel();
		panelGenero.setBounds(17, 309, 107, 20);
		
		JLabel lblGnero = new JLabel("G\u00CANERO");
		panelGenero.add(lblGnero);
		
		JPanel panelQtdeLivros = new JPanel();
		panelQtdeLivros.setBounds(17, 484, 210, 33);
		
		JLabel lblQuantidadeDe = new JLabel("2. Quantidade de livros");
		lblQuantidadeDe.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelQtdeLivros.add(lblQuantidadeDe);
		
		JPanel panelNumeroLivros = new JPanel();
		panelNumeroLivros.setBounds(17, 530, 197, 35);
		
		JLabel lblNmeroDeCpias = new JLabel("N\u00DAMERO DE C\u00D3PIAS A ADICIONAR");
		panelNumeroLivros.add(lblNmeroDeCpias);
		spinnerQtdeLivros.setBounds(232, 530, 58, 35);
		
		
		spinnerQtdeLivros.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		
		JButton buttonConcluir = new JButton("CONCLUIR");
		buttonConcluir.setBounds(12, 697, 149, 44);
		buttonConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tipoTela==0) {
					try {
						ControllerCadastroLivro.cadastrarLivro(textFieldTitulo.getText(), textFieldAutor.getText(), textFieldGenero.getText(), 
								(int)spinnerAno.getValue(), (int) spinnerQtdeLivros.getValue());
					} catch (IOException | HeadlessException | ErroOperacaoException | CampoInvalidoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					String sinopse = ControllerEditarLivro.getLivroSistema().getSinopse();
					
					try {
						ControllerEditarLivro.atualizaTodosLivrosIguais(textFieldTitulo.getText(), textFieldAutor.getText(), 
								textFieldGenero.getText(), sinopse, (int)spinnerAno.getValue());
						
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
		buttonConcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton buttonCancelar = new JButton("CANCELAR");
		buttonCancelar.setBounds(179, 697, 149, 44);
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		buttonCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JPanel panel = new JPanel();
		panel.setBounds(17, 353, 138, 26);
		
		JLabel lblAnoDeLanamento = new JLabel("ANO DE LAN\u00C7AMENTO");
		panel.add(lblAnoDeLanamento);
		
		JPanel panelSinopse = new JPanel();
		panelSinopse.setBounds(17, 386, 119, 24);
		
		JLabel lblSinopse = new JLabel("SINOPSE");
		panelSinopse.add(lblSinopse);
		spinnerAno.setBounds(179, 353, 121, 22);
		
		
		
		//JSpinner spinnerAno = new JSpinner();
		spinnerAno.setModel(new SpinnerNumberModel(1990, 1900, 2050, 1));
		btnInserirSinopse.setBounds(179, 387, 138, 23);
		
		
		btnInserirSinopse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tipoTela==0) {
					try {
						
						ControllerCadastroLivro.informarSinopse(textFieldTitulo.getText());

					} catch (CampoInvalidoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					try {
						ControllerEditarLivro.informarSinopse(textFieldTitulo.getText());
					} catch (CampoInvalidoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				

				
	
			}
		});
		btnInserirSinopse.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		//JPanel panelStatusSinopse = new JPanel();
		
		//JLabel labelStatusSinopse = new JLabel("N\u00C3O INFORMADO");
		labelStatusSinopse.setForeground(Color.RED);
		labelStatusSinopse.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelStatusSinopse.setBounds(325, 386, 119, 24);
		panelStatusSinopse.add(labelStatusSinopse);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 204));
		panel_1.setBounds(12, 166, 1350, 264);
		contentPaneNumeroCopias.setLayout(null);
		contentPaneNumeroCopias.add(panelSinopse);
		contentPaneNumeroCopias.add(panelDadosLivro);
		contentPaneNumeroCopias.add(panelTitulo);
		contentPaneNumeroCopias.add(panel);
		contentPaneNumeroCopias.add(spinnerAno);
		contentPaneNumeroCopias.add(textFieldGenero);
		contentPaneNumeroCopias.add(textFieldAutor);
		contentPaneNumeroCopias.add(textFieldTitulo);
		contentPaneNumeroCopias.add(btnInserirSinopse);
		contentPaneNumeroCopias.add(panelStatusSinopse);
		contentPaneNumeroCopias.add(panelAutor);
		contentPaneNumeroCopias.add(panelGenero);
		contentPaneNumeroCopias.add(buttonConcluir);
		contentPaneNumeroCopias.add(buttonCancelar);
		contentPaneNumeroCopias.add(panelQtdeLivros);
		contentPaneNumeroCopias.add(panelNumeroLivros);
		contentPaneNumeroCopias.add(spinnerQtdeLivros);
		contentPaneNumeroCopias.add(panel_1);
		contentPaneNumeroCopias.add(panelInfo);
		contentPaneNumeroCopias.add(panelCadastroLivro);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 153, 204));
		panel_2.setBounds(12, 464, 288, 129);
		contentPaneNumeroCopias.add(panel_2);
	}

	
	//uso do ControllerCadastroLivro
	public JLabel getLabelStatusSinopse() {
		return labelStatusSinopse;
	}

	public void setLabelStatusSinopse(JLabel labelStatusSinopse) {
		this.labelStatusSinopse = labelStatusSinopse;
	}

	public JTextField getTextFieldTitulo() {
		return textFieldTitulo;
	}

	public void setTextFieldTitulo(String titulo) {
		this.textFieldTitulo.setText(titulo);
	}

	public JTextField getTextFieldAutor() {
		return textFieldAutor;
	}

	public void setTextFieldAutor(String autor) {
		this.textFieldAutor.setText(autor);
	}

	public JTextField getTextFieldGenero() {
		return textFieldGenero;
	}

	public void setTextFieldGenero(String genero) {
		this.textFieldGenero.setText(genero);
	}

	public JSpinner getSpinnerAno() {
		return spinnerAno;
	}

	//Set spinner como valor do ano do livro
	public void setSpinnerAno(int ano) {
		this.spinnerAno.setModel(new SpinnerNumberModel(ano, 1990, 2050, 1));
	}

	public void setTextFieldTitulo(JTextField textFieldTitulo) {
		this.textFieldTitulo = textFieldTitulo;
	}

	public void setTextFieldAutor(JTextField textFieldAutor) {
		this.textFieldAutor = textFieldAutor;
	}

	public void setTextFieldGenero(JTextField textFieldGenero) {
		this.textFieldGenero = textFieldGenero;
	}

	public void setSpinnerAno(JSpinner spinnerAno) {
		this.spinnerAno = spinnerAno;
	}

	public JButton getBtnInserirSinopse() {
		return btnInserirSinopse;
	}

	public void setBtnInserirSinopse(JButton btnInserirSinopse) {
		this.btnInserirSinopse = btnInserirSinopse;
	}

	public JSpinner getSpinnerQtdeLivros() {
		return spinnerQtdeLivros;
	}

	public void setSpinnerQtdeLivros(JSpinner spinnerQtdeLivros) {
		this.spinnerQtdeLivros = spinnerQtdeLivros;
	}

	public JLabel getLblCadastroDeLivro() {
		return lblCadastroDeLivro;
	}

	public void setLblCadastroDeLivro(JLabel lblCadastroDeLivro) {
		this.lblCadastroDeLivro = lblCadastroDeLivro;
	}

	public int getTipoTela() {
		return tipoTela;
	}

	public void setTipoTela(int tipoTela) {
		this.tipoTela = tipoTela;
	}
}
