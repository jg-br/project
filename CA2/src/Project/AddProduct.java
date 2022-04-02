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

public class AddProduct extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField supplierId;
	private JTextField description;
	private JTextField unitCost;
	private JTextField Quantity;
	private String supplierID;
	private String model;
	private String desc;
	private String qty;
	private String cost;
	private String retail;
	private JTextField modelNo;
	private JTextField retailField;
	
	public AddProduct() 
	{
		super("Add Product");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddProduct.class.getResource("/Project/logo3b.jpg")));
		getContentPane().setBackground(Color.GRAY);
		setBackground(Color.GRAY);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		supplierId = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, supplierId, 49, SpringLayout.NORTH, getContentPane());
		supplierId.setFont(new Font("Verdana", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.EAST, supplierId, -420, SpringLayout.EAST, getContentPane());
		getContentPane().add(supplierId);
		supplierId.setColumns(10);
		
		JLabel SupplierIDLbl = new JLabel(" Enter Supplier ID:");
		springLayout.putConstraint(SpringLayout.NORTH, SupplierIDLbl, 49, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, SupplierIDLbl, -323, SpringLayout.SOUTH, getContentPane());
		SupplierIDLbl.setLabelFor(supplierId);
		springLayout.putConstraint(SpringLayout.EAST, SupplierIDLbl, -625, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, supplierId, 24, SpringLayout.EAST, SupplierIDLbl);
		springLayout.putConstraint(SpringLayout.WEST, SupplierIDLbl, 25, SpringLayout.WEST, getContentPane());
		SupplierIDLbl.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(SupplierIDLbl);
		
		JLabel modelNoLbl = new JLabel("Enter Model Number:");
		springLayout.putConstraint(SpringLayout.NORTH, modelNoLbl, 24, SpringLayout.SOUTH, SupplierIDLbl);
		springLayout.putConstraint(SpringLayout.WEST, modelNoLbl, 0, SpringLayout.WEST, SupplierIDLbl);
		modelNoLbl.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(modelNoLbl);
		
		description = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, description, 0, SpringLayout.WEST, supplierId);
		springLayout.putConstraint(SpringLayout.EAST, description, 0, SpringLayout.EAST, supplierId);
		description.setFont(new Font("Verdana", Font.PLAIN, 13));
		getContentPane().add(description);
		description.setColumns(10);
		
		JLabel phoneNolabel = new JLabel("Enter Product Description:");
		springLayout.putConstraint(SpringLayout.SOUTH, modelNoLbl, -25, SpringLayout.NORTH, phoneNolabel);
		springLayout.putConstraint(SpringLayout.NORTH, phoneNolabel, 4, SpringLayout.NORTH, description);
		springLayout.putConstraint(SpringLayout.WEST, phoneNolabel, 0, SpringLayout.WEST, SupplierIDLbl);
		springLayout.putConstraint(SpringLayout.SOUTH, phoneNolabel, -233, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, phoneNolabel, 0, SpringLayout.EAST, SupplierIDLbl);
		phoneNolabel.setLabelFor(description);
		phoneNolabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(phoneNolabel);
		
		unitCost = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, unitCost, 0, SpringLayout.WEST, supplierId);
		springLayout.putConstraint(SpringLayout.EAST, unitCost, 0, SpringLayout.EAST, supplierId);
		unitCost.setFont(new Font("Verdana", Font.PLAIN, 13));
		getContentPane().add(unitCost);
		unitCost.setColumns(10);
		
		JLabel qtyLabel = new JLabel("Enter Quantity");
		springLayout.putConstraint(SpringLayout.NORTH, qtyLabel, 21, SpringLayout.SOUTH, phoneNolabel);
		springLayout.putConstraint(SpringLayout.WEST, qtyLabel, 0, SpringLayout.WEST, SupplierIDLbl);
		springLayout.putConstraint(SpringLayout.SOUTH, qtyLabel, -193, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, qtyLabel, 0, SpringLayout.EAST, SupplierIDLbl);
		qtyLabel.setLabelFor(unitCost);
		qtyLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(qtyLabel);
		
		Quantity = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, Quantity, -4, SpringLayout.NORTH, qtyLabel);
		springLayout.putConstraint(SpringLayout.WEST, Quantity, 0, SpringLayout.WEST, supplierId);
		springLayout.putConstraint(SpringLayout.EAST, Quantity, 0, SpringLayout.EAST, supplierId);
		Quantity.setFont(new Font("Verdana", Font.PLAIN, 13));
		getContentPane().add(Quantity);
		Quantity.setColumns(10);
		
		JLabel unitCostLbl = new JLabel("Enter Unit Cose:");
		springLayout.putConstraint(SpringLayout.WEST, unitCostLbl, 25, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, unitCostLbl, -6, SpringLayout.WEST, unitCost);
		springLayout.putConstraint(SpringLayout.SOUTH, unitCost, 0, SpringLayout.SOUTH, unitCostLbl);
		springLayout.putConstraint(SpringLayout.NORTH, unitCostLbl, 17, SpringLayout.SOUTH, qtyLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, unitCostLbl, -153, SpringLayout.SOUTH, getContentPane());
		unitCostLbl.setLabelFor(Quantity);
		unitCostLbl.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(unitCostLbl);
		
		JButton cancelButton = new JButton("Administrator Window");
		cancelButton.addActionListener(new ActionListener()
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
			}
		});
		cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(cancelButton);
		
		JButton createAccountButton = new JButton("Add Product");
		springLayout.putConstraint(SpringLayout.NORTH, cancelButton, 0, SpringLayout.NORTH, createAccountButton);
		springLayout.putConstraint(SpringLayout.SOUTH, cancelButton, 0, SpringLayout.SOUTH, createAccountButton);
		springLayout.putConstraint(SpringLayout.NORTH, createAccountButton, 313, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, createAccountButton, 0, SpringLayout.WEST, SupplierIDLbl);
		springLayout.putConstraint(SpringLayout.SOUTH, createAccountButton, -36, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, createAccountButton, -648, SpringLayout.EAST, getContentPane());
		createAccountButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					supplierID= supplierId.getText();
					model=modelNo.getText();
					desc= description.getText();
					qty=	Quantity.getText();
					cost=	unitCost.getText();
					retail=	retailField.getText();
					Crud insert = new Crud();
					
					
					if(insert.supplierCheck(supplierID)==false)	//	make sure that the supplier Id exists in the supplier table before into the product table
						{
							ErrorMessage err = new ErrorMessage("Supplier ID is not valid");	
						}
					
					else
						{
							Crud insert2 = new Crud();
							insert2.insertProduct(supplierID, model, desc, qty, cost, retail);
							try 
					 		{
								insert2.close();
							} 
				 		catch (SQLException e1) 
					 		{
								ErrorMessage err = new ErrorMessage("Error  Product record. "+e1);
							}
							
						}
				} 
			catch (Exception e1) 
				{
					
					//e1.printStackTrace();
					ErrorMessage err = new ErrorMessage("There an error querying the database "+ e1);
				
				}
				supplierId.setText("");modelNo.setText("");description.setText("");Quantity.setText("");unitCost.setText("");retailField.setText("");
			}
		});
		createAccountButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(createAccountButton);
		
		JLabel iconLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, cancelButton, 0, SpringLayout.WEST, iconLabel);
		springLayout.putConstraint(SpringLayout.EAST, cancelButton, 0, SpringLayout.EAST, iconLabel);
		springLayout.putConstraint(SpringLayout.NORTH, iconLabel, 83, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, iconLabel, -60, SpringLayout.EAST, getContentPane());
		iconLabel.setIcon(new ImageIcon(AddProduct.class.getResource("/Project/logo3a.jpg")));
		getContentPane().add(iconLabel);
		
		modelNo = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, modelNoLbl, -6, SpringLayout.WEST, modelNo);
		springLayout.putConstraint(SpringLayout.NORTH, modelNo, 20, SpringLayout.SOUTH, supplierId);
		springLayout.putConstraint(SpringLayout.NORTH, description, 21, SpringLayout.SOUTH, modelNo);
		springLayout.putConstraint(SpringLayout.WEST, modelNo, 0, SpringLayout.WEST, supplierId);
		springLayout.putConstraint(SpringLayout.EAST, modelNo, 0, SpringLayout.EAST, supplierId);
		modelNo.setFont(new Font("Verdana", Font.PLAIN, 13));
		getContentPane().add(modelNo);
		modelNo.setColumns(10);
		
		JLabel lblEnterUnitRetail = new JLabel("Enter Unit Retail:");
		springLayout.putConstraint(SpringLayout.WEST, lblEnterUnitRetail, 28, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblEnterUnitRetail, 168, SpringLayout.WEST, getContentPane());
		lblEnterUnitRetail.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(lblEnterUnitRetail);
		
		retailField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblEnterUnitRetail, 0, SpringLayout.NORTH, retailField);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEnterUnitRetail, 16, SpringLayout.NORTH, retailField);
		springLayout.putConstraint(SpringLayout.NORTH, retailField, 19, SpringLayout.SOUTH, unitCost);
		springLayout.putConstraint(SpringLayout.WEST, retailField, 0, SpringLayout.WEST, supplierId);
		springLayout.putConstraint(SpringLayout.EAST, retailField, 0, SpringLayout.EAST, supplierId);
		retailField.setFont(new Font("Verdana", Font.PLAIN, 13));
		retailField.setColumns(10);
		getContentPane().add(retailField);
	}
}
