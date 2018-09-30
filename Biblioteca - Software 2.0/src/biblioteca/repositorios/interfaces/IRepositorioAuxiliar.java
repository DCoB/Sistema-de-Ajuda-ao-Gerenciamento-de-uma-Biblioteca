package biblioteca.repositorios.interfaces;

import java.io.IOException;

import biblioteca.repositorios.RepositorioAuxiliar;

public abstract interface IRepositorioAuxiliar {
	
	/**
	 * Método que Cria o Arquivo Auxiliar com Todos os Campos Necessários Preenchidos Corretamente
	 * @throws IOException
	 */
	public void iniciarArquivoAuxiliar() throws IOException;
	
	/**
	 * Método que Busca o Arquivo Auxiliar
	 * @return Retorna o Arquivo Auxiliar
	 * @throws IOException
	 */
	public RepositorioAuxiliar buscarArquivoAuxiliar() throws IOException;
	
	/**
	 * Método que Atualiza o Arquivo Auxiliar
	 * @param auxiliar = Novo Arquivo Auxiliar
	 * @throws IOException
	 */
	public void atualizarArquivoAuxiliar(RepositorioAuxiliar auxiliar) throws IOException;
	
	/**
	 * Método que Calcula a Diferença de Datas Entra a Data Atual para a Data da Última vez que esse Método foi Chamado
	 * @return Retorna a Diferença de Dias
	 * @throws IOException
	 */
	public int diferencaDiasDatas() throws IOException;

}
