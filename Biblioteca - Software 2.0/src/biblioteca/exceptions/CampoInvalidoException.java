package biblioteca.exceptions;

/**
 * 
 * Classe responsável por lançar exceptions referente às inconformidades de dados obtidos pelos usuários.
 * Exceptions estão sendo salvas no banco de Logs.
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
