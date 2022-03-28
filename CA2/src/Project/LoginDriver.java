package Project;


import javax.swing.JFrame;



public class LoginDriver {

	public static void main(String[] args) 
	{
		try
			{
				Login  login = new Login();
				login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				login.setSize(680, 230);
				login.setLocation(500,400);
				login.setResizable(false);
				login.setVisible(true);
				Crud test =new Crud();
				test.close();

			}
		catch(Exception e)
			{
				Error err = new Error("Unknown Error");
			}
	}

}
