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
		if(nome == null || nome.trim().isEmpty())
			throw new IllegalArgumentException("Nome inválido!\n");
		else if(valorAposta <= 0)
			throw new NumberFormatException("Valor de aposta inválido!\n");
		else if(previsao == null || previsao.trim().isEmpty())
			throw new IllegalArgumentException("Previsão de aposta inválida!\n");
		
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
	 * Retorna a previsão de acontecer ou não uma aposta.
	 * 
	 * @return : retorna a previsão de acontecimento de uma aposta.
	 */
	public String getPrevisao() {
		return previsao;
	}
	
	/**
	 * Representação String de uma aposta.
	 */
	public String toString() {
		return nome + " - " + valorAposta + " - " + previsao + System.lineSeparator();
	}

}
