package lab5.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import lab5.paulojunior.Aposta;

/**
 * Classe de testes da classe Aposta utilizando o JUnit.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */

public class ApostaTest {
	
	private Aposta a1;
	private Aposta a2;
	private Aposta a3;
	
	/**
	 * Inicializa algumas apostas.
	 */
	@Before
	public void criaApostas() {
		a1 = new Aposta("Pedro", 100, "VAI ACONTECER");
		a2 = new Aposta("Joao", 50, "VAI ACONTECER");
		a3 = new Aposta("Felipe", 1000, "N VAI ACONTECER");
	}

	/**
	 * Testa o método que cadastra uma aposta.
	 */
	@Test
	public void testCadastraAposta() {
		Aposta a = new Aposta("André", 200, "N VAI ACONTECER");
	}

	/**
	 * Testa a representação String de uma aposta.
	 */
	@Test
	public void testToString() {
		assertEquals("Pedro - 100 - VAI ACONTECER" + System.lineSeparator(), a1.toString());
		assertEquals("Joao - 50 - VAI ACONTECER" + System.lineSeparator(), a2.toString());
		assertEquals("Felipe - 1000 - N VAI ACONTECER" + System.lineSeparator(), a3.toString());
	}

}
