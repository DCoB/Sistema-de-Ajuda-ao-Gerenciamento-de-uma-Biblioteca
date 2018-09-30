package biblioteca.servicos;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import biblioteca.comparadores.AlunoNomeComparator;
import biblioteca.repositorios.*;
import biblioteca.servicos.basicas.Aluno;
import biblioteca.servicos.basicas.Livro;
import biblioteca.servicos.interfaces.IServicoAluno;

/**
 * Classe Responsável por Fazer Todas as Operações de Alunos e Deixas os Objetos de Alunos Prontos para ser Alterados no Banco
 * @version 2.0
 */
public class ServicoAluno implements IServicoAluno {
	
	
	private RepositorioAluno repA = new RepositorioAluno();
	private ServicoLog serLog = new ServicoLog();
	private RepositorioAuxiliar repAux = new RepositorioAuxiliar();
	private RepositorioLivro repL = new RepositorioLivro();
	private ServicoLivro servL = new ServicoLivro();
	private ServicoAuxiliar serAux = new ServicoAuxiliar();
	
	
	private Aluno aluno; //objeto que terá aluno responsável por utilizar o sistema
	private Livro[] livros;
	private int[] tipoLivro; //array que terá livros do aluno (Pegos, atrasados, histórico)
	private int [] idLivrosEmMaos;
	
	
	public ServicoAluno(Aluno a) {//sistema recebe um aluno para efetuar operações
		this.aluno=a;
		
		this.livros= this.aluno.getLivros();//recebe todos os livros do usuário
		tipoLivro = a.getTipoLivro(); //recebe a classificação de cada livro
		setIdLivrosEmMaos(aluno.getIdLivrosemMaos());
		
	
	}
	
	public ServicoAluno() {
		
	}
	
	

	public boolean cadastrarAluno(Aluno a) throws IOException
	{
		boolean disponivel = repA.checarLoginDisponivel(a.getLogin());
		
		if(disponivel == false)//CHECA SE O LOGIN ESTÁ DISPONÍVEL PARA O CADASTRO OU SE JÁ EXISTE UM LOGIN IGUAL
		{
			serLog.adicionarLogTemporario("Login Já Existente, Por favor Selecione outro Login !");
			
			return false;
		}
		else 
		{	
			try 
			{
				repAux = repAux.buscarArquivoAuxiliar();
				long x = repAux.getUltimoIdAlunoAdd();
		
				a.setIdPessoa(x);//PREENCHE O ID DO ARQUIVO QUE SERÁ ADICIONADO COM O ID DO ÚLTIMO ARQUIVO ADICINOADO NO BANCO +1
				a.setSenha(serAux.criptografarSenha(a.getSenha()));//FAZER A CRIPTOGRAFIA DA SENHA
				
				repA.adicionarAluno(a, x);//INVOCA O MÉTODO DE ADICIONAR ALUNO PELO REPOSITÓRIO
				
				//SALVA O LOG DE SUCESSO
				serLog.adicionarLog("Adicionado Aluno: " + a.getNome() +" ,de Matrícula: " + a.getMatricula() + " ,e de Id: " + a.getIdPessoa());
		
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
	}
	

	public boolean alterarAluno(Aluno a, long id) throws IOException
	{
		a.setIdPessoa(id);
		Aluno aluno1 = repA.buscarAlunoPorId(id);//BUSCAR O ALUNO COM AS INFORMAÇÕES ANTES DE SER EDITADO
		
		if(aluno1 == null || aluno1.getExcluido() == true)//CASO NÃO TENHA ENCONTRADO NENHUM ALUNO COM ESSE 'id' OU O ALUNO FOI EXCLUÍDO
		{		
			serLog.adicionarLogTemporario("Aluno Inexistente ou Inativo !");
			return false;
		}
		
		try
		{
			repA.editarAluno(id, a);//CHAMA O REPOSITÓRIO PARA A EDIÇÃO DO ALUNO
			
			String Log = "Aluno Editado, ";
			
			//PREENCHER O LOG COM A MENSAGEM CORRETA
			if(!a.getNome().equals(aluno1.getNome()))
			{
				Log += "de Nome: " + aluno1.getNome() + " para Nome: " + a.getNome() + " ";
			}
			if(!a.getCPF().equals(aluno1.getCPF()))
			{
				Log += "de CPF: " + aluno1.getCPF() + " para CPF: " + a.getCPF() + " ";
			}
			if(!a.getCurso().equals(aluno1.getCurso()))
			{
				Log += "de Curso: " + aluno1.getCurso() + " para Curso: " + a.getCurso() + " ";
			}
			if(Double.compare(a.getSaldoMultas(), aluno1.getSaldoMultas()) != 0)
			{	
				Log += "de Saldo das Multas: " + aluno1.getSaldoMultas() + " para Saldo das Multas: " + a.getSaldoMultas();
			}
			
			serLog.adicionarLog(Log);
		
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	

	public boolean deletarAluno(long id) throws IOException
	{
		Aluno a = new Aluno();
		try
		{
			a = repA.buscarAlunoPorId(id);
			if(a.getExcluido() == true||a == null)
			{
				serLog.adicionarLogTemporario("Aluno Inexistente ou Inativo !");
				return false;
			}
			a = repA.excluirAluno(a,id);
		}
		catch(Exception e)//ACONTECEU ALGUM ERRO DURANTE A EXCLUSÃO DA PESSOA NO BANCO
		{
			return false;
		}
		
		serLog.adicionarLog("Excluído Aluno: " + a.getNome() +" ,de Matrícula: " + a.getMatricula() + " ,e de Id: " + a.getIdPessoa());
	
		return true;
	}

	
	public Aluno[] listaAlunos() throws IOException
	{
		repAux = repAux.buscarArquivoAuxiliar();
		long x = repAux.getUltimoIdAluno();
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		List<Aluno> alunosF = new ArrayList<Aluno>();
		
		Object[] objeto = repA.listaBanco();//LISTA COM TODOS OS ARQUIVOS DO BANCO
		for(int y = 0 ; y <= x;y++)
		{
			alunos.add((Aluno)objeto[y]);
		}
			
		for(int y = 0 ; y < alunos.size();y++)
		{
			if(alunos.get(y).getExcluido() == false)
			{
				alunosF.add(alunos.get(y));
			}
			
		}
		
		Aluno[] alunosFiltrado =  new Aluno[alunosF.size()];
		for(int h = 0 ; h < alunosF.size();h++)
		{
			alunosFiltrado[h] = alunosF.get(h);
		}
		
		return alunosFiltrado;
	}
	
	public Aluno[] novosAlunos() throws IOException
	{
		Aluno[] a = listaAlunos();
		Aluno[] listaAlunos = new Aluno[4];
		
		listaAlunos[0] = a[a.length-1];
		listaAlunos[1] = a[a.length-2];
		listaAlunos[2] = a[a.length-3];
		listaAlunos[3] = a[a.length-4];
		
		return listaAlunos;
		
	}
	

	public void atualizarMultasGeral() throws IOException
	{
		setarTodosLivrosAtrasados();
		Livro livro = new Livro();
		RepositorioLivro l = new RepositorioLivro();
		
		
		Aluno[] aluno = listaAlunos();//recebimento de todos os alunos salvos no banco
		
		
		for(int y = 1; y < aluno.length;y++)
		{
			for(int r = 0; r < aluno[y].getTipoLivro().length;r++)
			{
				if(aluno[y].getTipoLivro()[r] == 2 || aluno[y].getTipoLivro()[r] != 0 )//Livro Atrasado
				{
					livro =  l.buscarLivroPorId(aluno[y].getLivros()[r].getIdLivro());
					int h = livro.getDiasRestantes();
					if(h < 0)
					{
						aluno[y].setSaldoMultas(aluno[y].getSaldoMultas() + 2*h);
						alterarAluno(aluno[y],aluno[y].getIdPessoa());
					}
				}
			}
		}
		
		/*for(int i = 0; i < 100;i++)
		{
			for(int r = 0; r < 3;r++)
			{
				if(aluno[i].getTipoLivro()[r] == 2)//Livro Atrasado
				{
					livro =  l.buscarLivroPorId(aluno[i].getLivros()[r].getIdLivro());
					int h = livro.getDiasRestantes();
					if(h < 0)
					{
						aluno[i].setSaldoMultas(aluno[i].getSaldoMultas() + 2*h);
						alterarAluno(aluno[i],aluno[i].getIdPessoa());
					}
				}
			}
		}*/
		
		serLog.adicionarLog("Multas de Todos os Alunos Atualizada com Sucesso !");
	}
	
	public void atualizarMultaAluno(String CPF) throws IOException
	{
		setarLivrosAlunoAtrasado(CPF);
		
		Aluno a = buscarAluno(CPF);
		Livro[] l = a.getLivros();
		int[] ver = a.getTipoLivro();
		Livro livro = new Livro();
		
		for(int x = 0; x < l.length;x++)
		{
			if(ver[x] == 2)//LIVRO ATRASADO
			{
				livro = servL.buscarLivroPorId(l[x].getIdLivro());
				a.setSaldoMultas( a.getSaldoMultas() + 2*livro.getDiasRestantes());
				alterarAluno(a, a.getIdPessoa());
			}
		}
	}
	
	public void setarTodosLivrosAtrasados() throws IOException
	{
		servL.atualizarAtrasos();
		
		Aluno[] a = listaAlunos();
		Livro livro = new Livro();
		Livro[] l = new Livro[100];
		int[] ver = new int[100];
		
		for(int x = 0 ; x < a.length;x++)
		{
			ver = a[x].getTipoLivro();
			l = a[x].getLivros();
			for(int y = 0; y < ver.length;y++)
			{
				if(ver[y] == 1)//LIVRO ESTÁ LOCADO
				{
					livro = servL.buscarLivroPorId(l[y].getIdLivro());
					if(livro.getDiasRestantes() < 0)
					{
						ver[y] = 2;						
					}
					a[x].setTipoLivro(ver);
					alterarAluno(a[x], a[x].getIdPessoa());
				}
			}
			
		}
	}
	
	public void setarLivrosAlunoAtrasado(String CPF) throws IOException
	{
		servL.atualizarAtrasos();
		
		Aluno a = buscarAluno(CPF);
		Livro[] l = a.getLivros();
		int[] ver = a.getTipoLivro();
		Livro livro = new Livro();
		
		for(int x = 0; x < l.length;x++)
		{
			if(ver[x] == 1)//LIVRO LOCADO
			{
				livro = servL.buscarLivroPorId(l[x].getIdLivro());
				if(livro.getDiasRestantes() < 0)
				{
					ver[x] = 2;
				}
				a.setTipoLivro(ver);
				alterarAluno(a, a.getIdPessoa());
			}			
		}				
	}
	

	public void avaliarLivro(Livro book, double nota) throws IOException {
		Livro l = new Livro();
		RepositorioLivro li = new RepositorioLivro();
		ServicoLivro servL = new ServicoLivro();
		
		l = li.buscarLivroPorId(book.getIdLivro());
		
		try 
		{
			if(l.getMediaAvaliacao() != 0.0)
			{
				l.setMediaAvaliacao((l.getMediaAvaliacao() + nota)/2);
			}
			else
			{
				l.setMediaAvaliacao(nota);
			}
		
			servL.alterarLivro(l, l.getIdLivro());
		}
		catch(Exception e)
		{
			serLog.adicionarLogTemporario("Problema Ao Avaliar Livro, Tente Novamente Mais Tarde !");
		}

	}
	

	public ArrayList<Aluno> organizaNome(boolean alfa) throws IOException
	{
		AlunoNomeComparator comp = new AlunoNomeComparator();
		Aluno[] alunos = listaAlunos();		
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		
		for(Aluno l : alunos)
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
	
	

	public Livro buscarLivroAluno(String titulo) throws IOException {
		//busca livro no inventário do aluno e retorna esse livro para manipulação
		
		Livro resultado=null;
		int i;
		
		for(i=0;i<livros.length;i++) {
			if(livros[i]==null)//pula livros nulos
				continue;
			if(livros[i].getTitulo().equalsIgnoreCase(titulo)) {//deve existir livro e título ser igual
				
					resultado=livros[i];
					serLog.adicionarLogTemporario("Livro Encontrado!");
					break;
			}
		}
		
		return resultado;
	}

	public boolean addLivroPerfil(long idPessoa,String titulo, long id) throws IOException {//OK 
		
		int i=0;
		boolean status=false;
		
		if(this.livrosPegos()==true) {//aluno ainda pode adicionar livro (no máximo 3)
			
			
			
			if(this.disponibilidadeLivro(titulo)!=null&&this.aluno.getSaldoMultas()==0) {//livro deve estar disponível e aluno sem multas
				
				for(i=0;i<livros.length;i++) {
					
					
					if(this.buscarLivroAluno(titulo)!=null&&this.tipoLivro[i]==3) {//verifica se aluno já possui livro no histórico
						
						
						livros[i] = this.disponibilidadeLivro(titulo);	//recebe livro
						livros[i].setDisponivel(false);	//livro fica indisponível
						livros[i].setDiasRestantes(7);	//dias restantes para devolver livro
						tipoLivro[i]=1;	//indica que livro foi pego
						
						
						
						this.repL.editarLivro(livros[i].getIdLivro(), livros[i]); //escreve alteração no banco de livros
						this.repA.editarAluno(aluno.getIdPessoa(), aluno); //escreve alteração no banco de aluno
						//Efeito de testes - irá ser implementado no log
						//System.out.println(aluno.getNome()+  "Livro adicionado:" + titulo);
						status=true;
						break;
					
					}else {
						
						serLog.adicionarLogTemporario(aluno.getNome()+"Livro já está adicionado" + titulo);
						serLog.adicionarLog(aluno.getNome()+"Livro já está adicionado" + titulo);
						status=false;
						
					}
					
					
					//adição de livro inédito para aluno
					if(this.buscarLivroAluno(titulo)==null&&tipoLivro[i]==0) {
						// livro não pode já estar adicionado
						//livro não pode estar locado ou atrasado, pode estar no histórico (ver condicional acima)
						
						
						livros[i] = this.disponibilidadeLivro(titulo);	//recebe livro
						livros[i].setDisponivel(false);	//livro fica indisponível
						livros[i].setDiasRestantes(7);	//dias restantes para devolver livro
						tipoLivro[i]=1;	//indica que livro foi pego
						
						
						this.repL.editarLivro(livros[i].getIdLivro(), livros[i]); //escreve alteração no banco de livros
						this.repA.editarAluno(aluno.getIdPessoa(), aluno); //escreve alteração no banco de aluno
						status=true;

						serLog.adicionarLogTemporario(this.aluno.getNome()+"Livro adicionado");
						serLog.adicionarLog(this.aluno.getNome()+"Livro adicionado");
						break;
					}else {

						serLog.adicionarLogTemporario(this.aluno.getNome()+"Livro já está adicionado.");
						serLog.adicionarLog(this.aluno.getNome()+"Livro já está adicionado.");

						status=false;
					}
				}
			}else {

				serLog.adicionarLogTemporario(this.aluno.getNome()+"Livro não disponível:" + titulo);
				serLog.adicionarLog(this.aluno.getNome()+"Livro não disponível:" + titulo);
				//System.out.println("Livro não disponível");
				status=false;
			}
			
		}else {

			serLog.adicionarLogTemporario(this.aluno.getNome()+"já tem 3 livros adicionados.");
			serLog.adicionarLog(this.aluno.getNome()+"já tem 3 livros adicionados.");
			status=false;
		}

		if(status==true) {
			serLog.adicionarLog(this.aluno.getNome()+": Alugou o Livro com sucesso:" + titulo);
			serLog.adicionarLogTemporario(this.aluno.getNome()+": Alugou o Livro com sucesso:" + titulo);
			
		}else {
			
			//serLog.adicionarLogTemporario(this.aluno.getNome()+"Não foi possível adicionar o livro:"+ titulo);

		}
		
		return status;
		
	}
	
	
	public int buscarClassificadorLivroAluno(String titulo) {// busca ID de onde livro está armazenado no array
			int resultado=0;
			int i;
			
			for(i=0;i<livros.length;i++) {
				if(livros[i]!=null) {
					if(livros[i].getTitulo().equals(titulo)) {
						resultado=i;
						break;
					}
				}
			}	
			return resultado;
		}
	

	public boolean devolverLivroPerfil(long idPessoa,String titulo, double nota,long id) throws IOException {//OK
		
		boolean status=false;

		for(int i=0;i<livros.length;i++) {
			if(livros[i]!=null) {
				if(livros[i].getTitulo().equals(titulo)) {
					
					if(tipoLivro[i]==1) {//livro não está atrasado
					
						livros[i].setDisponivel(true);
						livros[i].setDiasRestantes(0); //dias setados como 0, por padrão do sistema
						tipoLivro[i]=3;
						//this.avaliarLivro(livros[i], nota);
						
						//EM TESTES - IRÁ FICAR SOMENTE NO LOG
						//System.out.println("Livro entregue com sucesso");
						this.repL.editarLivro(livros[i].getIdLivro(), livros[i]); //escreve alteração no banco de livros
						this.repA.editarAluno(aluno.getIdPessoa(), aluno); //escreve alteração no banco de aluno
						
						serLog.adicionarLogTemporario(aluno.getNome() +": entregou o livro com sucesso:" + titulo);
						serLog.adicionarLog(aluno.getNome() +": entregou o livro com sucesso:" + titulo);
						status=true;
						break;
					
					}else if(tipoLivro[i]==2) {//livro atrasado
						
						
						this.repL.editarLivro(livros[i].getIdLivro(), livros[i]); //escreve alteração no banco de livros
						this.repA.editarAluno(aluno.getIdPessoa(), aluno); //escreve alteração no banco de aluno
						status=true;
						
					}else {
						serLog.adicionarLogTemporario(aluno.getNome() +": livro já foi entregue:" + titulo);
						serLog.adicionarLog(aluno.getNome() +": livro já foi entregue:" + titulo);
						status=false;
						break;
					}
				}
			}else {
				serLog.adicionarLogTemporario(aluno.getNome()+": teve problemas na entrega do livo. Tente novamente mais tarde:" + titulo);
				serLog.adicionarLog(aluno.getNome()+": teve problemas na entrega do livo. Tente novamente mais tarde:" + titulo);
				status=false;
				break;
			}
			
		}
		
		return status;
	}
	

	public boolean livrosPegos() {
		boolean resultado = false;
		
		int contador=0;
		
		for(int i=0; i<tipoLivro.length;i++) {//verifico todo o array que classifica os livros
			if(tipoLivro[i]==1||tipoLivro[i]==2) {//caso esteja pego o atrasado, usuário deve ter no máximo 3
				contador++;
			}
		}
		
		if(contador>=3) {//caso esteja pego o atrasado, usuário deve ter no máximo 3
			resultado=false;
		}else {
			resultado=true;
		}
		return resultado;	
	}
	
	
	public Livro disponibilidadeLivro(String titulo) throws IOException {
		int i=0;
		Livro[] busca = servL.buscarLivro(titulo);
		Livro resultado=null;
		
		if(busca!=null&&this.aluno.getSaldoMultas()==0) {//condição para aluno poder pegar o livro
			
			for(i=0;i<busca.length;i++) {
				
					if(busca[i].isDisponivel()==true) {//verifica se há algum livro disponível
						//irá desaparecer - efeito de testes
						
						//System.out.println("Livro disponível para locação.");
						resultado=busca[i];
						break;
					}
			}
		}
		
		if(resultado==null) {
			serLog.adicionarLogTemporario("Livro não disponível para locação:" + titulo);

		}else {
			serLog.adicionarLogTemporario("Livro disponível para locação:" + titulo);
		}
		return resultado;
	}


	
	public Livro[] buscaLivroPego() throws IOException {
		
		
		Livro[] resultadoBusca=null;
		
		//UTILIZAÇÃO DE ARRAY LIST EM VIRTUDE DE SUA PRATICIDADE À ALOCAÇÃO DE MEMÓRIA DINÂMICA
		
		ArrayList<Livro> livrosPegos = new ArrayList<Livro>();
		
		for(int i=0; i<livros.length;i++) {// percorre todos os livros do aluno
			if(tipoLivro[i]==1) {			//deseja filtrar apenas os livros pegos
				livrosPegos.add(livros[i]);	//adiciona ao array list 
			}
		}
		
		if(livrosPegos.size()!=0) { //verifica se a busca retornou algum livro
			resultadoBusca = (Livro[]) livrosPegos.toArray(new Livro[livrosPegos.size()]); //"converte" arraylist em um novo array
			
		}
		 return resultadoBusca; //retorna lista com livrosPegos do aluno
	}




	public Livro[] buscaLivroAtrasado() {
	Livro[] resultadoBusca=null;
	
	//UTILIZAÇÃO DE ARRAY LIST EM VIRTUDE DE SUA PRATICIDADE À ALOCAÇÃO DE MEMÓRIA DINÂMICA
	
	ArrayList<Livro> livrosAtrasados = new ArrayList<Livro>();
	
	for(int i=0; i<livros.length;i++) {// percorre todos os livros do aluno
		if(tipoLivro[i]==2) {			//deseja filtrar apenas os livros atrasados
			livrosAtrasados.add(livros[i]);	//adiciona ao array list 
		}
	}
	
	if(livrosAtrasados.size()!=0) { //verifica se a busca retornou algum livro
		resultadoBusca = (Livro[]) livrosAtrasados.toArray(new Livro[livrosAtrasados.size()]); //"converte" arraylist em um novo array
		
	}
	 return resultadoBusca; //retorna lista com livrosAtrasados do aluno
	
}




	public Livro[] buscaLivroHistorico() {
	Livro[] resultadoBusca=null;
	
	//UTILIZAÇÃO DE ARRAY LIST EM VIRTUDE DE SUA PRATICIDADE À ALOCAÇÃO DE MEMÓRIA DINÂMICA
	
	ArrayList<Livro> livrosHistorico = new ArrayList<Livro>();
	
	for(int i=0; i<livros.length;i++) {// percorre todos os livros do aluno
		if(tipoLivro[i]==3) {			//deseja filtrar apenas os livros no historico
			livrosHistorico.add(livros[i]);	//adiciona ao array list 
		}
	}
	
	if(livrosHistorico.size()!=0) { //verifica se a busca retornou algum livro
		resultadoBusca = (Livro[]) livrosHistorico.toArray(new Livro[livrosHistorico.size()]); //"converte" arraylist em um novo array
		
	}
	 return resultadoBusca; //retorna lista com livrosHistorico do aluno
}
	
	
	public Aluno buscarAluno(String dadoInformado) throws IOException 
	{
		
		
		Aluno[] alunos = this.listaAlunos();
		Aluno resultadoBusca=null;
		
		
		for(int i=0; i<alunos.length;i++) {//a busca pode ser feita informando nome ou cpf
			if(alunos[i].getNome().equalsIgnoreCase(dadoInformado)||alunos[i].getCPF().equals(dadoInformado)) {
				resultadoBusca = alunos[i];
			}
		}
		 
		 return resultadoBusca;
			
	}
	
	public Aluno BuscarAlunoIniciais(String dadoInformado) throws IOException
	{
		Aluno[] alunos = this.listaAlunos();
		Aluno resultadoBusca=null;
			
		dadoInformado = Normalizer.normalize(dadoInformado, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
		
		for(int i=0; i<alunos.length;i++) {
			String nome = alunos[i].getNome();
			nome = Normalizer.normalize(nome, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
						
			if(nome.indexOf(dadoInformado) >= 0||alunos[i].getCPF().equals(dadoInformado)) {
				resultadoBusca = alunos[i];
			}
		}

		 return resultadoBusca;
	}
	
	public void pagarTodasMultas(String CPF) throws IOException
	{
		Aluno a = buscarAluno(CPF);
		
		a.setSaldoMultas(0);
		alterarAluno(a, a.getIdPessoa());
	}
	
	public void arquivosBasicos() throws IOException
	{
		//PRIMEIRO ALUNO(A)
		Aluno aluno = new Aluno("Carlos Emanoel de Andrade", "CaAndrade", "cavalo123", 12345642, "423-632-341-53", "Engenharia Civil","");
		cadastrarAluno(aluno);
		
		
		//SEGUNDO ALUNO(A)
		aluno.setNome("José Pereira Júnior");
		aluno.setLogin("JuninP");
		aluno.setSenha("sapo123");
		aluno.setMatricula(54323453);
		aluno.setCPF("534-256-541-76");
		aluno.setCurso("Engenharia Elétrica");
		aluno.setSex("Masculino");
		cadastrarAluno(aluno);
		
		//TERCEIRO ALUNO(A)
		aluno.setNome("Emily Jordão da Silva");
		aluno.setLogin("ESilva");
		aluno.setSenha("cachorro123");
		aluno.setMatricula(53412345);
		aluno.setCPF("987-462-364-81");
		aluno.setCurso("Engenharia da Computação");
		aluno.setSex("Masculino");
		cadastrarAluno(aluno);
		
		//QUARTO ALUNO(A)
		aluno.setNome("Victor da Mota Cruz");
		aluno.setLogin("VictorCruz");
		aluno.setSenha("elefante123");
		aluno.setMatricula(13745623);
		aluno.setCPF("754-823-423-42");
		aluno.setCurso("Engenharia de Telecomunicações");
		aluno.setSex("Feminino");
		cadastrarAluno(aluno);
	}
	
	public int criaMatricula() throws IOException {
		
		Random geraMatricula = new Random();
		int resultado= geraMatricula.nextInt(100000000);
		return resultado;
		
	}

	public int [] getIdLivrosEmMaos() {
		return idLivrosEmMaos;
	}

	public void setIdLivrosEmMaos(int [] idLivrosEmMaos) {
		this.idLivrosEmMaos = idLivrosEmMaos;
	}

}
