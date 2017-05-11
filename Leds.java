import lejos.hardware.Button;

/**
 * 
 * Vilkuttaa ledivaloja.
 *
 * @version 0.1
 * @author Markus Vikholm
 * 
 */
public class Leds {	

	/** 
	 * Ledien vilkkuminen kohteen etsinn‰n aikana.
	 */
	public void searchLight(){	
		Button.LEDPattern(6);	
		Button.LEDPattern(5);	
	}
	
	/**
	 * Ledien vilkkuminen kohteen l‰hell‰.
	 */
	public void approach(){
		Button.LEDPattern(9);	
		Button.LEDPattern(7);
	}
	
	/**
	 * Ledien vilkkuminen k‰den k‰‰ntyess‰.
	 */
	public void slap(){
		Button.LEDPattern(9);
	}
	
	/**
	 * Ledien vilkkuminen pys‰ytett‰ess‰.
	 */
	public void shutDown(){
		Button.LEDPattern(3);
		Button.LEDPattern(2);
		Button.LEDPattern(1);
		Button.LEDPattern(0);		
	}
}
