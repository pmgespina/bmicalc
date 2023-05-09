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
		assertThrows(RuntimeException.class, () -> calc.calculateBodyMassIndex(-1, -3));
	}

	@Test
	@DisplayName("Negative value for mass and height = 0")
	public void bmitest2() {
		assertThrows(RuntimeException.class, () -> calc.calculateBodyMassIndex(-3, 0));
	}

	@Test
	@DisplayName("Negative value for mass")
	public void bmitest3() {
		assertThrows(RuntimeException.class, () -> calc.calculateBodyMassIndex(-1, 1.61));
	}

	@Test
	@DisplayName("Negative value for height and mass = 0")
	public void bmitest4() {
		assertThrows(RuntimeException.class, () -> calc.calculateBodyMassIndex(0, -3));
	}
	
	@Test
	@DisplayName("Negative value for height")
	public void bmitest5() {
		assertThrows(RuntimeException.class, () -> calc.calculateBodyMassIndex(61, -3));
	}
	
	@Test
	@DisplayName("BMI test with accurate values")
	public void bmitestCorrect() {
		assertEquals(18.924941241109856, calc.calculateBodyMassIndex(62, 1.81));
	}
	
	@Test
	@DisplayName("BMI test with accurate values")
	public void bmitestCorrect2() {
		assertEquals(20.775623268698062, calc.calculateBodyMassIndex(75, 1.90));
		
	}
	
	@Test
	@DisplayName("Category with negative bmi")
	public void category1() {
		assertThrows(RuntimeException.class, () -> calc.getObesityCategory(-2));
	}
	
	@Test
	@DisplayName("Category with bmi = 0")
	public void category2() {
		assertThrows(RuntimeException.class, () -> calc.getObesityCategory(0));
	}
	
	@Test
	@DisplayName("Category with bmi = 10")
	public void category3() {
		assertEquals(ObesityCategory.UNDERWEIGHT, calc.getObesityCategory(10));
	}
	
	@Test
	@DisplayName("Category with bmi = 18.4")
	public void category4() {
		assertEquals(ObesityCategory.UNDERWEIGHT, calc.getObesityCategory(18.4));
	}
	
	@Test
	@DisplayName("Category with bmi = 18.5")
	public void category5() {
		assertEquals(ObesityCategory.NORMAL, calc.getObesityCategory(18.5));
	}

	@Test
	@DisplayName("Category with bmi = 20")
	public void category6() {
		assertEquals(ObesityCategory.NORMAL, calc.getObesityCategory(20));
	}
	
	@Test
	@DisplayName("Category with bmi = 24.9")
	public void category7() {
		assertEquals(ObesityCategory.NORMAL, calc.getObesityCategory(24.9));
	}
	
	@Test
	@DisplayName("Category with bmi = 25")
	public void category8() {
		assertEquals(ObesityCategory.OVERWEIGHT, calc.getObesityCategory(25));
	}
	
	@Test
	@DisplayName("Category with bmi = 27")
	public void category9() {
		assertEquals(ObesityCategory.OVERWEIGHT, calc.getObesityCategory(27));
	}
	
	@Test
	@DisplayName("Category with bmi = 29.9")
	public void category10() {
		assertEquals(ObesityCategory.OVERWEIGHT, calc.getObesityCategory(29.9));
	}
	
	@Test
	@DisplayName("Category with bmi = 30")
	public void category11() {
		assertEquals(ObesityCategory.OBESE, calc.getObesityCategory(30));
	}
	
	@Test
	@DisplayName("Category with bmi = 35")
	public void category12() {
		assertEquals(ObesityCategory.OBESE, calc.getObesityCategory(35));
	}
	
	@Test
	@DisplayName("Abdominal obesity negative circunference male")
	public void abdominalObesity1() {
		assertThrows(RuntimeException.class, () -> calc.abdominalObesity(-2, Gender.MALE));
	}
	
	@Test
	@DisplayName("Abdominal obesity zero circunference female")
	public void abdominalObesity2() {
		assertThrows(RuntimeException.class, () -> calc.abdominalObesity(0, Gender.FEMALE));
	}

	@Test
	@DisplayName("Abdominal obesity zero circunference male")
	public void abdominalObesity7() {
		assertThrows(RuntimeException.class, () -> calc.abdominalObesity(0, Gender.MALE));
	}
	
	@Test
	@DisplayName("Abdominal obesity circunference = 10 male")
	public void abdominalObesity8() {
		assertEquals(false, calc.abdominalObesity(10, Gender.MALE));
	}
	
	@Test
	@DisplayName("Abdominal obesity circunference = 70 male")
	public void abdominalObesity9() {
		assertEquals(false, calc.abdominalObesity(70, Gender.MALE));
	}
	
	@Test
	@DisplayName("Abdominal obesity circunference = 90 male")
	public void abdominalObesity10() {
		assertEquals(false, calc.abdominalObesity(90, Gender.MALE));
	}
	
	@Test
	@DisplayName("Abdominal obesity circunference = 91 male")
	public void abdominalObesity11() {
		assertEquals(true, calc.abdominalObesity(91, Gender.MALE));
	}
	
	@Test
	@DisplayName("Abdominal obesity circunference = 100 male")
	public void abdominalObesity12() {
		assertEquals(true, calc.abdominalObesity(100, Gender.MALE));
	}
	
	@Test
	@DisplayName("Abdominal obesity circunference = 15 female")
	public void abdominalObesity13() {
		assertEquals(false, calc.abdominalObesity(15, Gender.FEMALE));
	}
	
	@Test
	@DisplayName("Abdominal obesity circunference = 27 female")
	public void abdominalObesity14() {
		assertEquals(false, calc.abdominalObesity(27, Gender.FEMALE));
	}
	
	@Test
	@DisplayName("Abdominal obesity circunference = 79 female")
	public void abdominalObesity15() {
		assertEquals(false, calc.abdominalObesity(79, Gender.FEMALE));
	}
	
	@Test
	@DisplayName("Abdominal obesity circunference = 80 female")
	public void abdominalObesity16() {
		assertEquals(false, calc.abdominalObesity(80, Gender.FEMALE));
	}
	
	@Test
	@DisplayName("Abdominal obesity circunference = 81 female")
	public void abdominalObesity17() {
		assertEquals(true, calc.abdominalObesity(81, Gender.FEMALE));
	}
	
	@Test
	@DisplayName("Abdominal obesity circunference = 90 female")
	public void abdominalObesity18() {
		assertEquals(true, calc.abdominalObesity(90, Gender.FEMALE));
	}
	
	
}
