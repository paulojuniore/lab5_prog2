package lab5.paulojunior;

public class CenarioBonus extends Cenario{
	
	/**
	 * Bônus de um cenário.
	 */
	private int bonus;

	
	/**
	 * Constrói um Cenário Bônus a partir de um cenário comum mais um bônus.
	 * 
	 * @param id : identificador do cenário.
	 * @param descricao : descrição de um cenário.
	 * @param bonus : bônus de um cenário.
	 */
	public CenarioBonus(int id, String descricao, int bonus) {
		super(id, descricao);
		this.bonus = bonus;
	}
	
	/**
	 * Retorna o bônus de um cenário.
	 * 
	 * @return : retorna o bônus do cenário.
	 */
	public int getBonus() {
		return bonus;
	}

}
