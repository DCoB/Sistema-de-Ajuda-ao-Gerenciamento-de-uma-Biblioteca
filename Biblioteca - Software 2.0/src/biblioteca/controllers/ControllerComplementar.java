package biblioteca.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import biblioteca.servicos.*;
import biblioteca.servicos.basicas.Pessoa;

/**
 * classe respons�vel por opera��es comuns a mais de um view da aplica��o
 */
public class  ControllerComplementar {//
	
	
		
		/**
		 * M�todo verifica se j� existe um usu�rio cadastrado no banco de dados. Retorna null caso n�o exista nenhum usu�rio com as credenciais.
		 * @param login
		 * @param senha
		 * @param cpf
		 * @param tipoBanco
		 * @return
		 * @throws IOException
		 * @throws NoSuchAlgorithmException 
		 * @deprecated
		 */	
		public static boolean usuarioCadastrado(String login, String senha, String cpf, int tipoBanco) throws IOException {
			
			Pessoa[] lista = null;
			
			boolean status=false;
			
			if(tipoBanco==2) {//recebe alunos do banco
				ServicoAluno a = new ServicoAluno();
				lista =  a.listaAlunos();
				
				
			}else if(tipoBanco==1) {//recebe funcionarios do banco
				ServicoFuncionario f = new ServicoFuncionario();
				lista = f.listaFuncionarios();
				
			}else if(tipoBanco==0) {//recebe gerentes do banco
				ServicoGerente g = new ServicoGerente();
				lista = g.listaGerentes();
			}
			
			for(int i=0; i<lista.length;i++) {
				
				if(lista[i].getLogin().equals(login)&&lista[i].getSenha().equals(senha)
						&&lista[i].getCPF().equals(cpf)) {//caso condi��o seja verdadeira, usu�rio n�o pode ser cadastrado
					status=true;
					break;
				}
				
			}
			return status;// retorna resultado da checagem
		}
		
		
		/**
		 * M�todo respons�vel por validar campos que contenham apenas letras e espa�os ou campos que contenham apenas n�meros.
		 * Retorna true caso verifica��o seja aceita.
		 * False caso haja algum problema.
		 * @param dado
		 * @param tipoVerificacao
		 * @return
		 */
		public static boolean validarCampos(String dado, int tipoVerificacao) {
			
			boolean resultado=false;
			
			
			if(tipoVerificacao==0) {//Verifica o campo nome
				
				if(dado.matches("^[a-zA-Z�������������������������� ]*$")) {//verifica se campo tem apenas letras e espa�os (campo nome)
					
					resultado=true;
					
				}else {
					resultado=false;
				}
				
			}else if(tipoVerificacao==1) {//verifica o campo cpf (se s� tem digitos)
				if(dado.matches("^[0-9]*$")) {
					resultado=true;
				}else {
					resultado=false;
				}
			}
			
			return resultado;
		}

}
