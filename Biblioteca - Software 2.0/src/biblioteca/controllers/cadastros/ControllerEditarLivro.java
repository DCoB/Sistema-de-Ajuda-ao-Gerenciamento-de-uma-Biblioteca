package biblioteca.controllers.cadastros;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JOptionPane;

import biblioteca.exceptions.CampoInvalidoException;
import biblioteca.exceptions.ErroOperacaoException;
import biblioteca.servicos.ServicoLivro;
import biblioteca.servicos.ServicoLog;
import biblioteca.servicos.basicas.Livro;
import biblioteca.views.cadastro.livro.ViewAdicionarSinopse;
import biblioteca.views.cadastro.livro.ViewLivro;
/**
 * 
 * Classe responsável por efetuar alterações de livros no banco de Livros.
 * Livros não são adicionados aqui.
 *
 */
public class ControllerEditarLivro {
	
	
	private static ViewLivro frameLivro = new ViewLivro(1);
	private static ViewAdicionarSinopse frameSinopse;
	
	private static ServicoLivro servL = new ServicoLivro();
	private static ServicoLog servLog = new ServicoLog();
	private static Livro livroSistema;
	private static Livro[] resultadoBusca; //livros iguais que serão alterados
	private static long[] idLivros;

	
	
	public static Livro getLivroSistema() {
		return livroSistema;
	}


	public static void setLivroSistema(Livro livroSistema) {
		ControllerEditarLivro.livroSistema = livroSistema;
	}


	public static void iniciaTelaEdicaoLivro(Livro livro) throws IOException, ErroOperacaoException {
		
		livroSistema=livro;
		buscarLivrosEId();
		preencheTelaEditarLivro(livroSistema);
		frameLivro.setLocationRelativeTo(null);//exibição de janela centralizada
		frameLivro.setVisible(true);
	}
	
	
	public static boolean atualizaTodosLivrosIguais(String titulo, String autor, String genero, String sinopse ,int anoLancamento) throws IOException, ErroOperacaoException {
		boolean resultado=false;
		
		
		
		Livro livroEditado = new Livro(titulo, autor, genero, sinopse, anoLancamento);
		

		if(resultadoBusca!=null) {
			
			for(int i=0; i<resultadoBusca.length;i++) {
				
				resultadoBusca[i]=livroEditado;
				servL.alterarLivro(resultadoBusca[i], idLivros[i]);
				
			}
			resultado=true;
		}
		
		if(resultado==true) {
			JOptionPane.showMessageDialog(frameLivro,"Livro(s) adicionados com sucesso.","Mensagem",JOptionPane.INFORMATION_MESSAGE);
			
		}else {
			
			JOptionPane.showMessageDialog(frameLivro,"Não foi possível adicionar o(s) livro(s).","Mensagem",JOptionPane.WARNING_MESSAGE);
			throw new ErroOperacaoException("Não foi possível adicionar o(s) livro(s).");
		}
		
		return resultado;
 		
	}
	
	
	
	public static void preencheTelaEditarLivro(Livro livro) {
		
		
		//Labels
		frameLivro.getLblCadastroDeLivro().setText("Edição de livro");
		
		//Text fields
		frameLivro.getTextFieldTitulo().setText(livro.getTitulo());
		frameLivro.getTextFieldAutor().setText(livro.getAutor());
		frameLivro.getTextFieldGenero().setText(livro.getGenero());
		
		//Sinopse
		frameLivro.getLabelStatusSinopse().setText("INFORMADO");
		frameLivro.getLabelStatusSinopse().setForeground(Color.GREEN);
		frameLivro.getLabelStatusSinopse().setFont(new Font("Tahoma", Font.BOLD, 11));
		
		frameSinopse = new ViewAdicionarSinopse(frameLivro, livro.getTitulo(), 1);
		
		
		//Spinners
		frameLivro.setSpinnerAno(livro.getAno());
		frameLivro.getSpinnerQtdeLivros().setEnabled(false);	
	}
	
	public static String retornaSinopse(String sinopseObtida) {//criar exception futuramente
		
		if(!sinopseObtida.trim().isEmpty()) {
			livroSistema.setSinopse(sinopseObtida);
			return sinopseObtida;
			
		}else {
			JOptionPane.showMessageDialog(frameSinopse, "Você precisa informar a sinopse do livro para prosseguir.");
			return null;
		}
		
	}	
	
	public static void informarSinopse(String titulo) throws CampoInvalidoException {
		
		if(!titulo.trim().isEmpty()) {//por enquanto, o campo de titulo deve estar pelo menos preenchido - implementar metodo verificador
			
			frameSinopse.getTextAreaSinopse().setText(livroSistema.getSinopse());
			frameSinopse.setLocationRelativeTo(null);//exibição de janela centralizada
			frameSinopse.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(frameLivro,"Título inválido","Mensagem",JOptionPane.WARNING_MESSAGE);
			throw new CampoInvalidoException("Título inválido");
		}
		

	}
	
	public static void buscarLivrosEId() throws IOException {
		
		resultadoBusca = servL.buscarLivro(livroSistema.getTitulo());
		idLivros = new long[resultadoBusca.length];
		for(int i=0; i<resultadoBusca.length;i++) {
			idLivros[i]= resultadoBusca[i].getIdLivro();
		}
		
	}


	public static ServicoLog getServLog() {
		return servLog;
	}


	public static void setServLog(ServicoLog servLog) {
		ControllerEditarLivro.servLog = servLog;
	}

}
