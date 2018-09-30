package biblioteca.exceptions;

public class ErroOperacaoException extends Exception {

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	
	public ErroOperacaoException(String mensagem) {
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
