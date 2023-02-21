package bmicalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BMICalcTest {

	private BMICalcImpl calc;

	@BeforeEach
	public void inicializar() {
		calc = new BMICalcImpl();
	}

	@Test
	@DisplayName("Negative values for both parameters")
	public void bmitest1() {
		assertThrows(RuntimeException.class, () -> calc.bmi(-1, -3));
	}

	@Test
	@DisplayName("Negative value for mass and height = 0")
	public void bmitest2() {
		assertThrows(RuntimeException.class, () -> calc.bmi(-3, 0));
	}

	@Test
	@DisplayName("Negative value for mass")
	public void bmitest3() {
		assertThrows(RuntimeException.class, () -> calc.bmi(-1, 1.61));
	}

	@Test
	@DisplayName("Negative value for height and mass = 0")
	public void bmitest4() {
		assertThrows(RuntimeException.class, () -> calc.bmi(0, -3));
	}
	
	@Test
	@DisplayName("Negative value for height")
	public void bmitest5() {
		assertThrows(RuntimeException.class, () -> calc.bmi(61, -3));
	}
	
	@Test
	@DisplayName("BMI test with accurate values")
	public void bmitestCorrect() {
		assertEquals(18.92, calc.bmi(62, 1.81));
	}
	
	@Test
	@DisplayName("BMI test with accurate values")
	public void bmitestCorrect2() {
		assertEquals(20.73, calc.bmi(75, 1.90));
	}
	
}
