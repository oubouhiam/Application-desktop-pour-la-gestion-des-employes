package GestionEmployee;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Application {

	private JFrame frame;

	Connection conn;
	PreparedStatement stmt;
	private JTextField fname;
	private JTextField lname;
	private JTextField age;
	private JTextField date;
	private JTextField price;
	JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Application() {
		initialize();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 1153, 734);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Gestion des Employees");
		lblNewLabel_2.setBounds(287, 10, 484, 59);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblFirstName = new JLabel("First Name:\r\n");
		lblFirstName.setBounds(27, 117, 120, 40);
		frame.getContentPane().add(lblFirstName);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 12));

		fname = new JTextField();
		fname.setBounds(105, 117, 251, 40);
		frame.getContentPane().add(fname);
		fname.setFont(new Font("Tahoma", Font.BOLD, 13));
		fname.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setBounds(27, 202, 120, 40);
		frame.getContentPane().add(lblLastName);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));

		lname = new JTextField();
		lname.setBounds(105, 202, 251, 40);
		frame.getContentPane().add(lname);
		lname.setFont(new Font("Tahoma", Font.BOLD, 13));
		lname.setColumns(10);

		age = new JTextField();
		age.setBounds(105, 282, 251, 40);
		frame.getContentPane().add(age);
		age.setFont(new Font("Tahoma", Font.BOLD, 13));
		age.setColumns(10);

		JLabel lblYear = new JLabel("Year :");
		lblYear.setBounds(27, 282, 120, 40);
		frame.getContentPane().add(lblYear);
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 12));

		JComboBox<?> services = new JComboBox();
		services.setBackground(new Color(0, 191, 255));
		services.setForeground(new Color(0, 0, 0));
		services.setModel(new DefaultComboBoxModel(new String[] { "Seller", "Representative", "Producer",
				"Producer Risk", "Warehouseman", "Handler Risk" }));
		services.setBounds(603, 201, 251, 40);
		frame.getContentPane().add(services);
		services.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblService_1 = new JLabel("Service  :");
		lblService_1.setBounds(427, 202, 120, 40);
		frame.getContentPane().add(lblService_1);
		lblService_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblServiceEntryDate = new JLabel("Service Entry Date:");
		lblServiceEntryDate.setBounds(427, 117, 153, 40);
		frame.getContentPane().add(lblServiceEntryDate);
		lblServiceEntryDate.setFont(new Font("Tahoma", Font.BOLD, 12));

		date = new JTextField();
		date.setBounds(603, 117, 251, 40);
		frame.getContentPane().add(date);
		date.setFont(new Font("Tahoma", Font.BOLD, 13));
		date.setColumns(10);

		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setBounds(427, 277, 261, 50);
		frame.getContentPane().add(lblPrice);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(Color.ORANGE);
		panel_2.setBackground(new Color(240, 255, 255));
		panel_2.setBounds(27, 452, 1079, 235);
		frame.getContentPane().add(panel_2);

		JLabel lblNewLabel_1_1 = new JLabel("LIST\r\n");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic", Font.BOLD, 34));
		lblNewLabel_1_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1_1.setBounds(424, 10, 179, 50);
		panel_2.add(lblNewLabel_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 50, 1079, 197);
		panel_2.add(scrollPane);

		price = new JTextField();
		price.setFont(new Font("Tahoma", Font.BOLD, 13));
		price.setColumns(10);
		price.setBounds(603, 282, 251, 40);
		frame.getContentPane().add(price);

		// table(((((((((((((((((((((((((((((((((((((((((((((((((
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				DefaultTableModel df = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();
				fname.setText(df.getValueAt(selectedIndex, 1).toString());
				lname.setText(df.getValueAt(selectedIndex, 2).toString());
				age.setText(df.getValueAt(selectedIndex, 3).toString());
				date.setText(df.getValueAt(selectedIndex, 5).toString());
				price.setText(df.getValueAt(selectedIndex, 6).toString());
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "FirstName", "LastName", "Age",
				"Services", "Service Entry Date", "Price", "Salary" }) {

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(81);
		table.getColumnModel().getColumn(5).setPreferredWidth(107);
		table.getColumnModel().getColumn(6).setPreferredWidth(49);
		scrollPane.setViewportView(table);

		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(0, 0, 0));
		btnAdd.setBounds(200, 404, 159, 38);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstname = fname.getText();
				String lastname = lname.getText();
				String year = age.getText();
				String service = services.getSelectedItem().toString();
				String dates = date.getText();
				String prices = price.getText();

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionemployes", "root", "");
					stmt = conn.prepareStatement(
							"insert into employe(firstname,lastname,year,service,dates,prices,salary)values(?,?,?,?,?,?,?)");
					stmt.setString(1, firstname);
					stmt.setString(2, lastname);
					stmt.setString(3, year);
					stmt.setString(4, service);
					stmt.setString(5, dates);
					stmt.setString(6, prices);
					switch (service) {
					case "Seller":
						double salaireVendeur = (0.2 * Integer.parseInt(prices)) + 1500;
						stmt.setDouble(7, salaireVendeur);
						stmt.execute();
						break;
					case "Representative":
						double salaireRepresentant = (0.2 * Integer.parseInt(prices)) + 2500;
						stmt.setDouble(7, salaireRepresentant);
						stmt.execute();
						break;
					case "Producer":
						double salaireProducteur = (5 * Integer.parseInt(prices));
						stmt.setDouble(7, salaireProducteur);
						stmt.execute();
						break;
					case "Producer Risk":
						double salaireProducteurARisque = (5 * Integer.parseInt(prices)) + 200;
						stmt.setDouble(7, salaireProducteurARisque);
						stmt.execute();
						break;
					case "Warehouseman":
						double salaireManutentionnaire = (50 * Integer.parseInt(prices));
						stmt.setDouble(7, salaireManutentionnaire);
						stmt.execute();
						break;
					case "Handler Risk":
						double salaireManutentionnaireARisque = (50 * Integer.parseInt(prices)) + 200;
						stmt.setDouble(7, salaireManutentionnaireARisque);
						stmt.execute();
						break;
					default:
						break;
					}
					JOptionPane.showMessageDialog(btnAdd, "Employee Added Successfully");
					show();
					fname.setText("");
					lname.setText("");
					age.setText("");
					services.setSelectedIndex(0);
					date.setText("");
					price.setText("");
					fname.requestFocus();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		JButton btnOrder = new JButton("DISPLAY\r\n");
		btnOrder.setForeground(new Color(255, 255, 255));
		btnOrder.setBackground(new Color(0, 0, 0));
		btnOrder.setBounds(382, 404, 159, 38);
		frame.getContentPane().add(btnOrder);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show();
			}
		});
		btnOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(0, 0, 0));
		btnUpdate.setBounds(730, 404, 159, 38);
		frame.getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel df = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();
				try {
					int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
					String firstname = fname.getText();
					String lastname = lname.getText();
					String year = age.getText();
					String service = services.getSelectedItem().toString();
					String dates = date.getText();
					String prices = price.getText();
					double salary = 0;
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionemployes", "root", "");
					switch (service) {
					case "Seller":
						salary = (0.2 * Integer.parseInt(prices)) + 1500;
						break;
					case "Representative":
						salary = (0.2 * Integer.parseInt(prices)) + 2500;
						break;
					case "Producer":
						salary = (5 * Integer.parseInt(prices));
						break;
					case "Producer A Risk":
						salary = (5 * Integer.parseInt(prices)) + 200;
						break;
					case "Warehouseman":
						salary = (50 * Integer.parseInt(prices));
						break;
					case "Handler A Risk":
						salary = (50 * Integer.parseInt(prices)) + 200;
						break;
					default:
						break;
					}
					stmt = conn.prepareStatement("UPDATE employe SET " + "firstname = '" + firstname + "', lastname = '"
							+ lastname + "', year = '" + year + "', dates = '" + dates + "', service = '" + service
							+ "', prices = '" + prices + "', salary = '" + salary + "' where id = '" + id + "'");
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(btnAdd, "Employe edited Successfully");
					show();
					fname.setText("");
					lname.setText("");
					age.setText("");
					services.setSelectedIndex(0);
					date.setText("");
					price.setText("");
					fname.requestFocus();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(0, 0, 0));
		btnDelete.setBounds(561, 404, 159, 38);
		frame.getContentPane().add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int msg = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete ??!!", "Delete",
						JOptionPane.YES_NO_OPTION);
				if (msg == 0) {
					DefaultTableModel df = (DefaultTableModel) table.getModel();
					int selectedIndex = table.getSelectedRow();
					try {
						int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
						Class.forName("com.mysql.cj.jdbc.Driver");
						conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionemployes", "root", "");
						stmt = conn.prepareStatement("DELETE from employe  where id = '" + id + "'");
						stmt.executeUpdate();
						JOptionPane.showMessageDialog(btnAdd, "Employee Deleted Successfully");
						show();
						fname.setText("");
						lname.setText("");
						age.setText("");
						services.setSelectedIndex(0);
						date.setText("");
						price.setText("");
						fname.requestFocus();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		JButton btnCancel = new JButton("Quitter");
		btnCancel.setBackground(new Color(255, 99, 71));
		btnCancel.setBounds(994, 404, 112, 38);
		frame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
	}
	private void show() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionemployes", "root", "");
			stmt = conn.prepareStatement("SELECT * FROM employe");
			ResultSet result = stmt.executeQuery();
			DefaultTableModel df = (DefaultTableModel) table.getModel();
			df.setRowCount(0);
			while (result.next()) {
				int id = result.getInt("id");
				String firstname = result.getString("firstname");
				String lastname = result.getString("lastname");
				int year = result.getInt("year");
				String service = result.getString("service");
				String dates = result.getString("dates");
				int prices = result.getInt("prices");
				Double salary = result.getDouble("salary");
				df.addRow(new Object[] { id, firstname, lastname, year, service, dates, prices, salary });
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
