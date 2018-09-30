package biblioteca.dados.interfaces;

import java.io.*;

public interface IBanco {//interface para um banco de dados genérico
	
	
	/**
	* Método que Cria a Pasta Onde Irão ficar os Bancos
	*/
	public abstract void criarDiretorio();
	
	/** 
	 * Método Cria Uma Pasta Onde Será Armazenado os Arquivos
	 */
	public abstract void criarBanco();
	
	/** 
	 * Método Limpa Um Banco(Pasta) Onde os Arquivos Estão Armazenados
	 */
	public abstract void limparBanco();
	
	/**
	 * Método Excluí um Banco(Pasta) dos Arquivos
	 * @param pasta = Objeto do Banco(Pasta) que Irá ser Excluído
	 * @return Se a Exclusão do Banco(Pasta) foi Bem Sucedida ou Não
	 */
	public abstract boolean excluirBanco(File pasta);
	
	/** 
	 * Método Gera Objetos Nulos em um Determinado Banco Para Testes no Mesmo Banco;
	 *  @param num = Número de Arquivos Nulos Gerados
	 *  @param modo = (0)Gerar 1 Arquivo com Vários Objetos, (1)Gerar Vários Arquivos Cada Arquivo com 1 Objeto
	 * @throws IOException 
	 *  @deprecated
	 */
	//public abstract void gerarObjetosParaTestes(int num,int modo) throws IOException;
	
	
	/**
	 * Método que Busca um Arquivo no Banco pelo seu 'ID'
	 * @param id = 'ID' do Arquivo a ser Bsucado
	 * @return Arquivo com 'ID' correspondende(Caso Ouver Arquivo com esse id), se não, Retorna null
	 * @throws IOException
	 */
	public abstract Object buscarArquivoPorId(long id)throws IOException;
	
	/**
	 * Método que Retorna uma Lista com Todos os Arquivos do Banco
	 * @return Lista com Todos os Arquivos do Banco
	 * @throws IOException
	 */
	public abstract Object[] listaBanco() throws IOException;
	
	/** 
	 * Método Cria Um Novo Arquivo do Banco
	 *  @param Arquivo = Arquivo a Ser Adicionado no Banco 
	 *  @param id = "Id" do Arquivo Adicionado
	 *  @return Objeto Criado
	 * @throws IOException 
	 */
	public abstract Object criarArquivo(Object arquivo,long id) throws IOException;
	
	/** 
	 * Método Muda o Status de Algum Arquivo para Excluído
	 *  @param id = "Id" do Arquivo Que Será Excluído
	 *  @return Arquivo Excluído ou NULL(Caso Ocorra Algum Problema na Exclusão do Objeto)
	 *  @deprecated
	 * @throws IOException 
	 * 
	 */
	//public Object excluirArquivo(long id) throws IOException;
	
	/** 
	 * Método Edita Algum Arquivo do Banco
	 *  @param id = "Id" do Arquivo que Será Editado
	 *  @param Mensagem = Printar A Mensagem de Sucesso ou Não
	 *  @return Objeto Editado ou NULL (Caso não Exista o Objeto)
	 * @throws IOException 
	 */
	public Object editarArquivo(long id,Object arquivoNovo) throws IOException;
	
	/** 
	 * Método Mostra o Tamanho do Banco
	 *  @return Tamanho do Banco
	 *  @deprecated
	 * @throws IOException 
	 */
	//public int tamanhoBanco() throws IOException;

}
