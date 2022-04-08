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
	private JTextField idTxtField;
	private JTextField modelTxtField;
	private JTextField descTxtField;
	private JTextField inStockTxtField;
	private JTextField priceTxtField;
	private JTextField orderQtyTxtField;
	private String state;
 	public Shop(String email, String account)
	{	
		
		super("Shop");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Shop.class.getResource("/Project/logo3b.jpg")));
		getContentPane().setBackground(Color.GRAY);
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
	
		//	jpanel containing JTable and Jbuttons
		 JPanel display = new JPanel();
		 springLayout.putConstraint(SpringLayout.WEST, display, 10, SpringLayout.WEST, getContentPane());
		 springLayout.putConstraint(SpringLayout.SOUTH, display, -10, SpringLayout.SOUTH, getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, display, -10, SpringLayout.EAST, getContentPane());
		 display.setBackground(Color.GRAY);
		 display.setVisible(true); 
		
		 getContentPane().add(display);	//	adds the panel to the content pane
		 SpringLayout sl_display = new SpringLayout();
		 display.setLayout(sl_display);	//	set the layout of the panel
		 
		 table = new JTable();		//	creates a new Jtable
		 table.setColumnSelectionAllowed(true);
		 table.setCellSelectionEnabled(true);
		 table.setToolTipText("Enter the product ID in the field labelled ID");
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
		 
		 JLabel idLabel = new JLabel("ID:");
		 springLayout.putConstraint(SpringLayout.WEST, idLabel, 20, SpringLayout.WEST, getContentPane());
		 idLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 getContentPane().add(idLabel);
		 
		 idTxtField = new JTextField();
		 springLayout.putConstraint(SpringLayout.WEST, idTxtField, 131, SpringLayout.WEST, getContentPane());
		 springLayout.putConstraint(SpringLayout.NORTH, idLabel, 5, SpringLayout.NORTH, idTxtField);
		 springLayout.putConstraint(SpringLayout.EAST, idLabel, -32, SpringLayout.WEST, idTxtField);
		 idTxtField.setFont(new Font("Verdana", Font.PLAIN, 13));
		
		 idTxtField.addActionListener(new ActionListener()
		 {
			 private final static String newline="\n";		//	generates an action when the return key is pressed
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		String text = idTxtField.getText();
		 		idTxtField.selectAll();
		 		getResults(text);		//	Fills the other fields the details gathered from the ID field. 	 		
		 	}
		 });
		 getContentPane().add(idTxtField);
		 idTxtField.setColumns(10);
		 
		 JLabel modelLanel = new JLabel("Model:");
		 springLayout.putConstraint(SpringLayout.WEST, modelLanel, 20, SpringLayout.WEST, getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, modelLanel, 0, SpringLayout.EAST, idLabel);
		 modelLanel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 getContentPane().add(modelLanel);
		 
		 modelTxtField = new JTextField();
		 springLayout.putConstraint(SpringLayout.WEST, modelTxtField, 32, SpringLayout.EAST, modelLanel);
		 springLayout.putConstraint(SpringLayout.NORTH, modelLanel, 5, SpringLayout.NORTH, modelTxtField);
		 springLayout.putConstraint(SpringLayout.SOUTH, idTxtField, -30, SpringLayout.NORTH, modelTxtField);
		 modelTxtField.setFont(new Font("Verdana", Font.PLAIN, 13));
		 modelTxtField.setColumns(10);
		 getContentPane().add(modelTxtField);
		 
		 JLabel descLabel = new JLabel("Description");
		 springLayout.putConstraint(SpringLayout.WEST, descLabel, 20, SpringLayout.WEST, getContentPane());
		 springLayout.putConstraint(SpringLayout.SOUTH, descLabel, -6, SpringLayout.NORTH, display);
		 descLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 getContentPane().add(descLabel);
		 
		 descTxtField = new JTextField();
		 springLayout.putConstraint(SpringLayout.EAST, descLabel, -6, SpringLayout.WEST, descTxtField);
		 springLayout.putConstraint(SpringLayout.WEST, descTxtField, 0, SpringLayout.WEST, idTxtField);
		 springLayout.putConstraint(SpringLayout.SOUTH, descTxtField, -6, SpringLayout.NORTH, display);
		 springLayout.putConstraint(SpringLayout.EAST, descTxtField, 0, SpringLayout.EAST, idTxtField);
		 descTxtField.setFont(new Font("Verdana", Font.PLAIN, 13));
		 descTxtField.setColumns(10);
		 getContentPane().add(descTxtField);
		 
		 JLabel priceLabel = new JLabel("Unit Price:");
		 springLayout.putConstraint(SpringLayout.NORTH, modelTxtField, -5, SpringLayout.NORTH, priceLabel);
		 springLayout.putConstraint(SpringLayout.EAST, priceLabel, -169, SpringLayout.EAST, getContentPane());
		 priceLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 getContentPane().add(priceLabel);
		 
		 priceTxtField = new JTextField();
		 springLayout.putConstraint(SpringLayout.NORTH, priceTxtField, -5, SpringLayout.NORTH, priceLabel);
		 springLayout.putConstraint(SpringLayout.WEST, priceTxtField, 6, SpringLayout.EAST, priceLabel);
		 springLayout.putConstraint(SpringLayout.EAST, priceTxtField, -20, SpringLayout.EAST, getContentPane());
		 priceTxtField.setFont(new Font("Verdana", Font.PLAIN, 13));
		 priceTxtField.setColumns(10);
		 getContentPane().add(priceTxtField);
		 
		 JLabel orderQtyLabel = new JLabel("Order Qty:");
		 springLayout.putConstraint(SpringLayout.SOUTH, priceLabel, -43, SpringLayout.NORTH, orderQtyLabel);
		 springLayout.putConstraint(SpringLayout.WEST, orderQtyLabel, 538, SpringLayout.WEST, getContentPane());
		 springLayout.putConstraint(SpringLayout.WEST, priceLabel, 0, SpringLayout.WEST, orderQtyLabel);
		 orderQtyLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 getContentPane().add(orderQtyLabel);
		 
		 orderQtyTxtField = new JTextField();
		 springLayout.putConstraint(SpringLayout.WEST, orderQtyTxtField, 623, SpringLayout.WEST, getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, orderQtyLabel, -6, SpringLayout.WEST, orderQtyTxtField);
		 springLayout.putConstraint(SpringLayout.EAST, orderQtyTxtField, -24, SpringLayout.EAST, getContentPane());
		 springLayout.putConstraint(SpringLayout.NORTH, orderQtyLabel, 5, SpringLayout.NORTH, orderQtyTxtField);
		 springLayout.putConstraint(SpringLayout.SOUTH, orderQtyTxtField, -6, SpringLayout.NORTH, display);
		 orderQtyTxtField.setFont(new Font("Verdana", Font.PLAIN, 13));
		 
		 JButton addToBasket = new JButton("Add to Basket");
		 sl_display.putConstraint(SpringLayout.WEST, addToBasket, 63, SpringLayout.WEST, display);
		 sl_display.putConstraint(SpringLayout.EAST, addToBasket, -588, SpringLayout.EAST, display);
		 addToBasket.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e)
		 	{
		 		
		 		try
		 			{	 					 		
			 				int prodID= Integer.parseInt(idTxtField.getText());
			 				int stock = Integer.parseInt(inStockTxtField.getText());
			 				int ordered= Integer.parseInt(orderQtyTxtField.getText());
			 				Crud add = new Crud();
			 				if((stock >=ordered))
				 				{
			 						add.insertBasket(prodID, ordered);
				 				
							 		//String query ="SELECT ProductID as 'Stock Code', ModelNo as 'Model', Description,QuantityInStock as 'Stock on hand', ProductRetail as 'Price in €' From Product where QuantityInStock >0";
			 						
			 						String query ="SELECT Product.ProductID as 'Product ID', ModelNo as 'Model', Description, Basket.Quantity as 'Quantity ordered', ProductRetail as 'Price in €' From Product inner join Basket on Product.productID= Basket.ProductID";
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
			 						orderQtyTxtField.setText("");
			 					}
		 			}
		 		catch(NumberFormatException nfe)
		 			{
		 				ErrorMessage err = new ErrorMessage("the value entered Must be a whole number ");
		 				orderQtyTxtField.setText("");
		 			}
		 		
		 		catch(Exception e2)
		 			{
		 				ErrorMessage err = new ErrorMessage("Error Updating Customer records. "+ e2);
		 			}	
		 		
		 	}
		 });
		 addToBasket.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 display.add(addToBasket);
		 
		 orderQtyTxtField.setColumns(10);
		 getContentPane().add(orderQtyTxtField);
		 
		 inStockTxtField = new JTextField();
		 springLayout.putConstraint(SpringLayout.NORTH, inStockTxtField, -5, SpringLayout.NORTH, idLabel);
		 springLayout.putConstraint(SpringLayout.EAST, inStockTxtField, 0, SpringLayout.EAST, priceTxtField);
		 getContentPane().add(inStockTxtField);
		 inStockTxtField.setFont(new Font("Verdana", Font.PLAIN, 13));
	
		 inStockTxtField.setColumns(10);
		 
		 JButton clearBasket = new JButton("Clear Basket");
		 sl_display.putConstraint(SpringLayout.NORTH, addToBasket, 0, SpringLayout.NORTH, clearBasket);
		 sl_display.putConstraint(SpringLayout.NORTH, clearBasket, 6, SpringLayout.SOUTH, scrollPane);
		 clearBasket.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		try
	 			{
		 			
	 				Crud clear = new Crud();
	 				clear.clearBasket();	//	calls the Crud class method to clear the basket 
			 		String query ="SELECT ProductID, ModelNo as 'Model', Description,QuantityInStock as 'Stock on hand', ProductRetail as 'Price in €' From Product where QuantityInStock > 0";
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
		 display.add(clearBasket);
		 
		 JLabel inStockLabel = new JLabel("In Stock:");
		 springLayout.putConstraint(SpringLayout.NORTH, inStockLabel, -3, SpringLayout.NORTH, idLabel);
		 springLayout.putConstraint(SpringLayout.WEST, inStockLabel, 0, SpringLayout.WEST, priceLabel);
		 springLayout.putConstraint(SpringLayout.SOUTH, inStockLabel, -116, SpringLayout.NORTH, display);
		 sl_display.putConstraint(SpringLayout.WEST, inStockLabel, 0, SpringLayout.WEST, display);
		 sl_display.putConstraint(SpringLayout.SOUTH, inStockLabel, -6, SpringLayout.NORTH, display);
		 sl_display.putConstraint(SpringLayout.EAST, inStockLabel, 15, SpringLayout.EAST, addToBasket);
		 getContentPane().add(inStockLabel);
		 inStockLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 
		 JLabel logoLabel = new JLabel("");
		 springLayout.putConstraint(SpringLayout.EAST, modelTxtField, -41, SpringLayout.WEST, logoLabel);
		 springLayout.putConstraint(SpringLayout.EAST, inStockLabel, 302, SpringLayout.WEST, logoLabel);
		 springLayout.putConstraint(SpringLayout.WEST, inStockTxtField, 117, SpringLayout.EAST, logoLabel);
		 springLayout.putConstraint(SpringLayout.EAST, logoLabel, -276, SpringLayout.EAST, getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, idTxtField, -41, SpringLayout.WEST, logoLabel);
		 springLayout.putConstraint(SpringLayout.SOUTH, logoLabel, -383, SpringLayout.SOUTH, getContentPane());
		 springLayout.putConstraint(SpringLayout.NORTH, display, 4, SpringLayout.SOUTH, logoLabel);
		 
		 JLabel title = new JLabel("");
		 sl_display.putConstraint(SpringLayout.NORTH, title, 0, SpringLayout.NORTH, display);
		 sl_display.putConstraint(SpringLayout.WEST, title, 225, SpringLayout.WEST, display);
		 sl_display.putConstraint(SpringLayout.SOUTH, title, -6, SpringLayout.NORTH, scrollPane);
		 sl_display.putConstraint(SpringLayout.EAST, title, -190, SpringLayout.EAST, display);
		 title.setHorizontalAlignment(SwingConstants.CENTER);
		 title.setFont(new Font("Times New Roman", Font.BOLD, 18));
		 display.add(title);
		 
		 JButton btnNewButton = new JButton("Customer Window");
		 sl_display.putConstraint(SpringLayout.WEST, btnNewButton, 563, SpringLayout.WEST, display);
		 sl_display.putConstraint(SpringLayout.EAST, btnNewButton, -37, SpringLayout.EAST, display);
		 sl_display.putConstraint(SpringLayout.EAST, clearBasket, -52, SpringLayout.WEST, btnNewButton);
		 sl_display.putConstraint(SpringLayout.NORTH, btnNewButton, 6, SpringLayout.SOUTH, scrollPane);
		 sl_display.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, display);
		 btnNewButton.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		Customer customer = new Customer(email);
				customer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				customer.setSize(800,600);
				customer.setLocation(300,100);
				customer.setVisible(true);
				customer.setResizable(false);
				dispose();
		 	}
		 });
		 btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 display.add(btnNewButton);
		 
		 JButton btnNewButton_1 = new JButton("Checkout");
		 btnNewButton_1.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		int qty=0;
		 		int prodId=0;
		 		int instock=0;
		 		Config t = new Config();
		 		final String DATABASE_URL = "jdbc:mysql://localhost:64000/CA3";
				Connection con = null ;
		 		PreparedStatement pstat=null;
		 		ResultSet rs=null;
		 		ResultSet rs1=null;
			 	try
			 		{
			 		
			 		int id= Integer.parseInt(account);
			 		int invoiceNo=0;
			 		Crud checkout =new Crud();
			 		checkout.insertInvoice(id);
			 		invoiceNo=checkout.invoiceRetrive(id);
			 		
			 		try {
						checkout.close();
					} catch (SQLException  e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			 		
			 		
			 		con= DriverManager.getConnection(DATABASE_URL, t.getUsername(), t.getPassword());
					pstat = con.prepareStatement("select ProductID, Quantity from Basket");
					rs=pstat.executeQuery();
					while(rs.next())
					{
						prodId=rs.getInt(1);
						qty=rs.getInt(2);
						
						pstat=con.prepareStatement("select QuantityInStock from Product where ProductID=?");
						pstat.setInt(1,prodId);
						rs1=pstat.executeQuery();
							while(rs1.next())
							{
								instock=rs1.getInt(1);
							}
						
							instock= instock-qty;
							
						pstat=con.prepareStatement("Update Product set QuantityInStock=? where ProductID=?");
						pstat.setInt(1,instock);
						pstat.setInt(2, prodId);
						pstat.executeUpdate();
						
						pstat = con.prepareStatement("Insert into InvoiceProduct (InvoiceId, ProductId,Qty) values (?,?,?)");
						pstat.setInt (1, invoiceNo);
						pstat.setInt (2, prodId ) ;
						pstat.setInt(3, qty);
						pstat.executeUpdate();
						pstat= con.prepareStatement("delete  from Basket");
						pstat.executeUpdate();
						
					}
					
						Info info = new Info("Checkout Sucsessful");
						
						
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
			 		}
			 		catch(SQLException sql)
			 		{
			 			ErrorMessage err = new ErrorMessage("Database connection Error "+ sql);
			 		}
			 		
			 	}
			 	String query ="SELECT ProductID as 'Product ID', ModelNo as 'Model', Description,QuantityInStock as 'Stock on hand', ProductRetail as 'Price in €' From Product where  QuantityInStock >0";	
		 		genTable(query);
		 	}
		 });
		 sl_display.putConstraint(SpringLayout.NORTH, btnNewButton_1, 6, SpringLayout.SOUTH, scrollPane);
		 sl_display.putConstraint(SpringLayout.WEST, btnNewButton_1, 75, SpringLayout.EAST, addToBasket);
		 sl_display.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, display);
		 sl_display.putConstraint(SpringLayout.EAST, btnNewButton_1, -40, SpringLayout.WEST, clearBasket);
		 btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		 display.add(btnNewButton_1);
		 
		 //	Company Logo
		 logoLabel.setIcon(new ImageIcon(Shop.class.getResource("/Project/logo3a.jpg")));
		 getContentPane().add(logoLabel);
		 
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
		 		
		 		clear();
		 		title.setText("Product Catalogue");	 		
		 			 		
		 		
		 		clear();
		 
		 		
		 		String query ="SELECT ProductID as 'Product ID', ModelNo as 'Model', Description,QuantityInStock as 'Stock on hand', ProductRetail as 'Price in €' From Product where  QuantityInStock >0";
		 		state="SELECT ModelNo, Description,QuantityInStock , ProductRetail  From Product where ProductID=?";
		 		genTable(query);
		 		
		 	}
		 });
		 ProductMenu.add(ViewProducts);
		 
		 JMenuItem updateOrder = new JMenuItem("Update Order Quantity");
		 updateOrder.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		try
	 			{	 					 		
		 				int prodID= Integer.parseInt(idTxtField.getText());
		 				int stock = Integer.parseInt(inStockTxtField.getText());
		 				int ordered= Integer.parseInt(orderQtyTxtField.getText());
		 				Crud update = new Crud();
		 				if((stock >=ordered))
			 				{
		 						update.updatetBasket(prodID, ordered);
			 				
						 		//String query ="SELECT ProductID as 'Stock Code', ModelNo as 'Model', Description,QuantityInStock as 'Stock on hand', ProductRetail as 'Price in €' From Product where QuantityInStock >0";
		 						String query ="SELECT Product.ProductID as 'Product ID', ModelNo as 'Model', Description, Basket.Quantity as 'Quantity ordered', ProductRetail as 'Price in €' From Product inner join Basket on Product.productID= Basket.ProductID";
		 						genTable(query);
						 		clear();
						 		
						 		try 
							 		{
										update.close();
									} 
							 	catch (SQLException e1) 
							 		{
										
							 		ErrorMessage err = new ErrorMessage("Error Updating Customer records. "+e1);
									}
			 				}
		 				else
		 					{
		 						Info info= new Info("the quantity ordered exceeds the stock available");
		 						orderQtyTxtField.setText("");
		 					}
	 			}
	 		catch(NumberFormatException nfe)
	 			{
	 				ErrorMessage err = new ErrorMessage("the value entered Must be a whole number ");
	 				orderQtyTxtField.setText("");
	 			}
	 		
	 		catch(Exception e2)
	 			{
	 				ErrorMessage err = new ErrorMessage("Error Updating Customer records. "+ e2);
	 			}	
	 		
	 	
		 		
		 		state= "select  ModelNo, Description, QuantityInStock, ProductRetail from Product where ProductID = ? and QuantityInStock > 0";
		 		clear();
		 		
		 	}
		 });
		 
		 JMenuItem mntmNewMenuItem = new JMenuItem("View Basket");
		 mntmNewMenuItem.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		title.setText("Basket");
		 		String query ="SELECT Product.ProductID as 'Product ID', ModelNo as 'Model', Description, Basket.Quantity as 'Quantity ordered', ProductRetail as 'Price in €' From Product inner join Basket on Product.productID= Basket.ProductID";
		 		state="SELECT ModelNo, Description,QuantityInStock , ProductRetail  From Product where ProductID=?";
		 		genTable(query);
		 	}
		 });
		 ProductMenu.add(mntmNewMenuItem);
		 ProductMenu.add(updateOrder);
		 
		 JMenuItem deleteProducts = new JMenuItem("Remove From Basket");
		 deleteProducts.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent e) 
		 	{
		 		try 
		 			{
		 				Crud basDel = new Crud();
						int id =Integer.parseInt(idTxtField.getText());
						basDel.basketDelete(id);
						state= "select  ModelNo, Description, QuantityInStock, ProductRetail from Product where ProductID = ?";					
						clear();
		 			}	
		 		catch (NumberFormatException e1) 
		 		{
					// TODO Auto-generated catch block
					ErrorMessage err = new ErrorMessage("The ID must be a whole number");
				}
		 		
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
							
							modelTxtField.setText(resultSet.getString(1));
							descTxtField.setText(resultSet.getString(2));
							inStockTxtField.setText(resultSet.getString(3));
							priceTxtField.setText(resultSet.getString(4));
							
							if(columns==5)
								{
									orderQtyTxtField.setText(resultSet.getString(5));
								
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
		idTxtField.setText("");modelTxtField.setText("");	descTxtField.setText("");	inStockTxtField.setText("");	priceTxtField.setText("");orderQtyTxtField.setText("");
	}
}// End of file.
