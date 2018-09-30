package biblioteca.controllers.cadastros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import biblioteca.exceptions.ErroOperacaoException;
import biblioteca.servicos.ServicoLivro;
import biblioteca.servicos.ServicoLog;
import biblioteca.servicos.basicas.Livro;
import biblioteca.views.cadastro.livro.ViewListaLivros;

public class ControllerListaLivros extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Livro> dados = new ArrayList<>();
	private String[] colunas = {"IdLivro","Título","Autor","Ano","Gênero","Nota","Disponibilidade"};
	private static Object[] options = {"Sim","Não",};
	private ServicoLog servLog = new ServicoLog();
	private ServicoLivro servL = new ServicoLivro();
	
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
				return dados.get(linha).getIdLivro();
			case 1: 
				return dados.get(linha).getTitulo();
			case 2 :
				return dados.get(linha).getAutor();
			case 3 :
				return dados.get(linha).getAno();
			case 4 :
				return dados.get(linha).getGenero();
			case 5 :
				return dados.get(linha).getMediaAvaliacao();
			case 6 :
					if(dados.get(linha).isDisponivel() == true)
					{
						return "Disponível";
					}
					else
					{
						return "Indiponível";
					}
		
		}
		
		return null;
	}
	
	public AbstractTableModel buscarTitulo(String titulo) throws IOException
	{

		if(!titulo.equals(""))
		{
			Livro[] l = servL.buscarLivrosInciais(titulo);
			
			dados.clear();
			if(l != null)
			{
				for(int y = 0; y < l.length ; y++)
				{
					this.dados.add(l[y]);
				}
			}
		}
		else
		{
			atualizarListaLivros();
		}
		
		return this;
	}
	
	public void listaLivro(JFrame window) throws IOException
	{
		window.dispose();
		
		atualizarListaLivros();
		
		ViewListaLivros viewL = new ViewListaLivros(this);
		
		viewL.setLocationRelativeTo(null);//exibição de janela centralizada
		viewL.setVisible(true);
		
	}
	
	public void chamarTelaEditarLivro(int linha) throws IOException, ErroOperacaoException
	{	
		//atualizarListaLivros();
		
		Object x = getValueAt(linha, 0);
		long id = (long)x;
		
		Livro livro = servL.buscarLivroPorId(id);
		
		ControllerEditarLivro.iniciaTelaEdicaoLivro(livro);
		
	}
	
	public void chamarTelaPefilLivro(int linha,JFrame window) throws IOException
	{
		Object x = getValueAt(linha, 0);
		long id = (long)x;
		
		ControllerPerfilLivro cp = new ControllerPerfilLivro();
		
		cp.iniciarTelaPerfilLivro(id, window);
	}
	
	public void atualizarListaLivros() throws IOException
	{
		Livro[] listaLivros = servL.listaLivros();
		this.dados.clear();
		for(int x = 0; x < listaLivros.length; x++)
		{
			this.dados.add(listaLivros[x]);
		}
	}
	
	public AbstractTableModel deletarLivro(int linha,JFrame frame) throws IOException
	{
		atualizarListaLivros();
		
		Object x = getValueAt(linha, 0);
		long id = (long)x;
		
		if(servL.deletarLivro(id) == true)
		{
			JOptionPane.showOptionDialog(frame,"Tem Certeza que Deseja Deletar esse Livro ?" ,"Confirmação de Exclusão", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
			JOptionPane.showMessageDialog(frame,servLog.UltimoLog(),"Livro Excluído com Sucesso",JOptionPane.WARNING_MESSAGE);
			
			atualizarListaLivros();
		}
		else
		{
			JOptionPane.showMessageDialog(frame,"Ocorreu Algum Problema na Exclusão desse Livro","Aviso",JOptionPane.WARNING_MESSAGE);
		}
		
		
		return this;
	}
	
	public AbstractTableModel listaOraganizadaAlfa(boolean i) throws IOException
	{
		this.dados = servL.organizaTitulo(i);
		
		return this;
	}
	
	public AbstractTableModel listaOrganizaNota(boolean i) throws IOException
	{
		this.dados = servL.organizaNota(i);
		
		return this;
	}
	
	public long buscarIdLivroSelecionado(int linha) throws IOException
	{
		atualizarListaLivros();
		
		Object x = getValueAt(linha, 0);
		long id = (long)x;
		
		return id;
	}
	
	

}
