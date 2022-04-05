package Project;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword extends JFrame 
{
	private JPasswordField oldPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField confirmPassField;
	private String oldPass;
	private String newPass;
	private String confirmPass;
	public ChangePassword(String email,int id)
	{
		super("Change Password");
		getContentPane().setBackground(Color.GRAY);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 28, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 33, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -11, SpringLayout.SOUTH, getContentPane());
		panel.setBackground(Color.GRAY);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 420, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -2, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -6, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 31, SpringLayout.NORTH, getContentPane());
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		oldPasswordField = new JPasswordField();
		oldPasswordField.setFont(new Font("Verdana", Font.PLAIN, 13));
		sl_panel.putConstraint(SpringLayout.NORTH, oldPasswordField, 27, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, oldPasswordField, -201, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, oldPasswordField, -47, SpringLayout.EAST, panel);
		panel.add(oldPasswordField);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setFont(new Font("Verdana", Font.PLAIN, 13));
		sl_panel.putConstraint(SpringLayout.NORTH, newPasswordField, 24, SpringLayout.SOUTH, oldPasswordField);
		sl_panel.putConstraint(SpringLayout.WEST, newPasswordField, 0, SpringLayout.WEST, oldPasswordField);
		sl_panel.putConstraint(SpringLayout.EAST, newPasswordField, 0, SpringLayout.EAST, oldPasswordField);
		panel.add(newPasswordField);
		
		confirmPassField = new JPasswordField();
		confirmPassField.setFont(new Font("Verdana", Font.PLAIN, 13));
		sl_panel.putConstraint(SpringLayout.NORTH, confirmPassField, 25, SpringLayout.SOUTH, newPasswordField);
		sl_panel.putConstraint(SpringLayout.WEST, confirmPassField, 0, SpringLayout.WEST, oldPasswordField);
		sl_panel.putConstraint(SpringLayout.EAST, confirmPassField, 0, SpringLayout.EAST, oldPasswordField);
		panel.add(confirmPassField);
		
		JLabel oldPassLabel = new JLabel("Old Password:");
		oldPassLabel.setLabelFor(oldPasswordField);
		oldPassLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		sl_panel.putConstraint(SpringLayout.NORTH, oldPassLabel, 0, SpringLayout.NORTH, oldPasswordField);
		sl_panel.putConstraint(SpringLayout.WEST, oldPassLabel, -155, SpringLayout.WEST, oldPasswordField);
		sl_panel.putConstraint(SpringLayout.SOUTH, oldPassLabel, 0, SpringLayout.SOUTH, oldPasswordField);
		sl_panel.putConstraint(SpringLayout.EAST, oldPassLabel, -6, SpringLayout.WEST, oldPasswordField);
		panel.add(oldPassLabel);
		
		JLabel newPassLabel = new JLabel("New Password:");
		newPassLabel.setLabelFor(newPasswordField);
		newPassLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		sl_panel.putConstraint(SpringLayout.NORTH, newPassLabel, 0, SpringLayout.NORTH, newPasswordField);
		sl_panel.putConstraint(SpringLayout.WEST, newPassLabel, 0, SpringLayout.WEST, oldPassLabel);
		sl_panel.putConstraint(SpringLayout.SOUTH, newPassLabel, 0, SpringLayout.SOUTH, newPasswordField);
		sl_panel.putConstraint(SpringLayout.EAST, newPassLabel, -6, SpringLayout.WEST, newPasswordField);
		panel.add(newPassLabel);
		
		JLabel confirmPassLabel = new JLabel("Confirm Password:");
		confirmPassLabel.setLabelFor(confirmPassField);
		confirmPassLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		sl_panel.putConstraint(SpringLayout.NORTH, confirmPassLabel, 0, SpringLayout.NORTH, confirmPassField);
		sl_panel.putConstraint(SpringLayout.WEST, confirmPassLabel, 0, SpringLayout.WEST, oldPassLabel);
		sl_panel.putConstraint(SpringLayout.SOUTH, confirmPassLabel, 0, SpringLayout.SOUTH, confirmPassField);
		sl_panel.putConstraint(SpringLayout.EAST, confirmPassLabel, -6, SpringLayout.WEST, confirmPassField);
		panel.add(confirmPassLabel);
		
		JButton changePass = new JButton("Change Password");
		changePass.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					oldPass= new String(oldPasswordField.getPassword());
					newPass = new String(newPasswordField.getPassword());
					confirmPass = new String(confirmPassField.getPassword());
					int hash = oldPass.hashCode();
					String pass = ""+hash;
					Crud passW = new Crud();
					if(!passW.passwordCheck(pass, id)==true)
						{
							ErrorMessage err = new ErrorMessage("The old password does not match our records ");
						}
					if(!newPass.equals(confirmPass))
						{
							ErrorMessage err = new ErrorMessage("The new password and confirm password must match");
						}
					else if (oldPass.equals(newPass))
						{
						ErrorMessage err = new ErrorMessage("The old and the new Passwords must be different");
						}
					else
						{
							hash=newPass.hashCode();
							pass=""+hash;
							passW.passwordUpdate(pass, id);
							
							
							Customer c=new Customer(email);
							c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							c.setSize(800,600);
							c.setLocation(300,200);
							c.setResizable(false);
							c.setVisible(true);
							dispose();
					
						} 
					
				}
			catch (Exception e1) 
					{
						ErrorMessage err = new ErrorMessage("Application Error "+ e1);				}
				
			}
		});
		changePass.setFont(new Font("Times New Roman", Font.BOLD, 13));
		sl_panel.putConstraint(SpringLayout.WEST, changePass, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, changePass, -10, SpringLayout.SOUTH, panel);
		panel.add(changePass);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Customer c=new Customer(email);
				c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				c.setSize(800,600);
				c.setLocation(300,200);
				c.setResizable(false);
				c.setVisible(true);
				dispose();
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, cancel, -145, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, cancel, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, cancel, -44, SpringLayout.EAST, panel);
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		panel.add(cancel);
		lblNewLabel.setIcon(new ImageIcon(ChangePassword.class.getResource("/Project/logo3a.jpg")));
		getContentPane().add(lblNewLabel);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChangePassword.class.getResource("/Project/logo3b.jpg")));
		setBackground(Color.GRAY);
	}
}
