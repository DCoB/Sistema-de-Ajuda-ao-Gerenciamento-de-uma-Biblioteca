package biblioteca.repositorios.interfaces;

import java.io.IOException;

import biblioteca.repositorios.RepositorioAuxiliar;

public abstract interface IRepositorioAuxiliar {
	
	/**
	 * M�todo que Cria o Arquivo Auxiliar com Todos os Campos Necess�rios Preenchidos Corretamente
	 * @throws IOException
	 */
	public void iniciarArquivoAuxiliar() throws IOException;
	
	/**
	 * M�todo que Busca o Arquivo Auxiliar
	 * @return Retorna o Arquivo Auxiliar
	 * @throws IOException
	 */
	public RepositorioAuxiliar buscarArquivoAuxiliar() throws IOException;
	
	/**
	 * M�todo que Atualiza o Arquivo Auxiliar
	 * @param auxiliar = Novo Arquivo Auxiliar
	 * @throws IOException
	 */
	public void atualizarArquivoAuxiliar(RepositorioAuxiliar auxiliar) throws IOException;
	
	/**
	 * M�todo que Calcula a Diferen�a de Datas Entra a Data Atual para a Data da �ltima vez que esse M�todo foi Chamado
	 * @return Retorna a Diferen�a de Dias
	 * @throws IOException
	 */
	public int diferencaDiasDatas() throws IOException;

}
