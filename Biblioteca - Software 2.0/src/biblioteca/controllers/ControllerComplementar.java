package biblioteca.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import biblioteca.servicos.*;
import biblioteca.servicos.basicas.Pessoa;

/**
 * classe responsável por operações comuns a mais de um view da aplicação
 */
public class  ControllerComplementar {//
	
	
		
		/**
		 * Método verifica se já existe um usuário cadastrado no banco de dados. Retorna null caso não exista nenhum usuário com as credenciais.
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
						&&lista[i].getCPF().equals(cpf)) {//caso condição seja verdadeira, usuário não pode ser cadastrado
					status=true;
					break;
				}
				
			}
			return status;// retorna resultado da checagem
		}
		
		
		/**
		 * Método responsável por validar campos que contenham apenas letras e espaços ou campos que contenham apenas números.
		 * Retorna true caso verificação seja aceita.
		 * False caso haja algum problema.
		 * @param dado
		 * @param tipoVerificacao
		 * @return
		 */
		public static boolean validarCampos(String dado, int tipoVerificacao) {
			
			boolean resultado=false;
			
			
			if(tipoVerificacao==0) {//Verifica o campo nome
				
				if(dado.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü ]*$")) {//verifica se campo tem apenas letras e espaços (campo nome)
					
					resultado=true;
					
				}else {
					resultado=false;
				}
				
			}else if(tipoVerificacao==1) {//verifica o campo cpf (se só tem digitos)
				if(dado.matches("^[0-9]*$")) {
					resultado=true;
				}else {
					resultado=false;
				}
			}
			
			return resultado;
		}

}
