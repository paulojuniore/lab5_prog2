package lab5.paulojunior;

/**
 * Representa um tipo de aposta, que é a aposta segurada com taxa, toda Aposta Assegurada possui todos os atributos
 * de uma aposta comum com o acréscimo de uma taxa de seguro.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */

public class ApostaSeguradaTaxa extends Aposta{
	
	/**
	 * Representa o tipo de seguro. (VALOR ou TAXA)
	 */
	private String tipoSeguro;
	
	/**
	 * Representa a taxa assegurada de uma aposta.
	 */
	private int taxaAssegurada;
	
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
	 * @param taxaAssegurada : taxa de seguro da aposta.
	 * @param custoSeguro : custo do seguro de uma aposta.
	 */
	public ApostaSeguradaTaxa(String nome, int valorAposta, String previsao, String tipoSeguro, int taxaAssegurada, int custoSeguro) {
		super(nome, valorAposta, previsao);
		this.tipoSeguro = tipoSeguro;
		this.taxaAssegurada = taxaAssegurada;
		this.custoSeguro = custoSeguro;
	}
	
	/**
	 * Retorna a taxa assegurada de uma aposta.
	 * 
	 * @return : retorna a taxa assegurada de uma aposta.
	 */
	public int getTaxaAssegurada() {
		return taxaAssegurada;
	}
	
	/**
	 * Retorna o custo do seguro de uma aposta.
	 * 
	 * @return : retorna o custo do seguro de uma aposta.
	 */
	public int getCustoSeguro() {
		return custoSeguro;
	}

}
