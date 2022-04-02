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

public class CreateAccount2 extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField name;
	private JTextField phoneNo;
	private JTextField email;
	private JTextField confirmEmail;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private String customerName;
	private String customerAddress;
	private String customerPhoneNo;
	private String customerEmail;
	private String confirmCustomerEmail;
	private String customerPassword;
	private String confirmCustomerPassword;
	
	public CreateAccount2() 
	{
		super("Customer SignUp");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreateAccount2.class.getResource("/Project/logo3b.jpg")));
		getContentPane().setBackground(Color.GRAY);
		setBackground(Color.GRAY);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		name = new JTextField();
		name.setFont(new Font("Verdana", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.EAST, name, -420, SpringLayout.EAST, getContentPane());
		getContentPane().add(name);
		name.setColumns(10);
		
		JLabel nameLabel = new JLabel("Please Enter your name:");
		nameLabel.setLabelFor(name);
		springLayout.putConstraint(SpringLayout.EAST, nameLabel, -625, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, name, 24, SpringLayout.EAST, nameLabel);
		springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 49, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, nameLabel, 25, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, name, 0, SpringLayout.NORTH, nameLabel);
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(nameLabel);
		
		JLabel addressLabel = new JLabel("Please Enter Your Address:");
		springLayout.putConstraint(SpringLayout.NORTH, addressLabel, 102, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, nameLabel, -34, SpringLayout.NORTH, addressLabel);
		springLayout.putConstraint(SpringLayout.WEST, addressLabel, 25, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, addressLabel, -242, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, addressLabel, -607, SpringLayout.EAST, getContentPane());
		addressLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(addressLabel);
		
		phoneNo = new JTextField();
		phoneNo.setFont(new Font("Verdana", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.EAST, phoneNo, 0, SpringLayout.EAST, name);
		getContentPane().add(phoneNo);
		phoneNo.setColumns(10);
		
		JLabel phoneNolabel = new JLabel("Please Enter your Phone No:");
		phoneNolabel.setLabelFor(phoneNo);
		springLayout.putConstraint(SpringLayout.NORTH, phoneNo, 2, SpringLayout.NORTH, phoneNolabel);
		springLayout.putConstraint(SpringLayout.WEST, phoneNo, 24, SpringLayout.EAST, phoneNolabel);
		springLayout.putConstraint(SpringLayout.NORTH, phoneNolabel, 108, SpringLayout.SOUTH, addressLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, phoneNolabel, -112, SpringLayout.SOUTH, getContentPane());
		phoneNolabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		springLayout.putConstraint(SpringLayout.WEST, phoneNolabel, 0, SpringLayout.WEST, nameLabel);
		springLayout.putConstraint(SpringLayout.EAST, phoneNolabel, 0, SpringLayout.EAST, nameLabel);
		getContentPane().add(phoneNolabel);
		
		email = new JTextField();
		email.setFont(new Font("Verdana", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.WEST, email, 0, SpringLayout.WEST, name);
		springLayout.putConstraint(SpringLayout.EAST, email, -420, SpringLayout.EAST, getContentPane());
		getContentPane().add(email);
		email.setColumns(10);
		
		JLabel emailLabel = new JLabel("Please Enter Your E-mail");
		emailLabel.setLabelFor(email);
		springLayout.putConstraint(SpringLayout.NORTH, email, 0, SpringLayout.NORTH, emailLabel);
		springLayout.putConstraint(SpringLayout.NORTH, emailLabel, 26, SpringLayout.SOUTH, phoneNolabel);
		springLayout.putConstraint(SpringLayout.SOUTH, emailLabel, -67, SpringLayout.SOUTH, getContentPane());
		emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		springLayout.putConstraint(SpringLayout.WEST, emailLabel, 0, SpringLayout.WEST, nameLabel);
		springLayout.putConstraint(SpringLayout.EAST, emailLabel, 0, SpringLayout.EAST, nameLabel);
		getContentPane().add(emailLabel);
		
		confirmEmail = new JTextField();
		confirmEmail.setFont(new Font("Verdana", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.NORTH, confirmEmail, 22, SpringLayout.SOUTH, email);
		springLayout.putConstraint(SpringLayout.WEST, confirmEmail, 0, SpringLayout.WEST, name);
		springLayout.putConstraint(SpringLayout.SOUTH, confirmEmail, 41, SpringLayout.SOUTH, email);
		springLayout.putConstraint(SpringLayout.EAST, confirmEmail, 0, SpringLayout.EAST, name);
		getContentPane().add(confirmEmail);
		confirmEmail.setColumns(10);
		
		JLabel confirmEmailLabel = new JLabel("Confirm E-mail Address:");
		confirmEmailLabel.setLabelFor(confirmEmail);
		confirmEmailLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		springLayout.putConstraint(SpringLayout.NORTH, confirmEmailLabel, 22, SpringLayout.SOUTH, emailLabel);
		springLayout.putConstraint(SpringLayout.WEST, confirmEmailLabel, 0, SpringLayout.WEST, nameLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, confirmEmailLabel, 0, SpringLayout.SOUTH, confirmEmail);
		springLayout.putConstraint(SpringLayout.EAST, confirmEmailLabel, 0, SpringLayout.EAST, addressLabel);
		getContentPane().add(confirmEmailLabel);
		
		JButton cancelButton = new JButton("Login");
		springLayout.putConstraint(SpringLayout.WEST, cancelButton, 608, SpringLayout.WEST, getContentPane());
		cancelButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Login  login = new Login();
				login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				login.setSize(680, 230);
				login.setLocation(500,400);
				login.setResizable(false);
				login.setVisible(true);
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, cancelButton, 0, SpringLayout.SOUTH, confirmEmail);
		springLayout.putConstraint(SpringLayout.EAST, cancelButton, -28, SpringLayout.EAST, getContentPane());
		cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(cancelButton);
		
		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.EAST, passwordField, 0, SpringLayout.EAST, cancelButton);
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 13));
		getContentPane().add(passwordField);
		
		JLabel passwordLabel = new JLabel("Please Enter Password:");
		springLayout.putConstraint(SpringLayout.SOUTH, passwordLabel, -70, SpringLayout.SOUTH, phoneNolabel);
		springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 59, SpringLayout.EAST, phoneNo);
		springLayout.putConstraint(SpringLayout.EAST, passwordLabel, -213, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 209, SpringLayout.NORTH, getContentPane());
		passwordLabel.setLabelFor(passwordField);
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(passwordLabel);
		
		confirmPasswordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, confirmPasswordField, 35, SpringLayout.SOUTH, passwordField);
		springLayout.putConstraint(SpringLayout.EAST, confirmPasswordField, -28, SpringLayout.EAST, getContentPane());
		confirmPasswordField.setFont(new Font("Verdana", Font.PLAIN, 13));
		getContentPane().add(confirmPasswordField);
		
		JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
		springLayout.putConstraint(SpringLayout.WEST, confirmPasswordField, 16, SpringLayout.EAST, confirmPasswordLabel);
		springLayout.putConstraint(SpringLayout.NORTH, confirmPasswordLabel, -2, SpringLayout.NORTH, confirmPasswordField);
		springLayout.putConstraint(SpringLayout.WEST, confirmPasswordLabel, 59, SpringLayout.EAST, email);
		springLayout.putConstraint(SpringLayout.EAST, confirmPasswordLabel, 0, SpringLayout.EAST, passwordLabel);
		confirmPasswordLabel.setLabelFor(confirmPasswordField);
		confirmPasswordLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(confirmPasswordLabel);
		
		JTextPane textPaneAddress = new JTextPane();
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 223, SpringLayout.EAST, textPaneAddress);
		springLayout.putConstraint(SpringLayout.NORTH, textPaneAddress, 30, SpringLayout.SOUTH, name);
		springLayout.putConstraint(SpringLayout.SOUTH, textPaneAddress, -28, SpringLayout.NORTH, phoneNo);
		addressLabel.setLabelFor(textPaneAddress);
		textPaneAddress.setFont(new Font("Verdana", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.WEST, textPaneAddress, 6, SpringLayout.EAST, addressLabel);
		springLayout.putConstraint(SpringLayout.EAST, textPaneAddress, 0, SpringLayout.EAST, name);
		getContentPane().add(textPaneAddress);
		
		JButton createAccountButton = new JButton("Create Account");
		springLayout.putConstraint(SpringLayout.SOUTH, confirmPasswordLabel, -62, SpringLayout.NORTH, createAccountButton);
		springLayout.putConstraint(SpringLayout.NORTH, createAccountButton, 357, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, createAccountButton, -213, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, cancelButton, 0, SpringLayout.NORTH, createAccountButton);
		springLayout.putConstraint(SpringLayout.SOUTH, createAccountButton, -22, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, createAccountButton, 59, SpringLayout.EAST, confirmEmail);
		createAccountButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Crud insert = new Crud();
					customerName = name.getText();
					customerAddress = textPaneAddress.getText();
					customerPhoneNo = phoneNo.getText();
					customerEmail = email.getText();
					confirmCustomerEmail= confirmEmail.getText();
					customerPassword = new String(passwordField.getPassword());
					confirmCustomerPassword = new String(confirmPasswordField.getPassword());
					if(!customerEmail.equals(confirmCustomerEmail))
						{
							ErrorMessage err = new ErrorMessage("The E-mail Addresses must match");
						}
					else if(!customerPassword.equals(confirmCustomerPassword))
						{
							ErrorMessage err = new ErrorMessage("The passwords must match");
						}
					else if (insert.emailCheck(customerEmail)== true)
						{
							ErrorMessage err = new ErrorMessage("Account exists, please use login instead");
							
						}
					else
						{
							int hashValue = customerPassword.hashCode();
							customerPassword= ""+ hashValue;
							insert.insertCustomer(customerName, customerAddress, customerPhoneNo , customerEmail, customerPassword);
							insert.close();
							
							Login  login = new Login();
							login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							login.setSize(680, 230);
							login.setLocation(500,400);
							login.setResizable(false);
							login.setVisible(true);
							dispose();
						}
				} 
			catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					ErrorMessage err = new ErrorMessage("There an error querying the database");
				
				}
			}
		});
		createAccountButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(createAccountButton);
		
		JLabel iconLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 24, SpringLayout.SOUTH, iconLabel);
		springLayout.putConstraint(SpringLayout.NORTH, iconLabel, 0, SpringLayout.NORTH, name);
		springLayout.putConstraint(SpringLayout.EAST, iconLabel, -28, SpringLayout.EAST, getContentPane());
		iconLabel.setIcon(new ImageIcon(CreateAccount2.class.getResource("/Project/logo3a.jpg")));
		getContentPane().add(iconLabel);
		
		JButton admin = new JButton("administrator");
		admin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Admin admin = new Admin();
			 	admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				admin.setSize(800,600);
				admin.setLocation(300,100);
				admin.setVisible(true);
				admin.setResizable(false);
				dispose();
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, admin, 17, SpringLayout.SOUTH, confirmPasswordField);
		springLayout.putConstraint(SpringLayout.WEST, admin, 0, SpringLayout.WEST, cancelButton);		
		springLayout.putConstraint(SpringLayout.SOUTH, admin, -15, SpringLayout.NORTH, cancelButton);
		springLayout.putConstraint(SpringLayout.EAST, admin, -28, SpringLayout.EAST, getContentPane());
		admin.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(admin);
	}
}
