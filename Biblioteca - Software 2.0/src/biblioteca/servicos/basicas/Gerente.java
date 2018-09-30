package biblioteca.servicos.basicas;

/**
 * Classe que Contém Todos os Atributos Básicos de Todos os Gerentes
 * @version 2.0
 */
public class Gerente extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construtor com Todos os Atributos da Classe Básica 'Gerente' Definidos
	 * @param nome = Nome Completo do Gerente
	 * @param login = Login do Gerente
	 * @param senha = Senha do Gerente
	 * @param cpf = CPF do Gerente
	 */
	public Gerente(String nome, String login, String senha,String cpf, String sex) {
		super(nome, login, senha,cpf,0, sex);
	}
	
	/**
	 * Construtor Usado Somente para a Criação de Objetos para a Chamada de Métodos
	 */
	public Gerente() {
		super("","","","",0,"");

	}
}
