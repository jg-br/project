package Project;
/* Student Name: John Brennan 
 * Student ID:c00114371
 * Date: */
import java.awt.GraphicsConfiguration;   
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class SetupAccess extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;

	public SetupAccess()  
	{
		super("Configure Database Connection");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SetupAccess.class.getResource("/Project/logo3b.jpg")));
		setBackground(Color.GRAY);
		getContentPane().setBackground(Color.GRAY);
		
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JButton cancel = new JButton("Cancel");
		springLayout.putConstraint(SpringLayout.WEST, cancel, 289, SpringLayout.WEST, getContentPane()); // sets the components position in relation to other 
		// components with in the JFrame
		cancel.addActionListener(new ActionListener() // Action listener for the cancel button, 
		{
			public void actionPerformed(ActionEvent e) 
			{
				 try
					{					
			        	Login  login = new Login();
						login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						login.setSize(680, 230);
						login.setLocation(500,400);
						login.setResizable(false);
						login.setVisible(true);
						dispose();//	disposes of the setup access window and and regenerates the login window if the user presses cancel.

					}
				catch(Exception e1) // catches any general exceptions and  displays an error message.
					{
						ErrorMessage err = new ErrorMessage("Unknown Error"+ e1);
					}        
				
			}
		});
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(cancel);	//adds the button to the content pane.
		
		JButton setup = new JButton("Enter Setup");
		springLayout.putConstraint(SpringLayout.NORTH, setup, 0, SpringLayout.NORTH, cancel);
		springLayout.putConstraint(SpringLayout.WEST, setup, 57, SpringLayout.WEST, getContentPane());
		setup.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
		        try
				{
		        	
		        	String pass = new String(passwordField.getPassword());	// creates a String object from the password character field.
		        	if(pass.equals("1234"))	// hard coded password
			        	{	 
		        			// Instantiates a new window object
			               	Setup setup = new Setup();
							setup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							setup.setSize(680, 230);
							setup.setLocation(500,400);
							setup.setResizable(false);
							setup.setVisible(true);
							dispose();
			        	}

				}
			catch(Exception e1)
				{
					ErrorMessage err = new ErrorMessage("Error"+e1);
				}        
			}
		});
		setup.setToolTipText("Enter program setup");
		setup.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(setup);
		
		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.EAST, passwordField, -181, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, cancel, 25, SpringLayout.SOUTH, passwordField);
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 53, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 241, SpringLayout.WEST, getContentPane());
		getContentPane().add(passwordField);
		
		JLabel iconLabel = new JLabel(""); // Company logo added 
		springLayout.putConstraint(SpringLayout.EAST, cancel, -17, SpringLayout.WEST, iconLabel);
		springLayout.putConstraint(SpringLayout.NORTH, iconLabel, 27, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, iconLabel, 440, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, iconLabel, 134, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, iconLabel, 0, SpringLayout.EAST, getContentPane());
		iconLabel.setIcon(new ImageIcon(SetupAccess.class.getResource("/Project/logo3b.jpg")));
		getContentPane().add(iconLabel);
		
		JLabel passwordLabel = new JLabel("Enter Setup Password:");	//	Label for the password field.
		springLayout.putConstraint(SpringLayout.SOUTH, setup, 52, SpringLayout.SOUTH, passwordLabel);
		springLayout.putConstraint(SpringLayout.EAST, setup, 0, SpringLayout.EAST, passwordLabel);
		springLayout.putConstraint(SpringLayout.WEST, passwordLabel, 55, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, passwordLabel, -384, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, passwordLabel, 1, SpringLayout.NORTH, passwordField);
		springLayout.putConstraint(SpringLayout.SOUTH, passwordLabel, -2, SpringLayout.SOUTH, passwordField);
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().add(passwordLabel);
		// TODO Auto-generated constructor stub
	}

	public SetupAccess(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public SetupAccess(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public SetupAccess(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
}
