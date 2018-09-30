package biblioteca.testes.testesGerais;

import java.io.IOException;

import biblioteca.servicos.ServicoAuxiliar;

public class PrimeiraExecucao {

	
	public static void main(String[] args) throws IOException {
		ServicoAuxiliar sisA = new ServicoAuxiliar();
		System.setProperty("IdPessoa", String.valueOf(0));//ESSA LINHA É NECESSÁRIA PARA SETAR O ID "0" COMO O PADRÃO
		System.setProperty("LogTemporario", String.valueOf(0));//ESSA LINHA É NECESSÁRIA PARA SETAR O LOG TEMPORARIO "0" COMO O PADRÃO;		
		System.setProperty("TipoPessoa", String.valueOf(0));
		
		//sisA.limparTodosOsBancos();
		
		sisA.primeiraExecucao();
		
		
		
	}
	
}
