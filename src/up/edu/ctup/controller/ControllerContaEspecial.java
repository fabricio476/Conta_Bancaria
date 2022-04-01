package up.edu.ctup.controller;

import java.util.ArrayList;
import java.util.List;

import up.edu.ctup.model.ContaEspecial;

public class ControllerContaEspecial {

	
	
	public List<ContaEspecial> listcontaespecial = new ArrayList<ContaEspecial>();
	
	
      public void cadastrarConta(ContaEspecial cliente) { //quardar o objeto na lista
		
		listcontaespecial.add(cliente);
	}
	
	
	
      public int posicaoconta(int numeroconta) { //descobre a posição do cliente na lista
  		int posicao =0;
  		for (int i = 0; i <listcontaespecial.size(); i++) {
  			
  			if(listcontaespecial.get(i).getNum_conta() == numeroconta) {
  				
  				posicao= i;
  			}
  		}
  		return posicao;
  	}
      
	
	
public void deposit_list(int N,float v) { //realizar deposito
		
	listcontaespecial.get(N).depositar(v);
	}
	
	
	public void saque_list(int N,float v) { // realizar saque
		
		listcontaespecial.get(N).sacar(v);
	}
	
	
	public float saldo(int N) { //envia o saldo
 	   
    	return listcontaespecial.get(N).getSaldo();  
       }
	
}
