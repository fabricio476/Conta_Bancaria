package up.edu.ctup.controller;


import java.util.HashMap;



import up.edu.ctup.model.Cliente;
import up.edu.ctup.model.Debito;
import up.edu.ctup.model.Poupanca;



public class ControllerContaBancariaCliente {
	
	private static Integer num=1000; // numero inicial das contas bancarias
	
   
	
	/*gera um numero de conta para o cliente*/
	public Integer numeroConta() { num= num+1; return num; }

	HashMap<Integer,Cliente> MapsDeClientes = new HashMap<Integer,Cliente>();
	
	
	/*salva o cliente no MAP*/
	public boolean salvarCliente(Cliente cliente) {
		boolean resposta = false;
		
		/*checa se o cliente já existe*/
		if(!autenticar(cliente)) {
			
			Integer numeroCONTAgerado = numeroConta();
			
			cliente.getContaBancaria().getContascliente().add(new Debito());
			cliente.getContaBancaria().getContascliente().add(new Poupanca());
			cliente.getContaBancaria().setNumero_conta(numeroCONTAgerado);
			MapsDeClientes.put(numeroCONTAgerado, cliente);	
			
			resposta = true;
				
		}
		
		
	return resposta;			
	}
	
	
	/*protected metodo só e usado dentro da classe*/
	protected boolean VerificarConta(Cliente cliente) {
		
		boolean resposta = false;
		
		/*metodo para checar se existe a chave*/
		if(MapsDeClientes.containsKey(cliente.getContaBancaria().getNumero_conta())) {
			
			resposta = true;
		}
		
		return resposta;
	}
	
	
	
	
	/*retorna se o cliente existe ou não*/
	public boolean autenticar(Cliente cliente) { // altenticar o cliente no login
		boolean verifica = false;
		
		
		MapsDeClientes.get(cliente.getContaBancaria().getNumero_conta());
		
		 /*percorrer as chaves*/ 
		for (Integer i : MapsDeClientes.keySet()) {
			
			if(MapsDeClientes.get(i).getEmail()== cliente.getEmail() && MapsDeClientes.get(i).getSenha()==cliente.getSenha()) {
				
				  if(VerificarConta(MapsDeClientes.get(i))) {
					 
					  verifica = true;  
				  }
	
			 break;
			}
			
		}
		
		return verifica;
	}
	
	
	
	
	
	
	
	
	
	
	
	


	
       
       
	
	
	
}

