package up.edu.ctup.model;

import up.edu.ctup.constantes.NomeContas;

public class Credito extends Conta{
	

	public Credito(){
		
		this.Tipo = NomeContas.CREDITO;
		
	}
	
	
	

	
}

/*atributo float limite
redefini��o do m�todo sacar, permitindo saldo negativo at� o valor do limite.
*/