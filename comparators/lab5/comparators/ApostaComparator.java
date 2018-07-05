package lab5.comparators;

import java.util.Comparator;

import lab5.paulojunior.Cenario;

/**
 * Comparator de um cenário através do número de apostas.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */

public class ApostaComparator implements Comparator<Cenario> {
	
	public int compare(Cenario c1, Cenario c2) {
		return c2.getTotalDeApostas() - c1.getTotalDeApostas();
	}

}
