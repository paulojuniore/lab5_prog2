package lab5.paulojunior;

import java.util.ArrayList;

public class Cenario {
	
	private int id = 0;
	private String descricao;
	private boolean status;
	private ArrayList<Aposta> apostas;
	
	public Cenario(String descricao) {
		this.id = id++;
		this.descricao = descricao;
		this.status = false;
	}
	
	public int getId() {
		return id;
	}
	
	public ArrayList<Aposta> getApostas(){
		return this.apostas;
	}
	
	public String toString() {
		return this.id + " - " + this.descricao + " - " + this.status + System.lineSeparator();
	}

}
