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
	 * Cadastra um novo cenário que possui um bônus.
	 * 
	 * @param descricao : descrição do cenário de apostas.
	 * @param bonus : bônus a ser inserido no caixa.
	 * 
	 * @return : retorna um int representando o identificador do cenário.
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		Cenario cenario = new CenarioBonus(idCenario, descricao, bonus);
		cenarios.put(this.idCenario, cenario);
		this.caixa -= bonus;
		return this.idCenario++;
	}
	
	/**
	 * Exibe um cenário a partir do seu número de identificação.
	 * 
	 * @param cenario : inteiro que representa a identificação de um cenário.
	 * 
	 * @return : retorna a representação String de um cenário.
	 */
	public String exibirCenario(int cenario) {
		if(cenarios.containsKey(cenario))
			return cenarios.get(cenario).toString();
		else if(cenario < 0)
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		else
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
	}
	
	/**
	 * Exibe todas as apostas efetuadas em um cenário.
	 * 
	 * @param idCenario : identificador do cenário.
	 * 
	 * @return : todas as apostas efetuadas em um cenário.
	 */
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
			aux += cenarios.get(chave).toString() + System.lineSeparator();
		}
		return aux;
	}
	
	/**
	 * Cadastra uma aposta dentro do sistema em um cenário especificado. Podem ocorrer mensagens de erro, como por
	 * exemplo: tentar cadastrar uma aposta em um cenário inexistente.
	 * 
	 * @param cenario : número de identificação do cenário.
	 * @param apostador : nome do apostador.
	 * @param valor : valor da aposta.
	 * @param previsao : previsão de o apostador ganhar ou não a aposta.
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		if(cenarios.containsKey(cenario)) {
			Cenario aux = this.cenarios.get(cenario);
			aux.fazerAposta(apostador, valor, previsao);
		}
		else if(cenario <= 0)
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		else {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
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
	 * Retorna o total de apostas efetuadas em um cenário, a partir do número do cenário. , como por exemplo: 
	 * tentar acessar o total de apostas de um cenário inexistente.
	 * 
	 * @param cenario : número do cenário a saber a quantidade de apostas.
	 * 
	 * @return : retorna o número de apostas efetuadas em um cenário.
	 */
	public int totalDeApostas(int cenario) {
		if(cenarios.containsKey(cenario))
			return cenarios.get(cenario).getTotalDeApostas();
		else if(cenario <= 0)
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		else
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
	}
	
	/**
	 * Retorna o valor total arrecadado em apostas pelo sistema. Podem ocorrer mensagens de erro, como por exemplo:
	 * tentar consultar o valor total em apostas de um cenário inexistente ou não cadastrado.
	 * 
	 * @param cenario : identificador do cenário.
	 * 
	 * @return : retorna o valor total arrecadado em apostas pelo sistema.
	 */
	public int valorTotalEmApostas(int cenario) {
		if(cenarios.containsKey(cenario)) 
			return cenarios.get(cenario).getValorTotalEmApostas();
		else if(cenario <= 0) 
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		else
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
	}
	
	/**
	 * Encerra um cenário e atribui o dinheiro dos apostadores que perderam ao caixa. Podem ocorrer mensagens de 
	 * erro, como por exemplo: tentar encerrar um cenário que já está fechado ou um não cadastrado.
	 * 
	 * @param cenario : identificador do cenário que será encerrado.
	 * @param ocorreu : boolean que representa se ocorreu ou não a aposta. (true/false).
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		if(cenarios.containsKey(cenario)) {
			String aux = cenarios.get(cenario).getStatus();
			if(aux.equals("Finalizado (ocorreu)") || aux.equals("Finalizado (n ocorreu)")) {
				throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
			}
			else {
				this.cenarios.get(cenario).encerrarCenario(ocorreu);
				this.caixa += (int) this.cenarios.get(cenario).somaApostasPerdedoras() * taxa;
			}
		}
		else if(cenario <= 0) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		else {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
	}
	
	/**
	 * Retorna a quantidade de dinheiro que será destinada ao caixa. Podem ocorrer mensagens de erro, como por exemplo:
	 * tentar retornar a quantidade de dinheiro do caixa de um cenário que ainda está aberto ou um cenário inexistente.
	 * 
	 * @return : retorna a quantidade de dinheiro que será destinada ao caixa.
	 */
	public int getCaixaCenario(int cenario) {
		if(cenarios.containsKey(cenario)) {
			String aux = cenarios.get(cenario).getStatus();
			if(aux.equals("Finalizado (ocorreu)") || aux.equals("Finalizado (n ocorreu)")){
				return this.cenarios.get(cenario).getCaixa(taxa);
				//return (int) (this.cenarios.get(cenario).somaApostasPerdedoras() * taxa);
			}
			else
				throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		else if(cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
		else {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
	}
	
	/**
	 * Retorna o rateio total de de um cenário. Que é o valor que será distribuido entre as apostas vencedoras. Podem
	 * ocorrer mensagens de erro, como por exemplo: pedir o rateio de um cenário inexistente ou ainda aberto.
	 * 
	 * @param cenario : identificador de um cenário.
	 * 
	 * @return : retorna o rateio total de um cenário, ou uma mensagem de erro, se for o caso.
	 */
	public int getTotalRateioCenario(int cenario) {
		if(cenarios.containsKey(cenario)) {
			String aux = cenarios.get(cenario).getStatus();
			if(aux.equals("Finalizado (ocorreu)") || aux.equals("Finalizado (n ocorreu)")){
				return this.cenarios.get(cenario).getRateioTotalCenario(taxa);
				//return this.cenarios.get(cenario).somaApostasPerdedoras() - this.getCaixaCenario(cenario);
			}
			else
				throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		else if(cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
		else {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
	}
}
