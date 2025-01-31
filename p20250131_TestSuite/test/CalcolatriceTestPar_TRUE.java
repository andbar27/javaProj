import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalcolatriceTestPar_TRUE {
	private int numeroTestato1;
	private int numeroTestato2;
	private int risultatoAtteso;

	public CalcolatriceTestPar_TRUE(int numeroTestato1, int numeroTestato2, int risultatoAtteso) {
		this.numeroTestato1 = numeroTestato1;
		this.numeroTestato2 = numeroTestato2;
		this.risultatoAtteso = risultatoAtteso;
	}

	@Parameterized.Parameters
	public static Collection dataset() {
		return Arrays.asList(new Object[][] { { 1, 2, 3 }, { 2, 0, 2 }, { 3, 2, 4} });
	}

	@Test
	public void testNumeroPari() {
		Calcolatrice n = new Calcolatrice();
		System.out.println("Test con i numeri : " + numeroTestato1 + "," + numeroTestato2 + " eseguito");
		assertEquals("Il numero " + numeroTestato1 + " è dispari ", risultatoAtteso, n.somma(numeroTestato1, numeroTestato2));
	}
}