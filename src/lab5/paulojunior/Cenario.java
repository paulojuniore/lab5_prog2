package lab5.paulojunior;

import java.util.ArrayList;

/**
 * Representa um cenário de apostas. Todo cenário possui uma descrição, um status (Finalizado/Nao finalizado), uma 
 * previsão de acontecimento da aposta (true/false), um conjunto de apostas e um identificador único de um cenário.
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
	
	/**
	 * Identificador único de um cenário de apostas.
	 */
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
		this.status = "Nao finalizado";
		this.previsao = false;
		this.apostas = new ArrayList<>();
		this.id = id;
	}
	
	/**
	 * Cadastra uma aposta em um cenário.
	 * 
	 * @param apostador : nome do apostador.
	 * @param valor : valor da aposta.
	 * @param previsao : previsão de se o apostador vai ganhar ou não a aposta.
	 */
	public void fazerAposta(String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(apostador, valor, previsao);
		this.apostas.add(aposta);
		this.valorTotalEmApostas += aposta.getValor();	
	}
	
	/**
	 * Concretiza uma aposta assegurada por valor, já com todos os atributos verificados e válidos.
	 * 
	 * @param cenario : identificador do cenário em que será cadastrada a aposta.
	 * @param apostador : nome do apostador.
	 * @param valorAposta : valor da aposta.
	 * @param previsao : previsão de o apostador ganhar ou não a aposta.
	 * @param valorSeguro : valor a ser assegurado pelo cenário.
	 * @param custoSeguro : custo do seguro.
	 * 
	 * @return : retorna um identificador único de uma aposta assegurada por valor.
	 */
	public int fazerApostaSeguradaValor(int cenario, String apostador, int valorAposta, String previsao, int valorSeguro, int custoSeguro) {
		Aposta aposta = new ApostaSeguradaValor(apostador, valorAposta, previsao, valorSeguro, custoSeguro);
		this.apostas.add(aposta);
		this.valorTotalEmApostas += aposta.getValor();
		return apostas.lastIndexOf(aposta);
	}
	
	/**
	 * Concretiza uma aposta assegurada por taxa, já com todos os atributos verificados e válidos.
	 * 
	 * @param cenario : identificador do cenário em que será cadastrada a aposta.
	 * @param apostador : nome do apostador.
	 * @param valorAposta : valor da aposta.
	 * @param previsao : previsão de o apostador ganhar ou não a aposta.
	 * @param taxaSeguro : taxa a ser assegurada pelo cenário.
	 * @param custoSeguro : custo do seguro.
	 * 
	 * @return : retorna um identificador único de uma aposta assegurada por taxa.
	 */
	public int fazerApostaSeguradaTaxa(int cenario, String apostador, int valorAposta, String previsao, double taxaSeguro, int custoSeguro) {
		Aposta aposta = new ApostaSeguradaTaxa(apostador, valorAposta, previsao, taxaSeguro, custoSeguro);
		this.apostas.add(aposta);
		this.valorTotalEmApostas += aposta.getValor();
		return apostas.lastIndexOf(aposta);
	}
	
	/**
	 * Altera uma aposta assegurada por taxa, para uma assegurada por valor.
	 * 
	 * @param aposta : objeto Aposta a ser alterado.
	 * @param apostaAssegurada : identificador da aposta assegurada por taxa.
	 * @param valor : valor da aposta.
	 * 
	 * @return : retorna o identificador da aposta após ser alterada.
	 */
	public int alteraApostaValor(ApostaSeguradaTaxa aposta, int apostaAssegurada, int valor) {
		Aposta aux = new ApostaSeguradaValor(aposta.getNome(), aposta.getValor(), aposta.getPrevisao(), valor, aposta.getCustoSeguro());
		this.apostas.remove(apostaAssegurada);
		this.apostas.add(aux);
		return apostas.lastIndexOf(aux);
	}
	
	/**
	 * Altera uma apostas assegurada por valor, para uma assegurada por taxa.
	 * 
	 * @param aposta : objeto Aposta a ser alterado.
	 * @param apostaAssegurada : identificador da aposta assegurada por valor.
	 * @param taxa : taxa da aposta.
	 * 
	 * @return : retorna o identificador da aposta após ser alterada.
	 */
	public int alteraApostaTaxa(ApostaSeguradaValor aposta, int apostaAssegurada, double taxa) {
		Aposta aux = new ApostaSeguradaTaxa(aposta.getNome(), aposta.getValor(), aposta.getPrevisao(), taxa, aposta.getCustoSeguro());
		this.apostas.remove(apostaAssegurada);
		this.apostas.add(aux);
		return apostas.lastIndexOf(aux);
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
	 * Retorna a lista de apostas de um cenário.
	 * 
	 * @param i : index da aposta na lista de apostas.
	 * 
	 * @return : retorna a lista de apostas de um cenário.
	 */
	public Aposta getApostas(int i){
		return apostas.get(i);
	}
	
	/**
	 * Retorna a descrição de um cenário.
	 * 
	 * @return : retorna a descrição de um cenário.
	 */
	public String getDescricao() {
		return descricao;
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
	 * Retorna o valor que será destinado ao caixa do sistema. Que é a soma das apostas perdedoras multiplicada
	 * pela taxa do sistema.
	 * 
	 * @param taxa : taxa de desconto do sistema.
	 * 
	 * @return : valor que será destinado ao caixa do sistema.
	 */
	public int getCaixa(double taxa) {
		return (int) Math.floor(this.somaApostasPerdedoras() * taxa);
	}
	
	/**
	 * Retorna o rateio total do cenário. Que é o valor que será dividido entre as apostas vencedoras.
	 * 
	 * @param taxa : taxa do sistema.
	 * 
	 * @return : retorna o rateio total do cenário.
	 */
	public int getRateioTotalCenario(double taxa) {
		return (int) Math.floor(this.somaApostasPerdedoras() - getCaixa(taxa));
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
	 * Retorna o identificador único de um cenário.
	 * 
	 * @return : retorna o identificador único de um cenário.
	 */
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
		return this.id + " - " + this.descricao + " - " + this.status;
	}
	
}
