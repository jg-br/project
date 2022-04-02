package Project;
/* Student Name: John Brennan
 * Student ID:c00114371
 * Date: */

import java.sql.SQLException;

import javax.swing.JFrame;



public class LoginDriver {

	public static void main(String[] args) 
	{
		try
			{
				//creates the initial login window.
				Login  login = new Login();
				login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				login.setSize(680, 230);
				login.setLocation(500,400);
				login.setResizable(false);
				login.setVisible(true);
				//	Creates a test connection object to make sure that the  database is running.
				Crud test =new Crud();
				test.close();

			}
		catch(SQLException sqle)
			{
			Error err = new Error("The database is unavailable");
			}
		catch(Exception e)
			{
				Error err = new Error("Unknown Error");
			}
	}

}
