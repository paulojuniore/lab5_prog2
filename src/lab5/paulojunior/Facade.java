package lab5.paulojunior;

public class Facade {
		
	public void inicializa(int caixa, double taxa) {
		Sistema system = new Sistema(caixa, taxa);
	}
	
	public int cadastrarCenario(String descricao) {
		Cenario cenario = new Cenario(descricao);
		return cenario.getId();
	}
	
	public String exibirCenario(int idCenario) {
		Cenario aux = buscaCenario(idCenario); 
		if(aux != null)
			return aux.toString();
		return "Cenário não cadastrado!" + System.lineSeparator();
	}
	
	private Cenario buscaCenario(int id) {
		for (Cenario cenario : system.getCenarios()) {
			if(cenario.getId() == id)
				return cenario;
		}
		return null;
	}
	
	public String exibirCenarios() {
		String aux = "";
		for(Cenario cenario : system.getCenarios()) {
			aux += cenario.toString();
		}
		return aux;
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(apostador, valor, previsao);
		Cenario aux = buscaCenario(cenario);
		if(aux != null) {
			system.getApostas().add(aposta);
		}
	}
	
}
