package lab5.paulojunior;

/**
 * 
 * Representa uma Aposta. Toda aposta possui um apostador, valor da aposta e previsão de o apostador ganhar a aposta.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */
public class Aposta {
	
	/**
	 * Nome do apostador.
	 */
	private String nome;
	
	/**
	 * Valor da aposta.
	 */
	private int valorAposta;
	
	/**
	 * Previsão de apostador ganhar ou não a aposta.
	 */
	private String previsao;
		
	/**
	 * Constrói uma aposta a partir do nome do apostador, valor da aposta e previsão de o apostador ganhar a aposta.
	 * 
	 * @param nome : nome do apostador.
	 * @param valorAposta : valor da aposta.
	 * @param previsao : previsão de o apostador ganhar ou não a aposta.
	 */
	public Aposta(String nome, int valorAposta, String previsao) {
		this.nome = nome;
		this.valorAposta = valorAposta;
		this.previsao = previsao;
	}
	
	/**
	 * Retorna o valor da aposta.
	 * 
	 * @return : retorna o valor da aposta.
	 */
	public int getValor() {
		return valorAposta;
	}
	
	/**
	 * Representação String de uma aposta.
	 */
	public String toString() {
		return nome + " - " + valorAposta + " - " + previsao + System.lineSeparator();
	}

}
