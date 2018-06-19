package lab5.testes;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import lab5.paulojunior.CenarioController;

/**
 * Classe de testes da classe CenarioController utilizando JUnit.
 * 
 * @author Paulo Mendes da Silva Júnior - 117210922
 *
 */

public class CenarioControllerTest {
	
	private CenarioController sistema;
	
	/**
	 * Cria um novo sistema com seus parâmetros válidos.
	 */
	@Before
	public void criaSistema() {
		sistema = new CenarioController(500, 0.05);
		sistema.cadastrarCenario("O Brasil não será campeão");
		sistema.cadastrarCenario("A Argentina irá mais longe que Portugal na copa");
	}
	
	/**
	 * Cria um sistema com um caixa inicializado com valor negativo, O que não é permitido.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void criaSistemaComCaixaInvalido() {
		new CenarioController(-2, 0.05);
	}
	
	/**
	 * Cria um sistema com uma taxa nula, O que não é permitido.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void criaSistemaComTaxaInvalida() {
		new CenarioController(-21, 0);
	}

	/**
	 * Testa o método cadastrar cenário.
	 */
	@Test
	public void testCadastrarCenario() {
		sistema.cadastrarCenario("Brasil não ganhará da Suíça");
		sistema.cadastrarCenario("Pagarei cálculo 2 com 10");
	}

	/**
	 * Testa o método para exibir um cenário através do seu id.
	 */
	@Test
	public void testExibirCenario() {
		assertEquals("O Brasil não será campeão - Não finalizado" + System.lineSeparator(), sistema.exibirCenario(1));
		assertEquals("A Argentina irá mais longe que Portugal na copa - Não finalizado" + System.lineSeparator(), sistema.exibirCenario(2));
	}

	/**
	 * 
	 */
	@Test
	public void testExibirCenarios() {
		assertEquals("1 - O Brasil não será campeão - Não finalizado" + System.lineSeparator() +
					 "2 - A Argentina irá mais longe que Portugal na copa - Não finalizado" + System.lineSeparator(), sistema.exibirCenarios());
	}

	/**
	 * Testa o método cadastrar aposta.
	 */
	@Test
	public void testCadastrarAposta() {
		sistema.cadastrarAposta(1, "Paulo", 50, "VAI ACONTECER");
		sistema.cadastrarAposta(1, "Paulo", 100, "NAO VAI ACONTECER");
		sistema.cadastrarAposta(2, "João", 30, "VAI ACONTECER");
		assertEquals(2, sistema.totalDeApostas(1));
		sistema.cadastrarAposta(2, "Felipe", 50, "NAO VAI ACONTECER");
		sistema.cadastrarAposta(2, "Paulo", 20, "VAI ACONTECER");
		assertEquals(3, sistema.totalDeApostas(2));
	}
	
	/**
	 *  Testa o método getValorTotalEmApostas.
	 */
	@Test
	public void testGetValorTotalEmApostas() {
		sistema.cadastrarAposta(1, "Paulo", 50, "VAI ACONTECER");
		sistema.cadastrarAposta(1, "Paulo", 100, "NAO VAI ACONTECER");
		assertEquals(150, sistema.valorTotalEmApostas(1));
		sistema.cadastrarAposta(2, "João", 30, "VAI ACONTECER");
		sistema.cadastrarAposta(2, "Felipe", 50, "NAO VAI ACONTECER");
		sistema.cadastrarAposta(2, "Paulo", 20, "VAI ACONTECER");
		assertEquals(100, sistema.valorTotalEmApostas(2));
	}

}
