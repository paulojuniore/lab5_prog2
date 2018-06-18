package lab5.paulojunior;

/**
 * Classe Fachada para o sistema de apostas.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */
public class Facade {
	
	/**
	 * Representa um sistema de apostas.
	 */
	private CenarioController system;
		
	/**
	 * Inicializa um sistema a partir do dinheiro inicial no caixa e a taxa de juros do sistema.
	 * 
	 * @param caixa : dinheiro disponível no caixa.
	 * @param taxa : taxa de juros do sistema.
	 */
	public void inicializa(int caixa, double taxa) {
		system = new CenarioController(caixa, taxa);
	}
	
	/**
	 * Cadastra um novo cenário a partir de sua descrição.
	 * 
	 * @param descricao : descrição do cenário.
	 * 
	 * @return : retorna um inteiro representando o número de identificação do sistema.
	 */
	public int cadastrarCenario(String descricao) {
		return system.cadastrarCenario(descricao);
	}
	
	/**
	 * Exibe um cenário já existente a partir do seu número de identificação.
	 * 
	 * @param idCenario : número de identificação do cenário.
	 *  
	 * @return : retorna a representação String do cenário escolhido.
	 */
	public String exibirCenario(int idCenario) {
		return system.exibirCenario(idCenario);
	}
	
	/**
	 * Exibe todos os cenários cadastrados no sistema.
	 * 
	 * @return : retorna uma String que representa todos os cenários que foram cadastrados no sistema.
	 */
	public String exibirCenarios() {
		return system.exibirCenarios();
	}
	
	/**
	 * Cadastra uma nova aposta em um cenário.
	 * 
	 * @param cenario : número de identificação de um cenário.
	 * @param apostador : nome do apostador. 
	 * @param valor : valor da aposta.
	 * @param previsao : previsão de o apostador ganhar ou não a aposta.
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		system.cadastrarAposta(cenario, apostador, valor, previsao);
	}
	
	/**
	 * Retorna o número de apostas cadastradas em um cenário.
	 * 
	 * @param cenario : número do cenário.
	 * 
	 * @return : retorna o número de apostas cadastradas em um cenário.
	 */
	public int valorTotalDeApostas(int cenario) {
		return system.valorTotalEmApostas(cenario);
	}
	
	/**
	 * Retorna o valor total em apostas de um determinado cenário.
	 * 
	 * @param cenario : número do cenário.
	 * 
	 * @return : retorna o valor total em apostas de um determinado cenário.
	 */
	public int totalDeApostas(int cenario) {
		return system.totalDeApostas(cenario);
	}
	
	/**
	 * Retorna uma String com a representação de todas as apostas de um cenário.
	 * 
	 * @param cenario : número do cenário.
	 * 
	 * @return : retorna a representaçaõ String de todas as apostas de um cenário.
	 */
	public String exibeApostas(int cenario) {
		return system.exibirApostas(cenario);
	}
	
	/**
	 * Fecha uma aposta de um determinado cenário.
	 * 
	 * @param cenario : número do cenário.
	 * @param ocorreu : boolean que indica se ocorreu ou não a aposta.
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		system.fecharAposta(cenario, ocorreu);
	}
	
	/**
	 * Retorna o valor total de um cenário encerrado que será destinado ao caixa.
	 * 
	 * @param cenario : número do cenário.
	 * 
	 * @return : retorna o valor total de um cenário encerrado que será destinado ao caixa.
	 */
	public int getCaixaCenario(int cenario) {
		return system.getCaixaCenario(cenario);
	}
	
	/**
	 * Retorna o valor total de um cenário encerrado que será destinado a distribuição entre as apostas vencedoras.
	 * 
	 * @param cenario : número do cenário.
	 *  
	 * @return : retorna o valor total de um cenário encerrado que será destinado a distribuição entra as apostas vencedoras.
	 */
	public int getTotalRateioCenario(int cenario) {
		return system.getTotalRateioCenario(cenario);
	}
	
}
