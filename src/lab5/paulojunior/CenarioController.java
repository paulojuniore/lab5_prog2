package lab5.paulojunior;

import java.util.Iterator;
import java.util.SortedMap;

/**
 * Representa um sistema de apostas. Todo Sistema possui um caixa, taxa e um conjunto de cenários.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */
public class CenarioController {
	
	/**
	 * Representa o identificador de um sistema.
	 */
	private int idBase;
	
	/**
	 * Caixa que representa a quantidade de dinheiro do sistema.
	 */
	private int caixa;
	
	/**
	 * Taxa de juros do sistema.
	 */
	private double taxa;
	
	/**
	 * Representa o valor que é multiplicado pela taxa para ser adicionado ao caixa.
	 */
	private int rateio;
	
	/**
	 * Conjunto de cenários que armazena todos os cenários do sistema.
	 */
	private SortedMap<Integer, Cenario> cenarios;
	
	/**
	 * Constrói um sistema a partir da quantidade inicial de dinheiro no sistema e sua taxa de juros.
	 * 
	 * @param caixa : dinheiro do sistema.
	 * @param taxa : taxa de juros do sistema.
	 */
	public CenarioController(int caixa, double taxa) {
		this.idBase = 1;
		this.caixa = caixa;
		this.taxa = taxa;
	}
		
	/**
	 * Cadastra um novo cenário a partir da sua descrição.
	 * 
	 * @param descricao : descrição do cenário de apostas.
	 * 
	 * @return : retorna uma String representando a probabilidade de acerto.
	 */
	public int cadastrarCenario(String descricao) {
		Cenario cenario = new Cenario(this.idBase++, descricao);
		cenarios.put(cenario.getId(), cenario);
		return cenario.getId();
	}
	
	/**
	 * Exibe um cenário a partir do seu número de identificação.
	 * 
	 * @param idCenario : inteiro que representa a identificação de um cenário.
	 * 
	 * @return : retorna a representação String de um cenário.
	 */
	public String exibirCenario(int idCenario) {
		if(cenarios.containsKey(idCenario))
			return cenarios.get(idCenario).toString();
		return "Cenário não cadastrado!" + System.lineSeparator();
	}
		
	/**
	 * Exibe todos os cenários cadastrados no sistema.
	 * 
	 * @return : retorna uma String com todos a representação de cada um dos cenários cadastrados no sistema.
	 */
	public String exibirCenarios() {
		String aux = "";
		Iterator<Integer> it = this.cenarios.keySet().iterator();
		while(it.hasNext()) {
			aux += this.cenarios.get(it.next()).toString();
		}
		return aux;
	}
	
	/**
	 * Cadastra uma aposta dentro do sistema em um cenário especificado.
	 * 
	 * @param cenario : número de identificação do cenário.
	 * @param apostador : nome do apostador.
	 * @param valor : valor da aposta.
	 * @param previsao : previsão de o apostador ganhar ou não a aposta.
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		Cenario aux = this.cenarios.get(cenario);
		if(aux != null) {
			aux.cadastrarAposta(apostador, valor, previsao);
		}
	}
	
	/**
	 * Retorna a quantidade de dinheiro contida no caixa.
	 * 
	 * @return : retorna a a quantidade de dinheiro contida no caixa.
	 */
	public int getCaixa() {
		return caixa;
	}
	
	/**
	 * Encerra um cenário e atribui o dinheiro dos apostadores que perderam ao caixa.
	 * 
	 * @param cenario : identificador do cenário que será encerrado.
	 * @param ocorreu : boolean que representa se ocorreu ou não (true/false).
	 */
	public void fecharCenario(int cenario, boolean ocorreu) {
		if(cenarios.containsKey(cenario)) {
			int rateio = 0;
			Cenario aux = cenarios.get(cenario);
			Iterator<Aposta> it = aux.getApostas().iterator();
			if(ocorreu) {
				while(it.hasNext()) {
					if(it.next().getPrevisao().equals("NÃO OCORREU")) {
						rateio += it.next().getValor();
					}
				}
			}
			else {
				while(it.hasNext()) {
					if(it.next().getPrevisao().equals("OCORREU")) {
						rateio += it.next().getValor();
					}
				}
			}
			this.caixa += rateio * this.taxa;
		}
	}
	
//	public int getCaixaCenario(int cenario) {
//		if(cenarios.containsKey(cenario)) {
//			return cenarios.get(cenario)
//		}
//	}
	
}
