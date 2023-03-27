package bmicalc.gui;

import java.awt.EventQueue;

import bmicalc.BMICalcImpl;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMICalcImpl calc = new BMICalcImpl();
					View view = new View();
					Controller controller = new Controller(calc, view);
					view.registerController(controller);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}