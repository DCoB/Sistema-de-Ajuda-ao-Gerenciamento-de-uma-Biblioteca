package biblioteca.views.cadastro.usuario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import biblioteca.controllers.cadastros.ControllerCadastroAluno;
import biblioteca.controllers.cadastros.ControllerCadastroUsuario;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ViewCursoAluno extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	private String nome;
	private String login;
	private String senha;
	private String cpf;
	private String sexo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewCursoAluno dialog = new ViewCursoAluno(null,"","","","","");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewCursoAluno(Window frame,String nome, String login, String senha, String cpf, String sexo) {
		super(frame);// passo o componente pai deste Jdialog
		
		this.setNome(nome);
		this.setLogin(login);
		this.setSenha(senha);
		this.setCpf(cpf);
		this.setSexo(sexo);
		
		setModal(true);
		setTitle("Sky Books - informar curso do aluno");
		setBounds(100, 100, 547, 296);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("INFORME O CURSO DO ALUNO");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"selecione um curso", "ENGENHARIA CIVIL", "ENGENHARIA DA COMPUTA\u00C7\u00C3O", "ENGENHARIA EL\u00C9TRICA ELETR\u00D4NICA", "ENGENHARIA EL\u00C9TRICA ELETROT\u00C9CNICA", "ENGENHARIA EL\u00C9TRICA TELECOMUNICA\u00C7\u00D5ES", "ENGENHARIA MEC\u00C2NICA", "ENGENHARIA DE CONTROLE E AUTOMA\u00C7\u00C3O", "F\u00CDSICA DE MATERIAIS"}));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(118, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addGap(108))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(88, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("CONCLUIR CADASTRO");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						//recebo qual o curso informado pelo aluno
						ControllerCadastroAluno.setCursoAluno((String)comboBox.getSelectedItem());
						//efetua cadastro de aluno
						try {
							if(ControllerCadastroAluno.cadastrarAluno(nome, login, senha, cpf, (String)comboBox.getSelectedItem(),sexo)) {
									dispose();
									//desativo tela onde dados foram preenchidos
									ControllerCadastroUsuario.setStatusView(true);
									ControllerCadastroUsuario.statusFrame();
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
										
					}
				});
				okButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("CANCELAR");
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
