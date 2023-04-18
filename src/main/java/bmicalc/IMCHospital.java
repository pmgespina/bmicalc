package bmicalc;

import java.util.Map;

public interface IMCHospital {

	public Map<Double, String> imc(double altura, double peso); // new HashMap; despues un put para poner la clave y el
																// valor

	public boolean tieneObesidadAbdominal(char genero, double circunferencia);

}
