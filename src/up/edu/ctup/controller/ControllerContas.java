package up.edu.ctup.controller;

import java.util.ArrayList;
import java.util.List;


import up.edu.ctup.model.ContaBancaria;
import up.edu.ctup.model.Poupanca;


public class ControllerContas {
	
	
	
	static Poupanca polp = new Poupanca();
	static int num=1000; // numero inicial da conta bancaria
	static ContaBancaria conta = new ContaBancaria(); //para utilizar as funções da classe contabancaria

	
	public List<ContaBancaria> listacontas = new ArrayList<ContaBancaria>(); //criar a lista principal
	
	public List<Poupanca> listacontapolp = new ArrayList<Poupanca>(); //lista poupanca
	
	
	
	
	
	public void cadastrarConta(ContaBancaria cliente) { //quardar o objeto na lista principal
		
		listacontas.add(cliente);
	}

     public void cadastrarContapoupanca(Poupanca cliente) { //quardar o objeto na lista polpança
		
		listacontapolp.add(cliente);
	}
	

	public int numeroConta() { // criar o numero da conta do cliente altomatico
		
		num= num+1;
		
		return num;
	}

	
	public boolean autenticar(int numeroconta, int senha) { // altenticar o cliente no login
		boolean verifica = false;
		for (int i = 0; i <listacontas.size(); i++) {
			
			if(listacontas.get(i).getNum_conta() == numeroconta && listacontas.get(i).getSenha() == senha) {
				
				verifica = true;
			}
		}
		return verifica;
	}
	
	
	public int contacliente(int numeroconta, int senha) { //descobrie a posição do cliente
		int posicao =0;
		for (int i = 0; i <listacontas.size(); i++) {
			
			if(listacontas.get(i).getNum_conta() == numeroconta && listacontas.get(i).getSenha() == senha) {
				
				posicao= i;
			}
		}
		return posicao;
	}
	
	
	
	public int posicaoconta(int numeroconta) { //descobrie a posição do cliente para a listapoupaça
		int posicao =0;
		for (int i = 0; i <listacontapolp.size(); i++) {
			
			if(listacontapolp.get(i).getNum_conta() == numeroconta) {
				
				posicao= i;
			}
		}
		return posicao;
	}
	
	
	
	
	


	public void deposit_list(int N,float v) { //realizar deposito na poupança
		
		listacontapolp.get(N).depositar(v);
	}
	
	
	public void saque_list(int N,float v) { // realizar saque na contapoupanca
		
		listacontapolp.get(N).sacar(v);
	}
	
	
       public ContaBancaria dados_cliente(int N) { // mostrar dados do cliente
		
		return listacontas.get(N);
		
	  }
       
       public float saldo(int N) { //mostrar saldo polpança
    	   
    	return listacontapolp.get(N).getSaldo();  
       }
       
       
	
	
	
}

