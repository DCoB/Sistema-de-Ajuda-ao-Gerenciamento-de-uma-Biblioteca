package biblioteca.repositorios;

import java.io.IOException;

import biblioteca.dados.Banco;
import biblioteca.servicos.basicas.Log;

public class RepositorioLog extends Banco{
	private static final long serialVersionUID = 1L;
	
	public RepositorioLog(long id) {
		super(id);
		setBanco("Banco_Logs\\");
		setArquivo("Log"); 
	}
	
	
	public void criarLog(Log log) throws IOException
	{
		criarArquivo(log,log.getIdLog());
	}
	
	public void editarLog(Log log) throws IOException
	{
		log = (Log)editarArquivo(1,log);
	}
	
	public Log[] listaLogs() throws IOException
	{
		RepositorioAuxiliar repAux = new RepositorioAuxiliar();
		
		repAux = repAux.buscarArquivoAuxiliar();
		long x = repAux.getUltimoIdLog();
		
		Object[] objeto = listaBancoLogs();
		Log[] Logs = new Log[(int) x];
		
		for(int y = 0 ; y < x;y++)
		{
			Logs[y] = (Log)objeto[y];
		}
		
		return Logs;
		
	}

}
