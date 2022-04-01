package up.edu.ctup.model;

public class ContaPoupan�a extends ContaBancaria{
	
	private int dia_de_rendimento;
	private float taxa= (float) 0.003;
	


	public int getDia_de_rendimento() {
		return dia_de_rendimento;
	}


	public void setDia_de_rendimento(int dia_de_rendimento) {
		this.dia_de_rendimento = dia_de_rendimento;
	}


	public float getTaxa() {
		return taxa;
	}


	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

	public void calcularNovoSaldo(float dinheiro) { //rendimento da poupa�a
		
		float valor;
		
		valor= dinheiro*taxa;
		
		this.saldo = getSaldo() + valor;
		
	}
	
}

/*atributo int dia de rendimento
m�todo calcularNovoSaldo, recebe a taxa de rendimento da poupan�a e atualiza o saldo.
*/