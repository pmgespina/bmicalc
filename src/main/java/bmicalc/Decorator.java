package bmicalc;

import java.util.Map;

public class Decorator {
	
	protected IMCHospital calculator;
	
	public Decorator(IMCHospital d) {
		calculator = d;
	}
	
	public Map<Double, String> imc(double altura, double peso) {
		return calculator.imc(altura, peso);
	}
	
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		return calculator.tieneObesidadAbdominal(genero, circunferencia);
	}

}
