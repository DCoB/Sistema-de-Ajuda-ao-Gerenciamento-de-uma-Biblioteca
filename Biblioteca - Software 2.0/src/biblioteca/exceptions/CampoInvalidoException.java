package biblioteca.exceptions;

/**
 * 
 * Classe respons�vel por lan�ar exceptions referente �s inconformidades de dados obtidos pelos usu�rios.
 * Exceptions est�o sendo salvas no banco de Logs.
 *
 */
public class CampoInvalidoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	
	public CampoInvalidoException(String mensagem) {
		super(mensagem);
		this.mensagem=mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
