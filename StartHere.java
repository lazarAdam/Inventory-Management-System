
import java.awt.EventQueue;


/** StartHere class
*
* Instantiates the user interface (View)
* 
* @author 	Copyright (c) Sue Fitzgerald All rights revised  by oussama el aallali 
* 			8/25/14
 */

public class StartHere {
	/** main
	 * Invokes user interface.  Prints stack on exception.
	 * @param s - unused
	 */
	public static void main(String[] s) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserI frame = new UserI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}
