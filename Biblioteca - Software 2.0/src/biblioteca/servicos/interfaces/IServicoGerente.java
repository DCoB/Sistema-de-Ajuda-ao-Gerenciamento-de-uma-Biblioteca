package biblioteca.servicos.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import biblioteca.servicos.basicas.Gerente;

public interface IServicoGerente {

	/**
	 * M�todo que Trata o Objeto Gerente para Ser Adicionado no Banco Pelo Reposit�rio
	 * @param a = Gerente a Ser Adicionado
	 * @return (TRUE)Caso a Adi��o do Gerente Foi bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Erro na Adi��o do Gerente
	 * @throws IOException
	 */
	public boolean cadastrarGerente(Gerente g) throws IOException;
	
	/**
	 * M�todo que Trata as Informa��es do Gerente para Ser Editado pelo Reposit�rio
	 * @param a = Gerente a Ser Editado
	 * @param id = 'id' do Gerente a Ser Editado
	 * @return (TRUE)Caso a Edi��o do Gerente Tenha Sido bem Sucedida ou (FALSE)Caso a Edi��o do Gerente N�o Tenha Sida Bem Sucedida
	 * @throws IOException
	 */
	public boolean alterarGerente(Gerente g,long id) throws IOException;
	
	/**
	 * M�todo que Trata as Informa��es do Objeto para a Exclus�o do Mesmo pelo Reposit�rio
	 * @param id = 'id' do Gerente a Ser Exclu�do
	 * @return (TRUE)Caso a Exclu�o Tenha sido Bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Problema na Exclus�o do Gerente
	 * @throws IOException
	 */
	public boolean deletarGerente(long id) throws IOException;
	
	/**
	 * M�todo que Busca em Todo Banco de Gerente Todos os Arquivos ATIVOS
	 * @return Lista com Todos os Gerentes ATIVOS Registrados no Banco
	 * @throws IOException
	 */
	public Gerente[] listaGerentes() throws IOException;
	
	/**
	 * M�todo que Organiza A Lista de Arquivos ATIVOS do Banco
	 * Pelo Nome em Ordem Alf�betica ou o Inverso
	 * @param alfa = (FALSE) Ordem Alfab�tica ou (TRUE) Ordem Inversa da Alfab�tica
	 * @return Lista Organizada em Ordem Alfab�tica ou Inverso
	 * @throws IOException
	 */
	public ArrayList<Gerente> organizaNome(boolean alfa) throws IOException;
	
	/**
	 * Busca Gerente Pelo Nome
	 * @param dadoInformado = Nome do Gerente
	 * @return Gerente Buscado
	 * @throws IOException
	 */
	public Gerente buscarGerente(String dadoInformado) throws IOException;
	
}
