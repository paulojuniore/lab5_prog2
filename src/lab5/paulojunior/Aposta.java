package lab5.paulojunior;

public class Aposta {
	
	private String nome;
	private double valorAposta;
	private String previsao;
	
	public Aposta(String nome, double valorAposta, String previsao) {
		this.nome = nome;
		this.valorAposta = valorAposta;
		this.previsao = previsao;
	}
	
	public String toString() {
		return nome + " - " + valorAposta + " - " + previsao + System.lineSeparator();
	}

}
