package biblioteca.repositorios.interfaces;

import java.io.IOException;

import biblioteca.servicos.basicas.Funcionario;

public abstract interface IRepositorioFuncionario {

	/**
	 * Método que Cria o Banco(Pasta) Onde Ficarão Todos os Arquivos de Funcionários.
	 * Também Cria o Funcionário 'Sistema' com ID = 0
	 * @throws IOException
	 */
	public void criarBancoFuncionario() throws IOException;
	
	/**
	 * Método que Excluí Todos os Arquivos do Banco 'Funcionario'. 
	 * Deixando Somente o Arquivo com id = 0 (Arquivo de Sistema)
	 * @throws IOException
	 */
	public void limparBancoFuncionario() throws IOException;
	
	/**
	 * Método que Faz a Adição de um Novo Funcionário no Banco
	 * @param func = Funcionário a ser Adicionado
	 * @param x = 'id' do Funcionário a Ser Adicionado
	 * @return Funcionário Adicionado
	 * @throws IOException
	 */
	public Funcionario adicionarFuncionario(Funcionario func,long x) throws IOException;
	
	/**
	 * Método que Edita um Funcionário no Banco
	 * @param id = 'id' do Funcionário a Ser Editado
	 * @param func = Funcionário já com As Novas Informações
	 * @return Funcionário Editado
	 * @throws IOException
	 */
	public Funcionario editarFuncionario(Funcionario func,long id) throws IOException;
	
	/**
	 * Método que Seta um Funcionário como Excluído no Banco
	 * @param id = 'id' do Funcionário a ser Excluído
	 * @return Funcionário Excluído
	 * @throws IOException
	 */
	public Funcionario excluirFuncionario(Funcionario f,long id) throws IOException;
	
	/**
	 * Método que Busca um Funcionário no Banco Identificado Pelo seu 'id'
	 * @param id = 'id' do Funcionário Buscado
	 * @return Funcionário Buscado ou NULL(CASO NÃO HAJA ALUNO COM ESSE ID)
	 * @throws IOException
	 */
	public Funcionario buscarFuncionarioPorId(long id) throws IOException;
	
	/**
	 * Método que Checa se o Login Está Disponível ou já Existe Alguém com o Mesmo Login
	 * @param login = Login a Se Checado
	 * @return (TRUE)Caso o Login Esteja Disponível, (FALSE)Caso o Login Não Esteja Disponível
	 * @throws IOException
	 */
	public boolean checarLoginDisponivel(String login) throws IOException;
}
