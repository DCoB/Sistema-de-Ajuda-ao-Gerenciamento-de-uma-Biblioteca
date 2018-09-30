package biblioteca.views.cadastro.livro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteca.controllers.cadastros.ControllerCadastroLivro;
import biblioteca.controllers.cadastros.ControllerEditarLivro;

import java.awt.Font;
import java.awt.Window;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAdicionarSinopse extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private String titulo;
	
	private int tipoTela;
	
	private JTextArea textAreaSinopse = new JTextArea();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewAdicionarSinopse dialog = new ViewAdicionarSinopse(null, null,0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewAdicionarSinopse(Window frame, String nomeLivro, int tipoTela) {
		super(frame);
		titulo=nomeLivro;
		this.setTipoTela(tipoTela);
		setModal(true);//jdialog é modal
		setResizable(false);
		setTitle("Books Sky - cadastro de livro - sinopse");
		setBounds(100, 100, 720, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JPanel panelInfo = new JPanel();
		{
			JLabel labelInfo = new JLabel("INFORME A SINOPSE DO LIVRO");
			labelInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
			panelInfo.add(labelInfo);
		}
		JPanel panelMostraTitulo = new JPanel();
		{
			JLabel labelMostraLivro = new JLabel("Livro:" + titulo);
			labelMostraLivro.setFont(new Font("Tahoma", Font.BOLD, 18));
			panelMostraTitulo.add(labelMostraLivro);
		}
		
		JScrollPane scrollPaneSinopse = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panelInfo, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelMostraTitulo, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneSinopse, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelInfo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelMostraTitulo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPaneSinopse, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		
		
		textAreaSinopse.setLineWrap(true);
		scrollPaneSinopse.setViewportView(textAreaSinopse);
		//preenche text area caso usuário já tenha feito alguma edição
		if(ControllerCadastroLivro.getTextoSinopse()!=null) {
			textAreaSinopse.setText(ControllerCadastroLivro.getTextoSinopse());
		}
		
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("CONCLUIR");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//retornar sinopse para prosseguir com cadastro. A principio, todos os caracteres são válidos nesse campo.
						if(tipoTela==0) {
							if(ControllerCadastroLivro.retornaSinopse(textAreaSinopse.getText())!=null) {
								ControllerCadastroLivro.atualizaStatus();
								dispose();
							}
						}else {
							
							if(ControllerEditarLivro.retornaSinopse(textAreaSinopse.getText())!=null) {
								dispose();
							}
							
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

	public JTextArea getTextAreaSinopse() {
		return textAreaSinopse;
	}

	public void setTextAreaSinopse(JTextArea textAreaSinopse) {
		this.textAreaSinopse = textAreaSinopse;
	}

	public int getTipoTela() {
		return tipoTela;
	}

	public void setTipoTela(int tipoTela) {
		this.tipoTela = tipoTela;
	}
	
}
