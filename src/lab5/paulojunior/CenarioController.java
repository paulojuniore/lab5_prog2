package lab5.paulojunior;

import java.util.HashMap;

/**
 * Representa um sistema de apostas. Todo Sistema possui um caixa, taxa e um conjunto de cenários.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */
public class CenarioController {
	
	/**
	 * Caixa que representa a quantidade de dinheiro do sistema.
	 */
	private int caixa;
	
	/**
	 * Taxa de juros do sistema.
	 */
	private double taxa;
	
	/**
	 * Conjunto de cenários que armazena todos os cenários do sistema.
	 */
	private HashMap<Integer, Cenario> cenarios;
	
	/**
	 * Representa o identificador de um sistema.
	 */
	private int idCenario;
	
	
	/**
	 * Constrói um sistema a partir da quantidade inicial de dinheiro no sistema e sua taxa de juros.
	 * 
	 * @param caixa : dinheiro do sistema.
	 * @param taxa : taxa de juros do sistema.
	 */
	public CenarioController(int caixa, double taxa) {
		if(caixa < 0) 
			throw new NumberFormatException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		else if(taxa < 0)
			throw new NumberFormatException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		
		this.idCenario = 1;
		this.caixa = caixa;
		this.taxa = taxa;
		this.cenarios = new HashMap<>();
		
	}
		
	/**
	 * Cadastra um novo cenário a partir da sua descrição.
	 * 
	 * @param descricao : descrição do cenário de apostas.
	 * 
	 * @return : retorna um int representando o identificador do cenário.
	 */
	public int cadastrarCenario(String descricao) {
		Cenario cenario = new Cenario(idCenario, descricao);
		cenarios.put(this.idCenario, cenario);
		return this.idCenario++;
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
	
	public String exibirApostas(int idCenario) {
		if(cenarios.containsKey(idCenario))
			return cenarios.get(idCenario).exibirApostas();
		return "Cenário não cadastrado!" + System.lineSeparator();
	}
		
	/**
	 * Exibe todos os cenários cadastrados no sistema.
	 * 
	 * @return : retorna uma String com todos a representação de cada um dos cenários cadastrados no sistema.
	 */
	public String exibirCenarios() {
		String aux = "";
		for(int chave : cenarios.keySet()) {
			aux += chave + " - " + cenarios.get(chave).toString();
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
			aux.fazerAposta(apostador, valor, previsao);
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
	 * Retorna o total de apostas efetuadas em um cenário, a partir do número do cenário.
	 * 
	 * @param cenario : número do cenário a saber a quantidade de apostas.
	 * 
	 * @return : retorna o número de apostas efetuadas em um cenário.
	 */
	public int totalDeApostas(int cenario) {
		return cenarios.get(cenario).getTotalDeApostas();
	}
	
	public int valorTotalEmApostas(int cenario) {
		return cenarios.get(cenario).getValorTotalEmApostas();
	}
	
	/**
	 * Encerra um cenário e atribui o dinheiro dos apostadores que perderam ao caixa.
	 * 
	 * @param cenario : identificador do cenário que será encerrado.
	 * @param ocorreu : boolean que representa se ocorreu ou não (true/false).
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		this.cenarios.get(cenario).encerrarCenario(ocorreu);
		this.caixa += (int) this.cenarios.get(cenario).somaApostasPerdedoras() * taxa;
	}
	
	/**
	 * Retorna a quantidade de dinheiro que será destinada ao caixa.
	 * 
	 * @return : retorna a quantidade de dinheiro que será destinada ao caixa.
	 */
	public int getCaixaCenario(int cenario) {
		return (int) (this.cenarios.get(cenario).somaApostasPerdedoras() * taxa);
	}
	
	public int getTotalRateioCenario(int cenario) {
		return this.cenarios.get(cenario).somaApostasPerdedoras() - this.getCaixaCenario(cenario);
	}
	
}
