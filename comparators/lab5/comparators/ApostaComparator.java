package lab5.comparators;

import java.util.Comparator;

import lab5.paulojunior.Cenario;

public class ApostaComparator implements Comparator<Cenario> {
	
	public int compare(Cenario c1, Cenario c2) {
		return c2.getTotalDeApostas() - c1.getTotalDeApostas();
	}

}
