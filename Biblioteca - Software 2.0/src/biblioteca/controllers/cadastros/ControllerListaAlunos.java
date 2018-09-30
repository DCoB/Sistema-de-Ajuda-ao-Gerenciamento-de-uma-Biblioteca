package biblioteca.controllers.cadastros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import biblioteca.servicos.ServicoAluno;
import biblioteca.servicos.ServicoAuxiliar;
import biblioteca.servicos.ServicoLog;
import biblioteca.servicos.basicas.Aluno;
import biblioteca.servicos.basicas.Pessoa;
import biblioteca.views.cadastro.usuario.ViewListaAlunos;

public class ControllerListaAlunos extends AbstractTableModel{
	
	
	private static final long serialVersionUID = 1L;
	private List<Aluno> dados = new ArrayList<>();
	private String[] colunas = {"IdPessoa","Nome","Login","Matrícula","Curso","Saldo Multas"};
	private static Object[] options = {"Sim","Não",};
	private ServicoLog servLog = new ServicoLog();
	private ServicoAluno servL = new ServicoAluno();
	private ServicoAuxiliar servA = new ServicoAuxiliar();
	
	
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	@Override
	public int getRowCount() {
		return dados.size();
	}
	@Override
	public Object getValueAt(int linha, int coluna) 
	{
		switch(coluna)
		{
			case 0: 
				return dados.get(linha).getIdPessoa();
			case 1: 
				return dados.get(linha).getNome();
			case 2 :
				return dados.get(linha).getLogin();
			case 3 :
				return servA.formatarMatricula(dados.get(linha).getMatricula());
			case 4 :
				return dados.get(linha).getCurso();
			case 5 :
				return dados.get(linha).getSaldoMultas();		
		}
		
		return null;
	}
	
	public void listaAlunos(JFrame window) throws IOException
	{
		window.dispose();
		
		atualizarListaAlunos();
		
		ViewListaAlunos viewA = new ViewListaAlunos(this);
		
		viewA.setLocationRelativeTo(null);//exibição de janela centralizada
		viewA.setVisible(true);
	}
	
	public void atualizarListaAlunos() throws IOException
	{
		Aluno[] listaAlunos = servL.listaAlunos();
		this.dados.clear();
		for(int x = 0; x < listaAlunos.length; x++)
		{
			this.dados.add(listaAlunos[x]);
		}
	}
	
	public void charmarTelaEditarAluno(int linha) throws IOException
	{
		//atualizarListaAlunos();
		
		Object x = getValueAt(linha, 1);
		String nome = (String)x;
		
		Pessoa Aluno = servL.buscarAluno(nome);
		
		ControllerEditarUsuario.iniciaTelaEdicao(Aluno, Aluno.getTipoPessoa());
	}
	
	public void charmarTelaPerfilALuno(int linha,JFrame window) throws NumberFormatException, IOException
	{
		Object x = getValueAt(linha, 1);
		String nome = (String)x;
		
		Pessoa Aluno = servL.buscarAluno(nome);
		
		ControllerPerfilUsuario.iniciaTelaPerfil(window, Aluno.getIdPessoa(), 2);
	}
	
	public AbstractTableModel buscarNome(String Nome) throws IOException
	{
		if(!Nome.equals(""))
		{
			Aluno a = servL.BuscarAlunoIniciais(Nome);
			
			dados.clear();
			if(a != null)
			{
				this.dados.add(a);
			}
			
		}
		else
		{
			atualizarListaAlunos();
		}
		
		return this;
	}
	
	public AbstractTableModel deletarAluno(int linha,JFrame frame) throws IOException
	{
		atualizarListaAlunos();
		
		Object x = getValueAt(linha, 0);
		long id = (long)x;
		
		if(servL.deletarAluno(id) == true)
		{
			JOptionPane.showOptionDialog(frame,"Tem Certeza que Deseja Deletar esse Aluno ?" ,"Confirmação de Exclusão", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
			JOptionPane.showMessageDialog(frame,servLog.UltimoLog(),"Aluno Excluído com Sucesso",JOptionPane.WARNING_MESSAGE);
			
			atualizarListaAlunos();
		}
		else
		{
			JOptionPane.showMessageDialog(frame,"Ocorreu Algum Problema na Exclusão desse Livro","Aviso",JOptionPane.WARNING_MESSAGE);
		}
		
		return this;
	}
	
	public AbstractTableModel listaOrganizadaNome(boolean i) throws IOException
	{
		this.dados = servL.organizaNome(i);
		
		return this;
	}
	
	public long buscarIdLivroSelecionado(int linha) throws IOException
	{
		atualizarListaAlunos();
		
		Object x = getValueAt(linha, 0);
		long id = (long)x;
		
		return id;
	}
	
	
	
}
