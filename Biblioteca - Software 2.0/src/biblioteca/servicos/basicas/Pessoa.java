package biblioteca.servicos.basicas;

import java.io.Serializable;

/**
 * Classe que Contém Todos os Atributos Básicos de Todas as Pessoas
 * @version 2.0
 * @param idPessoa = 'id' da Pessoa
 * @param nome = Nome Completo da Pessoa
 * @param login = Login da Pessoa
 * @param senha = Senha da Pessoa
 * @param cpf = cpf da Pessoa
 * @param status = 
 * @param tipopessoa = Confirma se a Pessoa é: Gerente = 0, Funcionario = 1 e Aluno = 2
 */
abstract public class Pessoa implements Serializable{//CLASSE NÃO É INSTANCIADA, SUPERCLASSE DE TODOS OS USUÁRIOS
	private static final long serialVersionUID = 1L;
	private long idPessoa;
	private String nome;
	private String login;
	private String senha;
	private String cpf;
	private boolean status;
	private int tipopessoa;
	private boolean excluido;
	private String sex;
	
	/**
	 * Construtor com Todos os Atributos da Classe Básica 'Pessoa' Definidos
	 * @param nome = Nome Completo da Pessoa
	 * @param login = Login da Pessoa
	 * @param senha = Senha da Pessoa
	 * @param cpf = CPF da Pessoa
	 * @param tipopessoa = Confirma se a Pessoa é: Gerente = 0, Funcionario = 1 e Aluno = 2
	 */
	public Pessoa(String nome, String login, String senha,String cpf,int tipopessoa,String sex ) {
		this.idPessoa = 0;
		this.tipopessoa= tipopessoa;
		this.nome= nome;
		this.login= login;
		this.senha= senha;
		this.cpf= cpf;
		this.status= true;	
		this.excluido = false;
		this.sex=sex;
	}
	
	/**
	 * Construtor Usado Somente para a Criação de Objetos para a Chamada de Métodos
	 */
	public Pessoa()
	{
		this.idPessoa = 0;
		this.status=true;
	}
	
	//Getters e Setters
		
		public long getIdPessoa() {
			return idPessoa;
		}
		public void setIdPessoa(long idPessoa) {
			this.idPessoa = idPessoa;
		}
		public String getNome() {
			return this.nome;
		}		
		public void setNome(String nome) {
			this.nome = nome;
		}	
		public String getCPF() {
			return this.cpf;
		}	
		public void setCPF(String cpf) {
			this.cpf = cpf;
		}	
		public String getLogin() {
			return this.login;
		}	
		public void setLogin(String login) {
			this.login=login;
		}	
		public String getSenha() {
			return this.senha;
		}	
		public void setSenha(String senha) {
			this.senha=senha;
		}	
		public boolean getStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}	
		public int getTipoPessoa() {
			return this.tipopessoa;
		}
		public void setTipoPessoa(int tipoPessoa) {
			this.tipopessoa = tipoPessoa;
		}
		public boolean getExcluido()
		{
			return this.excluido;
		}
		public void setExcluido(boolean excluido)
		{
			this.excluido = excluido;
		}
		
		
		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}
		
		
		//Método sera sobrescrito em Aluno, Funcionario e Gerente
		@Override
		public String toString() {
			return "Pessoa [nome=" + nome + ", login=" + login + ", senha=" + senha + ", cpf=" + cpf + ", status=" + status
					+ ", tipopessoa=" + tipopessoa + "]";
		}
	
}
