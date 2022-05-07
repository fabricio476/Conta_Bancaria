package up.edu.ctup.interfaces;

import java.util.HashMap;

import up.edu.ctup.model.Cliente;
import up.edu.ctup.model.Pessoa;

public interface PermitirAcesso {
	
	
	/*metodo para fazer altenticação*/
	public boolean autenticar(HashMap<Integer, Cliente> dados);
	
	public Cliente acesso(Integer numero_conta, HashMap<?, ?> dados);

}
