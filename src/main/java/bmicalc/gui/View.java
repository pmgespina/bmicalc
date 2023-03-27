package bmicalc.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Font;

public class View extends JFrame {

	private JPanel contentPane;
	
	private JTextField textFieldmass;
	private JTextField textFieldheight;
	private JTextField txtEnterMassAnd;
	private JButton btnClear;
	private JButton btnBMICalc;
	private JLabel lblBMI;
	private JLabel lblError;
	
	private JTextField textFieldbmi;
	private JTextField textFieldEnterBMI;
	private JButton btnCategorize;
	private JLabel lblCategory;
	
	private JTextField textFieldwaist;
	private JRadioButton rdbtnM;
	private JRadioButton rdbtnF;
	private JTextField textFieldEnterGenderAnd;
	private JButton btnObesity;
	private JLabel lblObesity;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 3, 0, 0));
		
		// ---------------------------------------------------------

		JPanel izq = new JPanel();
		contentPane.add(izq);
		izq.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel izq_arriba = new JPanel();
		izq.add(izq_arriba);
		izq_arriba.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel izq_abajo = new JPanel();
		izq.add(izq_abajo);
		izq_abajo.setLayout(new GridLayout(3, 1, 0, 0));
		
		lblBMI = new JLabel("");
		lblBMI.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		izq_abajo.add(lblBMI);
		
		txtEnterMassAnd = new JTextField();
		txtEnterMassAnd.setFont(new Font("Lao Sangam MN", Font.BOLD, 13));
		txtEnterMassAnd.setHorizontalAlignment(SwingConstants.LEFT);
		txtEnterMassAnd.setForeground(Color.RED);
		txtEnterMassAnd.setText("Mass & Height to calculate BMI");
		izq_abajo.add(txtEnterMassAnd);
		txtEnterMassAnd.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		izq_abajo.add(lblError);

		JPanel panel_mass = new JPanel();
		izq_arriba.add(panel_mass);
		panel_mass.setLayout(new GridLayout(1, 2, 0, 0));
		JLabel lblmass = new JLabel("mass (kg)");
		lblmass.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		panel_mass.add(lblmass);
		textFieldmass = new JTextField();
		textFieldmass.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		panel_mass.add(textFieldmass);
		textFieldmass.setColumns(10);

		JPanel panel_height = new JPanel();
		izq_arriba.add(panel_height);
		panel_height.setLayout(new GridLayout(1, 2, 0, 0));
		JLabel lblheight = new JLabel("height (m)");
		lblheight.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		panel_height.add(lblheight);
		textFieldheight = new JTextField();
		textFieldheight.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		panel_height.add(textFieldheight);
		textFieldheight.setColumns(10);

		btnBMICalc = new JButton("CALCULATE BMI");
		btnBMICalc.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		izq_arriba.add(btnBMICalc);
		
		// ---------------------------------------------------------
		
		JPanel central = new JPanel();
		contentPane.add(central);
		central.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel central_arriba = new JPanel();
		central.add(central_arriba);
		central_arriba.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_bmi = new JPanel();
		central_arriba.add(panel_bmi);
		panel_bmi.setLayout(new GridLayout(1, 2, 0, 0));
		JLabel lblbmi = new JLabel("BMI (Body Mass Index)");
		lblbmi.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		panel_bmi.add(lblbmi);
		textFieldbmi = new JTextField();
		textFieldbmi.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		panel_bmi.add(textFieldbmi);
		textFieldbmi.setColumns(10);
		
		btnCategorize = new JButton("CATEGORIZE");
		btnCategorize.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		central_arriba.add(btnCategorize);
		
		JPanel central_abajo = new JPanel();
		central.add(central_abajo);
		central_abajo.setLayout(new GridLayout(3, 1, 0, 0));
		
		lblCategory = new JLabel("");
		lblCategory.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		central_abajo.add(lblCategory);
		
		textFieldEnterBMI = new JTextField();
		textFieldEnterBMI.setFont(new Font("Lao Sangam MN", Font.BOLD, 13));
		textFieldEnterBMI.setForeground(Color.RED);
		textFieldEnterBMI.setText("BMI to categorize yourself");
		central_abajo.add(textFieldEnterBMI);
		textFieldEnterBMI.setColumns(10);
		
		// ---------------------------------------------------------
		
		JPanel dch = new JPanel();
		contentPane.add(dch);
		dch.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel dch_arriba = new JPanel();
		dch.add(dch_arriba);
		dch_arriba.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_gender = new JPanel();
		dch_arriba.add(panel_gender);
		panel_gender.setLayout(new GridLayout(1, 2, 0, 0));
		JLabel lblgender = new JLabel("gender");
		lblgender.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		panel_gender.add(lblgender);
		
		JPanel panel_gender_select = new JPanel();
		panel_gender.add(panel_gender_select);
		panel_gender_select.setLayout(new GridLayout(2, 1, 0, 0));
		
		rdbtnM = new JRadioButton("M");
		rdbtnM.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		panel_gender_select.add(rdbtnM);
		
		rdbtnF = new JRadioButton("F");
		rdbtnF.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		panel_gender_select.add(rdbtnF);
		
		JPanel panel_waist = new JPanel();
		dch_arriba.add(panel_waist);
		panel_waist.setLayout(new GridLayout(1, 2, 0, 0));
		JLabel lblwaist = new JLabel("waist circumference (cm)");
		lblwaist.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		panel_waist.add(lblwaist);
		textFieldwaist = new JTextField();
		textFieldwaist.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		panel_waist.add(textFieldwaist);
		textFieldwaist.setColumns(10);
		
		btnObesity = new JButton("OBESITY?");
		btnObesity.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		dch_arriba.add(btnObesity);
		
		JPanel dch_abajo = new JPanel();
		dch.add(dch_abajo);
		dch_abajo.setLayout(new GridLayout(3, 1, 0, 0));
		
		lblObesity = new JLabel("");
		lblObesity.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		dch_abajo.add(lblObesity);
		
		textFieldEnterGenderAnd = new JTextField();
		textFieldEnterGenderAnd.setFont(new Font("Lao Sangam MN", Font.BOLD, 13));
		textFieldEnterGenderAnd.setForeground(Color.RED);
		textFieldEnterGenderAnd.setText("Gender & Waist circumference to know if you are obese");
		dch_abajo.add(textFieldEnterGenderAnd);
		textFieldEnterGenderAnd.setColumns(10);
		
		btnClear = new JButton("CLEAR VALUES");
		dch_abajo.add(btnClear);
		btnClear.setFont(new Font("Lao Sangam MN", Font.PLAIN, 13));
		
		pack();
		setVisible(true);
	}
	
	public double getMass() {
		return Double.parseDouble(textFieldmass.getText().replace(',', '.'));
	}
	
	public double getHeightBMI() {
		return Double.parseDouble(textFieldheight.getText().replace(',', '.'));
	}
	
	public double getBMI() {
		return Double.parseDouble(textFieldbmi.getText().replace(',', '.'));
	}
	
	public double getWaistCircumference() {
		return Double.parseDouble(textFieldwaist.getText().replace(',', '.'));
	}
	
	public char getGender() {
		char res;
		if (rdbtnM.isSelected() && !rdbtnF.isSelected()) {
			res = 'M';
		} else if (!rdbtnM.isSelected() && rdbtnF.isSelected()) {
			res = 'F';
		} else {
			res = 'A';
		}
		return res;
	}
	
	public void setGender(char s) {
		if (s == 'M') {
			rdbtnM.setSelected(true);
			rdbtnF.setSelected(false);
		} else {
			rdbtnM.setSelected(false);
			rdbtnF.setSelected(true);
		}
	}
	
	public void setObesity(boolean b) {
		if (b) {
			lblObesity.setText("You have obesity");
		} else {
			lblObesity.setText("You do not have obesity");
		}
	}
	
	public void setBMI(double value) {
		lblBMI.setText("Your BMI value is: " + value);
	}
	
	public void setCategory(String cat) {
		lblCategory.setText("Your category according to the data is: " + cat);
	}
	
	public void setError(String e) {
		lblError.setText("ERROR: " + e);
	}
	
	public void registerController(ActionListener ctrl) {
		btnBMICalc.addActionListener(ctrl);
		btnBMICalc.setActionCommand("BMICalc");
		
		btnClear.addActionListener(ctrl);
		btnClear.setActionCommand("Clear");
		
		btnCategorize.addActionListener(ctrl);
		btnCategorize.setActionCommand("Categorize");
		
		
		btnObesity.addActionListener(ctrl);
		btnObesity.setActionCommand("Obesity");
	}

	public void empty() {
		textFieldmass.setText("");
		textFieldheight.setText("");
		lblBMI.setText("");
		
		textFieldbmi.setText("");
		lblCategory.setText("");
		
		textFieldwaist.setText("");
		rdbtnM.setSelected(false);
		rdbtnF.setSelected(false);
		lblObesity.setText("");
		
		lblError.setText("");
	}
	
	public void cleanError() {
		lblError.setText("");
	}

}
