import lejos.hardware.Button;

//Luokka joka m‰‰rittelee ledien toiminnan
public class LEDS {
	
	public static LEDS start(){
		return new LEDS();
	}
		// Ledien toimina etsinn‰n aikana
		public void searchlight(){
		Button.LEDPattern(6);
		
		Button.LEDPattern(5);
		
		}
		
		//Ledien toiminta kun robotti saavuttaa kohdetta
		public void approach(){
		Button.LEDPattern(9);
		
		Button.LEDPattern(7);
		}
		
		//Ledien toiminta kun robotti l‰im‰isee
		public void slap(){
		Button.LEDPattern(9);
		}
		
		//Ledien toiminta shutdownin aikana
		public void shutDown(){
		Button.LEDPattern(3);
		Button.LEDPattern(2);
		Button.LEDPattern(1);
		Button.LEDPattern(0);
		
	}
		

}
