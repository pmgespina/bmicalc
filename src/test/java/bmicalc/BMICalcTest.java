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
	
	@Test
	@DisplayName("Category with negative bmi")
	public void category1() {
		assertThrows(RuntimeException.class, () -> calc.category(-2));
	}
	
	@Test
	@DisplayName("Category with bmi = 0")
	public void category2() {
		assertThrows(RuntimeException.class, () -> calc.category(0));
	}
	
	@Test
	@DisplayName("Category with bmi = 10")
	public void category3() {
		assertEquals("UNDERWEIGHT", calc.category(10));
	}
	
	@Test
	@DisplayName("Category with bmi = 18.4")
	public void category4() {
		assertEquals("UNDERWEIGHT", calc.category(18.4));
	}
	
	@Test
	@DisplayName("Category with bmi = 18.5")
	public void category5() {
		assertEquals("NORMAL", calc.category(18.5));
	}

	@Test
	@DisplayName("Category with bmi = 20")
	public void category6() {
		assertEquals("NORMAL", calc.category(20));
	}
	
	@Test
	@DisplayName("Category with bmi = 24.9")
	public void category7() {
		assertEquals("NORMAL", calc.category(24.9));
	}
	
	@Test
	@DisplayName("Category with bmi = 25")
	public void category8() {
		assertEquals("OVERWEIGHT", calc.category(25));
	}
	
	@Test
	@DisplayName("Category with bmi = 27")
	public void category9() {
		assertEquals("OVERWEIGHT", calc.category(27));
	}
	
	@Test
	@DisplayName("Category with bmi = 29.9")
	public void category10() {
		assertEquals("OVERWEIGHT", calc.category(29.9));
	}
	
	@Test
	@DisplayName("Category with bmi = 30")
	public void category11() {
		assertEquals("OBESE", calc.category(30));
	}
	
	@Test
	@DisplayName("Category with bmi = 35")
	public void category12() {
		assertEquals("OBESE", calc.category(35));
	}
	
}
