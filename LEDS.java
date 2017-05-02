import lejos.hardware.Button;
import lejos.utility.Delay;

//Luokka joka m‰‰rittelee ledien toiminnan
public class LEDS {
	
	public static LEDS start(){
		return new LEDS();
	}
		// Ledien toimina etsinn‰n aikana
		public void searchlight(){
		Button.LEDPattern(6);
		Delay.msDelay(1500);
		Button.LEDPattern(5);
		Delay.msDelay(1500);
		}
		
		//Ledien toiminta kun robotti saavuttaa kohdetta
		public void approach(){
		Button.LEDPattern(9);
		Delay.msDelay(500);
		Button.LEDPattern(7);
		Delay.msDelay(500);
		}
		
		//Ledien toiminta kun robotti l‰im‰isee
		public void slap(){
		Button.LEDPattern(9);
		Delay.msDelay(50);
		}
		
		//Ledien toiminta shutdownin aikana
		public void shutDown(){
		Button.LEDPattern(3);
		Delay.msDelay(2000);
		Button.LEDPattern(2);
		Delay.msDelay(2000);
		Button.LEDPattern(1);
		Delay.msDelay(2000);
		Button.LEDPattern(0);
		Delay.msDelay(50);
		
	}
		

}
