package biblioteca.servicos.basicas;

/**
 * Classe que Contém Todos os Atributos Básicos de Todos os Funcionarios
 * @version 2.0
 */
public class Funcionario extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor com Todos os Atributos da Classe Básica 'Funcionario' Definidos
	 * @param nome = Nome Completo do Funcionario
	 * @param login = Login do Funcionario
	 * @param senha = Senha do Funcionario
	 * @param cpf = CPF do Funcionario
	 */
	public Funcionario(String nome, String login, String senha,String cpf, String sex) {
		super(nome, login, senha,cpf,1, sex);
	}
	
	/**
	 * Construtor Usado Somente para a Criação de Objetos para a Chamada de Métodos
	 */
	public Funcionario() {
		super("","","","",1,"");

	}
		
}
