package up.edu.ctup.view;

import java.util.Scanner;


import up.edu.ctup.controller.ControllerContaBancariaCliente;
import up.edu.ctup.model.Cliente;
import up.edu.ctup.model.ContaBancaria;


public class Principal {


	static Scanner scan = new Scanner(System.in);
	public static Cliente cliente;
	static ControllerContaBancariaCliente controllerContaCliente = new ControllerContaBancariaCliente();
	
	
	public static void main(String[] args) {
		
		
			
		menu_Inicial();	// menu inicial onde o programa começa
		
	}//=============final main===========================
	
	
	public static void menu_Inicial() { // primeiro menu
		
		int op=0,sair=0;
		do {
			
		System.out.println("1- Criar Conta");
		System.out.println("2- Login Cliente");
		System.out.println("3- sair");
		op = scan.nextInt();
		
		if(op == 1) {
			
			cliente = new Cliente(new ContaBancaria());
			
			System.out.println("Nome :");
			cliente.setNome(scan.next());
			
			System.out.println("Cpf :");
			cliente.setCpf(scan.next());
			
			System.out.println("Email: :");
			cliente.setEmail(scan.next());
			
			System.out.println("Senha :");
			cliente.setSenha(scan.next());
			
			
			if(controllerContaCliente.salvarCliente(cliente)) {
				
				System.out.println("Cliente Cadastrado com Sucesso !!");
				
			}else {
				
				System.out.println("ERRO ao cadastrar Cliente !!");
			}
          
			
		}else if(op == 2) {
			
			cliente = new Cliente();
			
			System.out.println("EMAIL :");
			cliente.setEmail(scan.next());
			System.out.println("SENHA :");
			cliente.setSenha(scan.next());
			
			if(cliente.autenticar()) {
				
				
				menu_Cliente(); // segundo menu dentro da conta do cliente 
				
			}else {
				
				System.out.println("||||  LOGIN NÃO ENCONTRADO  ||||");
			}
			
			
			
		}else if(op == 3) {
			
			sair = 3;
		}
		
		}while(sair != 3);
	}
	
	
	
	
	public static void menu_Cliente(){ // segundo menu
		
		int sair=0;
		
		do {
		System.out.println("2- Depositar");
		System.out.println("3- Sacar");
		System.out.println("4- Saldo");
		System.out.println("5- tranferir");
		System.out.println("6- Mostrar Minhas Informações");
		System.out.println("7- sair");
		
		int op = scan.nextInt();
		
		
		switch(op){
		
		case 2:
			
          
			
		break;
		
			
		case 3:
			
		
			
		break;
		
			
		case 4:
			
		
			
		break;
			
		
		case 5:
			
			
			
		break;
		
			
		case 6:
			
			
			
			
		break;
		
		
		default:
			
			sair =7;
			
		break;	
		
		} 
		
		
		}while(sair != 7);
			
	}//----

	
	
	public static void criar_Conta() { // cadastro cliente
		
		
		System.out.println("Digite nome: ");
		String Nome= scan.next();
		
		System.out.println("Senha: ");
		String Senha = scan.next();
		
		
		
	
	}//----

	
	
	
     
	
	
	
	
}


