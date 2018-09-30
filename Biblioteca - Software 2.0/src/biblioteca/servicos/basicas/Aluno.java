package biblioteca.servicos.basicas;

/**
 * Classe que Contém Todos os Atributos Básicos de Todas os Alunos
 * @version 2.0
 * @param matricula = Matrícula do Aluno
 * @param curso = Curso do Aluno
 * @param idLivrosemMaos[3] = Lista dos ids dos Livros que Estão na Mão do Aluno(MAX 3 Livros). Se Não Tiver Livro id = '0'
 * @param livros[100] = Lista de Livros que Estão Registrados no Banco
 * @param classificaLivro = Variável que Ordena se o Livro Está Pego, Atrasado ou no Histórico
 * @param saldoMultas = Salto Total das Multas do Aluno
 */
public class Aluno extends Pessoa{
	
	private static final long serialVersionUID = 1L;
	private int matricula;
	private String curso;
	private int[] idLivrosemMaos = new int[3];
	private Livro[] livros = new Livro[100]; //espaço onde aluno terá seus livros
	private int[] tipoLivro = new int[100]; //atua em conjunto com o atributo livros, informando se ele está pego, atrasado ou no histórico
	private double saldoMultas;
	
	
	/**
	 * Construtor com Todos os Atributos da Classe Básica 'Pessoa' Definidos
	 * @param nome = Nome Completo do Aluno
	 * @param login = Login do Aluno
	 * @param senha = Senha do Aluno
	 * @param matricula = Matrícula do Aluno
	 * @param cpf = CPF do Aluno
	 */
	public Aluno(String nome, String login, String senha,int matricula,String cpf, String curso, String sex) {
		super(nome, login, senha,cpf,2, sex);
		this.matricula=matricula;
		this.curso = curso;		
	}
	
	//para o banco
	public Aluno(String nome, String login, String senha,int matricula,String cpf) {
		super(nome, login, senha,cpf,2,"");
		this.matricula=matricula;
		this.curso ="" ;
		
		/*for(int x = 0; x < 3;x++)
		{
			this.idLivrosemMaos[x] = 0;
		}*/	
	}
	

	
	/**
	 * Construtor Usado Somente para a Criação de Objetos para a Chamada de Métodos
	 */
	public Aluno () {
		super("","","","",2,"");
		/*for(int x = 0; x < 3;x++)
		{
			this.idLivrosemMaos[x] = 0;
		}*/
		
	}

	
	//Getters e Setters
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}		

	

	public Livro[] getLivros() {
		return livros;
	}

	public void setLivros(Livro[] livros) {
		this.livros = livros;
	}

	public int[] getTipoLivro() {
		return tipoLivro;
	}

	public void setTipoLivro(int[] tipoLivro) {
		this.tipoLivro = tipoLivro;
	}

	public double getSaldoMultas() {
		return saldoMultas;
	}

	public void setSaldoMultas(double saldoMultas) {
		this.saldoMultas = saldoMultas;
	}

	public int[] getIdLivrosemMaos() {
		return idLivrosemMaos;
	}

	public void setIdLivrosemMaos(int[] idLivrosemMaos) {
		this.idLivrosemMaos = idLivrosemMaos;
	}
	
	


}
