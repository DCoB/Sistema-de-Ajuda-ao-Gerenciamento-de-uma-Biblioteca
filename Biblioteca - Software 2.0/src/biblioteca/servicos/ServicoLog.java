package biblioteca.servicos;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

import biblioteca.repositorios.RepositorioAuxiliar;
import biblioteca.repositorios.RepositorioLog;
import biblioteca.servicos.basicas.Log;
import biblioteca.servicos.interfaces.IServicoLog;

/**
 * Classe que Lida com o Tratamento das Configura��es do Log para Fazer as Altera��es
 * @version 1.0
 */
public class ServicoLog implements IServicoLog {
	private RepositorioLog repLog = new RepositorioLog(0);
	private Log log = new Log();
	

	public void adicionarLog(String mensagem) throws IOException
	{	
		
		RepositorioAuxiliar repAux = new RepositorioAuxiliar();
		
		repAux = repAux.buscarArquivoAuxiliar();//BUSCA O ARQUIVO AUXILIAR
		long x = repAux.getUltimoIdLogAdd();//RECEBE QUAL O �LTIMO ID DO BANCO DE LOG +1
		
		log.setIdLog(x);//SETA O 'id' CORRETO
		log.setIdPessoa(Long.parseLong(System.getProperty("IdPessoa")));//RECEBE QUAL PESSOA EST� LOGADA E EST� REALIZANDO ESSAS OPERA��O
		log.setTipopessoa(Short.parseShort(System.getProperty("TipoPessoa")));
		log.setMensagem(mensagem);
		
		repLog.criarLog(log);//CHAMA O M�TODO DO REPOSIT�RIO PARA ADICIONAR UM NOVO LOG
	}
	

	public void adicionarLogTemporario(String mensagem) throws IOException
	{	
		log.setIdLog(1);//SETA O 'id' = 1
		//ESTA LINHA IR� RETORNAR. EFEITO DE TESTES
		log.setIdPessoa(Long.parseLong(System.getProperty("IdPessoa")));//RECEBE QUAL PESSOA EST� LOGADA E EST� REALIZANDO ESSAS OPERA��O
		log.setTipopessoa(Short.parseShort(System.getProperty("TipoPessoa")));
		log.setMensagem(mensagem);
		
		repLog.editarLog(log);//CHAMA O M�TODO DO REPOSIT�RIO QUE ALTERA O LOG DE ERRO
		
		System.setProperty("LogTemporario", String.valueOf(1));//SETA A PROPRIEDADE DO SISTEMA: "LogTemporario' = 1 PARA AVISAR QUE EXISTE LOG DE ERRO 
		
	}
	

	public String UltimoLog() throws IOException
	{
		Log log = new Log();
		RepositorioAuxiliar repAux = new RepositorioAuxiliar();
		
		if(Long.parseLong(System.getProperty("LogTemporario")) == 1)//CHECA SE EXISTE LOG TEMPOR�RIO DISPON�VEL OU N�O
		{
			String Mensagem = LogTemporario();//RECEBE A MENSAGEM DESSE LOG TEMPOR�RIO
			
			log.setMensagem("");//ZERA A MENSAGEM DO LOG TEMPOR�RIO
			repLog.editarLog(log);//EDITA O LOG TEMPOR�RIO
			System.setProperty("LogTemporario", String.valueOf(0));//SETA A PROPRIEDADE DO SISTEMA COMO 0, PARA DIZER QUE N�O EXISTE MAIS LOG TEMPOR�RIO
			
			return Mensagem;
		}
		else //N�O EXISTE LOG TEMPOR�RIO
		{		
			repAux = repAux.buscarArquivoAuxiliar();//ABRE O ARQUIVO AUXILIAR
			long x = repAux.getUltimoIdLog();//RECEBE O �LTIMO ID DE LOG ADICIONADO
		
			log = (Log)repLog.buscarArquivoPorId(x);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String agoraFormatado = log.getHoraData().format(formatter);//FORMATA A DATA E HOR�RIO PARA O FORMATO: Dia/M�s/Ano Hora:Minuto:Segundo
			
			return log.getMensagem() + " Em: " + agoraFormatado;
		}
		
		
	}
	

	public String LogTemporario() throws IOException
	{
		log = (Log)repLog.buscarArquivoPorId(1);
		
		return log.getMensagem();
		
	}
	
	
	public Log[] tresUltimoLogUsuario(long id,int tipoPessoa) throws IOException
	{
		Log[] log = new Log[3];
		ArrayList<Log> listaLog = buscarLogPorIdUsuario(id,tipoPessoa);
		Collections.reverse(listaLog);
		
		for(int y = 0; y < listaLog.size() && y <3; y++)
		{
			log[y] = listaLog.get(y);
		}
		
		return log;
	}
	
	

	public ArrayList<Log> buscarLogPorIdUsuario(long id,int tipoPessoa) throws IOException
	{
				
		ArrayList<Log> listaLog = new ArrayList<Log>();
		
		Log[] log = repLog.listaLogs();
		
		for(int y = 0;y < log.length;y++)
		{
			if(log[y].getIdPessoa() == id && log[y].getTipopessoa() == tipoPessoa && y != 0)
			{
				listaLog.add(log[y]);
			}
		}
		
		if(log.length == 0)
		{
			return null;
		}
		
		return listaLog;
	}
}
