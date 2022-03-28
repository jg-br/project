package Project;

import javax.swing.JOptionPane;

public class Info 
{
	public Info(String message)
	{
		JOptionPane.showMessageDialog( null, message, "Information Message", JOptionPane.INFORMATION_MESSAGE);
	}
}
