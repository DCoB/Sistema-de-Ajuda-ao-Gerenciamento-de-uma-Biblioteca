package biblioteca.interfaces.controllerGeral;

import java.io.IOException;

public interface IControllerGeral {
	
	
	/**
	 * M�todo que � Acionado ao Usu�rio Fazer a Tentativa de Login e que Redireciona para a Proxima Tela
	 * @param login = Login Oferecido
	 * @param senha = Senha Oferecido
	 * @param tipoPessoa = 0(Gerente), 1(Funcion�rio) e 2(Aluno)
	 * @param lembrarSenha = Lembrar a Senha caso o Login tenha Sido Bem sucedido
	 * @throws IOException
	 */
	public void Entrar(String login,String senha,int tipoPessoa,boolean lembrarSenha) throws IOException;

}
