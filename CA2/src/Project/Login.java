package Project;
/* Student Name: John Brennan
 * Student ID:c00114371
 * Date: */
import java.awt.GraphicsConfiguration;    
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class Login extends JFrame 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField passwordField;

	public Login() throws HeadlessException 
	{
		super("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Project/logo3b.jpg")));
		setBackground(Color.GRAY);
		getContentPane().setBackground(Color.GRAY);
		
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				try 
				{
					Crud login = new Crud(); // Opens a database connection
					
					String customerEmail = username.getText();	//	retrieves the data in the username text field
					String customerPassword = new String(passwordField.getPassword()); /// converts the character based password field into a string
					int hashValue = customerPassword.hashCode(); //	 runs java's built in hash function 
					customerPassword =""+ hashValue;	//	 Concatenates the has value with a blank string
					
					 
					if(login.adminLogin(customerEmail,customerPassword)== true)	//	 if the username/password combination is not found in the customer table
						 //	the Admin table is compared with the username/password combination
					 	{
						 	//	if true the Admin window is instantiated 
						 	Admin admin = new Admin();
						 	admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							admin.setSize(800,600);
							admin.setLocation(300,100);
							admin.setVisible(true);
							admin.setResizable(false);
							dispose();
					 	}
					 else if (login.loginVerify(customerEmail,customerPassword)== true)	//	checks the customer table to see if the email/password combination are there
						{
							//	 if so the customer window is instantiated 
							Customer customer = new Customer(customerEmail);
							customer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							customer.setSize(800,600);
							customer.setLocation(300,100);
							customer.setVisible(true);
							customer.setResizable(false);
							dispose();
						}
					 else
					 	{
						 	Info log = new Info("The Email or password is incorrect please try again");	// if no match is found the information message tells the user same
						 	username.setText("");	//	clears the email/password fields.
						 	passwordField.setText("");
					 	}
					
				} 
			catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					ErrorMessage err = new ErrorMessage("Progran error"+ e1);	//	general error message
					
				
				}
			}
			
		});
		springLayout.putConstraint(SpringLayout.NORTH, login, 142, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, login, 20, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, login, 119, SpringLayout.WEST, getContentPane());
		login.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(login);
		
		JButton cancel = new JButton("Clear");
		cancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				username.setText("");
				passwordField.setText("");
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, cancel, 0, SpringLayout.NORTH, login);
		springLayout.putConstraint(SpringLayout.WEST, cancel, 346, SpringLayout.WEST, getContentPane());
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(cancel);
		
		JButton createAccount = new JButton("Create Account");
		springLayout.putConstraint(SpringLayout.NORTH, createAccount, 0, SpringLayout.NORTH, login);
		springLayout.putConstraint(SpringLayout.WEST, createAccount, 19, SpringLayout.EAST, login);
		springLayout.putConstraint(SpringLayout.EAST, createAccount, -26, SpringLayout.WEST, cancel);
		createAccount.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	//	instantiates the create account window when the create account button is clicked.
				CreateAccount customer = new CreateAccount();
				customer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				customer.setSize(800,400);
				customer.setLocation(500,400);
				customer.setVisible(true);
				customer.setResizable(false);
				dispose();
			}
		});
		createAccount.setToolTipText("Create new account");
		createAccount.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(createAccount);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		getContentPane().add(horizontalGlue);
		
		username = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, username, 43, SpringLayout.NORTH, getContentPane());
		getContentPane().add(username);
		username.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Please Enter E-mail: ");
		usernameLabel.setForeground(Color.BLACK);
		springLayout.putConstraint(SpringLayout.WEST, username, 6, SpringLayout.EAST, usernameLabel);
		springLayout.putConstraint(SpringLayout.NORTH, usernameLabel, 43, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, usernameLabel, 37, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, usernameLabel, -469, SpringLayout.EAST, getContentPane());
		usernameLabel.setLabelFor(username);
		usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(usernameLabel);
		
		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.SOUTH, username, -17, SpringLayout.NORTH, passwordField);
		springLayout.putConstraint(SpringLayout.EAST, username, 0, SpringLayout.EAST, passwordField);
		getContentPane().add(passwordField);
		
		JLabel passwordLabel = new JLabel("Please Enter Passwword:");
		passwordLabel.setForeground(Color.BLACK);
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 0, SpringLayout.NORTH, passwordLabel);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 25, SpringLayout.EAST, passwordLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, usernameLabel, -17, SpringLayout.NORTH, passwordLabel);
		springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 79, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, passwordLabel, -44, SpringLayout.NORTH, login);
		passwordLabel.setToolTipText("Please Enter your password to login");
		passwordLabel.setLabelFor(passwordField);
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 37, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, passwordLabel, 178, SpringLayout.WEST, getContentPane());
		getContentPane().add(passwordLabel);
		
			//	company logo displayed via jlabel
		JLabel lblNewLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -113, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 22, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, -168, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 129, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -22, SpringLayout.EAST, getContentPane());
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Project/logo3b.jpg")));
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Setup");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SetupAccess setup = new SetupAccess();
				setup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setup.setSize(620,200);
				setup.setLocation(500,400);
				setup.setVisible(true);
				setup.setResizable(false);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 491, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, cancel, -29, SpringLayout.WEST, btnNewButton);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, login);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, login);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -22, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnNewButton);
		// TODO Auto-generated constructor stub
	}

	public Login(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public Login(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public Login(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
}
