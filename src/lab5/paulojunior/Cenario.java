package lab5.paulojunior;

public class Cenario {
	
	private int id = 0;
	private String descricao;
	private boolean status;
	
	public Cenario(String descricao) {
		this.id = id++;
		this.descricao = descricao;
		this.status = false;
	}
	
	public int getId() {
		return id;
	}
	
	public String toString() {
		return this.id + " - " + this.descricao + " - " + this.status + System.lineSeparator();
	}

}
