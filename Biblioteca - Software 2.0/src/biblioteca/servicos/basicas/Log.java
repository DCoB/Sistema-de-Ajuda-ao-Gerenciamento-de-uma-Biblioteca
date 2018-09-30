package biblioteca.servicos.basicas;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Log implements Serializable{
	private static final long serialVersionUID = 1L;
	private long idLog;
	private String Mensagem;
	private LocalDateTime HoraData;
	private long IdPessoa;
	private int tipopessoa;
	
	/**
	 * Construtor com Todos os Atributos da Classe B�sica 'Log' Definidos
	 * @param Mensagem = Mensagem que Ser� Salva no Log
	 * @param IdPessoa = 'id' da Pessoa que Realizou a Opera��o do Log
	 */
	public Log(String Mensagem,long IdPessoa)
	{
		idLog = 0;
		this.Mensagem = Mensagem;
		this.IdPessoa = IdPessoa;
		this.HoraData = LocalDateTime.now();
	}
	
	/**
	 * Construtor Usado Somente para a Cria��o de Objetos para a Chamada de M�todos
	 */
	public Log()
	{
		idLog = 0;
		this.HoraData = LocalDateTime.now();
	}

	
	//Getters e Setters
	public long getIdLog() {
		return idLog;
	}
	public void setIdLog(long idLog) {
		this.idLog = idLog;
	}
	public String getMensagem() {
		return Mensagem;
	}
	public void setMensagem(String mensagem) {
		Mensagem = mensagem;
	}
	public LocalDateTime getHoraData() {
		return HoraData;
	}
	public void setHoraData(LocalDateTime horaData) {
		HoraData = horaData;
	}
	public long getIdPessoa() {
		return IdPessoa;
	}
	public void setIdPessoa(long idPessoa) {
		IdPessoa = idPessoa;
	}

	public int getTipopessoa() {
		return tipopessoa;
	}

	public void setTipopessoa(int tipopessoa) {
		this.tipopessoa = tipopessoa;
	}
	
	
	
	
}
