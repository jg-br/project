package Project;
/* Student Name: John Brennan 
 * Student ID:c00114371
 * Date: */
import javax.swing.Icon;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Customer extends JFrame
{
	private JTable orderHistory;
	private JTextField phoneNoField;
	private JTextField emailField;
	private JTextField accountNumber;
	private String details;
	private String name;
	private String address;
	private String account;
	private String phone;
	private int split=0;
	private String[] arr = new String[4];
	private JTextField nameField;
	public Customer(String email) 
	{
			Crud c = new Crud();
			
			details = c.customerDetails(email);
			
			for(int i=0;i<arr.length;i++)
				{
					split = details.indexOf(",");
					arr[i]=details.substring(0,split);
					details=details.substring(split+1);
				}
			account=arr[0]; 
			name=arr[1];
			address=arr[2];
			phone=arr[3];
		

		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Customer.class.getResource("/Project/logo3b.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.GRAY);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JPanel orderPanel = new JPanel();
		orderPanel.setBackground(Color.GRAY);
		springLayout.putConstraint(SpringLayout.NORTH, orderPanel, 142, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, orderPanel, 22, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, orderPanel, -73, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, orderPanel, -23, SpringLayout.EAST, getContentPane());
		getContentPane().add(orderPanel);
		orderPanel.setLayout(new BorderLayout(0, 0));
		
		// Table to display the order history
		orderHistory = new JTable();
		orderHistory.setFont(new Font("Verdana", Font.PLAIN, 13));
		orderPanel.add(orderHistory, BorderLayout.CENTER);
		
		JLabel orderHistoryLabel = new JLabel("Order History");
		orderHistoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderHistoryLabel.setLabelFor(orderHistory);
		orderHistoryLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		orderPanel.add(orderHistoryLabel, BorderLayout.NORTH);
		
		// Panel for customer details
		JPanel customerPanel = new JPanel();
		customerPanel.setBackground(Color.GRAY);
		springLayout.putConstraint(SpringLayout.NORTH, customerPanel, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, customerPanel, 22, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, customerPanel, -6, SpringLayout.NORTH, orderPanel);
		springLayout.putConstraint(SpringLayout.EAST, customerPanel, 763, SpringLayout.WEST, getContentPane());
		getContentPane().add(customerPanel);
		SpringLayout sl_customerPanel = new SpringLayout();
		customerPanel.setLayout(sl_customerPanel);
		
		//	Text area to display customers address
		JTextArea addressDetails = new JTextArea();
		sl_customerPanel.putConstraint(SpringLayout.SOUTH, addressDetails, 0, SpringLayout.SOUTH, customerPanel);
		addressDetails.setFont(new Font("Verdana", Font.PLAIN, 13));
		addressDetails.setText(address);
		addressDetails.setEditable(false);
		addressDetails.setLineWrap(true);
		addressDetails.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
		customerPanel.add(addressDetails);
		
		// Labels for the customers name and address
		JLabel nameLabel = new JLabel("Name:");
		sl_customerPanel.putConstraint(SpringLayout.NORTH, nameLabel, 4, SpringLayout.NORTH, customerPanel);
		sl_customerPanel.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, customerPanel);
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		customerPanel.add(nameLabel);
		
		JLabel AddressLabel = new JLabel("Address:");
		sl_customerPanel.putConstraint(SpringLayout.NORTH, addressDetails, 10, SpringLayout.NORTH, AddressLabel);
		sl_customerPanel.putConstraint(SpringLayout.WEST, addressDetails, 6, SpringLayout.EAST, AddressLabel);
		sl_customerPanel.putConstraint(SpringLayout.NORTH, AddressLabel, 6, SpringLayout.SOUTH, nameLabel);
		sl_customerPanel.putConstraint(SpringLayout.EAST, nameLabel, 0, SpringLayout.EAST, AddressLabel);
		sl_customerPanel.putConstraint(SpringLayout.WEST, AddressLabel, 10, SpringLayout.WEST, customerPanel);
		sl_customerPanel.putConstraint(SpringLayout.EAST, AddressLabel, -653, SpringLayout.EAST, customerPanel);
		AddressLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		customerPanel.add(AddressLabel);
		
		// Label to display the company logo.
		JLabel icanLabel = new JLabel("");
		sl_customerPanel.putConstraint(SpringLayout.NORTH, icanLabel, 0, SpringLayout.NORTH, customerPanel);
		sl_customerPanel.putConstraint(SpringLayout.WEST, icanLabel, 283, SpringLayout.WEST, customerPanel);
		sl_customerPanel.putConstraint(SpringLayout.SOUTH, icanLabel, 0, SpringLayout.SOUTH, customerPanel);
		sl_customerPanel.putConstraint(SpringLayout.EAST, icanLabel, -265, SpringLayout.EAST, customerPanel);
		icanLabel.setIcon(new ImageIcon(Customer.class.getResource("/Project/logo3a.jpg")));
		customerPanel.add(icanLabel);
		
		//	Text fields for the phone and email address.
		phoneNoField = new JTextField();
		sl_customerPanel.putConstraint(SpringLayout.EAST, phoneNoField, -2, SpringLayout.EAST, customerPanel);
		phoneNoField.setFont(new Font("Verdana", Font.PLAIN, 13));
		phoneNoField.setEditable(false);
		phoneNoField.setText(phone);
		customerPanel.add(phoneNoField);
		phoneNoField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setToolTipText("Email adresses must be updated by our staff");
		sl_customerPanel.putConstraint(SpringLayout.SOUTH, phoneNoField, -18, SpringLayout.NORTH, emailField);
		sl_customerPanel.putConstraint(SpringLayout.SOUTH, emailField, -10, SpringLayout.SOUTH, customerPanel);
		sl_customerPanel.putConstraint(SpringLayout.EAST, emailField, 0, SpringLayout.EAST, phoneNoField);
		emailField.setText(email);
		emailField.setFont(new Font("Verdana", Font.PLAIN, 13));
		emailField.setColumns(10);
		customerPanel.add(emailField);
		
		JLabel phoneNoLabel = new JLabel("Phone No:");
		sl_customerPanel.putConstraint(SpringLayout.EAST, phoneNoLabel, -158, SpringLayout.EAST, customerPanel);
		sl_customerPanel.putConstraint(SpringLayout.WEST, phoneNoField, 10, SpringLayout.EAST, phoneNoLabel);
		sl_customerPanel.putConstraint(SpringLayout.NORTH, phoneNoLabel, 5, SpringLayout.NORTH, phoneNoField);
		sl_customerPanel.putConstraint(SpringLayout.WEST, phoneNoLabel, 6, SpringLayout.EAST, icanLabel);
		phoneNoLabel.setLabelFor(phoneNoField);
		phoneNoLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		phoneNoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		customerPanel.add(phoneNoLabel);
		
		JLabel lblEmail = new JLabel("E-mail:");
		sl_customerPanel.putConstraint(SpringLayout.WEST, emailField, 6, SpringLayout.EAST, lblEmail);
		sl_customerPanel.putConstraint(SpringLayout.NORTH, lblEmail, 93, SpringLayout.NORTH, customerPanel);
		sl_customerPanel.putConstraint(SpringLayout.SOUTH, lblEmail, -10, SpringLayout.SOUTH, customerPanel);
		sl_customerPanel.putConstraint(SpringLayout.EAST, lblEmail, -154, SpringLayout.EAST, customerPanel);
		sl_customerPanel.putConstraint(SpringLayout.WEST, lblEmail, 10, SpringLayout.EAST, icanLabel);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 13));
		customerPanel.add(lblEmail);
		
		accountNumber = new JTextField();
		sl_customerPanel.putConstraint(SpringLayout.NORTH, accountNumber, 4, SpringLayout.NORTH, customerPanel);
		sl_customerPanel.putConstraint(SpringLayout.WEST, accountNumber, 0, SpringLayout.WEST, phoneNoField);
		sl_customerPanel.putConstraint(SpringLayout.EAST, accountNumber, 2, SpringLayout.EAST, customerPanel);
		accountNumber.setEditable(false);
		accountNumber.setText(account);
		accountNumber.setFont(new Font("Verdana", Font.PLAIN, 13));
		accountNumber.setColumns(10);
		customerPanel.add(accountNumber);
		
		JLabel phoneNoLabel_1 = new JLabel("Customer Account");
		sl_customerPanel.putConstraint(SpringLayout.SOUTH, phoneNoLabel_1, 0, SpringLayout.SOUTH, accountNumber);
		sl_customerPanel.putConstraint(SpringLayout.EAST, phoneNoLabel_1, 0, SpringLayout.EAST, phoneNoLabel);
		phoneNoLabel_1.setLabelFor(accountNumber);
		sl_customerPanel.putConstraint(SpringLayout.NORTH, phoneNoLabel_1, -16, SpringLayout.SOUTH, accountNumber);
		sl_customerPanel.putConstraint(SpringLayout.WEST, phoneNoLabel_1, 6, SpringLayout.EAST, icanLabel);
		phoneNoLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		phoneNoLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		customerPanel.add(phoneNoLabel_1);
		
		nameField = new JTextField();
		sl_customerPanel.putConstraint(SpringLayout.WEST, nameField, 6, SpringLayout.EAST, nameLabel);
		sl_customerPanel.putConstraint(SpringLayout.EAST, nameField, -76, SpringLayout.WEST, icanLabel);
		sl_customerPanel.putConstraint(SpringLayout.EAST, addressDetails, 0, SpringLayout.EAST, nameField);
		sl_customerPanel.putConstraint(SpringLayout.NORTH, nameField, 4, SpringLayout.NORTH, customerPanel);
		nameLabel.setLabelFor(nameField);
		nameField.setFont(new Font("Verdana", Font.PLAIN, 13));
		nameField.setEditable(false);
		nameField.setText(name);
		customerPanel.add(nameField);
		nameField.setColumns(10);
		
		// Buttons for to view the product catalogue, update customer details
		JButton viewProductButton = new JButton("View Products");
		springLayout.putConstraint(SpringLayout.EAST, viewProductButton, 127, SpringLayout.WEST, orderPanel);
		viewProductButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		springLayout.putConstraint(SpringLayout.NORTH, viewProductButton, 23, SpringLayout.SOUTH, orderPanel);
		springLayout.putConstraint(SpringLayout.WEST, viewProductButton, 22, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, viewProductButton, 49, SpringLayout.SOUTH, orderPanel);
		getContentPane().add(viewProductButton);
		
		JButton updateDetailsButton = new JButton("Update ");
		updateDetailsButton.setEnabled(false);
		springLayout.putConstraint(SpringLayout.NORTH, updateDetailsButton, 1, SpringLayout.NORTH, viewProductButton);
		springLayout.putConstraint(SpringLayout.WEST, updateDetailsButton, 21, SpringLayout.EAST, viewProductButton);
		springLayout.putConstraint(SpringLayout.EAST, updateDetailsButton, -489, SpringLayout.EAST, getContentPane());
		updateDetailsButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Crud update =new Crud();
				update.customerUpdateDetails(nameField.getText(),addressDetails.getText(), phoneNoField.getText(),accountNumber.getText() );
				nameField.setEditable(false);
				phoneNoField.setEditable(false);
				addressDetails.setEditable(false);
				updateDetailsButton.setEnabled(false);
			
				
				
			}

			
		});
		updateDetailsButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(updateDetailsButton);
		
		JButton changePasswoord = new JButton("Change password");
		springLayout.putConstraint(SpringLayout.NORTH, changePasswoord, 1, SpringLayout.NORTH, viewProductButton);
		changePasswoord.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(changePasswoord);
		
		JButton closeAccount = new JButton("Close Account");
		springLayout.putConstraint(SpringLayout.EAST, changePasswoord, -33, SpringLayout.WEST, closeAccount);
		springLayout.putConstraint(SpringLayout.NORTH, closeAccount, 1, SpringLayout.NORTH, viewProductButton);
		springLayout.putConstraint(SpringLayout.EAST, closeAccount, 0, SpringLayout.EAST, orderPanel);
		closeAccount.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(closeAccount);
		
		JButton update = new JButton("Update Details");
		update.setEnabled(true);
		springLayout.putConstraint(SpringLayout.NORTH, update, 1, SpringLayout.NORTH, viewProductButton);
		springLayout.putConstraint(SpringLayout.WEST, update, 35, SpringLayout.EAST, updateDetailsButton);
		springLayout.putConstraint(SpringLayout.EAST, update, -44, SpringLayout.WEST, changePasswoord);
		update.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						nameField.setEditable(true);
						phoneNoField.setEditable(true);
						addressDetails.setEditable(true);
						updateDetailsButton.setEnabled(true);
						
					}
				});
		getContentPane().add(update);
		update.setFont(new Font("Times New Roman", Font.BOLD, 13));
		
		Icon logo = new ImageIcon(getClass().getResource("logo3.jpg"));
		
		
		
	}
}
