package biblioteca.controllers.cadastros;

import java.io.IOException;

import javax.swing.JOptionPane;

import biblioteca.servicos.ServicoLivro;
import biblioteca.servicos.ServicoLog;
import biblioteca.servicos.basicas.Livro;
import biblioteca.views.cadastro.livro.ViewTipoCadastroLivro;

public class ControllerTipoCadastroLivro {
	
	private static ServicoLivro serL = new ServicoLivro();
	private static ServicoLog serLog = new ServicoLog();
	
	private static ViewTipoCadastroLivro viewPergunta = new ViewTipoCadastroLivro();
	
	//construtor chama view que pergunta qual tipo de cadastro de livros
	public static void iniciaTipoCadastroLivro() {
		
		viewPergunta.setLocationRelativeTo(null);//exibi��o de janela centralizada
		viewPergunta.setVisible(true);
		
	}
	
	public static boolean efetuaCadastro(String livroBuscado) throws IOException {
		
		boolean resultado=false;
		if(!livroBuscado.trim().isEmpty()) {
			
			if(serL.buscarLivro(livroBuscado)!=null) {
				
				//caso a busca retorne um livro, sistema redireciona para view de cadastro de livro
				//no entanto, nenhum campo ser� edit�vel, somente o n�mero de c�pias a serem adicionadas
				
				
				Livro[] busca = serL.buscarLivro(livroBuscado);
				//M�TODO PREENCHE A VIEW COM OS DADOS ENCONTRADOS NA BUSCA
				ControllerCadastroLivro.preencheTelaCadastroLivro(busca[0]);
				ControllerCadastroLivro.iniciaTelaCadastroLivro();
				resultado=true;
				
			}else {
				
				serLog.adicionarLog("Desculpe, o livro n�o foi encontrado.");
				JOptionPane.showMessageDialog(viewPergunta,"Desculpe, o livro n�o foi encontrado.",
						"Sem resultados",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}else {
			
			serLog.adicionarLog("Voc� precisa informar um t�tulo para a busca iniciar.");
			JOptionPane.showMessageDialog(viewPergunta,"Voc� precisa informar um t�tulo para a busca iniciar.",
					"Mensagem",JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		
		return resultado;
		
	}
	

}
