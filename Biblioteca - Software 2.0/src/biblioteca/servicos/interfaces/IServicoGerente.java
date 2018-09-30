package biblioteca.servicos.interfaces;

import java.io.IOException;
import java.util.ArrayList;

import biblioteca.servicos.basicas.Gerente;

public interface IServicoGerente {

	/**
	 * Método que Trata o Objeto Gerente para Ser Adicionado no Banco Pelo Repositório
	 * @param a = Gerente a Ser Adicionado
	 * @return (TRUE)Caso a Adição do Gerente Foi bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Erro na Adição do Gerente
	 * @throws IOException
	 */
	public boolean cadastrarGerente(Gerente g) throws IOException;
	
	/**
	 * Método que Trata as Informações do Gerente para Ser Editado pelo Repositório
	 * @param a = Gerente a Ser Editado
	 * @param id = 'id' do Gerente a Ser Editado
	 * @return (TRUE)Caso a Edição do Gerente Tenha Sido bem Sucedida ou (FALSE)Caso a Edição do Gerente Não Tenha Sida Bem Sucedida
	 * @throws IOException
	 */
	public boolean alterarGerente(Gerente g,long id) throws IOException;
	
	/**
	 * Método que Trata as Informações do Objeto para a Exclusão do Mesmo pelo Repositório
	 * @param id = 'id' do Gerente a Ser Excluído
	 * @return (TRUE)Caso a Excluão Tenha sido Bem Sucedida ou (FALSE)Caso Tenha Ocorrido Algum Problema na Exclusão do Gerente
	 * @throws IOException
	 */
	public boolean deletarGerente(long id) throws IOException;
	
	/**
	 * Método que Busca em Todo Banco de Gerente Todos os Arquivos ATIVOS
	 * @return Lista com Todos os Gerentes ATIVOS Registrados no Banco
	 * @throws IOException
	 */
	public Gerente[] listaGerentes() throws IOException;
	
	/**
	 * Método que Organiza A Lista de Arquivos ATIVOS do Banco
	 * Pelo Nome em Ordem Alfábetica ou o Inverso
	 * @param alfa = (FALSE) Ordem Alfabética ou (TRUE) Ordem Inversa da Alfabética
	 * @return Lista Organizada em Ordem Alfabética ou Inverso
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
