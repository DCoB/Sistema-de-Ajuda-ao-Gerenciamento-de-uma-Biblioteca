package biblioteca.controllers.cadastros;

import java.awt.Color;
import java.awt.Window;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import biblioteca.controllers.ControllerComplementar;
import biblioteca.exceptions.CampoInvalidoException;
import biblioteca.repositorios.*;
import biblioteca.servicos.ServicoAluno;
import biblioteca.servicos.ServicoLivro;
import biblioteca.servicos.ServicoLog;
import biblioteca.servicos.basicas.*;
import biblioteca.views.ViewAvaliarECriticarLivro;
import biblioteca.views.cadastro.usuario.ViewPerfilUsuario;

public class ControllerPerfilUsuario {
	
	
	private static ViewPerfilUsuario perfilUsuario;
	
	private static Pessoa ser;
	
	private static RepositorioAluno repA = new RepositorioAluno();
	private static RepositorioFuncionario repF = new RepositorioFuncionario();
	private static RepositorioGerente repG = new RepositorioGerente();
	private static Object[] options = {"Pagar Multas do Aluno","Cancelar",};
	
	private static ServicoAluno servA = new ServicoAluno();
	
	private static String historico="";
	
	
	public static void iniciaTelaPerfil(JFrame window, long idPessoa, int tipoPessoa) throws NumberFormatException, IOException {
		
		window.dispose();
		historico="";
		buscaPessoa(idPessoa, tipoPessoa);
		perfilUsuario = new ViewPerfilUsuario();
		
		preencheDados();
		perfilUsuario.setLocationRelativeTo(null);
		perfilUsuario.setVisible(true);	
	}
	
	//Confirma se a Pessoa é: Gerente = 0, Funcionario = 1 e Aluno = 2
	
	/**
	 * Identifica qual usuário está logado
	 * @param idPessoa
	 * @param tipoPessoa
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void buscaPessoa(long idPessoa, int tipoPessoa) throws NumberFormatException, IOException {
		
		
		if(tipoPessoa==2) {
			
			ser = repA.buscarAlunoPorId(idPessoa);
			servA = new ServicoAluno((Aluno) ser);
			
			
		}else if(tipoPessoa==1) {
			
			ser = repF.buscarFuncionarioPorId(idPessoa);
			
		}else {
			ser = repG.buscarGerentePorId(idPessoa);
		}
		
	}
	
	/**
	 * Preenche os dados da view do perfil de usuário (apenas dados de cadastro)
	 */
	public static void preencheDados() throws IOException {
		
		//preenche dados comuns as todos os usuários
		
		perfilUsuario.getLabelName().setText(ser.getNome());
		perfilUsuario.getLblLoginn().setText(ser.getLogin());
		perfilUsuario.getLblCpff().setText(ser.getCPF());
		perfilUsuario.getLblSex().setText(ser.getSex());
		
		if(ser instanceof Aluno) {
			if(Short.parseShort(System.getProperty("TipoPessoa")) == 2)
			{
				perfilUsuario.getBtnPagarMultas().setVisible(false);
				perfilUsuario.getBtnDevolver1().setVisible(false);
				perfilUsuario.getButtonDevolver2().setVisible(false);
				perfilUsuario.getButtonDevolver3().setVisible(false);
				
			}
			
			perfilUsuario.getLabelCursoo().setText(((Aluno) ser).getCurso());
			perfilUsuario.getLblMatriculaa().setText(String.valueOf(((Aluno) ser).getMatricula()));
			perfilUsuario.getTextSaldoMultas().setText(String.valueOf(((Aluno) ser).getSaldoMultas()));
			perfilUsuario.getTextTipoUsuario().setText("Aluno");
			perfilUsuario.getScrollPaneLogs().setVisible(false);
			perfilUsuario.getLblListadeLogs().setVisible(false);
			
			preencheLivrosEmPosse();
			livrosHistorico();
			if(!historico.trim().isEmpty()) {
				perfilUsuario.getTxtrHistricoEmBranco().setText(historico);
				perfilUsuario.getTxtrHistricoEmBranco().setEnabled(false);
			}
		historico ="";
			
		}else if(ser instanceof Funcionario) {
						
			perfilUsuario.getLblMatriculaa().setEnabled(false);
			perfilUsuario.getTextTipoUsuario().setText("Funcionário");
			perfilUsuario.getTextAreaLogs().setText(listaLogsUsuario(((Funcionario) ser).getIdPessoa(), 1));
			
			perfilUsuario.getPainelALuno().setVisible(false);
			perfilUsuario.getPainelLivrosEmPosse().setVisible(false);
			perfilUsuario.getLblPainelAluno().setVisible(false);
			perfilUsuario.getLblListadeLivros().setVisible(false);
			perfilUsuario.getLblLivrosEmPosse().setVisible(false);
			perfilUsuario.getScrollPaneLivrosHistóricos().setVisible(false);
			perfilUsuario.getBtnPagarMultas().setVisible(false);
			
		}else {
			perfilUsuario.getLblMatriculaa().setEnabled(false);
			perfilUsuario.getTextTipoUsuario().setText("Gerente");
			perfilUsuario.getTextAreaLogs().setText(listaLogsUsuario(((Gerente) ser).getIdPessoa(), 0));
			
			perfilUsuario.getPainelALuno().setVisible(false);
			perfilUsuario.getPainelLivrosEmPosse().setVisible(false);
			perfilUsuario.getLblPainelAluno().setVisible(false);
			perfilUsuario.getLblListadeLivros().setVisible(false);
			perfilUsuario.getLblLivrosEmPosse().setVisible(false);
			perfilUsuario.getScrollPaneLivrosHistóricos().setVisible(false);
			perfilUsuario.getBtnPagarMultas().setVisible(false);
			
		}
		
	}
	
	/**
	 * Método retorna livros pegos e atrasados do usuário
	 * @return
	 * @throws IOException
	 */
	public static Livro[] preencheDadosLivros() throws IOException {
		
		
		
		Livro[] a = servA.buscaLivroPego();
		Livro[] b = servA.buscaLivroAtrasado();
		
		ArrayList< Livro > livrosEmPosse = new ArrayList< Livro >();
		
		Livro[] resultadoBusca= null;
		
		if(a!=null) {
			for(int i=0; i<a.length;i++) {
				livrosEmPosse.add(a[i]);
			}
		}
		
		if(b!=null) {
			for(int i=0; i<a.length;i++) {
				livrosEmPosse.add(b[i]);
			}
		}
			
			 if(livrosEmPosse.size()!=0) {
				 resultadoBusca = (Livro[]) livrosEmPosse.toArray(new Livro[livrosEmPosse.size()]); 
			 }
			 
			 return resultadoBusca;	
	}
	/*
	 * Método preenche livros em posse na view do perfil, caso existam.
	 */
	public static void preencheLivrosEmPosse() throws IOException {
		
		
		
		Livro[] resultado = preencheDadosLivros();
		
		if(resultado!=null) {
			
			int valor = resultado.length;
				
				if(valor>=1&&resultado[0].getTitulo()!=null) {//preenche primeiro campo
					
						perfilUsuario.getLblLivro11().setText(resultado[0].getTitulo());
						perfilUsuario.getLblLivro11().setForeground(Color.GREEN);
					if(resultado[0].getDiasRestantes()<0) {
						perfilUsuario.getLblLivro11().setForeground(Color.RED);
					}
						
				}
				
				if(valor>=2&&resultado[1].getTitulo()!=null) {
					perfilUsuario.getLblLivro22().setText(resultado[1].getTitulo());
					perfilUsuario.getLblLivro22().setForeground(Color.GREEN);
					if(resultado[1].getDiasRestantes()<0) {
						perfilUsuario.getLblLivro22().setForeground(Color.RED);
					}
				} 
				if(valor>=3&&resultado[2].getTitulo()!=null) {
					perfilUsuario.getLblLivro32().setText(resultado[2].getTitulo());
					perfilUsuario.getLblLivro32().setForeground(Color.GREEN);
					if(resultado[2].getDiasRestantes()<0) {
						perfilUsuario.getLblLivro32().setForeground(Color.RED);
					}
					
				}
		}

	}
	/**
	 * Método busca livros do histórico para exibi-los.
	 * @return
	 */
	public static String livrosHistorico() {
		Livro[] resultado = servA.buscaLivroHistorico();
		
			if(resultado!=null) {
				for(int i=0;i<resultado.length;i++) {
					historico+="--"+ resultado[i].getTitulo() + "\n";
				}
			}

		return historico;
		
	}
	
	public static boolean devolverLivro(String titulo, double nota) throws IOException {
		boolean status=false;
		
		if(!titulo.equals("Livro")&&servA.devolverLivroPerfil(ser.getIdPessoa(), titulo, nota, 0)) {
			status=true;		
		}
		
		if(status==true) {
			JOptionPane.showMessageDialog(perfilUsuario,
				    "Livro entregue com sucesso.","Êxito na operação.",JOptionPane.INFORMATION_MESSAGE);
			
			ViewAvaliarECriticarLivro AC = new ViewAvaliarECriticarLivro(titulo);
			AC.setLocationRelativeTo(null);//exibição de janela centralizada
			AC.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(perfilUsuario,
				    "Não foi possível devolver o livro.","Falha na operação.",JOptionPane.ERROR_MESSAGE);
		}
		
		return status;
	}
	
	public static String listaLogsUsuario(long idUsuario,int tipoPessoa) throws IOException
	{
		String logs = "";
		ServicoLog l = new ServicoLog();
		
		ArrayList<Log> listalog = l.buscarLogPorIdUsuario(idUsuario, tipoPessoa);
		
		for(int x = 0; x <listalog.size();x++)
		{
			logs += " -- " + listalog.get(x).getMensagem() + listalog.get(x).getHoraData() + "\n\n";
		}
		
		
		return logs;
	}
	
	public static void charmarTelaPagarMultas(JFrame window) throws NumberFormatException, IOException
	{
		ServicoAluno servA = new ServicoAluno();
		
		if(((Aluno) ser).getSaldoMultas() != 0.0)
		{
			int n = JOptionPane.showOptionDialog(window,"Tem Certeza que Deseja Zerar o Saldo de todas a Multas desse Aluno? !","Aviso", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
		
			if(n == 0)
			{
				servA.pagarTodasMultas((((Aluno)ser).getCPF()));
				iniciaTelaPerfil(window, ((Aluno) ser).getIdPessoa(), 2);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(window,
				    "Aluno não possui multas!","Aviso",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void avaliarECriticarLivro(Window window,String titulo,String nota,String critica) throws IOException, CampoInvalidoException
	{
		ServicoAluno servA = new ServicoAluno();
		ServicoLivro servL = new ServicoLivro();
		critica = ((Aluno)ser).getNome() + ",\n" + "  " + critica;
		
		if(ControllerComplementar.validarCampos(nota, 1)&&titulo.trim().isEmpty()==false) {
			
			Livro[] l = servL.buscarLivro(titulo);
			
			
			for(int x = 0 ; x < l.length;x++)
			{
				servA.avaliarLivro(l[x], Double.parseDouble(nota));
				l = servL.buscarLivro(titulo);
				servL.adicionarCritica(critica, l[x]);
			}
			
			JOptionPane.showMessageDialog(perfilUsuario,
				    "Livro Avaliado com sucesso.","Êxito na operação.",JOptionPane.INFORMATION_MESSAGE);
			window.dispose();
		}else {
			
			JOptionPane.showMessageDialog(perfilUsuario,
				    "Dados incompatíveis. Tente novamente.","Êxito na operação.",JOptionPane.INFORMATION_MESSAGE);
			throw new CampoInvalidoException("Dados incompatíveis. Tente novamente.");

		}
	
	}
	
}
