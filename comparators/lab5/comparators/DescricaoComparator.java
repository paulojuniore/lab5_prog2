package lab5.comparators;

import java.util.Comparator;
import lab5.paulojunior.Cenario;

/**
 * Comparator de um cenário através da sua descrição.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */

public class DescricaoComparator implements Comparator<Cenario> {

	public int compare(Cenario c1, Cenario c2) {
		return c1.getDescricao().compareTo(c2.getDescricao());
	}
	
}
