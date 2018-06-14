package lab5.paulojunior;

import java.util.ArrayList;

public class Cenario {
	
	private int id;
	private String descricao;
	private boolean status;
	private ArrayList<Aposta> apostas;
	private int totalEmApostas = 0;
	
	public Cenario(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
		this.status = false;
	}
	
	public void cadastrarAposta(String apostador, int valor, String previsao) {
		Aposta aposta = new Aposta(apostador, valor, previsao);
		this.apostas.add(aposta);
		this.totalEmApostas += aposta.getValor();
		
	}
	
	public int getId() {
		return id;
	}
	
	public int getTotalEmApostas() {
		return totalEmApostas;
	}
	
	public ArrayList<Aposta> getApostas(){
		return this.apostas;
	}
	
	public String toString() {
		return this.id + " - " + this.descricao + " - " + this.status + System.lineSeparator();
	}

}
