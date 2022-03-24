package doacao;

import java.util.List;

import beneficiario.Beneficiario;
import transacao.Transacao;

public abstract class Doacao  extends Transacao {

	private List<Beneficiario> beneficiarios;
	
	public abstract void doar();
	
	public void addBeneficiario(Beneficiario beneficiario) {
		
	}
}
