package lab5.comparators;

import java.util.Comparator;
import lab5.paulojunior.Cenario;

public class DescricaoComparator implements Comparator {

	public int compare(Cenario c1, Cenario c2) {
		return c1.getDescricao().compareTo(c2.getDescricao());
	}
	
}
