package Project;

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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.ScrollPane;


public class Admin extends JFrame  
{
	private JTable table;
	private JScrollBar scrollBar;
	private JButton btnNewButton;
 	public Admin()
	{	
		
		super("Administrator");
		getContentPane().setBackground(Color.GRAY);
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
	
 
		 JPanel display = new JPanel();
		 springLayout.putConstraint(SpringLayout.NORTH, display, 30, SpringLayout.NORTH, getContentPane());
		 springLayout.putConstraint(SpringLayout.WEST, display, 20, SpringLayout.WEST, getContentPane());
		 springLayout.putConstraint(SpringLayout.SOUTH, display, -10, SpringLayout.SOUTH, getContentPane());
		 springLayout.putConstraint(SpringLayout.EAST, display, -20, SpringLayout.EAST, getContentPane());
		 display.setBackground(Color.GRAY);
		 display.setVisible(true); 
		
		 getContentPane().add(display);
		 SpringLayout sl_display = new SpringLayout();
		 display.setLayout(sl_display);
		 
		 table = new JTable();
		 sl_display.putConstraint(SpringLayout.NORTH, table, 61, SpringLayout.NORTH, display);
		 sl_display.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, display);
		 sl_display.putConstraint(SpringLayout.SOUTH, table, -10, SpringLayout.SOUTH, display);
		 sl_display.putConstraint(SpringLayout.EAST, table, 0, SpringLayout.EAST, display);
		
		 JScrollPane scrollPane = new JScrollPane(table);
		 sl_display.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, display);
		 sl_display.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, display);
		 display.add(scrollPane);
		 
		 scrollBar = new JScrollBar();
		 sl_display.putConstraint(SpringLayout.WEST, scrollBar, 0, SpringLayout.WEST, display);
		 sl_display.putConstraint(SpringLayout.NORTH, scrollBar, -1, SpringLayout.NORTH, display);
		 sl_display.putConstraint(SpringLayout.SOUTH, scrollBar, -10, SpringLayout.SOUTH, display);
		 table.add(scrollBar);
		 
		 btnNewButton = new JButton("View Customers");
		 sl_display.putConstraint(SpringLayout.NORTH, scrollPane, 23, SpringLayout.SOUTH, btnNewButton);
		 sl_display.putConstraint(SpringLayout.SOUTH, scrollPane, 462, SpringLayout.SOUTH, btnNewButton);
		 sl_display.putConstraint(SpringLayout.NORTH, btnNewButton, 10, SpringLayout.NORTH, display);
		 sl_display.putConstraint(SpringLayout.WEST, btnNewButton, 30, SpringLayout.WEST, display);
		 display.add(btnNewButton);
		 btnNewButton.addActionListener(new ActionListener() 
		 {
			 public void actionPerformed(ActionEvent e) 
			 {
		 		Config t = new Config();
				// database URL
				final String DATABASE_URL = "jdbc:mysql://localhost:64000/CA3";
				Connection con = null ;
				PreparedStatement pstat=null;
				
		 		try 
			 		{
			 			con= DriverManager.getConnection(DATABASE_URL, t.getUsername(), t.getPassword()); 
						pstat = con.prepareStatement("SELECT * FROM Customer");
						ResultSet result = pstat.executeQuery();
						ResultSetMetaData metaData = result.getMetaData();
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						
						
						int columns =metaData.getColumnCount();
						String[] headings= new String[columns];
						
						for(int i=0;i< columns;i++)
							{
								headings[i] = metaData.getColumnName(i+1);
							}
						model.setColumnIdentifiers(headings);
						
						String id,name,address,email,phone,password;
						while(result.next())
							{
								id= result.getString(1);
								name=result.getString(2);
								address=result.getString(3);
								email=result.getString(4);
								phone=result.getString(5);
								password=result.getString(6);
								
								
								String[] row = {id,name,address,email,phone,password};
								model.addRow(row);
								
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
		 });
		 btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
	}
}
