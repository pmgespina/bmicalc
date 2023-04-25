
package bmicalc;

import java.util.Scanner;

import java.util.Map;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Write your weight: ");
		String w = sc.nextLine().replace(',', '.');
		double weight = Double.parseDouble(w);

		System.out.println("Write your height: ");
		String h = sc.nextLine().replace(',', '.');
		double height = Double.parseDouble(h);

		System.out.println("Write your gender (M for male and F for female): ");
		char gender = sc.nextLine().charAt(0);

		System.out.println("Write your waist circumference (in centimeters): ");
		String wc = sc.nextLine().replace(',', '.');
		double waist_circumference = Double.parseDouble(wc);
		
		System.out.println();
		sc.close();
		
		// ----------------------------------------------------------------------------------------------------------
		
		BMICalcImpl singleton = BMICalcImpl.getInstance();

		double singleton_bmi = singleton.bmi(weight, height);
		String singleton_cat = singleton.category(singleton_bmi);
		boolean singleton_obesity = singleton.abdominalObesity(waist_circumference, gender);
		
		String res_singleton;
		if (singleton_obesity) {
			res_singleton = "You have";
		} else {
			res_singleton = "You do not have";
		}

		System.out.println("Singleton Pattern Tests");
		System.out.println("Your BMI is: " + singleton_bmi);
		System.out.println("Your Category is: " + singleton_cat); 
		System.out.println(res_singleton + " abdominal obesity");
		System.out.println();

		// ----------------------------------------------------------------------------------------------------------
		
		Adapter adapter = new Adapter();
		
		Map<Double, String> adapter_map = adapter.imc(height, weight);
		boolean adapter_obesity = adapter.tieneObesidadAbdominal(gender, waist_circumference);
		
		String res_adapter;
		if (adapter_obesity) {
			res_adapter = "You have";
		} else {
			res_adapter = "You do not have";
		}

		System.out.println("Adapter Pattern Tests");
		System.out.println("Your BMI and Category (in this order) are: " + adapter_map.toString());
		System.out.println(res_adapter + " abdominal obesity");
		System.out.println();

		// ----------------------------------------------------------------------------------------------------------

		Proxy proxy = new Proxy();

		proxy.imc(1.81, 68);
		proxy.imc(1.62, 50);
		proxy.imc(1.69, 56);
		proxy.imc(1.79, 49);
		proxy.imc(1.80, 93);

		Map<Double, String> proxy_map = proxy.imc(height, weight);
		boolean proxy_obesity = proxy.tieneObesidadAbdominal(gender, waist_circumference);
		double mean_height = proxy.alturaMedia();
		double mean_weight = proxy.pesoMedio();
		double mean_bmi = proxy.imcMedio();
		int number_patients = proxy.numPacientes();
		
		String res_proxy;
		if (proxy_obesity) {
			res_proxy = "You have";
		} else {
			res_proxy = "You do not have";
		}
	
		System.out.println("Proxy Pattern Tests");
		System.out.println("Your BMI and category (in this order) are: " + proxy_map);
		System.out.println(res_proxy + " abdominal obesity");
		System.out.println("The mean height of the patients is : " + mean_height);
		System.out.println("The mean weight of the patients is : " + mean_weight);
		System.out.println("The mean BMI of the patients is : " + mean_bmi);
		System.out.println("The number of patients using the calculator is : " + number_patients);
		System.out.println();

		// ----------------------------------------------------------------------------------------------------------
		
		System.out.println("Decorator Pattern Tests");
		
		System.out.println("	Calculadora Europea");
		EuropeanDecorator eur = new EuropeanDecorator(proxy);
		eur.imc(height, weight);
		eur.tieneObesidadAbdominal(gender, waist_circumference);
		System.out.println("Numero de pacientes: " + proxy.numPacientes());
		System.out.println("Altura media: " + proxy.alturaMedia());
		System.out.println("Peso medio: " + proxy.pesoMedio());
		System.out.println("IMC medio: " + proxy.imcMedio());

		System.out.println();
		System.out.println("	American Calculator");
		AmericanDecorator usa = new AmericanDecorator(proxy);
		
		double heightAm = height * 3.28084;
		double weightAm = weight * 2.20462;
		double wcAm = waist_circumference / 2.54;
		usa.imc(heightAm, weightAm);
		usa.tieneObesidadAbdominal(gender, wcAm);
		System.out.println("Number of patients: " + proxy.numPacientes());
		System.out.println("Mean height: " + proxy.alturaMedia());
		System.out.println("Mean weight: " + proxy.pesoMedio());
		System.out.println("Mean BMI: " + proxy.imcMedio());
		System.out.println();

	}

}