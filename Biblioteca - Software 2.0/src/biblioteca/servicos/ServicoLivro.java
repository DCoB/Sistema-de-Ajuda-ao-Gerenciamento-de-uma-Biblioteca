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
* Classe Responsável por Fazer Todas as Operações de Livros e Deixas os Objetos de Livros 
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
			
			l.setIdLivro(x);//PREENCHE O ID DO ARQUIVO QUE SERÁ ADICIONADO COM O ID DO ÚLTIMO ARQUIVO ADICINOADO NO BANCO +1
			
			repL.adicionarLivro(l, x);//INVOCA O MÉTODO DE ADICIONAR ALUNO PELO REPOSITÓRIO
			
			
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
		Livro livro1 = repL.buscarLivroPorId(id);//BUSCAR O LIVRO COM AS INFORMAÇÕES ANTES DE SER EDITADO
		
		if(livro1 == null || livro1.getExcluido() == true)//CASO NÃO TENHA ENCONTRADO NENHUM ALUNO COM ESSE 'id' OU O ALUNO FOI EXCLUÍDO
		{
			serLog.adicionarLogTemporario("Livro Inexistente ou Inativo !");
			return false;
		}
		
		try
		{
			repL.editarLivro(id, l);//CHAMA O REPOSITÓRIO PARA A EDIÇÃO DO LIVRO
			
			String Log = "Livro Editado, ";
			
			//PREENCHER O LOG COM A MENSAGEM CORRETA
			if(!l.getTitulo().equals(livro1.getTitulo()))
			{
				Log += "de Título: " + livro1.getTitulo() + " para Título: " + l.getTitulo() + " ";
			}
			if(!l.getAutor().equals(livro1.getAutor()))
			{
				Log += "de Autor: " + livro1.getAutor() + " para Autor: " + l.getAutor() + " ";
			}
			if(!l.getGenero().equals(livro1.getGenero()))
			{
				Log += "de Gênero: " + livro1.getGenero() + " para Gênero: " + l.getGenero() + " ";
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
				Log += "de Avaliação Média: " + livro1.getMediaAvaliacao() + " para Avaliação Média: "
				+ l.getMediaAvaliacao() + " ";
			}
			if(l.getExcluido() != livro1.getExcluido())
			{
				if(l.getExcluido() == true)
				{
					Log += "de Livro NÃO Disponível para Livro Disponível ! ";
				}
				else
				{
					Log += "de Livro Disponível para Livro NÃO Disponível ! ";
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
		
		serLog.adicionarLog("Excluído Livro: " + l.getTitulo() +" ,de Autor: " + l.getAutor() + " ,e de Id: " + l.getIdLivro());
		
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
			livrosFiltrado[h] = livrosF.get(h);//PREENCHENDO A LISTA DE FUNCIONÁRIOS COM A LISTA DOS ARQUIVOS DO BANCO
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
		for (int i = 1; i < repAux.getUltimoIdLivro() + 1; i++)//NÚMEROS ENTRE 1 E O ÚLTIMO ID ADICIONADO
		{ 
		    numeros.add(i);
		}
		
		Collections.shuffle(numeros);//EMBARALHAR OS NÚMEROS
		
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
	
	public void arquivosBásicos() throws IOException
	{
		//PRIMEIRO LIVRO
		Livro l  = new Livro("Engenharia de Software", "Pressman, Roger S", "Computação", "Com mais de três décadas de "
				+ "liderança de mercado, Engenharia de Software chega à sua 8ª edição como o mais abrangente guia "
				+ "sobre essa importante área. Totalmente revisada e reestruturada, esta nova edição foi amplamente "
				+ "atualizada para incluir os novos tópicos da “engenharia do século 21”. Capítulos inéditos abordam a "
				+ "segurança de software e os desafios específicos ao desenvolvimento para aplicativos móveis. "
				+ "Conteúdos novos também foram incluídos em capítulos existentes, e caixas de texto informativas e "
				+ "conteúdos auxiliares foram expandidos, deixando este guia ainda mais prático para uso em sala de aula "
				+ "e em estudos autodida tas.", 2016);
		cadastrarLivro(l);
		
		
		//SEGUNDO LIVRO
		l.setTitulo("Métodos Numéricos Aplicados com Matlab para Engenheiros e Cientistas");
		l.setAutor("Chapra,Steven C.");
		l.setGenero("Computação");
		l.setSinopse("Steven Chapra, um dos autores mais conhecidos no ensino de métodos numéricos, "
				+ "oferece nesta nova edição, e de maneira didática, reformulações importantes para "
				+ "o aprendizado e a aplicação do MATLAB® na resolução de problemas em engenharia e "
				+ "métodos científicos. Trata-se de um livro rico em aplicações, com linguagem fácil para"
				+ " um estudo independente e atualizações significativas para estudantes iniciantes.");
		l.setAno(2013);
		cadastrarLivro(l);
		
		
		//TERCEIRO LIVRO
		l.setTitulo("Concreto Armado - Eu Te Amo Vol.1");
		l.setAutor("Botelho,Manoel/ Marchetti, Osvaldemar");
		l.setGenero("Civil");
		l.setSinopse("Este livro foi desenvolvido para estudantes de engenharia civil, arquitetura, "
				+ "tecnólogos e profissionais da construção em geral. Trata-se de um ABC explicativo, "
				+ "didático e prático no mundo do concreto armado e tem aplicação prática atuante em construções "
				+ "de até 4 andares, ou seja, praticamente 90% das edificações brasileiras.");
		l.setAno(2015);
		cadastrarLivro(l);
		
		
		//QUARTO LIVRO
		l.setTitulo("Direito Civil - Direito das Coisas - Col. Sinopses Jurídicas");
		l.setAutor("Carlos Roberto Gonçalves");
		l.setGenero("Direito");
		l.setSinopse("Apresentar, numa abordagem concisa e objetiva, os institutos que compõem os vários "
				+ "ramos do direito, abrangendo, em volumes específicos para cada disciplina, o conteúdo "
				+ "necessário a uma eficiente revisão do programa dos principais concursos na área jurídica, "
				+ "ou mesmo uma introdução às matérias curriculares. É este, pois, o objetivo desta "
				+ "Coleção: constituir-se em ferramenta hábil ao concursando e ao recém-ingresso nas "
				+ "carreiras jurídicas, como fonte de consulta rápida, coesa, de fácil assimilação e com "
				+ "farto conteúdo. Ao estudante, em seus primeiros contatos com a matéria, as Sinopses se "
				+ "fazem, igualmente, de indiscutível utilidade, proporcionando uma visão geral apta a "
				+ "norteá-lo em seus estudos futuros e, ao mesmo tempo, específica o sufi ciente para "
				+ "propiciar a compreensão imediata dos tópicos tratados. Para manter seu caráter "
				+ "sintético, sem abrir mão da necessária qualidade doutrinária, a Coleção foi organizada "
				+ "no sentido de aliar o máximo de conteúdo ao máximo de praticidade. Assim, foram "
				+ "selecionados autores com vasta experiência no magistério superior e em cursos "
				+ "preparatórios para ingresso nas carreiras jurídicas, além de larga vivência no cotidiano "					
				+ "forense e familiaridade com o trabalho acadêmico de pesquisa e desenvolvimento "
				+ "científico do direito.");
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