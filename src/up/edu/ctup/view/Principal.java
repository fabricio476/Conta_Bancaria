package up.edu.ctup.view;

import java.util.Scanner;


import up.edu.ctup.controller.ControllerContaBancariaCliente;
import up.edu.ctup.model.Cliente;
import up.edu.ctup.model.ContaBancaria;
import up.edu.ctup.model.Pessoa;


public class Principal {


	static Scanner scan = new Scanner(System.in);
	public static Cliente cliente;
	
	static ControllerContaBancariaCliente controller = new ControllerContaBancariaCliente();
	
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
			
			
			if(ControllerContaBancariaCliente.salvarCliente(cliente)) {
				
				System.out.println("Cliente Cadastrado com Sucesso !!");
				
			}else {
				
				System.err.println("ERRO ao cadastrar Cliente !! [CLIENTE JÁ EXISTE ! ]\n");
			}
          
			
		}else if(op == 2) {
			
			
			
			System.out.println("EMAIL :");
			String email = scan.next();
			
			
			System.out.println("SENHA :");
			String senha = scan.next();
			
			
					
			
			
			if(new Cliente(email,senha).autenticar(ControllerContaBancariaCliente.getClientes())  ) {
			
			cliente = new Cliente(email,senha);
			
				
			cliente = controller.buscarCliente(cliente); /*metodo para retornar os atributos do cliete autenticado*/
				
			if(cliente != null) {
				
				System.out.println("Nome : "+cliente.getNome() + " | Numero Conta : "+ cliente.getContaBancaria().getNumero_conta());
				
				menu_Cliente(); // segundo menu dentro da conta do cliente 
				
			}else {
				
				System.err.println("\t ** Perfil Admin **\n");
				
				System.out.println("Qual o NUMERO da conta do cliente?");
				Integer nConta = scan.nextInt();
				
				cliente =  (Cliente) new Cliente().acesso(nConta, ControllerContaBancariaCliente.getClientes());
				
				if(cliente == null) {
					
					System.err.println("Usuario não encontrado !!\n");
				}else {
					int salir=0;
					
					do {
					System.out.println("Nome : "+cliente.getNome() + " | Numero Conta : "+ cliente.getContaBancaria().getNumero_conta());
					
					System.out.println("1 - Bloquear Conta");
					System.out.println("2 - Ajustar Limite");
					System.out.println("3 - Excluir Conta ");
					System.out.println("4 - Enviar Mensagem");
					System.out.println("5 - Sair");
					int ap = scan.nextInt();
					
					switch (ap) {
					case 1:
						
						break;
						
                      case 5:
						salir =7;
						break;

					default:
						salir =7;
						break;
					}
					
					
					
					
					}while(salir != 7);
					
					
				}
				
				
				
			}
			
			
			
				
				
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
			
			float valor = cliente.getContaBancaria().getContascliente().get(1).getSaldo();
			
			System.out.println("Qual o Valor do deposito?");
			cliente.getContaBancaria().getContascliente().get(1).depositar_dinheiro(scan.nextFloat());
			
			
			
			if(valor != cliente.getContaBancaria().getContascliente().get(1).getSaldo() ) {
				
				System.out.println("Deposito Realizado com Sucesso");
				
			}else {
				
				System.err.println("Falha ao Realizar o Deposito ");
				
			}
			
			 
			
		break;
		
			
		case 3:
			
		
			
		break;
		
			
		case 4:
			
		  System.out.println(" SALDO : "+cliente.getContaBancaria().getContascliente().get(1).getSaldo());
			
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

	


	
	
	
     
	
	
	
	
}


