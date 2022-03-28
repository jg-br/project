
package Project;



import javax.swing.JOptionPane;

public class ErrorMessage 
{
	/**
	 * @wbp.parser.entryPoint
	 */
	public ErrorMessage(String message)
	{
		JOptionPane.showMessageDialog( null, message, "Error Message", JOptionPane.ERROR_MESSAGE );
	}

}
