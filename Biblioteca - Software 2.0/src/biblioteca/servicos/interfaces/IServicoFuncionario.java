package biblioteca.servicos.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import biblioteca.servicos.basicas.Funcionario;

public interface IServicoFuncionario {
	
	/**
	 * M�todo que Trata o Objeto Funcion�rio para Ser Adicionado no Banco Pelo Reposit�rio
	 * @param a = Funcion�rio a Ser Adicionado
	 * @return (TRUE)Caso a Adi��o do Funcion�rio Foi bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Erro na Adi��o do Funcion�rio
	 * @throws IOException
	 */
	public boolean cadastrarFuncionario(Funcionario f) throws IOException;
	
	/**
	 * M�todo que Trata as Informa��es do Funcion�rio para Ser Editado pelo Reposit�rio
	 * @param a = Funcion�rio a Ser Editado
	 * @param id = 'id' do Funcion�rio a Ser Editado
	 * @return (TRUE)Caso a Edi��o do Funcion�rio Tenha Sido bem Sucedida ou (FALSE)Caso a Edi��o do Funcion�rio N�o Tenha Sida Bem Sucedida
	 * @throws IOException
	 */
	public boolean alterarFuncionario(Funcionario f,long id) throws IOException;
	
	/**
	 * M�todo que Trata as Informa��es do Objeto para a Exclus�o do Mesmo pelo Reposit�rio
	 * @param id = 'id' do Funcion�rio a Ser Exclu�do
	 * @return (TRUE)Caso a Exclu�o Tenha sido Bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Problema na Exclus�o do Funcion�rio
	 * @throws IOException
	 */
	public boolean deletarFuncionario(long id) throws IOException;
	
	/**
	 * M�todo que Busca em Todo Banco de Funcion�rio Todos os Arquivos ATIVOS
	 * @return Lista com Todos os Funcion�rios ATIVOS Registrados no Banco
	 * @throws IOException
	 */
	public Funcionario[] listaFuncionarios() throws IOException;
	
	
	/**
	 * M�todo que Organiza A Lista de Arquivos ATIVOS do Banco
	 * Pelo Nome em Ordem Alf�betica ou o Inverso
	 * @param alfa = (FALSE) Ordem Alfab�tica ou (TRUE) Ordem Inversa da Alfab�tica
	 * @return Lista Organizada em Ordem Alfab�tica ou Inverso
	 * @throws IOException
	 */
	public ArrayList<Funcionario> organizaNome(boolean alfa) throws IOException;
	
	/**
	 * Busca Funcion�rio pelo Nome
	 * @param dadoInformado = Nome do Funcion�rio
	 * @return Funcion�rio Buscado
	 * @throws IOException
	 */
	public Funcionario buscarFuncionario(String dadoInformado) throws IOException;
	
	
	

}
