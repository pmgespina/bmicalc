package bmicalc;

import java.util.HashMap;
import java.util.Map;

public class Adapter implements IMCHospital {
	
	private BMICalcImpl adapter;

	@Override
	public Map<Double, String> imc(double altura, double peso) {
		Map<Double,String> res = new HashMap<>();
		double bmi = adapter.bmi(peso, altura);
		res.put(bmi, adapter.category(bmi));
		return res;
	}

	@Override
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		return adapter.abdominalObesity(circunferencia, genero);
	}

}
