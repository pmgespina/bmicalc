package bmicalc.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bmicalc.BMICalcImpl;

public class Controller implements ActionListener {
	
	private BMICalcImpl calc;
	private View view;
	
	public Controller(BMICalcImpl calc, View v) {
		this.calc = calc;
		this.view = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equalsIgnoreCase("Clear")) {
			view.empty();
		} else if (command.equalsIgnoreCase("BMICalc")) {
			try {
				view.cleanError();
				double mass = view.getMass();
				double height = view.getHeightBMI();
				double res = calc.calculateBodyMassIndex(mass, height);
				view.setBMI(res);
			} catch (RuntimeException exception) {
				view.setError(exception.getMessage());
			}
			
		} else if (command.equalsIgnoreCase("Categorize")) {
			try {
				view.cleanError();
				double bmi = view.getBMI();
				String cat = calc.getObesityCategory(bmi);
				view.setCategory(cat);
			} catch (RuntimeException exception) {
				view.setError(exception.getMessage());
			}
		} else if (command.equalsIgnoreCase("Obesity")) {
			try {
				view.cleanError();
				char gender = view.getGender();
				double waist = view.getWaistCircumference();
				boolean ob = calc.abdominalObesity(waist, gender);
				view.setObesity(ob);
			} catch (RuntimeException exception) {
				view.setError(exception.getMessage());
			}
		}
		
	}

}
