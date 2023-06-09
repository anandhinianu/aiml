package Account;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Reg {

	private JFrame frame;
	private JTextField tf1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg window = new Reg();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 240, 245));
		frame.setBounds(100, 100, 382, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(145, 11, 127, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(55, 76, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Branch");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(55, 129, 61, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Prgm lang");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(55, 156, 82, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(55, 108, 61, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tf1 = new JTextField();
		tf1.setBounds(147, 74, 86, 20);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		JRadioButton r1 = new JRadioButton("Female");
		r1.setBackground(new Color(255, 240, 245));
		r1.setBounds(145, 105, 72, 23);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Male");
		r2.setBackground(new Color(255, 240, 245));
		r2.setBounds(219, 105, 109, 23);
		frame.getContentPane().add(r2);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		JComboBox c1 = new JComboBox();
		c1.setBackground(new Color(255, 240, 245));
		c1.setModel(new DefaultComboBoxModel(new String[] {"select", "Cse", "Aiml", "Ds", "Ece", "It"}));
		c1.setBounds(145, 132, 88, 22);
		frame.getContentPane().add(c1);
		
		JCheckBox cb1 = new JCheckBox("Java");
		cb1.setBackground(new Color(255, 240, 245));
		cb1.setBounds(145, 159, 61, 23);
		frame.getContentPane().add(cb1);
		
		JCheckBox cb2 = new JCheckBox("C");
		cb2.setBounds(208, 159, 46, 23);
		frame.getContentPane().add(cb2);
		
		JCheckBox cb3 = new JCheckBox("Python");
		cb3.setBounds(258, 159, 97, 23);
		frame.getContentPane().add(cb3);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tf1.getText();
				String gen = null;
				if(r1.isSelected()) {
					gen="Female";
				}
				else if(r2.isSelected()) {
					gen="Male";
				}
				else {
					JOptionPane.showMessageDialog(btnNewButton, "Invalid");
				}
				
				String branch=(String) c1.getSelectedItem();
				String prgmlang="";
				if(cb1.isSelected()) {
					prgmlang=prgmlang+"java";
				}
				if(cb2.isSelected()) {
					prgmlang=prgmlang+";C";
				}
				if(cb3.isSelected()) {
					prgmlang=prgmlang+"Python";
				}
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml","root","mrec");
					String q="insert into reg values( '"+name+"','"+gen+"','"+branch+"','"+prgmlang+"')";
					JOptionPane.showMessageDialog(btnNewButton, "Done!!");
	                Statement sta=con.createStatement();
	                sta.execute(q);
	                con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(145, 196, 89, 32);
		frame.getContentPane().add(btnNewButton);
	}
}
