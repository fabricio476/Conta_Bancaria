package up.edu.ctup.model;

import up.edu.ctup.constantes.NomeContas;

public class Credito extends Conta{
	

	public Credito(){
		
		this.Tipo = NomeContas.CREDITO;
		
	}
	
	
	

	
}

/*atributo float limite
redefinição do método sacar, permitindo saldo negativo até o valor do limite.
*/