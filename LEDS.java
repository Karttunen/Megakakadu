import lejos.hardware.Button;

/**
 * 
 * 
 * @version 0.1
 * @author Markus Vikholm
 *
 */
public class LEDS {
	

	/** Ledien toimina etsinn�n aikana
	 */
	public void searchlight(){
	Button.LEDPattern(6);
	
	Button.LEDPattern(5);
	
	}
	
	/**Ledien toiminta kun robotti saavuttaa kohdetta
	 */
	public void approach(){
	Button.LEDPattern(9);
	
	Button.LEDPattern(7);
	}
	
	/**Ledien toiminta kun robotti l�im�isee
	 */
	public void slap(){
	Button.LEDPattern(9);
	}
	
	/**Ledien toiminta shutdownin aikana
	 */
	public void shutDown(){
	Button.LEDPattern(3);
	Button.LEDPattern(2);
	Button.LEDPattern(1);
	Button.LEDPattern(0);
		
	}
		

}
