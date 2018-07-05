package lab5.comparators;

import java.util.Comparator;
import lab5.paulojunior.Cenario;

/**
 * Comparator de um cenário através da ordem de cadastro.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */

public class CadastroComparator implements Comparator<Cenario> {
	
	public int compare(Cenario c1, Cenario c2) {
		return c1.getId() - c2.getId();
	}

}
