package up.edu.ctup.model;

import up.edu.ctup.interfaces.PermitirAcesso;

public class Cliente extends Pessoa implements PermitirAcesso{

	
	private ContaBancaria contaBancaria;
	
	
	public Cliente(){
		
		
		
	}


	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}


	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}


	@Override
	public boolean autenticar() {
		
		return this.email.equals("admin") && this.senha.equals("admin");
	}
	
	
	
	
}
