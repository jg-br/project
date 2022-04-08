package Project;
/* Student Name: John Brennan 
 * Student ID:c00114371
 * Date: */
import javax.swing.JFrame; 
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class AddSupplier extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField supplierName;
	private JTextField supplierPhone;
	private JTextField supplierEmail;
	private String name;
	private String address;
	private String phone;
	private String email;
	private JTextField supplierAddress;
	
	public AddSupplier() 
	{
		super("Add Supplier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddSupplier.class.getResource("/Project/logo3b.jpg")));
		getContentPane().setBackground(Color.GRAY);
		setBackground(Color.GRAY);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		supplierName = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, supplierName, -312, SpringLayout.SOUTH, getContentPane());
		supplierName.setFont(new Font("Verdana", Font.PLAIN, 13));
		getContentPane().add(supplierName);
		supplierName.setColumns(10);
		
		//	Supplier name and supplier address labels
		JLabel SupplierNameLbl = new JLabel("Supplier Name:");
		springLayout.putConstraint(SpringLayout.NORTH, SupplierNameLbl, 69, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, SupplierNameLbl, 25, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, SupplierNameLbl, -546, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, supplierName, 24, SpringLayout.EAST, SupplierNameLbl);
		SupplierNameLbl.setLabelFor(supplierName);
		SupplierNameLbl.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(SupplierNameLbl);
		
		JLabel supplierAddressLbl = new JLabel("Supplier Address:");
		springLayout.putConstraint(SpringLayout.NORTH, supplierAddressLbl, 119, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, supplierAddressLbl, 25, SpringLayout.WEST, getContentPane());
		supplierAddressLbl.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(supplierAddressLbl);
		
		supplierPhone = new JTextField();	//	supplier phone number text field
		supplierPhone.setFont(new Font("Verdana", Font.PLAIN, 13));
		getContentPane().add(supplierPhone);
		supplierPhone.setColumns(10);
		
//		supplier phone number label and email label
		JLabel supplierPhoneNoLbl = new JLabel("Supplier Phone No:");	
		springLayout.putConstraint(SpringLayout.WEST, supplierPhone, 24, SpringLayout.EAST, supplierPhoneNoLbl);
		springLayout.putConstraint(SpringLayout.SOUTH, supplierAddressLbl, -41, SpringLayout.NORTH, supplierPhoneNoLbl);
		springLayout.putConstraint(SpringLayout.NORTH, supplierPhoneNoLbl, 3, SpringLayout.NORTH, supplierPhone);
		springLayout.putConstraint(SpringLayout.WEST, supplierPhoneNoLbl, 25, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, supplierPhoneNoLbl, 0, SpringLayout.EAST, SupplierNameLbl);
		supplierPhoneNoLbl.setLabelFor(supplierPhone);
		supplierPhoneNoLbl.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(supplierPhoneNoLbl);
		
		JLabel supplierEmailLbl = new JLabel("Supplier  Email:");
		springLayout.putConstraint(SpringLayout.NORTH, supplierEmailLbl, 251, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, supplierEmailLbl, 25, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, supplierEmailLbl, -558, SpringLayout.EAST, getContentPane());
		supplierEmailLbl.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(supplierEmailLbl);
		
		//	email text field
		supplierEmail = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, supplierPhone, -39, SpringLayout.NORTH, supplierEmail);
		springLayout.putConstraint(SpringLayout.NORTH, supplierEmail, -5, SpringLayout.NORTH, supplierEmailLbl);
		springLayout.putConstraint(SpringLayout.WEST, supplierEmail, 0, SpringLayout.WEST, supplierName);
		springLayout.putConstraint(SpringLayout.EAST, supplierEmail, -341, SpringLayout.EAST, getContentPane());
		supplierEmail.setFont(new Font("Verdana", Font.PLAIN, 13));
		getContentPane().add(supplierEmail);
		supplierEmail.setColumns(10);
		
		
		//	jbutton to return to the administrator window
		JButton adminWindowBtn = new JButton("Administrator Window");
		springLayout.putConstraint(SpringLayout.EAST, adminWindowBtn, -37, SpringLayout.EAST, getContentPane());
		adminWindowBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Admin  login = new Admin();
				login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				login.setSize(800, 600);
				login.setLocation(300,200);
				login.setResizable(false);
				login.setVisible(true);
				dispose();
			}	//	Action listener to dispose of the add supplier window and re-open the administrator window 
		});
		adminWindowBtn.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(adminWindowBtn);
		
		//	Jbutton to add a supplier
		JButton addSupplier = new JButton("Add Supplier");
		springLayout.putConstraint(SpringLayout.NORTH, adminWindowBtn, 0, SpringLayout.NORTH, addSupplier);
		springLayout.putConstraint(SpringLayout.SOUTH, adminWindowBtn, 0, SpringLayout.SOUTH, addSupplier);
		springLayout.putConstraint(SpringLayout.EAST, addSupplier, -546, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, addSupplier, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, addSupplier, 315, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, addSupplier, -34, SpringLayout.SOUTH, getContentPane());
		addSupplier.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					name= supplierName.getText();
					address=supplierAddress.getText();
					phone= supplierPhone.getText();
					email=	supplierEmail.getText();
										
							Crud insert2 = new Crud();
							insert2.insertSupplier(name, address, phone, email);	//calls the insert supplier method form the crud.
							try 
					 		{
								insert2.close();
							} 
				 		catch (SQLException e1) 
					 		{
								ErrorMessage err = new ErrorMessage("Error  creating Supplier record. "+e1);
							}
							
						
				} 
			catch (Exception e1) 
				{
					
					//e1.printStackTrace();
					ErrorMessage err = new ErrorMessage("There an error querying the database "+ e1);
				
				}
				supplierName.setText("");supplierAddress.setText("");supplierPhone.setText("");supplierEmail.setText("");
			}
		});		
		addSupplier.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(addSupplier);
		
		JLabel iconLabel = new JLabel("");	//	logo label
		springLayout.putConstraint(SpringLayout.EAST, supplierPhone, -105, SpringLayout.WEST, iconLabel);
		springLayout.putConstraint(SpringLayout.EAST, supplierName, -105, SpringLayout.WEST, iconLabel);
		springLayout.putConstraint(SpringLayout.WEST, adminWindowBtn, 0, SpringLayout.WEST, iconLabel);
		springLayout.putConstraint(SpringLayout.NORTH, iconLabel, 0, SpringLayout.NORTH, supplierName);
		springLayout.putConstraint(SpringLayout.EAST, iconLabel, -37, SpringLayout.EAST, getContentPane());
		iconLabel.setIcon(new ImageIcon(AddSupplier.class.getResource("/Project/logo3a.jpg")));
		getContentPane().add(iconLabel);
		
		supplierAddress = new JTextField();	//	text field for the supplier address.
		springLayout.putConstraint(SpringLayout.EAST, supplierAddressLbl, -24, SpringLayout.WEST, supplierAddress);
		springLayout.putConstraint(SpringLayout.WEST, supplierAddress, 0, SpringLayout.WEST, supplierName);
		springLayout.putConstraint(SpringLayout.SOUTH, supplierAddress, 0, SpringLayout.SOUTH, supplierAddressLbl);
		springLayout.putConstraint(SpringLayout.EAST, supplierAddress, 0, SpringLayout.EAST, supplierName);
		supplierAddress.setFont(new Font("Verdana", Font.PLAIN, 13));
		getContentPane().add(supplierAddress);
		supplierAddress.setColumns(10);
	}
}
