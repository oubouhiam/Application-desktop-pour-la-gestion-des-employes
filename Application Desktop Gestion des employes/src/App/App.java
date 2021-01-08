package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class App extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the App.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setBackground(Color.ORANGE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1043, 667);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtId.getText();
			}
		});
		btnNewButton.setBounds(55, 456, 333, 50);
		contentPane.add(btnNewButton);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(154, 114, 308, 35);
		contentPane.add(txtId);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("yassine\r\ndfsqdf\r\nsdfsdf\r\nsdf");
		comboBox.setBounds(154, 384, 308, 27);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Gestion Des Emplyes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 49));
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setBounds(197, 10, 720, 63);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1.setBackground(Color.GREEN);
		lblNewLabel_1.setBounds(10, 114, 87, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("First Name");
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1_1.setBackground(Color.GREEN);
		lblNewLabel_1_1.setBounds(10, 159, 87, 35);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(154, 159, 308, 35);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Last Name");
		lblNewLabel_1_2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1_2.setBackground(Color.GREEN);
		lblNewLabel_1_2.setBounds(10, 204, 87, 35);
		contentPane.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(154, 204, 308, 35);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Age\r\n");
		lblNewLabel_1_2_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBackground(Color.GREEN);
		lblNewLabel_1_2_1.setBounds(10, 249, 87, 35);
		contentPane.add(lblNewLabel_1_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(154, 249, 308, 35);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Date of entryservic");
		lblNewLabel_1_2_2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1_2_2.setBackground(Color.GREEN);
		lblNewLabel_1_2_2.setBounds(10, 294, 134, 35);
		contentPane.add(lblNewLabel_1_2_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(154, 294, 308, 35);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Chiffre d'affaire");
		lblNewLabel_1_2_2_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1_2_2_1.setBackground(Color.GREEN);
		lblNewLabel_1_2_2_1.setBounds(10, 339, 134, 35);
		contentPane.add(lblNewLabel_1_2_2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(154, 339, 308, 35);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("TYPE");
		lblNewLabel_1_2_2_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1_2_2_1_1.setBackground(Color.GREEN);
		lblNewLabel_1_2_2_1_1.setBounds(10, 379, 134, 35);
		contentPane.add(lblNewLabel_1_2_2_1_1);
		
		JButton btnNewButton_1 = new JButton("Edite\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(433, 456, 333, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(237, 516, 333, 50);
		contentPane.add(btnNewButton_1_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1002, 127, 17, 227);
		contentPane.add(scrollBar);
		
		JList list = new JList();
		list.setBounds(625, 355, 141, -195);
		contentPane.add(list);
	}
}
