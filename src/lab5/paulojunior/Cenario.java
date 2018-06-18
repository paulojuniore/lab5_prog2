package lab5.paulojunior;

import java.util.ArrayList;

/**
 * Representa um cenário de apostas. Todo cenário possui um identificador único, descrição, status e um conjunto de apostas.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */
public class Cenario {
	
	/**
	 * Identificador único de um cenário.
	 */
	private int id;
	
	/**
	 * Descrição de um cenário.
	 */
	private String descricao;
	
	/**
	 * Status de um cenário. O status inicia como true, significando que o cenário está funcionando.
	 */
	private boolean status;
	
	/**
	 * Conjunto de apostas de um cenário.
	 */
	private ArrayList<Aposta> apostas;
	
	/**
	 * Soma dos valores de todas as apostas do cenário.
	 */
	private int valorTotalEmApostas = 0;
	
	
	/**
	 * Constrói um cenário a partir do seu identificador e descrição.
	 * 
	 * @param id : identificador único de um cenário.
	 * @param descricao : descrição de um cenário.
	 */
	public Cenario(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
		this.status = true;
	}
	
	/**
	 * Cadastra uma aposta em um cenário.
	 * 
	 * @param apostador : nome do apostador.
	 * @param valor : valor da aposta.
	 * @param previsao : previsão de se o apostador vai ganhar ou não.
	 */
	public void cadastrarAposta(String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(apostador, valor, previsao);
		this.apostas.add(aposta);
		this.valorTotalEmApostas += aposta.getValor();	
	}
	
	/**
	 * Retorna o identificador de um cenário.
	 * 
	 * @return : retorna o identificador de um cenário.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Retorna o status de um cenário.
	 * 
	 * @return : retorna o status de um cenário.
	 */
	public boolean getStatus() {
		return status;
	}
	
	/**
	 * Altera o status de um cenário.
	 * 
	 * @param status : status do cenário.
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	/**
	 * Retorna o valor total em apostas de um cenário.
	 * 
	 * @return : retorna o valor total em apostas de um cenário.
	 */
	public int getValorTotalEmApostas() {
		return valorTotalEmApostas;
	}
	
	/**
	 * Retorna o total de apostas realizadas em um cenário.
	 * 
	 * @return : retorna o total de apostas realizadas em um cenário.
	 */
	public int getTotalDeApostas() {
		return apostas.size();
	}
		
	/**
	 * Exibe todas as apostas de um cenário na ordem em que foram efetuadas.
	 * 
	 * @return : retorna uma String que contém todas as apostas efetuadas.
	 */
	public String exibirApostas() {
		String aux = "";
		for (Aposta aposta : apostas) {
			aux += aposta.toString();
		}
		return aux;
	}
	
	/**
	 * Retorna a lista de apostas de um cenário.
	 * 
	 * @return : retorna a lista de apostas de um cenário.
	 */
	public ArrayList<Aposta> getApostas(){
		return this.apostas;
	}
	
	/**
	 * Retorna a representação String de um cenário.
	 * 
	 * @return : retorna a representação String de um cenário.
	 */
	public String toString() {
		return this.id + " - " + this.descricao + " - " + this.status + System.lineSeparator();
	}

}
