package biblioteca.servicos;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import biblioteca.comparadores.LivroNotaComparator;
import biblioteca.comparadores.LivroTituloComparator;
import biblioteca.repositorios.*;
import biblioteca.servicos.basicas.Livro;
import biblioteca.servicos.interfaces.IServicoLivro;

/**
* Classe Respons�vel por Fazer Todas as Opera��es de Livros e Deixas os Objetos de Livros 
* Prontos para ser Alterados no Banco
* @version 1.0
*/
public class ServicoLivro implements IServicoLivro {
	private RepositorioLivro repL = new RepositorioLivro();
	private ServicoLog serLog = new ServicoLog();
	private RepositorioAuxiliar repAux = new RepositorioAuxiliar();
	private ServicoAuxiliar serAux = new ServicoAuxiliar();
	private Livro[] livrosFiltrados;
	

	public boolean cadastrarLivro(Livro l) throws IOException
	{
		try
		{
			repAux = repAux.buscarArquivoAuxiliar();
			long x = repAux.getUltimoIdLivroAdd();
			
			l.setIdLivro(x);//PREENCHE O ID DO ARQUIVO QUE SER� ADICIONADO COM O ID DO �LTIMO ARQUIVO ADICINOADO NO BANCO +1
			
			repL.adicionarLivro(l, x);//INVOCA O M�TODO DE ADICIONAR ALUNO PELO REPOSIT�RIO
			
			
			//SALVA O LOG DE SUCESSO
			serLog.adicionarLog("Adicionado Livro: " + l.getTitulo() + " ,de Autor: " + l.getAutor()
			+ " ,do Ano de: " + l.getAno());
			
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}
	

	public boolean alterarLivro(Livro l,long id) throws IOException
	{
		l.setIdLivro(id);
		Livro livro1 = repL.buscarLivroPorId(id);//BUSCAR O LIVRO COM AS INFORMA��ES ANTES DE SER EDITADO
		
		if(livro1 == null || livro1.getExcluido() == true)//CASO N�O TENHA ENCONTRADO NENHUM ALUNO COM ESSE 'id' OU O ALUNO FOI EXCLU�DO
		{
			serLog.adicionarLogTemporario("Livro Inexistente ou Inativo !");
			return false;
		}
		
		try
		{
			repL.editarLivro(id, l);//CHAMA O REPOSIT�RIO PARA A EDI��O DO LIVRO
			
			String Log = "Livro Editado, ";
			
			//PREENCHER O LOG COM A MENSAGEM CORRETA
			if(!l.getTitulo().equals(livro1.getTitulo()))
			{
				Log += "de T�tulo: " + livro1.getTitulo() + " para T�tulo: " + l.getTitulo() + " ";
			}
			if(!l.getAutor().equals(livro1.getAutor()))
			{
				Log += "de Autor: " + livro1.getAutor() + " para Autor: " + l.getAutor() + " ";
			}
			if(!l.getGenero().equals(livro1.getGenero()))
			{
				Log += "de G�nero: " + livro1.getGenero() + " para G�nero: " + l.getGenero() + " ";
			}
			if(l.getAno() != livro1.getAno())
			{
				Log += "de Ano: " + livro1.getAno() + " para Ano: " + l.getAno() + " ";
			}
			if(!l.getSinopse().equals(livro1.getSinopse()))
			{
				Log += "de Sinopse: " + livro1.getSinopse() + " para Sinopse: " + l.getSinopse() + " ";
			}
			if(Double.compare(l.getMediaAvaliacao(),livro1.getMediaAvaliacao()) != 0)
			{
				Log += "de Avalia��o M�dia: " + livro1.getMediaAvaliacao() + " para Avalia��o M�dia: "
				+ l.getMediaAvaliacao() + " ";
			}
			if(l.getExcluido() != livro1.getExcluido())
			{
				if(l.getExcluido() == true)
				{
					Log += "de Livro N�O Dispon�vel para Livro Dispon�vel ! ";
				}
				else
				{
					Log += "de Livro Dispon�vel para Livro N�O Dispon�vel ! ";
				}
			}
			if(l.getDiasRestantes() != livro1.getDiasRestantes())
			{
				Log += "de Dias Restantes para a Entrega: " + livro1.getDiasRestantes() + " para Dias"
						+ " Restantes para a Entrega: " + l.getDiasRestantes();
			}
			
			serLog.adicionarLog(Log);
			
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	

	public boolean deletarLivro(long id) throws IOException
	{
		Livro l = new Livro();
		try
		{
			l = repL.buscarLivroPorId(id);
			if(l.getExcluido() == true || l == null)
			{
				serLog.adicionarLogTemporario("Livro Inexistente ou Inativo !");
				return false;
			}
			l = repL.excluirLivro(l, id);
		}
		catch(Exception e)
		{
			return false;
		}
		
		serLog.adicionarLog("Exclu�do Livro: " + l.getTitulo() +" ,de Autor: " + l.getAutor() + " ,e de Id: " + l.getIdLivro());
		
		return true;
		
	}
	

	public Livro[] listaLivros() throws IOException
	{
		repAux = repAux.buscarArquivoAuxiliar();
		long x = repAux.getUltimoIdLivro();
		
		
		List<Livro> livros = new ArrayList<Livro>();
		List<Livro> livrosF = new ArrayList<Livro>();
		Object[] objeto = repL.listaBanco();//LISTA COM TODOS OS ARQUIVOS DO BANCO
		for(int y = 0 ; y <= x;y++)
		{
			livros.add((Livro)objeto[y]);
		}
		
		for(int y = 0 ; y < livros.size();y++)
		{
			if(livros.get(y).getExcluido() == false)
			{
				livrosF.add(livros.get(y));				
			}			
		}
		
		Livro[] livrosFiltrado = new Livro[livrosF.size()];
		for(int h = 0; h < livrosF.size();h++)
		{
			livrosFiltrado[h] = livrosF.get(h);//PREENCHENDO A LISTA DE FUNCION�RIOS COM A LISTA DOS ARQUIVOS DO BANCO
		}
		
		return livrosFiltrado;
	}
	

	public Livro[] ultimosLivros() throws IOException
	{
		repAux = repAux.buscarArquivoAuxiliar();
		int x = (int) repAux.getUltimoIdLivro();
		
		Livro[] livros = new Livro[4];
		setLivrosFiltrados(new Livro[4]);
		Object[] objeto = repL.listaBanco();//LISTA COM TODOS OS ARQUIVOS DO BANCO
			
		for(int y = 0 ; y < 4;y++)
		{
			livros[y] = (Livro)objeto[x-y];
		}	
		return livros;
	}
	

	public Livro[] recomendaLivros() throws IOException
	{
		Livro[] livros = new Livro[4];
		repAux = repAux.buscarArquivoAuxiliar();
		
		List<Integer> numeros = new ArrayList<Integer>();
		for (int i = 1; i < repAux.getUltimoIdLivro() + 1; i++)//N�MEROS ENTRE 1 E O �LTIMO ID ADICIONADO
		{ 
		    numeros.add(i);
		}
		
		Collections.shuffle(numeros);//EMBARALHAR OS N�MEROS
		
		for (int i = 0; i < 4; i++)//PREENCHER OS 4 LIVROS 
		{
		   livros[i] = repL.buscarLivroPorId(numeros.get(i));
		}
		
		return livros;
	}
	

	public ArrayList<Livro> organizaTitulo(boolean alfa) throws IOException
	{
		LivroTituloComparator comp = new LivroTituloComparator();
		Livro[] livros = listaLivros();		
		ArrayList<Livro> lista = new ArrayList<Livro>();
		
		for(Livro l : livros)
		{
			lista.add(l);
		}
		
		Collections.sort(lista, comp);
		
		if(alfa == true) 
		{
			Collections.reverse(lista);
		}	
		
		return lista;
	}
	

	public ArrayList<Livro> organizaNota(boolean cresc) throws IOException
	{
		LivroNotaComparator comp = new LivroNotaComparator();
		Livro[] livros = listaLivros();		
		ArrayList<Livro> lista = new ArrayList<Livro>();
		
		for(Livro l : livros)
		{
			lista.add(l);
		}
		
		Collections.sort(lista, comp);
		
		if(cresc == true)
		{
			Collections.reverse(lista);
		}
		
		return lista;
	}
	
	public Livro buscarLivroPorId(long id)throws IOException
	{
		Livro l = new Livro();
		
		l = (Livro)this.repL.buscarArquivoPorId(id);
		
		return l;
	}
	

	public Livro[] buscarLivro(String titulo) throws IOException 
	{
		Livro[] livros = this.listaLivros();
		
		for(int i = 0 ; i<livros.length;i++) {
			livros[i]= buscarLivroPorId(i);
		}
		
		List<Livro> livrosBanco = Arrays.asList(livros);
		
		 List<Livro> tempLivros = livrosBanco.stream()
			        .filter((Livro l) -> serAux.deAccent(l.getTitulo().toUpperCase()).equals(serAux.deAccent(titulo.toUpperCase())))
			        .collect(Collectors.toList());
		 
		 Livro[] resultadoBusca=null;
		 
		 if(tempLivros.size()!=0) {
			 resultadoBusca = (Livro[]) tempLivros.toArray(new Livro[tempLivros.size()]);
		 }
		 
		 return resultadoBusca;
			
	}
	
	public Livro[] buscarLivrosInciais(String Titulo) throws IOException
	{
		Livro[] livros = this.listaLivros();
		
		ArrayList<Livro> listaLivros = new ArrayList<Livro>();
		
		Titulo = Normalizer.normalize(Titulo, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
		
		for(int x = 0; x < livros.length;x++)
		{
			String Titulo1 = livros[x].getTitulo();
			Titulo1 = Normalizer.normalize(Titulo1, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
						
			if(Titulo1.indexOf(Titulo) >= 0) {
				listaLivros.add(livros[x]);
			}
		}
		
		Livro[] resultadoBusca = new Livro[listaLivros.size()];
		for(int y = 0; y < listaLivros.size(); y++)
		{
			resultadoBusca[y] = listaLivros.get(y);
		}
		
		return resultadoBusca;
		
	}
	
	
	public void atualizarAtrasos() throws IOException
	{
		
		int x = repAux.diferencaDiasDatas();
		
		Livro[] livros = listaLivros();
		
		for(int y = 0; y < livros.length; y++)
		{
			if(livros[y].isDisponivel() == false && x !=0)
			{
				livros[y].setDiasRestantes(livros[y].getDiasRestantes() - x);
				
				alterarLivro(livros[y], livros[y].getIdLivro());
			}
		}
		
	}
	
	public void adicionarCritica(String critica,Livro l) throws IOException
	{
		ArrayList<String> listaCriticas = new ArrayList<String>();
		if(l.getCriticas() != null)
		{
			listaCriticas = l.getCriticas();
		}
		listaCriticas.add(critica);
		l.setCriticas(listaCriticas);
		
		alterarLivro(l, l.getIdLivro());
	}
	
	public void arquivosB�sicos() throws IOException
	{
		//PRIMEIRO LIVRO
		Livro l  = new Livro("Engenharia de Software", "Pressman, Roger S", "Computa��o", "Com mais de tr�s d�cadas de "
				+ "lideran�a de mercado, Engenharia de Software chega � sua 8� edi��o como o mais abrangente guia "
				+ "sobre essa importante �rea. Totalmente revisada e reestruturada, esta nova edi��o foi amplamente "
				+ "atualizada para incluir os novos t�picos da �engenharia do s�culo 21�. Cap�tulos in�ditos abordam a "
				+ "seguran�a de software e os desafios espec�ficos ao desenvolvimento para aplicativos m�veis. "
				+ "Conte�dos novos tamb�m foram inclu�dos em cap�tulos existentes, e caixas de texto informativas e "
				+ "conte�dos auxiliares foram expandidos, deixando este guia ainda mais pr�tico para uso em sala de aula "
				+ "e em estudos autodida tas.", 2016);
		cadastrarLivro(l);
		
		
		//SEGUNDO LIVRO
		l.setTitulo("M�todos Num�ricos Aplicados com Matlab para Engenheiros e Cientistas");
		l.setAutor("Chapra,Steven C.");
		l.setGenero("Computa��o");
		l.setSinopse("Steven Chapra, um dos autores mais conhecidos no ensino de m�todos num�ricos, "
				+ "oferece nesta nova edi��o, e de maneira did�tica, reformula��es importantes para "
				+ "o aprendizado e a aplica��o do MATLAB� na resolu��o de problemas em engenharia e "
				+ "m�todos cient�ficos. Trata-se de um livro rico em aplica��es, com linguagem f�cil para"
				+ " um estudo independente e atualiza��es significativas para estudantes iniciantes.");
		l.setAno(2013);
		cadastrarLivro(l);
		
		
		//TERCEIRO LIVRO
		l.setTitulo("Concreto Armado - Eu Te Amo Vol.1");
		l.setAutor("Botelho,Manoel/ Marchetti, Osvaldemar");
		l.setGenero("Civil");
		l.setSinopse("Este livro foi desenvolvido para estudantes de engenharia civil, arquitetura, "
				+ "tecn�logos e profissionais da constru��o em geral. Trata-se de um ABC explicativo, "
				+ "did�tico e pr�tico no mundo do concreto armado e tem aplica��o pr�tica atuante em constru��es "
				+ "de at� 4 andares, ou seja, praticamente 90% das edifica��es brasileiras.");
		l.setAno(2015);
		cadastrarLivro(l);
		
		
		//QUARTO LIVRO
		l.setTitulo("Direito Civil - Direito das Coisas - Col. Sinopses Jur�dicas");
		l.setAutor("Carlos Roberto Gon�alves");
		l.setGenero("Direito");
		l.setSinopse("Apresentar, numa abordagem concisa e objetiva, os institutos que comp�em os v�rios "
				+ "ramos do direito, abrangendo, em volumes espec�ficos para cada disciplina, o conte�do "
				+ "necess�rio a uma eficiente revis�o do programa dos principais concursos na �rea jur�dica, "
				+ "ou mesmo uma introdu��o �s mat�rias curriculares. � este, pois, o objetivo desta "
				+ "Cole��o: constituir-se em ferramenta h�bil ao concursando e ao rec�m-ingresso nas "
				+ "carreiras jur�dicas, como fonte de consulta r�pida, coesa, de f�cil assimila��o e com "
				+ "farto conte�do. Ao estudante, em seus primeiros contatos com a mat�ria, as Sinopses se "
				+ "fazem, igualmente, de indiscut�vel utilidade, proporcionando uma vis�o geral apta a "
				+ "norte�-lo em seus estudos futuros e, ao mesmo tempo, espec�fica o sufi ciente para "
				+ "propiciar a compreens�o imediata dos t�picos tratados. Para manter seu car�ter "
				+ "sint�tico, sem abrir m�o da necess�ria qualidade doutrin�ria, a Cole��o foi organizada "
				+ "no sentido de aliar o m�ximo de conte�do ao m�ximo de praticidade. Assim, foram "
				+ "selecionados autores com vasta experi�ncia no magist�rio superior e em cursos "
				+ "preparat�rios para ingresso nas carreiras jur�dicas, al�m de larga viv�ncia no cotidiano "					
				+ "forense e familiaridade com o trabalho acad�mico de pesquisa e desenvolvimento "
				+ "cient�fico do direito.");
		l.setAno(2018);
		cadastrarLivro(l);
	}


	public Livro[] getLivrosFiltrados() {
		return livrosFiltrados;
	}


	public void setLivrosFiltrados(Livro[] livrosFiltrados) {
		this.livrosFiltrados = livrosFiltrados;
	}
	
		
	}