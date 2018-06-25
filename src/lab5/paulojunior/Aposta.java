package lab5.paulojunior;

/**
 * Representa uma Aposta. Toda aposta possui um apostador, valor da aposta e previsão de o apostador ganhar ou perder a aposta.
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
	 * Previsão de apostador ganhar ou perder a aposta.
	 */
	private String previsao;
		
	
	/**
	 * Constrói uma aposta a partir do nome do apostador, valor da aposta e previsão da aposta.
	 * 
	 * @param nome : nome do apostador.
	 * @param valorAposta : valor da aposta.
	 * @param previsao : previsão de o apostador ganhar ou perder a aposta.
	 */
	public Aposta(String nome, int valorAposta, String previsao) {
		if(nome == null || nome.trim().isEmpty())
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		else if(valorAposta <= 0)
			throw new NumberFormatException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		else if(previsao == null || previsao.trim().isEmpty())
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		else if(!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER"))
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		
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
