package lab5.paulojunior;

/**
 * Representa um cenário que possui um bônus, estende a classe cenário que possui todos os atributos de um cenário comum,
 * com o acréscimo de um bônus.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */

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
		if(bonus <= 0)
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
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
	
	/**
	 * Retorna o rateio total do cenário a partir da taxa do sistema.
	 * 
	 * @param taxa : taxa do sistema.
	 * 
	 * @return : retorna o rateio total do cenário que será dividido entre as apostas vencedoras.
	 */
	public int getRateioTotalCenario(double taxa) {
		return super.getRateioTotalCenario(taxa) + this.bonus;
	}
	
	/**
	 * Retorna a representação String de um cenário com bônus.
	 * 
	 * @return : retorna a representação String de um cenário com bônus.
	 */
	public String toString() {
		return super.getId() + " - " + super.getDescricao() + " - " + super.getStatus() + " - R$ " +
		String.format("%.2f", (float) this.bonus / 100);
	}
}
