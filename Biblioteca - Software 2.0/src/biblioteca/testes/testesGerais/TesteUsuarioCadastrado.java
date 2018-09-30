package biblioteca.testes.testesGerais;

import java.io.IOException;

import biblioteca.controllers.ControllerComplementar;

public class TesteUsuarioCadastrado {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		
		
		
		System.out.println(ControllerComplementar.usuarioCadastrado("a", "1", "1", 0));
		
		
	}

}
