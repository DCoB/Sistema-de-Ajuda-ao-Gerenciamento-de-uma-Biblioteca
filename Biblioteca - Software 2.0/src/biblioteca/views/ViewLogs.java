package biblioteca.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biblioteca.controllers.ControllerLogs;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;

public class ViewLogs extends JFrame {

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
					ViewLogs frame = new ViewLogs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public ViewLogs() throws IOException {

		
		setForeground(new Color(0, 255, 255));
		setBackground(new Color(25, 25, 112));
		setTitle("BookSky - Vers\u00E3o 2.0 Lista de Logs");
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Biblioteca - Software 2.0/Imagens/Logo1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 789);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		Layout.view(contentPane,this);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 1354, 549);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Calibri", Font.BOLD, 22));
		textArea.setText(ControllerLogs.stringTodosLogs());
		textArea.setWrapStyleWord(true);
		//textArea.setLineWrap(true);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}
}
