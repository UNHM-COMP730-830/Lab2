import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

public class Lab2 {

	private JFrame frmWeightCalculator;
	private JComboBox<String> comboBoxList;
	private JTextField textFieldWeight;
	private JTextField textFieldWeight2;
	private JLabel lblImage;
	private PlanetData planetData = new PlanetData();
	private JLabel lblMsg3;
	private JLabel lblMsg4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab2 window = new Lab2();
					window.frmWeightCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lab2() {
		initialize();
	}
	
	private void calculateWeight() {
		int selected = comboBoxList.getSelectedIndex();
		String weightStr = textFieldWeight.getText();
		double weight = 0.0;
		try {
			weight = Double.parseDouble(weightStr);
		}
		catch (Exception e) {
			System.out.println("<<< " + e.getMessage());
			return;
		}
		Planet selectedPlanet = planetData.getData()[selected];
		double weight2 = selectedPlanet.calculateWeight(weight);
		String str = String.format("%.2f", weight2);
		textFieldWeight2.setText(str);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWeightCalculator = new JFrame();
		frmWeightCalculator.setTitle("Weight Calculator");
		frmWeightCalculator.setBounds(100, 100, 346, 407);
		frmWeightCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWeightCalculator.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Your Weight on Other Planets");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(30, 20, 296, 24);
		frmWeightCalculator.getContentPane().add(lblTitle);
		
		JLabel lblMsg1 = new JLabel("Enter Your Weight");
		lblMsg1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMsg1.setBounds(30, 70, 130, 24);
		frmWeightCalculator.getContentPane().add(lblMsg1);
		
		JButton btnCalc = new JButton("Calculate");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateWeight();
			}
		});
		btnCalc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalc.setBounds(30, 160, 100, 24);
		frmWeightCalculator.getContentPane().add(btnCalc);
		
		lblImage = new JLabel("");
		lblImage.setBounds(152, 144, 150, 150);
		frmWeightCalculator.getContentPane().add(lblImage);
		
		comboBoxList = new JComboBox<String>();
		comboBoxList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = comboBoxList.getSelectedIndex();
//				String str = String.valueOf(selected);
//				JOptionPane.showMessageDialog(null, "+++ " + str);
				Planet[] planetList = planetData.getData();
				lblImage.setIcon(planetList[selected].getImage());
			}
		});
		comboBoxList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxList.setBounds(124, 110, 178, 24);
		frmWeightCalculator.getContentPane().add(comboBoxList);
		String[] list = planetData.getNameList();
		for (String s : list) comboBoxList.addItem(s);
		
		textFieldWeight = new JTextField();
		textFieldWeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldWeight.setText("100");
		textFieldWeight.setBounds(160, 70, 50, 24);
		frmWeightCalculator.getContentPane().add(textFieldWeight);
		textFieldWeight.setColumns(10);
		
		JLabel lblSelectPlanet = new JLabel("Select Planet");
		lblSelectPlanet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectPlanet.setBounds(30, 110, 106, 24);
		frmWeightCalculator.getContentPane().add(lblSelectPlanet);
		
		JLabel lblMsg2 = new JLabel("Your weight is ");
		lblMsg2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMsg2.setBounds(30, 320, 100, 24);
		frmWeightCalculator.getContentPane().add(lblMsg2);
		
		textFieldWeight2 = new JTextField();
		textFieldWeight2.setColumns(10);
		textFieldWeight2.setBounds(125, 320, 50, 24);
		frmWeightCalculator.getContentPane().add(textFieldWeight2);
		
		lblMsg3 = new JLabel("Kg");
		lblMsg3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMsg3.setBounds(215, 70, 20, 24);
		frmWeightCalculator.getContentPane().add(lblMsg3);
		
		lblMsg4 = new JLabel("Kg");
		lblMsg4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMsg4.setBounds(185, 320, 20, 24);
		frmWeightCalculator.getContentPane().add(lblMsg4);
	}
}
