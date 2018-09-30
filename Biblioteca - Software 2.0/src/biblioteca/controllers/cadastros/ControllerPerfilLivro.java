package biblioteca.controllers.cadastros;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import biblioteca.servicos.ServicoAluno;
import biblioteca.servicos.ServicoLivro;
import biblioteca.servicos.ServicoLog;
import biblioteca.servicos.basicas.Aluno;
import biblioteca.servicos.basicas.Livro;
import biblioteca.views.ViewPagarMultas;
import biblioteca.views.cadastro.livro.ViewAlugarLivro;
import biblioteca.views.cadastro.livro.ViewPerfilLivro;

public class ControllerPerfilLivro {

	private static Object[] options = {"Pagar Multas do Aluno","Cancelar",};
	
	private static ServicoLog servLog = new ServicoLog();
	
	/**
	 * Inicia a tela do perfil de livro
	 * @param idLivro
	 * @param window
	 * @throws IOException
	 */
	public void iniciarTelaPerfilLivro(long idLivro,JFrame window) throws IOException
	{
		window.dispose();
		
		ServicoLivro servL = new ServicoLivro();
		servL.atualizarAtrasos();
		
		Livro livro = servL.buscarLivroPorId(idLivro);
		
		String criticas = "";
		ArrayList<String> l= livro.getCriticas();
		
		if(l != null)
		{
			for(int x =0; x < livro.getCriticas().size() ;x++)
			{
				criticas += "  -- " + livro.getCriticas().get(x) + "\n\n";
			}
		}
		
		ViewPerfilLivro ViewP = new ViewPerfilLivro(livro,criticas);
		
		ViewP.setLocationRelativeTo(null);//exibição de janela centralizada
		ViewP.setVisible(true);
	}
	
	public void chamarViewAlugarLivro(String Titulo)
	{
		ViewAlugarLivro ViewAL = new ViewAlugarLivro(Titulo);
		ViewAL.setLocationRelativeTo(null);//exibição de janela centralizada
		ViewAL.setVisible(true);
		
	}
	
	public void confirmarAlugarLivro(String CPF,JFrame window,String Titulo) throws IOException
	{
		ServicoAluno ca = new ServicoAluno();
					
		Aluno a = ca.buscarAluno(CPF);	
		if(a != null)
		{
			ServicoAluno ca1 = new ServicoAluno(a);	
			ca1.atualizarMultaAluno(CPF);
			
			if(a.getSaldoMultas() < 0)
			{
				int n = JOptionPane.showOptionDialog(window,"Para Continuar a Locação do Livro, é Preciso Pagar as Multas do Aluno !","Aviso", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
				if(n == 0)
				{
					ViewPagarMultas ViewPM = new ViewPagarMultas(a.getNome(), Titulo,a);
					ViewPM.setLocationRelativeTo(null);//exibição de janela centralizada
					ViewPM.setVisible(true);
				}
			}
			else
			{
			
					
				if(ca1.addLivroPerfil(0, Titulo, 0)) {
					JOptionPane.showMessageDialog(window,"Livro Locado Com Sucesso","Mensagem",JOptionPane.INFORMATION_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(window,servLog.UltimoLog(),"Mensagem",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		}
		else
		{
			JOptionPane.showMessageDialog(window,
				    "Usuário com esse CPF Não Encontrado!.","Aviso",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void continuarLocacaoLivro(String Titulo,JFrame window,Aluno a) throws IOException
	{
		ServicoAluno servA = new ServicoAluno();
		servA.pagarTodasMultas(a.getCPF());
		
		ServicoAluno aluno = new ServicoAluno(a);
		
		aluno.addLivroPerfil(0, Titulo, 0);
		JOptionPane.showMessageDialog(window,"Livro Locado Com Sucesso","Mensagem",JOptionPane.INFORMATION_MESSAGE);
		window.dispose();
	}
	
}
