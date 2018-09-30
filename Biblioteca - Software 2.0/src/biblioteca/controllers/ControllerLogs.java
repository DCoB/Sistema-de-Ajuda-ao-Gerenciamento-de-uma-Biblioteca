package biblioteca.controllers;

import java.io.IOException;

import javax.swing.JFrame;

import biblioteca.repositorios.RepositorioLog;
import biblioteca.servicos.basicas.Log;
import biblioteca.views.ViewLogs;

/**
 * Classe Respons�vel por Fazer Todas as Opera��es que Acontecem na View de Lista de Logs
 */
public class ControllerLogs {
	
	
	private static ViewLogs frameLog;
	private static RepositorioLog repLog = new RepositorioLog(0);
	private static String todosLogs = "";
	
	/**
	 * M�todo que Chama a Tela de Lista de Logs
	 * @param window = Janela que Chamou o m�todo
	 * @throws IOException
	 */
	public static void iniciaTelaLog(JFrame window) throws IOException {
		lerLogs();
		window.dispose();
		frameLog = new ViewLogs();
		frameLog.setLocationRelativeTo(null);
		frameLog.setVisible(true);
	}
	
	/**
	 * M�todo que Preenche a lista de Logs com Todos os Logs do Banco
	 * @throws IOException
	 */
	public static void lerLogs() throws IOException {
		
		
		Log[] resultado = repLog.listaLogs();
		int x = repLog.listaLogs().length -1 ;
		
		for(int i=0; i<x;i++) {
			
			todosLogs += resultado[x-i].getHoraData() + "  -  " + "  -  " + resultado[x-i].getMensagem() +"\n\n";
			
		}
	}
	
	/**
	 * M�tood que Checa se Existe Lista de Logs ou N�o
	 * @return Mensagem que N�o existe Log ou a Lista de Logs
	 * @throws IOException
	 */
	public static String stringTodosLogs() throws IOException {
		if(todosLogs==null) {
			return "N�o h� nenhum log.";
		}else {
			return todosLogs;
		}
	}

}
