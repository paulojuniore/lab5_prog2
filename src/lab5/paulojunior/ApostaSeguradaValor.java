package lab5.paulojunior;

/**
 * Representa um tipo de aposta, que é a aposta segurada com valor, toda Aposta Assegurada por Valor possui todos 
 * os atributos de uma aposta comum com o acréscimo de um valor a ser assegurado e o custo do seguro.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */

public class ApostaSeguradaValor extends Aposta{
	
	/**
	 * Representa o valor assegurado de uma aposta.
	 */
	private int valorAssegurado;
	
	/**
	 * Representa o custo do segura da aposta.
	 */
	private int custoSeguro;


	/**
	 * Constrói uma aposta segurada por valor.
	 * 
	 * @param nome : nome do apostador.
	 * @param valorAposta : valor da aposta.
	 * @param previsao : previsão de apostador ganhar a aposta.
	 * @param valorAssegurado : valor assegurado pela aposta.
	 * @param custoSeguro : custo do seguro da aposta.
	 */
	public ApostaSeguradaValor(String nome, int valorAposta, String previsao, int valorAssegurado, int custoSeguro) {
		super(nome, valorAposta, previsao);
		this.valorAssegurado = valorAssegurado;
		this.custoSeguro = custoSeguro;
	}
	
	/**
	 * Retorna o valor assegurado da aposta.
	 * 
	 * @return : retorna o valor assegurado da aposta.
	 */
	public int getValorAssegurado() {
		return valorAssegurado;
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
	 * Representação String de uma Aposta Assegurada por Valor.
	 * 
	 * @return : retorna a representação String de uma aposta assegurada por valor.
	 */
	public String toString() {
		return super.getNome() + " - R$" + super.getValor() + " - " + super.getPrevisao() + " - ASSEGURADA (VALOR) - R$" + String.format("%.2f", (float) getValorAssegurado()); 
	}

}
