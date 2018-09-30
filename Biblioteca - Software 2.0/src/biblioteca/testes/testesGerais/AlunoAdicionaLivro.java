package biblioteca.testes.testesGerais;

import biblioteca.servicos.*;
import biblioteca.servicos.basicas.*;

import java.io.IOException;
public class AlunoAdicionaLivro {
	
	
	public static void main(String[] args) throws IOException {
		
		ServicoAluno repA = new ServicoAluno();
		
		System.setProperty("IdPessoa", String.valueOf(0));//ESSA LINHA É NECESSÁRIA PARA SETAR O ID "0" COMO O PADRÃO
		System.setProperty("LogTemporario", String.valueOf(0));//ESSA LINHA É NECESSÁRIA PARA SETAR O LOG TEMPORARIO "0" COMO O PADRÃO;		
		System.setProperty("TipoPessoa", String.valueOf(0));	
		
		
		
		Aluno[] a = repA.listaAlunos();//recebe todos os alunos do banco
		
		ServicoAluno sisA = new ServicoAluno(a[0]);//direciona qual aluno o sistema efetuará modificações
		
		//sisA.disponibilidadeLivro("Oi");
		//sisA.disponibilidadeLivro("Sei");
		

		/*sisA.addLivroPerfil(0, "Oi", 0);
		
		sisA.addLivroPerfil(0, "Sei", 0);
		
		sisA.addLivroPerfil(0, "Geometria", 0);
		*/
		

		
		sisA.addLivroPerfil(0, "Sei", 0);
		sisA.addLivroPerfil(0, "Geometria", 0);
		sisA.addLivroPerfil(0, "Oi", 0);
		
		//sisA.devolverLivroPerfil(0, "Sei", 10, 0);
		
		
		Livro[] livrosTipo;

		if(sisA.buscaLivroPego()!=null) { //mostra lista com livros pegos desse usuario
			livrosTipo = sisA.buscaLivroPego();
			System.out.println("****PEGOS*******");
			for(int i = 0; i< sisA.buscaLivroPego().length;i++) {
				System.out.println(livrosTipo[i].getTitulo());
			}
		}
		
		System.out.println("\n\n");
		
		if(sisA.buscaLivroHistorico()!=null) { //mostra lista com livros no histórico desse usuario
			livrosTipo = sisA.buscaLivroHistorico();
			System.out.println("****HISTÓRICO*******");
			for(int i = 0; i< sisA.buscaLivroHistorico().length;i++) {
				System.out.println(livrosTipo[i].getTitulo());
			}
		}
	
	}

}
