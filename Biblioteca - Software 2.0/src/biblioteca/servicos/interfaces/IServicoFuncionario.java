package biblioteca.servicos.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import biblioteca.servicos.basicas.Funcionario;

public interface IServicoFuncionario {
	
	/**
	 * Método que Trata o Objeto Funcionário para Ser Adicionado no Banco Pelo Repositório
	 * @param a = Funcionário a Ser Adicionado
	 * @return (TRUE)Caso a Adição do Funcionário Foi bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Erro na Adição do Funcionário
	 * @throws IOException
	 */
	public boolean cadastrarFuncionario(Funcionario f) throws IOException;
	
	/**
	 * Método que Trata as Informações do Funcionário para Ser Editado pelo Repositório
	 * @param a = Funcionário a Ser Editado
	 * @param id = 'id' do Funcionário a Ser Editado
	 * @return (TRUE)Caso a Edição do Funcionário Tenha Sido bem Sucedida ou (FALSE)Caso a Edição do Funcionário Não Tenha Sida Bem Sucedida
	 * @throws IOException
	 */
	public boolean alterarFuncionario(Funcionario f,long id) throws IOException;
	
	/**
	 * Método que Trata as Informações do Objeto para a Exclusão do Mesmo pelo Repositório
	 * @param id = 'id' do Funcionário a Ser Excluído
	 * @return (TRUE)Caso a Excluão Tenha sido Bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Problema na Exclusão do Funcionário
	 * @throws IOException
	 */
	public boolean deletarFuncionario(long id) throws IOException;
	
	/**
	 * Método que Busca em Todo Banco de Funcionário Todos os Arquivos ATIVOS
	 * @return Lista com Todos os Funcionários ATIVOS Registrados no Banco
	 * @throws IOException
	 */
	public Funcionario[] listaFuncionarios() throws IOException;
	
	
	/**
	 * Método que Organiza A Lista de Arquivos ATIVOS do Banco
	 * Pelo Nome em Ordem Alfábetica ou o Inverso
	 * @param alfa = (FALSE) Ordem Alfabética ou (TRUE) Ordem Inversa da Alfabética
	 * @return Lista Organizada em Ordem Alfabética ou Inverso
	 * @throws IOException
	 */
	public ArrayList<Funcionario> organizaNome(boolean alfa) throws IOException;
	
	/**
	 * Busca Funcionário pelo Nome
	 * @param dadoInformado = Nome do Funcionário
	 * @return Funcionário Buscado
	 * @throws IOException
	 */
	public Funcionario buscarFuncionario(String dadoInformado) throws IOException;
	
	
	

}
