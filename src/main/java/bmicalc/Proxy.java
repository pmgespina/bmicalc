package bmicalc;

import java.util.Iterator;
import java.util.Map;

public class Proxy implements IMCStats, IMCHospital {

	private Adapter calculator;
	private static double alturas;
	private static double pesos;
	private static double imcs;
	private static int cnt;
	
	public Proxy() {
		calculator = new Adapter();
	}

	@Override
	public Map<Double, String> imc(double altura, double peso) {
		alturas += altura;
		pesos += peso;
		Map<Double, String> res = calculator.imc(altura, peso);
		Iterator<Double> it = res.keySet().iterator();
		imcs += it.next();
		cnt++;
		return res;
	}

	@Override
	public boolean tieneObesidadAbdominal(char genero, double circunferencia) {
		return calculator.tieneObesidadAbdominal(genero, circunferencia);
	}

	@Override
	public double alturaMedia() {
		return alturas / cnt;
	}

	@Override
	public double pesoMedio() {
		return pesos / cnt;
	}

	@Override
	public double imcMedio() {
		return imcs / cnt;
	}

	@Override
	public int numPacientes() {
		return cnt;
	}

}
