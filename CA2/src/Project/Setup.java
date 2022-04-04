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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class Setup extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField passwordField;

	public Setup() throws HeadlessException 
	{
		super("Configure Database Connection");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Setup.class.getResource("/Project/logo3b.jpg")));
		setBackground(Color.GRAY);
		getContentPane().setBackground(Color.GRAY);
		
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				 try
					{		//	Regenerates the login window if the cancel button is pressed.			
			        	Login  login = new Login();
						login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						login.setSize(680, 230);
						login.setLocation(500,400);
						login.setResizable(false);
						login.setVisible(true);
						dispose();

					}
				catch(Exception e1)
					{
						ErrorMessage err = new ErrorMessage("Unknown Error");
					}        
				
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, cancel, 308, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, cancel, -162, SpringLayout.EAST, getContentPane());
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(cancel);
		
		JButton createAccount = new JButton("Update Configuration ");
		springLayout.putConstraint(SpringLayout.NORTH, createAccount, 0, SpringLayout.NORTH, cancel);
		springLayout.putConstraint(SpringLayout.WEST, createAccount, 104, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, createAccount, -46, SpringLayout.WEST, cancel);
		createAccount.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
		        try
				{
		        	String user = username.getText();
		        	String pass = new String(passwordField.getPassword());
		        	Config t = new Config(user,pass);
		        	t.setCredentials();// sets the new database user/password combination
					
		        	Login  login = new Login();
					login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					login.setSize(680, 230);
					login.setLocation(500,400);
					login.setResizable(false);
					login.setVisible(true);
					dispose();

				}
			catch(Exception e1)
				{
					ErrorMessage err = new ErrorMessage("Unknown Error");
				}        
			}
		});
		createAccount.setToolTipText("Create bew account");
		createAccount.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(createAccount);
		
		username = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, username, 43, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, username, 201, SpringLayout.WEST, getContentPane());
		getContentPane().add(username);
		username.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Enter Database Username:");
		springLayout.putConstraint(SpringLayout.NORTH, usernameLabel, 43, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, usernameLabel, 37, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, usernameLabel, -391, SpringLayout.EAST, getContentPane());
		usernameLabel.setLabelFor(username);
		usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(usernameLabel);
		
		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, cancel, 44, SpringLayout.SOUTH, passwordField);
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 17, SpringLayout.SOUTH, username);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 201, SpringLayout.WEST, getContentPane());
		getContentPane().add(passwordField);
		
		JLabel passwordLabel = new JLabel("Enter Database Passwword:");
		springLayout.putConstraint(SpringLayout.SOUTH, usernameLabel, -17, SpringLayout.NORTH, passwordLabel);
		springLayout.putConstraint(SpringLayout.EAST, passwordLabel, 0, SpringLayout.EAST, usernameLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, passwordLabel, -95, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 37, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 79, SpringLayout.NORTH, getContentPane());
		passwordLabel.setToolTipText("Please Enter your password to login");
		passwordLabel.setLabelFor(passwordField);
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(passwordLabel);
		
		JLabel lblNewLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -47, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, username, -47, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 430, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 27, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 134, SpringLayout.NORTH, getContentPane());
		lblNewLabel.setIcon(new ImageIcon(Setup.class.getResource("/Project/logo3b.jpg")));
		getContentPane().add(lblNewLabel);
		// TODO Auto-generated constructor stub
	}

	public Setup(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public Setup(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public Setup(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
}
