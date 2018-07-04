package lab5.comparators;

import java.util.Comparator;

import lab5.paulojunior.Cenario;

public class CadastroComparator implements Comparator<Cenario> {
	
	public int compare(Cenario c1, Cenario c2) {
		return c1.getId() - c2.getId();
	}

}
