package bmicalc;

import java.util.Iterator;
import java.util.Map;

public class EuropeanDecorator extends Decorator {

	public EuropeanDecorator(IMCHospital d) {
		super(d);
	}

	public Map<Double, String> imc(double altura, double peso) {
		Map<Double, String> res = calculator.imc(altura, peso);
		Iterator<Double> it = res.keySet().iterator();
		System.out.println("La persona con altura " + altura + " metros y " + peso + " kilos de peso tiene un IMC de " + it.next());
		return res;
	}
	
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		return calculator.tieneObesidadAbdominal(genero, circunferencia);
	}

}
