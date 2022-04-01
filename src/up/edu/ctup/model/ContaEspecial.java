package up.edu.ctup.model;

public class ContaEspecial  extends ContaBancaria{
	private float limite;

	
	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	
	@Override
	public void sacar(float valor) {
		
		if(valor <saldo) {
			
			this.setSaldo(saldo-valor);
			
		}else if(valor<=saldo+getLimite()) {
			
			float result = saldo+getLimite();
			saldo=0;
			
			this.limite = valor-result;
			
		}
			
		
	}

	
}

/*atributo float limite
redefini��o do m�todo sacar, permitindo saldo negativo at� o valor do limite.
*/