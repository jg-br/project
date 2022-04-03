package Project;
/* Student Name: John Brennan 
 * Student ID:c00114371
 * Date: */
import java.awt.Color; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import java.sql.ResultSetMetaData;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


public class Shop extends JFrame  
{
	private JTable table;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private String state;
 	public Shop()
	{	
		
		super("Administrator");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Shop.class.getResource("/Project/logo3b.jpg")));
		getContentPane().setBackground(Color.GRAY);
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
	
		//	jpanel containing JTable and Jbuttons
		 JPanel display = new JPanel();
		 springLayout.putConstraint(SpringLayout.WEST, display, 10, SpringLayout.WEST, getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, display, -10, SpringLayout.EAST, getContentPane());
		 display.setBackground(Color.GRAY);
		 display.setVisible(true); 
		
		 getContentPane().add(display);	//	adds the panel to the content pane
		 SpringLayout sl_display = new SpringLayout();
		 display.setLayout(sl_display);	//	set the layout of the panel
		 
		 table = new JTable();		//	creates a new Jtable
		 table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		 table.setFont(new Font("Verdana", Font.PLAIN, 13));
		 sl_display.putConstraint(SpringLayout.NORTH, table, 61, SpringLayout.NORTH, display);
		 sl_display.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, display);
		 sl_display.putConstraint(SpringLayout.SOUTH, table, -10, SpringLayout.SOUTH, display);
		 sl_display.putConstraint(SpringLayout.EAST, table, 0, SpringLayout.EAST, display);
		
		 JScrollPane scrollPane = new JScrollPane(table);
		 sl_display.putConstraint(SpringLayout.NORTH, scrollPane, 46, SpringLayout.NORTH, display);
		 sl_display.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, display);
		 sl_display.putConstraint(SpringLayout.SOUTH, scrollPane, -41, SpringLayout.SOUTH, display);
		 sl_display.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, display);
		 scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		 display.add(scrollPane);	//	adds the scroll pane (with Jtable) to the display panel
		 
		 JLabel test = new JLabel("New label");
		 test.setVisible(false);
		 test.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 getContentPane().add(test);
		 
		 textField = new JTextField();
		 springLayout.putConstraint(SpringLayout.NORTH, test, 5, SpringLayout.NORTH, textField);
		 springLayout.putConstraint(SpringLayout.EAST, test, -32, SpringLayout.WEST, textField);
		 springLayout.putConstraint(SpringLayout.WEST, textField, 131, SpringLayout.WEST, getContentPane());
		 textField.setFont(new Font("Verdana", Font.PLAIN, 13));
		
		 textField.addActionListener(new ActionListener()
		 {
			 private final static String newline="\n";		//	generates an action when the return key is pressed
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		String text = textField.getText();
		 		textField.selectAll();
		 		getResults(text);		//	Fills the other fields the details gathered from the ID field. 	 		
		 	}
		 });
		 textField.setVisible(false);
		 getContentPane().add(textField);
		 textField.setColumns(10);
		 
		 JLabel test1 = new JLabel("New label");
		 springLayout.putConstraint(SpringLayout.WEST, test, 0, SpringLayout.WEST, test1);
		 test1.setVisible(false);
		 springLayout.putConstraint(SpringLayout.NORTH, test1, 57, SpringLayout.NORTH, getContentPane());
		 springLayout.putConstraint(SpringLayout.WEST, test1, 20, SpringLayout.WEST, getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, test1, -687, SpringLayout.EAST, getContentPane());
		 test1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 getContentPane().add(test1);
		 
		 textField1 = new JTextField();
		 springLayout.putConstraint(SpringLayout.SOUTH, textField, -12, SpringLayout.NORTH, textField1);
		 springLayout.putConstraint(SpringLayout.EAST, textField1, 0, SpringLayout.EAST, textField);
		 springLayout.putConstraint(SpringLayout.WEST, textField1, 32, SpringLayout.EAST, test1);
		 textField1.setFont(new Font("Verdana", Font.PLAIN, 13));
		 springLayout.putConstraint(SpringLayout.NORTH, textField1, -1, SpringLayout.NORTH, test1);
		 textField1.setVisible(false);
		 textField1.setColumns(10);
		 getContentPane().add(textField1);
		 
		 JLabel test2 = new JLabel("New label");
		 springLayout.putConstraint(SpringLayout.NORTH, test2, 23, SpringLayout.SOUTH, test1);
		 springLayout.putConstraint(SpringLayout.WEST, test2, 24, SpringLayout.WEST, getContentPane());
		 test2.setVisible(false);
		 test2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 getContentPane().add(test2);
		 
		 textField2 = new JTextField();
		 springLayout.putConstraint(SpringLayout.EAST, test2, -2, SpringLayout.WEST, textField2);
		 springLayout.putConstraint(SpringLayout.NORTH, textField2, 16, SpringLayout.SOUTH, textField1);
		 springLayout.putConstraint(SpringLayout.WEST, textField2, 131, SpringLayout.WEST, getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, textField2, 0, SpringLayout.EAST, textField);
		 textField2.setFont(new Font("Verdana", Font.PLAIN, 13));
		 textField2.setVisible(false);
		 textField2.setColumns(10);
		 getContentPane().add(textField2);
		 
		 JLabel test4 = new JLabel("New label");
		 springLayout.putConstraint(SpringLayout.NORTH, test4, 22, SpringLayout.NORTH, getContentPane());
		 springLayout.putConstraint(SpringLayout.WEST, test4, 538, SpringLayout.WEST, getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, test4, -169, SpringLayout.EAST, getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, textField, -268, SpringLayout.WEST, test4);
		 test4.setVisible(false);
		 test4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 getContentPane().add(test4);
		 
		 textField4 = new JTextField();
		 springLayout.putConstraint(SpringLayout.NORTH, textField4, 22, SpringLayout.NORTH, getContentPane());
		 springLayout.putConstraint(SpringLayout.WEST, textField4, 6, SpringLayout.EAST, test4);
		 springLayout.putConstraint(SpringLayout.EAST, textField4, -20, SpringLayout.EAST, getContentPane());
		 textField4.setFont(new Font("Verdana", Font.PLAIN, 13));
		 textField4.setVisible(false);
		 textField4.setColumns(10);
		 getContentPane().add(textField4);
		 
		 JLabel test5 = new JLabel("New label");
		 springLayout.putConstraint(SpringLayout.NORTH, test5, 39, SpringLayout.SOUTH, test4);
		 springLayout.putConstraint(SpringLayout.WEST, test5, 268, SpringLayout.EAST, textField1);
		 test5.setVisible(false);
		 test5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 getContentPane().add(test5);
		 
		 textField5 = new JTextField();
		 springLayout.putConstraint(SpringLayout.EAST, test5, -10, SpringLayout.WEST, textField5);
		 springLayout.putConstraint(SpringLayout.NORTH, textField5, 27, SpringLayout.SOUTH, textField4);
		 springLayout.putConstraint(SpringLayout.WEST, textField5, 627, SpringLayout.WEST, getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, textField5, -20, SpringLayout.EAST, getContentPane());
		 textField5.setFont(new Font("Verdana", Font.PLAIN, 13));
		 textField5.setVisible(false);
		 
		 JButton addToBasket = new JButton("Add to Basket");
		 sl_display.putConstraint(SpringLayout.NORTH, addToBasket, 6, SpringLayout.SOUTH, scrollPane);
		 sl_display.putConstraint(SpringLayout.WEST, addToBasket, 0, SpringLayout.WEST, display);
		 addToBasket.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		try
		 			{
			 			
		 				Crud add = new Crud();

		 				int stock = Integer.parseInt(textField3.getText());
		 				int ordered= Integer.parseInt(textField5.getText());
		 				System.out.println(stock+"\n"+ordered);
		 				if(stock >=ordered)
			 				{
			 				
						 		String query ="SELECT ProductID, ModelNo as 'Model', Description,QuantityInStock as 'Stock on hand', ProductRetail as 'Price in €' From Product";
						 		genTable(query);
						 		clear();
						 		
						 		try 
							 		{
										add.close();
									} 
							 	catch (SQLException e1) 
							 		{
										
							 		ErrorMessage err = new ErrorMessage("Error Updating Customer records. "+e1);
									}
			 				}
		 				else
		 					{
		 						Info info= new Info("the quantity ordered exceeds the stock available");
		 						textField5.setText("");
		 					}
		 				
		 			}
		 		catch(NumberFormatException nfe)
		 			{
		 				ErrorMessage err = new ErrorMessage("the value entered Must be a whole number ");
		 				textField5.setText("");
		 			}
		 		catch(Exception e2)
		 			{
		 				ErrorMessage err = new ErrorMessage("Error Updating Customer records. "+ e2);
		 			}	
		 		
		 	}
		 });
		 addToBasket.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 addToBasket.setVisible(false);
		 display.add(addToBasket);
		 
		 JButton deleteCustomerBtn = new JButton("Remove from basket");
		 sl_display.putConstraint(SpringLayout.NORTH, deleteCustomerBtn, 6, SpringLayout.SOUTH, scrollPane);
		 sl_display.putConstraint(SpringLayout.EAST, addToBasket, -6, SpringLayout.WEST, deleteCustomerBtn);
		 deleteCustomerBtn.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		try
		 			{
		 			
				 		Crud delete=new Crud();
				 		String query ="DELETE from basket   WHERE ProductID=?";
				 		String q2="SELECT ProductID, ModelNo as 'Model', Description,QuantityInStock as 'Stock on hand', ProductRetail as 'Price in €' From Product where ProductID > 0";
				 		String id= textField.getText();
				 		delete.adminDelete(query, id);
				 		clear();
				 		try 
					 		{
								delete.close();
							} 
				 		catch (SQLException e1) 
					 		{
								// TODO Auto-generated catch block
								ErrorMessage err = new ErrorMessage("Error deleting Customer record. "+e1);
							}
				 		genTable(q2);
				 		clear();
				 		//textField.setText("");textField1.setText("");	textField2.setText("");	textField3.setText("");	textField4.setText("");
		 			}
		 		catch(Exception e2)
		 			{
		 				ErrorMessage err = new ErrorMessage("Error deleting Customer record. "+ e2);
		 			}
		 		}
		 });
		 deleteCustomerBtn.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 deleteCustomerBtn.setVisible(false);
		 display.add(deleteCustomerBtn);
		 
		 textField5.setColumns(10);
		 getContentPane().add(textField5);
		 
		 JLabel test6 = new JLabel("New label");
		 springLayout.putConstraint(SpringLayout.NORTH, display, 6, SpringLayout.SOUTH, test6);
		 springLayout.putConstraint(SpringLayout.SOUTH, display, 375, SpringLayout.SOUTH, test6);
		 springLayout.putConstraint(SpringLayout.NORTH, test6, 49, SpringLayout.SOUTH, test5);
		 springLayout.putConstraint(SpringLayout.SOUTH, test6, -385, SpringLayout.SOUTH, getContentPane());
		 test6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 test6.setVisible(false);
		 getContentPane().add(test6);
		 
		 textField6 = new JTextField();
		 springLayout.putConstraint(SpringLayout.EAST, test6, 0, SpringLayout.WEST, textField6);
		 springLayout.putConstraint(SpringLayout.WEST, textField6, 0, SpringLayout.WEST, textField4);
		 springLayout.putConstraint(SpringLayout.SOUTH, textField6, -385, SpringLayout.SOUTH, getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, textField6, -20, SpringLayout.EAST, getContentPane());
		 textField6.setFont(new Font("Verdana", Font.PLAIN, 13));
		 textField6.setVisible(false);
		 getContentPane().add(textField6);
		 textField6.setColumns(10);
		 
		 textField3 = new JTextField();
		 springLayout.putConstraint(SpringLayout.SOUTH, textField3, -6, SpringLayout.NORTH, display);
		 springLayout.putConstraint(SpringLayout.WEST, test6, 268, SpringLayout.EAST, textField3);
		 springLayout.putConstraint(SpringLayout.WEST, textField3, 131, SpringLayout.WEST, getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, textField3, 0, SpringLayout.EAST, textField);
		 getContentPane().add(textField3);
		 textField3.setFont(new Font("Verdana", Font.PLAIN, 13));
		 textField3.setVisible(false);
		 textField3.setColumns(10);
		 
		 JButton clearBasket = new JButton("Clear Basket");
		 sl_display.putConstraint(SpringLayout.WEST, clearBasket, 272, SpringLayout.WEST, display);
		 sl_display.putConstraint(SpringLayout.EAST, deleteCustomerBtn, -6, SpringLayout.WEST, clearBasket);
		 sl_display.putConstraint(SpringLayout.NORTH, clearBasket, 6, SpringLayout.SOUTH, scrollPane);
		 clearBasket.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		try
	 			{
		 			
	 				Crud clear = new Crud();
	 				clear.adminDelete("delete * from Basket", "*");
			 		String query ="SELECT ProductID, ModelNo as 'Model', Description,QuantityInStock as 'Stock on hand', ProductRetail as 'Price in €' From Product where ProductID > 0";
			 		genTable(query);
			 		clear();
			 		
			 		try 
				 		{
							clear.close();
						} 
				 	catch (SQLException e1) 
				 		{
							
				 		ErrorMessage err = new ErrorMessage("Error Updating Product records. "+e1);
						}
	 			}
	 		catch(Exception e2)
	 			{
	 				ErrorMessage err = new ErrorMessage("Error Updating Product records. "+ e2);
	 			}
		 	}
		 });
		 clearBasket.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 clearBasket.setVisible(false);
		 display.add(clearBasket);
		 
		 //	Delete a product
		 JButton productDelete = new JButton("Product Delete");
		 sl_display.putConstraint(SpringLayout.NORTH, productDelete, 6, SpringLayout.SOUTH, scrollPane);
		 productDelete.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		try
	 			{
	 			
			 		Crud delete=new Crud();
			 		String query ="DELETE from Product  WHERE ProductID=?";
			 		String q2="select * from Product";
			 		String id= textField.getText();
			 		delete.adminDelete(query, id);
			 		clear();
			 		try 
				 		{
							delete.close();
						} 
			 		catch (SQLException e1) 
				 		{
							ErrorMessage err = new ErrorMessage("Error deleting Product record. "+e1);
						}
			 		genTable(q2);
			 		clear();
			 		
	 			}
	 		catch(Exception e2)
	 			{
	 				ErrorMessage err = new ErrorMessage("Error deleting Product record. "+ e2);
	 			}
	 		}
		 });
		 productDelete.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 productDelete.setVisible(false);
		 display.add(productDelete);
		 
		 JLabel test3 = new JLabel("New label");
		 springLayout.putConstraint(SpringLayout.NORTH, test3, 21, SpringLayout.SOUTH, test2);
		 springLayout.putConstraint(SpringLayout.WEST, test3, 24, SpringLayout.WEST, getContentPane());
		 springLayout.putConstraint(SpringLayout.SOUTH, test3, -6, SpringLayout.NORTH, display);
		 springLayout.putConstraint(SpringLayout.EAST, test3, -32, SpringLayout.WEST, textField3);
		 sl_display.putConstraint(SpringLayout.WEST, test3, 0, SpringLayout.WEST, display);
		 sl_display.putConstraint(SpringLayout.SOUTH, test3, -6, SpringLayout.NORTH, display);
		 sl_display.putConstraint(SpringLayout.EAST, test3, 15, SpringLayout.EAST, addToBasket);
		 test3.setVisible(false);
		 getContentPane().add(test3);
		 test3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 
		 JLabel lblNewLabel = new JLabel("");
		 springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -4, SpringLayout.NORTH, display);
		 
		 JButton updateSupplier_1 = new JButton("Update Supplier");
		 sl_display.putConstraint(SpringLayout.NORTH, updateSupplier_1, 6, SpringLayout.SOUTH, scrollPane);
		 updateSupplier_1.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		try
	 			{
		 			
	 				Crud update = new Crud();
			 		update.adminSuppliertUpdateDetails(textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField.getText());
			 		String query ="SELECT * from Supplier";
			 		genTable(query);
			 		clear();
			 		
			 		try 
				 		{
							update.close();
						} 
				 	catch (SQLException e1) 
				 		{
							
				 		ErrorMessage err = new ErrorMessage("Error Updating Supplier records. "+e1);
						}
	 			}
	 		catch(Exception e2)
	 			{
	 				ErrorMessage err = new ErrorMessage("Error Updating Supplier records. "+ e2);
	 			}
		 	}
		 });
		 sl_display.putConstraint(SpringLayout.EAST, productDelete, -6, SpringLayout.WEST, updateSupplier_1);
		 updateSupplier_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 updateSupplier_1.setVisible(false);
		 display.add(updateSupplier_1);
		 
		 JButton deleteSupplier_1 = new JButton("Delete Supplier");
		 deleteSupplier_1.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		try
	 			{
	 			
			 		Crud delete=new Crud();
			 		String query ="DELETE from Supplier  WHERE SupplierID=?";
			 		String q2="select * from Supplier";
			 		String id= textField.getText();
			 		delete.adminDelete(query, id);
			 		clear();
			 		try 
				 		{
							delete.close();
						} 
			 		catch (SQLException e1) 
				 		{
							ErrorMessage err = new ErrorMessage("Error deleting Supplier record. "+e1);
						}
			 		genTable(q2);
			 		clear();
			 		
	 			}
	 		catch(Exception e2)
	 			{
	 				ErrorMessage err = new ErrorMessage("Error deleting Supplier record. "+ e2);
	 			}
		 	}
		 });
		 sl_display.putConstraint(SpringLayout.EAST, updateSupplier_1, -6, SpringLayout.WEST, deleteSupplier_1);
		 sl_display.putConstraint(SpringLayout.NORTH, deleteSupplier_1, 6, SpringLayout.SOUTH, scrollPane);
		 sl_display.putConstraint(SpringLayout.EAST, deleteSupplier_1, 0, SpringLayout.EAST, scrollPane);
		 deleteSupplier_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 deleteSupplier_1.setVisible(false);
		 display.add(deleteSupplier_1);
		 
		 JLabel title = new JLabel("");
		 sl_display.putConstraint(SpringLayout.NORTH, title, 0, SpringLayout.NORTH, display);
		 sl_display.putConstraint(SpringLayout.WEST, title, 225, SpringLayout.WEST, display);
		 sl_display.putConstraint(SpringLayout.SOUTH, title, -6, SpringLayout.NORTH, scrollPane);
		 sl_display.putConstraint(SpringLayout.EAST, title, -190, SpringLayout.EAST, display);
		 title.setHorizontalAlignment(SwingConstants.CENTER);
		 title.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 display.add(title);
		 springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -28, SpringLayout.WEST, test4);
		 
		 //	Company Logo
		 lblNewLabel.setIcon(new ImageIcon(Shop.class.getResource("/Project/logo3a.jpg")));
		 getContentPane().add(lblNewLabel);
		 
		 // the menu bar upon which the menus sit.
		 JMenuBar menuBar = new JMenuBar();
		 menuBar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		 menuBar.setBackground(Color.GRAY);
		 setJMenuBar(menuBar);
		 
		 Component verticalStrut_3 = Box.createVerticalStrut(16);
		 menuBar.add(verticalStrut_3);
		 
		 Component verticalStrut = Box.createVerticalStrut(20);
		 menuBar.add(verticalStrut);
		 
		 JMenu ProductMenu = new JMenu("Shop Menu");
		 ProductMenu.setHorizontalAlignment(SwingConstants.CENTER);
		 menuBar.add(ProductMenu);
		 
		 JMenuItem ViewProducts = new JMenuItem("View Product Catalogue");
		 ViewProducts.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		title.setText("Product Window");
		 		clear();
		 		title.setText("Product Catalogue");
		 		test.setVisible(true);
		 		textField.setVisible(true);
		 		test.setText("Product ID:");
		 		
		 		test1.setVisible(true);
		 		textField1.setVisible(true);
		 		textField1.setEditable(false);
		 		test1.setText(" Model:");
		 		
		 		test2.setVisible(true);
		 		textField2.setVisible(true);
		 		textField2.setEditable(false); 		 		
		 		test2.setText("Description:");
		 		
		 		test3.setVisible(true);
		 		textField3.setVisible(true);
		 		textField3.setEditable(false);
		 		test3.setText("In Stock:");
		 		
		 		test4.setVisible(true);
		 		textField4.setVisible(true);
		 		textField4.setEditable(false);
		 		test4.setText("Unit Price:");
		 		
		 		test5.setVisible(true);
		 		textField5.setVisible(true);
		 		test5.setText("Order Quantity:");
		 		
		 		test6.setVisible(true);
		 		textField6.setVisible(false);
		 		test6.setText("Unit Retail:");
		 		
		 		addToBasket.setVisible(true);
		 		clearBasket.setVisible(true);
		 		updateSupplier_1.setVisible(false);
		 		
		 		deleteCustomerBtn.setVisible(false);
		 		productDelete.setVisible(false);
		 		deleteSupplier_1.setVisible(false);
		 		clear();
		 
		 		
		 		String query ="SELECT ProductID as 'Product ID', ModelNo as 'Model', Description,QuantityInStock as 'Stock on hand', ProductRetail as 'Price in €' From Product where  QuantityInStock >0";
		 		state="SELECT ModelNo, Description,QuantityInStock , ProductRetail  From Product where ProductID=?";
		 		genTable(query);
		 		
		 	}
		 });
		 ProductMenu.add(ViewProducts);
		 
		 JMenuItem updateProducts = new JMenuItem("Update Quantity");
		 updateProducts.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		state= "select SupplierId, ModelNo, Description, QuantityInStock,ProductCost, ProductRetail from Product where ProductID = ? ";
		 		title.setText("Product Window");
		 		test.setVisible(true);
		 		textField.setVisible(true);
		 		test.setText("Product ID:");
		 		
		 		test1.setVisible(true);
		 		textField1.setVisible(true);
		 		test1.setText(" Supplier ID:");
		 		
		 		test2.setVisible(true);
		 		textField2.setVisible(true);
		 		test2.setText("Model No:");
		 		
		 		test3.setVisible(true);
		 		textField3.setVisible(true);
		 		test3.setText("Description:");
		 		
		 		test4.setVisible(true);
		 		textField4.setVisible(true);
		 		test4.setText("Qty In Stock:");
		 		
		 		test5.setVisible(true);
		 		textField5.setVisible(true);
		 		test5.setText("Unit Cost:");
		 		
		 		test6.setVisible(true);
		 		textField6.setVisible(true);
		 		test6.setText("Unit Retail:");
		 		
		 		addToBasket.setVisible(false);
		 		clearBasket.setVisible(true);
		 		updateSupplier_1.setVisible(false);
		 		
		 		deleteCustomerBtn.setVisible(false);
		 		productDelete.setVisible(false);
		 		deleteSupplier_1.setVisible(false);
		 		clear();
		 		
		 	}
		 });
		 ProductMenu.add(updateProducts);
		 
		 JMenuItem deleteProducts = new JMenuItem("Remove From Basket");
		 deleteProducts.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		state= "select SupplierId, ModelNo, Description, QuantityInStock,ProductCost, ProductRetail from Product where ProductID = ?";
		 		title.setText("Product Window");
		 		test.setVisible(true);
		 		textField.setVisible(true);
		 		test.setText("Product ID:");
		 		
		 		test1.setVisible(true);
		 		textField1.setVisible(true);
		 		test1.setText(" Supplier ID:");
		 		
		 		test2.setVisible(true);
		 		textField2.setVisible(true);
		 		test2.setText("Model No:");
		 		
		 		test3.setVisible(true);
		 		textField3.setVisible(true);
		 		test3.setText("Description:");
		 		
		 		test4.setVisible(true);
		 		textField4.setVisible(true);
		 		test4.setText("Qty In Stock:");
		 		
		 		test5.setVisible(true);
		 		textField5.setVisible(true);
		 		test5.setText("Unit Cost:");
		 		
		 		test6.setVisible(true);
		 		textField6.setVisible(true);
		 		test6.setText("Unit Retail:");
		 		
		 		addToBasket.setVisible(false);
		 		clearBasket.setVisible(false);
		 		updateSupplier_1.setVisible(false);
		 		
		 		deleteCustomerBtn.setVisible(false);
		 		productDelete.setVisible(true);
		 		deleteSupplier_1.setVisible(false);
		 		clear();
		 	}
		 });
		 ProductMenu.add(deleteProducts);
		 
		 Component verticalStrut_1 = Box.createVerticalStrut(20);
		 menuBar.add(verticalStrut_1);
		 
		 Component verticalStrut_2 = Box.createVerticalStrut(20);
		 menuBar.add(verticalStrut_2);
		
	}
 	public void genTable(String statement)
 	{
 		
	 		Config t = new Config();
			// database URL
			final String DATABASE_URL = "jdbc:mysql://localhost:64000/CA3";
			Connection con = null ;
			PreparedStatement pstat=null;
			
	 		try 
		 		{
		 			con= DriverManager.getConnection(DATABASE_URL, t.getUsername(), t.getPassword()); 
					pstat = con.prepareStatement(statement);
					ResultSet result = pstat.executeQuery();
					ResultSetMetaData metaData = result.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					
					int columns =metaData.getColumnCount();
					String[] headings= new String[columns];
					
					for(int i=0;i< columns;i++)
						{
							headings[i] = metaData.getColumnName(i+1);
						}
					model.setColumnIdentifiers(headings);
					
					String id,name,address,email,phone,password,retail;
					while(result.next())
						{
							
									id= result.getString(1);
									name=result.getString(2);
									address=result.getString(3);
									email=result.getString(4);
									phone=result.getString(5);
									
									
									
							if(columns==6)
								{
									password=result.getString(6);
									String[] row = {id,name,address,email,phone,password};
									model.addRow(row);
								}						
							else if(columns==7)
								{	
									password=result.getString(6);
									retail=result.getString(7);
									String[] row = {id,name,address,email,phone,password,retail};
									model.addRow(row);	
								}
							else						
								{
									String[] row = {id,name,address,email,phone};
									model.addRow(row);	
								
								}
						}
					
						
						result.close();
					
				} 
	 		catch (SQLException e1) 
	 			{
					// TODO Auto-generated catch block
					e1.printStackTrace();
	 			}
	 		finally
	 			{
	 				try
	 					{
							con.close();
							pstat.close();
	 					} 
	 				catch (SQLException e1) 
		 				{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	 				
	 				
	 			}
 	}
 	
 	public void getResults(String text)
 	{
	 		Config t = new Config();
			// database URL
			final String DATABASE_URL = "jdbc:mysql://localhost:64000/CA3";
			Connection connection = null ;
			PreparedStatement pstat = null ;
			String result="";
			ResultSet resultSet = null ;
			
			
			try
				{	connection= DriverManager.getConnection(DATABASE_URL, t.getUsername(), t.getPassword()); 
					// The prepared SQL statement to confirm that account details exist for the user attempting to login.
					pstat = connection.prepareStatement(state);
					pstat.setString(1, text);
					// query data in the table
					resultSet = pstat.executeQuery();
					// process query results
					ResultSetMetaData metaData = resultSet.getMetaData();
					int columns = metaData.getColumnCount();
					
					
					while( resultSet .next() )
						{
							
							textField1.setText(resultSet.getString(1));
							textField2.setText(resultSet.getString(2));
							textField3.setText(resultSet.getString(3));
							textField4.setText(resultSet.getString(4));
							
							if(columns==5)
								{
									textField5.setText(resultSet.getString(5));
								
								}
							
						}
					
					
				}
			catch(SQLException error) 
				{
					//sqlException . printStackTrace () ;
					ErrorMessage err = new ErrorMessage("Error retrieving Customer Details from the Database"+ error);
				}
			finally 
				{
					try
						{
							resultSet . close () ;
							pstat . close () ;
							connection. close () ;
						}
					catch (Exception ex)
						{
							//exception . printStackTrace () ;
							ErrorMessage err = new ErrorMessage("The database is unavailable "+ ex);
						}
				}		
 	}
 	public void clear()	//	clears all the text fields when called. 
	{
		textField.setText("");textField1.setText("");	textField2.setText("");	textField3.setText("");	textField4.setText("");textField5.setText("");textField6.setText("");
	}
 	public void hide() // resets all text fields to hidden.
 	{
 		textField.setVisible(false);textField1.setVisible(false);textField2.setVisible(false);textField3.setVisible(false);
 		textField4.setVisible(false);textField5.setVisible(false);textField6.setVisible(false);
 		
 	}
}// End of file.
