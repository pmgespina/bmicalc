package bmicalc.bdd;

import org.junit.jupiter.api.Assertions;

import bmicalc.BMICalcImpl;
import bmicalc.Gender;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	private BMICalcImpl calculadora;
	private Double mass;
	private Double height;
	private Double result;
	private boolean raiseException;
	private String cat;
	private Double waistcirc;
	private boolean obesity;
	
	@Before
	public void inicialization() {
		calculadora = null;
		mass = null;
		height = null;
		raiseException = false;
	}
	
	// bmicalc_BMI.feature
	
	@Given("the Body Mass Index calculator")
	public void the_body_mass_index_calculator() {
	    calculadora = new BMICalcImpl();
	}

	@When("the user with correct mass {double} kg and correct height {double} m clicks on the Calculate BMI button")
	public void the_user_with_correct_mass_kg_and_correct_height_m_clicks_on_the_calculate_bmi_button(Double m, Double h) {
	    mass = m;
	    height = h;
	    result = calculadora.calculateBodyMassIndex(mass, height);
	}

	@Then("the calculator returns a value {double}")
	public void the_calculator_returns_a_value(Double res) {
	    Assertions.assertEquals(res, result);
	}

	@When("the user with correct mass {double} kg and incorrect height {double} m clicks on the Calculate BMI button")
	public void the_user_with_correct_mass_kg_and_incorrect_height_m_clicks_on_the_calculate_bmi_button(Double m, Double h) {
	    try {
	    	result = calculadora.calculateBodyMassIndex(m, h);
	    } catch (RuntimeException e) {
	    	raiseException = true;
	    }
	}

	@Then("the calculator throws an exception")
	public void the_calculator_throws_an_exception() {
	    Assertions.assertTrue(raiseException);
	}

	@When("the user with incorrect mass {double} kg and incorrect height {double} m clicks on the Calculate BMI button")
	public void the_user_with_incorrect_mass_kg_and_incorrect_height_m_clicks_on_the_calculate_bmi_button(Double m, Double h) {
		try {
	    	result = calculadora.calculateBodyMassIndex(m, h);
	    } catch (RuntimeException e) {
	    	raiseException = true;
	    }
	}
	
	// bmicalc_categorize.feature
	
	@When("the user with a correct value {double} as BMI categorize himself")
	public void the_user_with_a_correct_value_as_bmi_categorize_himself(Double bmi) {
	    cat = calculadora.getObesityCategory(bmi).toString();
	}

	@Then("the calculator returns {string}")
	public void the_calculator_returns(String string) {
	    Assertions.assertEquals(string, cat);
	}

	@When("the user with an incorrect value {double} as BMI categorize himself")
	public void the_user_with_an_incorrect_value_as_bmi_categorize_himself(Double bmi) {
	    try {
	    	cat = calculadora.getObesityCategory(bmi).toString();
	    } catch (RuntimeException e) {
	    	raiseException = true;
	    }
	}
	
	// bmicalc_obesity.feature
	
	@When("an user introduces {string} gender and {double} cm as waist circumference")
	public void an_user_introduces_gender_and_cm_as_waist_circumference(String g, Double w) {
	    waistcirc = w;
	    obesity = calculadora.abdominalObesity(waistcirc, Gender.valueOf(g));
	}

	@Then("the calculator returns boolean {string}")
	public void the_calculator_returns_boolean(String string) {
	    boolean res = Boolean.parseBoolean(string);
	    Assertions.assertEquals(res, obesity);
	}

	@When("an user introduces {string} gender and incorrect {double} cm as waist circumference")
	public void an_user_introduces_gender_and_incorrect_cm_as_waist_circumference(String g, Double w) {
		try {
	    	obesity = calculadora.abdominalObesity(w, Gender.valueOf(g));
	    } catch (RuntimeException e) {
	    	raiseException = true;
	    }
	}
	
}
