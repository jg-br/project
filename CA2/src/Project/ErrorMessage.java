
package Project;

/* Student Name: John Brennan
 * Student ID:c00114371
 * Date: */

import javax.swing.JOptionPane;

public class ErrorMessage 
{
	/**
	 * @wbp.parser.entryPoint
	 */
	public ErrorMessage(String message)//	generic error message constructor
	{
		JOptionPane.showMessageDialog( null, message, "Error Message", JOptionPane.ERROR_MESSAGE );
	}

}
