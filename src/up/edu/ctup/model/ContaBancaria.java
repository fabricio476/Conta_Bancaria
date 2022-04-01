package up.edu.ctup.model;

public class ContaBancaria  {
	
	private String cliente;
	private int num_conta,senha,tipo;
	protected float saldo;
	
	
	 
	 public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}

	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public int getNum_conta() {
		return num_conta;
	}
	public void setNum_conta(int num_conta) {
		this.num_conta = num_conta;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	} 
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
	public void sacar(float valor) { // metodo sacar
		
		if(valor < saldo) {
			
			this.saldo = saldo - valor;	
			
		}else {
			
			System.out.println("error - saldo indisponivel");	
		}	
	}
	
	
	public void depositar(float valor) { //metodo depositar
		
	this.saldo = saldo + valor;	
	}
	
	
	@Override
	public String toString() {
		return "\n - CONTA BANCARIA - \n NOME: " + cliente + "\n Nº DA CONTA : " + num_conta + "\n TIPO CONTA: " + tipo+"\n";
	}
	
	
	

}

     /*Elabore uma classe ContaBancaria, com os seguintes atributos e métodos:
	 atributo String cliente
	 atributo int num_conta
	 atributo float saldo
	 sacar (o saldo não pode ficar negativo)
	 método depositar
*/