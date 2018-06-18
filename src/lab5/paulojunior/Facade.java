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
	
}
