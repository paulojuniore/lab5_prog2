package lab5.paulojunior;

/**
 * Representa um tipo de aposta, que é a aposta segurada com taxa, toda Aposta Assegurada por Taxa possui todos 
 * os atributos de uma aposta comum com o acréscimo de uma taxa a ser assegurada e o custo do seguro.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */

public class ApostaSeguradaTaxa extends Aposta{
	
	/**
	 * Representa a taxa assegurada de uma aposta.
	 */
	private double taxaSeguro;
	
	/**
	 * Representa o custo do segura da aposta.
	 */
	private int custoSeguro;

	
	/**
	 * Constrói uma aposta Assegurada por uma taxa.
	 * 
	 * @param nome : nome do apostador.
	 * @param valorAposta : valor da aposta.
	 * @param previsao : previsão de o apostador ganhar a aposta.
	 * @param taxaSeguro : taxa de seguro da aposta.
	 * @param custoSeguro : custo do seguro de uma aposta.
	 */
	public ApostaSeguradaTaxa(String nome, int valorAposta, String previsao, double taxaSeguro, int custoSeguro) {
		super(nome, valorAposta, previsao);
		this.taxaSeguro = taxaSeguro;
		this.custoSeguro = custoSeguro;
	}
	
	/**
	 * Retorna a taxa assegurada de uma aposta.
	 * 
	 * @return : retorna a taxa assegurada de uma aposta.
	 */
	public double getTaxaSeguro() {
		return taxaSeguro;
	}
	
	/**
	 * Retorna o custo do seguro de uma aposta.
	 * 
	 * @return : retorna o custo do seguro de uma aposta.
	 */
	public int getCustoSeguro() {
		return custoSeguro;
	}
	
	/**
	 * Representação String de uma Aposta Assegurada pro Taxa.
	 * 
	 * @return : retorna a representação String de uma aposta assegurada por taxa.
	 */
	public String toString() {
		return super.getNome() + " - R$" + super.getValor() + " - " + super.getPrevisao() + " - ASSEGURADA (TAXA) - R$" + getTaxaSeguro();
	}

}
