package lab5.paulojunior;

import easyaccept.EasyAccept;

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
	 * Cadastra um novo cenário a partir de sua descrição e um bônus de cenário.
	 * 
	 * @param descricao : descrição do cenário.
	 * @param bonus : bônus de um cenário.
	 * 
	 * @return : retorna um inteiro representando o número de identificação do sistema.
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		return system.cadastrarCenario(descricao, bonus);
	}
	
	/**
	 * Exibe um cenário já existente a partir do seu número de identificação.
	 * 
	 * @param cenario : número de identificação do cenário.
	 *  
	 * @return : retorna a representação String do cenário escolhido.
	 */
	public String exibirCenario(int cenario) {
		return system.exibirCenario(cenario);
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
	 * Cadastra uma aposta assegurada por valor. Retorna um identificador para a aposta.
	 * 
	 * @param cenario : identificador do cenário em que será cadastrada a aposta.
	 * @param apostador : nome do apostador.
	 * @param valorAposta : valor da aposta.
	 * @param previsao : previsão de o apostador ganhar ou não a aposta.
	 * @param valorSeguro : valor a ser assegurado.
	 * @param custoSeguro : custo do seguro.
	 * 
	 * @return : retorna um identificador único para a aposta.
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valorAposta, String previsao, int valorSeguro, int custoSeguro) {
		return system.cadastrarApostaSeguradaValor(cenario, apostador, valorAposta, previsao, valorSeguro, custoSeguro);
	}
	
	/**
	 * Cadastra uma aposta assegurada por taxa. Retorna um identificador para a aposta.
	 * 
	 * @param cenario : identificador do cenário em que será cadastrada a aposta.
	 * @param apostador : nome do apostador.
	 * @param valorAposta : valor da aposta.
	 * @param previsao : previsão de o apostador ganhar ou não a aposta.
	 * @param taxaSeguro : taxa a ser assegurada.
	 * @param custoSeguro : custo do seguro.
	 * 
	 * @return : retorna um identificador único para a aposta.
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valorAposta, String previsao, double taxaSeguro, int custoSeguro) {
		return system.cadastrarApostaSeguradaTaxa(cenario, apostador, valorAposta, previsao, taxaSeguro, custoSeguro);
	}
	
	/**
	 * Altera uma aposta assegurada por taxa, para uma assegurada por valor.
	 * 
	 * @param cenario : identificador do cenário em que será cadastrada a aposta.
	 * @param apostaAssegurada : identificador da aposta assegurada por taxa a ser alterada.
	 * @param valor : valor do seguro.
	 * 
	 * @return : retorna um identificador único para a aposta assegurada por valor.
	 */
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return system.alterarSeguroValor(cenario, apostaAssegurada, valor);
	}
	
	/**
	 * Altera uma aposta assegurada por valor, para uma assegurada por taxa.
	 * 
	 * @param cenario : identificador do cenário em que será cadastrada a aposta.
	 * @param apostaAssegurada : identificador da aposta assegurada por taxa a ser alterada.
	 * @param taxa : taxa do seguro.
	 * 
	 * @return : retorna um identificador único para a aposta assegurada por valor.
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return system.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
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
	
	/**
	 * Retorna o valor contido no caixa.
	 * 
	 * @return : retorna o valor contido no caixa.
	 */
	public int getCaixa() {
		return system.getCaixa();
	}
	
//	public void alterarOrdem(String ordem) {
//		
//	}
//	
//	public String exibirCenario(int cenario) {
//		
//	}
	
	/**
	 * Método para testes de aceitação do sistema de apostas.
	 * 
	 * @param args : trata-se do caminho da classe Fachada e dos arquivos que contém os testes do sistema.
	 */
	public static void main(String[] args) {
		args = new String[] {"lab5.paulojunior.Facade", "acceptance_tests/us1_test.txt", "acceptance_tests/us2_test.txt", 
				"acceptance_tests/us3_test.txt", "acceptance_tests/us4_test.txt", "acceptance_tests/us5_test.txt", 
				"acceptance_tests/us6_test.txt"};
		EasyAccept.main(args);
	}
	
}
