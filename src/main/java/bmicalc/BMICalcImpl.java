package bmicalc;

public class BMICalcImpl implements CardiovascularMetrics, MetabolicMetrics {

	public double calculateBodyMassIndex(double mass, double height) {
		if (mass <= 0 || height <= 0) {
			throw new RuntimeException("EXCEPTION: Invalid arguments");
		} else {
			return mass / Math.pow(height, 2);
		}
	}

	public ObesityCategory getObesityCategory(double bmi) {
		ObesityCategory res;
		if (bmi < 18.5 && bmi > 0) {
			res = ObesityCategory.UNDERWEIGHT;
		} else if (bmi >= 18.5 && bmi <= 24.9) {
			res = ObesityCategory.NORMAL;
		} else if (bmi >= 25 && bmi <= 29.9) {
			res = ObesityCategory.OVERWEIGHT;
		} else if (bmi >= 30) {
			res = ObesityCategory.OBESE;
		} else {
			throw new RuntimeException("EXCEPTION: Invalid arguments");
		}
		return res;
	}

	public boolean abdominalObesity(double waistCircumference, Gender gender) {
		boolean res = false;
		if (waistCircumference <= 0 || (gender != Gender.MALE && gender != Gender.FEMALE)) {
			throw new RuntimeException("EXCEPTION: Invalid arguments");
		} else if (gender == Gender.FEMALE && waistCircumference > 80) {
			res = true;
		} else if (gender == Gender.MALE && waistCircumference > 90) {
			res = true;
		}
		return res;
	}

}
