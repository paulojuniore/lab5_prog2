package lab5.paulojunior;

import java.util.ArrayList;

public class Sistema {
	
	private int caixa;
	private double taxa;
	private ArrayList<Cenario> cenarios;
	
	public Sistema(int caixa, double taxa) {
		this.caixa = caixa;
		this.taxa = taxa;
	}
	
	public ArrayList<Cenario> getCenarios(){
		return cenarios;
	}
	
	public int getCaixa() {
		return caixa;
	}
	
}
