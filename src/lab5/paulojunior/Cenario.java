package lab5.paulojunior;

import java.util.ArrayList;

/**
 * Representa um cenário de apostas. Todo cenário possui uma descrição, status e um conjunto de apostas.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */
public class Cenario {
	
	/**
	 * Descrição de um cenário.
	 */
	private String descricao;
	
	/**
	 * Status de um cenário. O status inicia como true, significando que o cenário está funcionando.
	 */
	private String status;
	
	/**
	 * Representa se uma aposta pode acontecer ou não. true/false
	 */
	private boolean previsao;
	
	/**
	 * Conjunto de apostas de um cenário.
	 */
	private ArrayList<Aposta> apostas;
	
	/**
	 * Soma dos valores de todas as apostas do cenário.
	 */
	private int valorTotalEmApostas = 0;
	
	private int id;
	
	
	/**
	 * Constrói um cenário a partir do seu identificador e descrição.
	 * 
	 * @param id : identificador único de um cenário.
	 * @param descricao : descrição de um cenário.
	 */
	public Cenario(int id, String descricao) {
		if(descricao.trim().isEmpty() || descricao == null) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		
		this.descricao = descricao;
		this.status = "N finalizado";
		this.previsao = false;
		this.apostas = new ArrayList<>();
		this.id = id;
	}
	
	/**
	 * Cadastra uma aposta em um cenário.
	 * 
	 * @param apostador : nome do apostador.
	 * @param valor : valor da aposta.
	 * @param previsao : previsão de se o apostador vai ganhar ou não.
	 */
	public void fazerAposta(String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(apostador, valor, previsao);
		this.apostas.add(aposta);
		this.valorTotalEmApostas += aposta.getValor();	
	}
	
	/**
	 * Encerra um cenário existente.
	 * 
	 * @param ocorreu : boolean que representa se a aposta ocorreu ou não.
	 */
	public void encerrarCenario(boolean ocorreu) {
		if(ocorreu) {
			this.status = "Finalizado (ocorreu)";
			this.previsao = true;
		}
		else {
			this.status = "Finalizado (n ocorreu)";
		}
	}
	
	/**
	 * Retorna a soma das apostas que tiveram resultado contrário ao sorteado.
	 * 
	 * @return : retorna a soma da apostas perdedoras.
	 */
	public int somaApostasPerdedoras() {
		int soma = 0;
		for(Aposta aposta : apostas) {
			if(aposta.getPrevisao().equals("VAI ACONTECER") && !previsao) {
				soma += aposta.getValor();
			}
			else if(aposta.getPrevisao().equals("N VAI ACONTECER") && previsao) {
				soma += aposta.getValor();
			}
		}
		return soma;
	}
	
	/**
	 * Retorna o status de um cenário.
	 * 
	 * @return : retorna o status de um cenário.
	 */
	public String getStatus() {
		return status;
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
	
	public int getId() {
		return id;
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
	 * Verifica se o cenário foi finalizado.
	 * 
	 * @return : retorna se o cenário foi finalizado ou não. true/false
	 */
	public boolean isFinalizado() {
		return status.equals("Finalizado (ocorreu)") || status.equals("Finalizado (n ocorreu)");
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
