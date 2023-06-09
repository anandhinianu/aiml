package Friendship;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 605, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("");
		l1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		l1.setFont(new Font("Segoe Script", Font.BOLD, 14));
		l1.setBounds(265, 48, 276, 75);
		frame.getContentPane().add(l1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random r=new Random();
				int i=r.nextInt(1,100);
				l1.setText("Your Friendhip Percentage\n : "+i);
			}
		});
		btnNewButton.setFont(new Font("Segoe Script", Font.BOLD, 17));
		btnNewButton.setBounds(122, 230, 110, 32);
		frame.getContentPane().add(btnNewButton);
		
		t2 = new JTextField();
		t2.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 15));
		t2.setBounds(46, 175, 168, 25);
		frame.getContentPane().add(t2);
		t2.setColumns(10);
		
		t1 = new JTextField();
		t1.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 15));
		t1.setBounds(46, 98, 158, 25);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Your Friends Name");
		lblNewLabel_3.setFont(new Font("Segoe Script", Font.BOLD, 15));
		lblNewLabel_3.setBounds(46, 132, 169, 32);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Segoe Script", Font.BOLD, 15));
		lblNewLabel_2.setBounds(75, 67, 59, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Friendship Calculator");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(91, 11, 304, 45);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\online lab\\Desktop\\i.jpg"));
		lblNewLabel.setBounds(-22, 0, 766, 326);
		frame.getContentPane().add(lblNewLabel);
	}
}
