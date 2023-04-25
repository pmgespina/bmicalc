package bmicalc;

import java.util.Iterator;
import java.util.Map;

public class AmericanDecorator extends Decorator {
	
	public AmericanDecorator(IMCHospital d) {
		super(d);
	}

	public Map<Double, String> imc(double altura, double peso) {
		double alt = altura / 3.28084;
		double pes = peso / 2.20462;
		Map<Double, String> res = calculator.imc(alt, pes);
		Iterator<Double> it = res.keySet().iterator();
		System.out.println("The person with height " + altura + " feet and " + peso + " pounds has a BMI of " + it.next());
		return res;
	}
	
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		return calculator.tieneObesidadAbdominal(genero, circunferencia);
	}

}
