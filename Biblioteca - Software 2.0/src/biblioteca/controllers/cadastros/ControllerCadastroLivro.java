package biblioteca.controllers.cadastros;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JOptionPane;

import biblioteca.controllers.ControllerComplementar;
import biblioteca.exceptions.CampoInvalidoException;
import biblioteca.exceptions.ErroOperacaoException;
import biblioteca.servicos.ServicoLivro;
import biblioteca.servicos.ServicoLog;
import biblioteca.servicos.basicas.Livro;
import biblioteca.views.cadastro.livro.ViewAdicionarSinopse;
import biblioteca.views.cadastro.livro.ViewLivro;

/**
 * Classe Respons�vel por Fazer Todas as Opera��es que Acontecem na View de Cadastro de Livro
 */
public class ControllerCadastroLivro {
	
	private static Component frame = null; 
	private static Object[] options = {"Sim","N�o",};
	private static int n =-1;
	
	
	private static ViewLivro frameLivro = new ViewLivro(0);
	private static ViewAdicionarSinopse sinopse;
	private static boolean sinop=false;
	private static String textoSinopse="";
	
	
	
	private static ServicoLivro serL = new ServicoLivro();
	private static ServicoLog serLog = new ServicoLog();
	

	public static String getTextoSinopse() {
		return textoSinopse;
	}


	public static void setTextoSinopse(String textoSinopse) {
		ControllerCadastroLivro.textoSinopse = textoSinopse;
	}


	/**
	 * M�todo chama a view de cadastro de livro.
	 */
	public static void iniciaTelaCadastroLivro() {
		
		frameLivro.setLocationRelativeTo(null);//exibi��o de janela centralizada
		frameLivro.setVisible(true);
	}
	
	public static void cadastrarLivro(String titulo, String autor, String genero, 
			int anoLancamento, int quantidadeLivros) throws IOException, ErroOperacaoException, HeadlessException, CampoInvalidoException {
		

				
		if(ControllerCadastroLivro.validarDadosLivro(titulo, autor, genero, ControllerCadastroLivro.getTextoSinopse())) {
			
			//solicito a confirma��o do usu�rio
			n = JOptionPane.showOptionDialog(frame,"Voc� deseja prosseguir?","Aviso", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
			
				if(n==0) {
					
					Livro novoLivro = new Livro(titulo, autor, genero, ControllerCadastroLivro.getTextoSinopse(), anoLancamento);
					
					for(int i=0;i<quantidadeLivros;i++) {
						serL.cadastrarLivro(novoLivro);
					}
					
					serLog.adicionarLog("Livro(s) adicionados com sucesso.");
					JOptionPane.showMessageDialog(frameLivro,"Livro(s) adicionados com sucesso.","Mensagem",JOptionPane.INFORMATION_MESSAGE);
				}

			
		}else {
			serLog.adicionarLog("N�o foi poss�vel adicionar o(s) livro(s).");
			JOptionPane.showMessageDialog(frameLivro,"N�o foi poss�vel adicionar o(s) livro(s).","Mensagem",JOptionPane.WARNING_MESSAGE);
			throw new ErroOperacaoException("N�o foi poss�vel adicionar o(s) livro(s).");
		}
		
	}
	
	
	public static boolean validarDadosLivro(String titulo, String autor, String genero, String sinopseLivro) throws IOException, CampoInvalidoException {
		
		boolean resultado=false;
		
		//todos os campos devem estar preenchidos
		if(!titulo.trim().isEmpty()&&!autor.trim().isEmpty()&&!sinopseLivro.trim().isEmpty()) {
			
			//verifica se campos autor e genero foram preenchidos corretamente
			if(ControllerComplementar.validarCampos(autor, 0)&&ControllerComplementar.validarCampos(genero, 0)) {
				resultado=true;
			}else {
				serLog.adicionarLog("H� caracteres inv�lidos no campo AUTOR ou G�NERO.");
				JOptionPane.showMessageDialog(frameLivro,"H� caracteres inv�lidos no campo AUTOR ou G�NERO.","Mensagem",JOptionPane.WARNING_MESSAGE);
				throw new CampoInvalidoException("H� caracteres inv�lidos no campo AUTOR ou G�NERO.");
			}
			
		}else {
			serLog.adicionarLog("Campos foram deixados em branco.\nFavor preenche-los");
			JOptionPane.showMessageDialog(frameLivro,"Campos foram deixados em branco.\nFavor preenche-los","Mensagem",JOptionPane.WARNING_MESSAGE);
		}
		
		return resultado;
	}
	
	
	
	/**
	 * M�todo chama a view de informar sinopse
	 * @param titulo
	 * @return
	 * @throws CampoInvalidoException 
	 */
	public static boolean informarSinopse(String titulo) throws CampoInvalidoException {
		boolean resultado=false;
		
		if(!titulo.trim().isEmpty()) {//por enquanto, o campo de titulo deve estar pelo menos preenchido - implementar metodo verificador
			sinopse = new ViewAdicionarSinopse(frameLivro,titulo,0);
			sinopse.setLocationRelativeTo(null);//exibi��o de janela centralizada
			sinopse.setVisible(true);
			resultado=true;
		}else {
			JOptionPane.showMessageDialog(frameLivro,"T�tulo inv�lido","Mensagem",JOptionPane.WARNING_MESSAGE);
			throw new CampoInvalidoException("T�tulo inv�lido");
		}
		
		return resultado;

	}

	/**
	 *  M�todo retorna a sinopse digitada pelo usu�rio
	 * @return
	 */
	public static String retornaSinopse(String sinopseObtida) {
		
		if(!sinopseObtida.trim().isEmpty()) {
			sinop=true;
			textoSinopse=sinopseObtida;
			return sinopseObtida;
			
		}else {
			sinop=false;
			ControllerCadastroLivro.atualizaStatus();
			JOptionPane.showMessageDialog(sinopse, "Voc� precisa informar a sinopse do livro para prosseguir.");
			return null;
		}
		
	}	
	public static void atualizaStatus() {
		
		if(sinop==true) {
			frameLivro.getLabelStatusSinopse().setText("INFORMADO");
			frameLivro.getLabelStatusSinopse().setForeground(Color.GREEN);
			frameLivro.getLabelStatusSinopse().setFont(new Font("Tahoma", Font.BOLD, 11));
		}else {
			frameLivro.getLabelStatusSinopse().setText("N�O INFORMADO");
			frameLivro.getLabelStatusSinopse().setForeground(Color.RED);
			frameLivro.getLabelStatusSinopse().setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		
	}
	
	public static void preencheTelaCadastroLivro(Livro dadosLivro) {
		
		
		
		frameLivro.setTextFieldTitulo(dadosLivro.getTitulo());
		frameLivro.getTextFieldTitulo().setEditable(false);
		
		frameLivro.setTextFieldAutor(dadosLivro.getAutor());
		frameLivro.getTextFieldAutor().setEditable(false);
		
		frameLivro.setTextFieldGenero(dadosLivro.getGenero());
		frameLivro.getTextFieldGenero().setEditable(false);
		
		frameLivro.getBtnInserirSinopse().setEnabled(false);
		
		
		frameLivro.setSpinnerAno(dadosLivro.getAno());
		frameLivro.getSpinnerAno().setEnabled(false);
		//este m�todo valida se sinopse foi informada ou n�o
		retornaSinopse(dadosLivro.getSinopse());
		atualizaStatus();
	
	}

}
