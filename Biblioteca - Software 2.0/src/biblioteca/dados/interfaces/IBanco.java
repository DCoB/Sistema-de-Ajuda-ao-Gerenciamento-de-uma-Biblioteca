package biblioteca.dados.interfaces;

import java.io.*;

public interface IBanco {//interface para um banco de dados gen�rico
	
	
	/**
	* M�todo que Cria a Pasta Onde Ir�o ficar os Bancos
	*/
	public abstract void criarDiretorio();
	
	/** 
	 * M�todo Cria Uma Pasta Onde Ser� Armazenado os Arquivos
	 */
	public abstract void criarBanco();
	
	/** 
	 * M�todo Limpa Um Banco(Pasta) Onde os Arquivos Est�o Armazenados
	 */
	public abstract void limparBanco();
	
	/**
	 * M�todo Exclu� um Banco(Pasta) dos Arquivos
	 * @param pasta = Objeto do Banco(Pasta) que Ir� ser Exclu�do
	 * @return Se a Exclus�o do Banco(Pasta) foi Bem Sucedida ou N�o
	 */
	public abstract boolean excluirBanco(File pasta);
	
	/** 
	 * M�todo Gera Objetos Nulos em um Determinado Banco Para Testes no Mesmo Banco;
	 *  @param num = N�mero de Arquivos Nulos Gerados
	 *  @param modo = (0)Gerar 1 Arquivo com V�rios Objetos, (1)Gerar V�rios Arquivos Cada Arquivo com 1 Objeto
	 * @throws IOException 
	 *  @deprecated
	 */
	//public abstract void gerarObjetosParaTestes(int num,int modo) throws IOException;
	
	
	/**
	 * M�todo que Busca um Arquivo no Banco pelo seu 'ID'
	 * @param id = 'ID' do Arquivo a ser Bsucado
	 * @return Arquivo com 'ID' correspondende(Caso Ouver Arquivo com esse id), se n�o, Retorna null
	 * @throws IOException
	 */
	public abstract Object buscarArquivoPorId(long id)throws IOException;
	
	/**
	 * M�todo que Retorna uma Lista com Todos os Arquivos do Banco
	 * @return Lista com Todos os Arquivos do Banco
	 * @throws IOException
	 */
	public abstract Object[] listaBanco() throws IOException;
	
	/** 
	 * M�todo Cria Um Novo Arquivo do Banco
	 *  @param Arquivo = Arquivo a Ser Adicionado no Banco 
	 *  @param id = "Id" do Arquivo Adicionado
	 *  @return Objeto Criado
	 * @throws IOException 
	 */
	public abstract Object criarArquivo(Object arquivo,long id) throws IOException;
	
	/** 
	 * M�todo Muda o Status de Algum Arquivo para Exclu�do
	 *  @param id = "Id" do Arquivo Que Ser� Exclu�do
	 *  @return Arquivo Exclu�do ou NULL(Caso Ocorra Algum Problema na Exclus�o do Objeto)
	 *  @deprecated
	 * @throws IOException 
	 * 
	 */
	//public Object excluirArquivo(long id) throws IOException;
	
	/** 
	 * M�todo Edita Algum Arquivo do Banco
	 *  @param id = "Id" do Arquivo que Ser� Editado
	 *  @param Mensagem = Printar A Mensagem de Sucesso ou N�o
	 *  @return Objeto Editado ou NULL (Caso n�o Exista o Objeto)
	 * @throws IOException 
	 */
	public Object editarArquivo(long id,Object arquivoNovo) throws IOException;
	
	/** 
	 * M�todo Mostra o Tamanho do Banco
	 *  @return Tamanho do Banco
	 *  @deprecated
	 * @throws IOException 
	 */
	//public int tamanhoBanco() throws IOException;

}
