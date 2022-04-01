package up.edu.ctup.view;

import java.util.Scanner;

import up.edu.ctup.controller.ControllerContaEspecial;
import up.edu.ctup.controller.ControllerContas;
import up.edu.ctup.model.ContaBancaria;
import up.edu.ctup.model.ContaEspecial;
import up.edu.ctup.model.ContaPoupança;


public class Contas {

	static ControllerContaEspecial controlespecial = new ControllerContaEspecial();
	static Scanner scan = new Scanner(System.in);
	static ContaBancaria conta = new ContaBancaria();
	static ContaEspecial contaespecial = new ContaEspecial();
	static ContaPoupança contapoupanca = new ContaPoupança();
	static ControllerContas control = new ControllerContas();
	static int nconta=0,pcliente,P,M;
	
	
	public static void main(String[] args) {
			
		menuinicial();	// menu inicial onde o programa começa
		
	}
	
	
	public static void menu(){ // segundo menu
		
		int sair=0;
		
		do {
		System.out.println("2- Depositar");
		System.out.println("3- Sacar");
		System.out.println("4- Saldo");
		System.out.println("5- Mostrar dados do cliente");
		System.out.println("6- sair");
		
		int op = scan.nextInt();
		
		
		switch(op){
		
		case 2:
			
           if(control.listacontas.get(pcliente).getTipo() == 01) { //-- depositar conta especial
				
        	   
        	System.out.println("informe o valor");
   			float valor = scan.nextFloat();	
   			
   			P = controlespecial.posicaoconta(control.listacontas.get(pcliente).getNum_conta()); // encontar onde esta guarsdado a conta do cliente
   					
   			controlespecial.deposit_list(P,valor); // classe contaespecial|controllercontaespecial|contas - executar o deposito
   			
   			   System.out.println("SALDO: "+controlespecial.saldo(P)); // printar o saldo
        	   
				
			}else if(control.listacontas.get(pcliente).getTipo() == 02) {  //--- depositar na conta polpança
				
				
				System.out.println("informe o valor");
				float valor = scan.nextFloat();	
				
				P = control.posicaoconta(control.listacontas.get(pcliente).getNum_conta());
				
				control.deposit_list(P,valor); // classe contapoupanca|controllercliente|contas - executar o deposito
				
				System.out.println("SALDO: "+control.saldo(P)); //printar o saldo
			}
			
		break;
		
			
		case 3:
			
			if(control.listacontas.get(pcliente).getTipo() == 01) {
			
				
				System.out.println("informe o valor");
				float valor = scan.nextFloat();	
				
				P = controlespecial.posicaoconta(control.listacontas.get(pcliente).getNum_conta());
				
				controlespecial.saque_list(P,valor); //classe contabancaria|controllercliente|contas - executar o saque
				
				System.out.println("SALDO: "+controlespecial.saldo(P));//printar o saldo
				
			}else if(control.listacontas.get(pcliente).getTipo() == 02) {
			
				System.out.println("informe o valor");
				float valor = scan.nextFloat();	
				
				P = control.posicaoconta(control.listacontas.get(pcliente).getNum_conta());
				
				control.saque_list(P,valor); //classe contabancaria|controllercliente|contas - executar o saque
				
				System.out.println("SALDO: "+control.saldo(P)); //printar o saldo
			}
			
		break;
		
			
		case 4:
			
			if(control.listacontas.get(pcliente).getTipo() == 01) {
				
				P = controlespecial.posicaoconta(control.listacontas.get(pcliente).getNum_conta());
				
				System.out.println("\nSALDO CONTA ESPECIAL ");
				System.out.println("SALDO: "+controlespecial.saldo(P));
				System.out.println("LIMITE:"+controlespecial.listcontaespecial.get(P).getLimite());
					
				
			}else if(control.listacontas.get(pcliente).getTipo() == 02) {
				
				P = control.posicaoconta(control.listacontas.get(pcliente).getNum_conta());
				
		contapoupanca.calcularNovoSaldo(control.listacontapolp.get(P).getSaldo());// conta recebe novo saldo com juros poupanca
				
		         System.out.println("\nSALDO + JUROS DE: %0.3");
		         System.out.println("NOVO SALDO: "+control.saldo(P)+"\n");
			}
			
		break;
			
		
		case 5:
			
			System.out.println(control.dados_cliente(pcliente)); // printar os dados do cliente
			
		break;
		
			
		case 6:
			
			P=0;
			sair =7;
			
		break;
		
		} 
		
		
		}while(sair != 7);
			
	}//final do metodo menu

	
	
	public static void cadcliente() { // cadastro cliente
		
		conta = new ContaBancaria();
		contaespecial = new ContaEspecial();
		contapoupanca = new ContaPoupança();
		
         nconta = control.numeroConta(); // gerar o numero da conta do cliente
		
		conta.setNum_conta(nconta); // quardar o numero da conta
		
		System.out.println("Digite nome: ");
		String A= scan.next();
		conta.setCliente(A);
		System.out.println("Senha: ");
		//int B= scan.nextInt();
		conta.setSenha(scan.nextInt());
		
		System.out.println(" - tipo da conta - \n 1 - Conta especial \n 2 - Conta Poupança");
		int op = scan.nextInt();
		
		if(op == 1) {
			
			
			conta.setTipo(01);
			contaespecial.setCliente(A);
			contaespecial.setNum_conta(nconta);
			contaespecial.setLimite(200);
			
			System.out.println("--------------------------------------");
			System.out.println("NOME: "+contaespecial.getCliente());
			System.out.println("NUMERO DA CONTA: "+contaespecial.getNum_conta());
			System.out.println("LIMITE: "+contaespecial.getLimite());
			System.out.println("TIPO DE CONTA: Especial");
			System.out.println("--------------------------------------");
			
			controlespecial.cadastrarConta(contaespecial); // quardar os dados na lista contaespecial
			
			
		}else if(op == 2) {
			
			conta.setTipo(02);
			contapoupanca.setCliente(A);
			contapoupanca.setNum_conta(nconta);
			
			System.out.println("--------------------------------------");
			System.out.println("NOME: "+contapoupanca.getCliente());
			System.out.println("NUMERO DA CONTA: "+contapoupanca.getNum_conta());
			System.out.println("TIPO DE CONTA : Poupança");
			System.out.println("--------------------------------------");
			
			control.cadastrarContapoupanca(contapoupanca); //quardar os dados na lista poupanca
			
		}
		
		
		control.cadastrarConta(conta); // quardar os dados na lista principal
	
	}//final da função cadcliente

	
	public static void menuinicial() { // primeiro menu
		
		int op=0,sair=0;
		do {
			
		System.out.println("1- cadastrar cliente");
		System.out.println("2- login");
		System.out.println("3- sair");
		op = scan.nextInt();
		
		if(op == 1) {
			
			cadcliente();	//função para cadastrar o cliente
			
		}else if(op == 2) {
			
			login(); //função para fazer o login
			
		}else if(op == 3) {
			
			sair = 3;
		}
		
		}while(sair != 3);
	}
	
	
	public static void login() { // fazer o login
		
		System.out.println("NUMERO CONTA :");
		int numero_conta = scan.nextInt();
		System.out.println("SENHA :");
		int senha = scan.nextInt();
		
		pcliente = control.contacliente(numero_conta, senha); //descobrir a posição do cliente a armazenar na variavel
		
		if(control.autenticar(numero_conta, senha)) {
			
			
			menu(); // segundo menu dentro da conta do cliente 
			
		}else {
			
			System.out.println("||||  LOGIN NÃO ENCONTRADO  ||||");
		}
			
	}
	
	
     
	
	
	
	
}


/*Após a implementação das classes acima, você deverá implementar uma classe Contas.Java,
contendo o método main. Nesta classe, você deverá implementar:
Incluir dados relativos a(s) conta(s) de um cliente;
Sacar um determinado valor da(s) sua(s) conta(s);
Depositar um determinado valor na(s) sua(s) conta(s);
Mostrar o novo saldo do cliente, a partir da taxa de rendimento, daqueles que possuem conta poupança;
Mostrar os dados da(s) conta(s) de um cliente;

*/