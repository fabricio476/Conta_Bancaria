package up.edu.ctup.model;

public abstract class Conta {
	
	protected String Tipo;
	protected float saldo=0;
	
	
	
	
	
	
	public String getTipo() {
		return Tipo;
	}






	public void setTipo(String tipo) {
		Tipo = tipo;
	}






	public float getSaldo() {
		return saldo;
	}






	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}






	public void sacar_dinheiro(float valor) {
		
		if(valor <= this.saldo && valor >0) {
			
			this.saldo -= valor;
			
		}
		
		
	}
	
	
    public void depositar_dinheiro(float valor) {
    	
    	
    	if(valor != 0 && valor > 0) {
    		
    		this.saldo += valor;
    		
    	}
		
    	
		
	}
	
	



	
	
	
	

}
