import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

/**
 * 
 * Tämä on kaikkein tärkein osa SlapMAchinea
 * Ilman SlapMotoria, läpsiminen ei tapahtuisi
 * 
 * @version 0.1
 * @author Veli Oskari Karttunen
 *
 */

public class slapMotor {
	
	RegulatedMotor ms = new EV3MediumRegulatedMotor(MotorPort.D);
	
	int slapCount;
	

	
	/** tuhoaa KAIKEN.
	 * Moottori pyörähtää 180 astetta ja sitten pyörii takaisin.
	 * Parametri "num" määrittää kuinka monta kertaa läpsitään.
	 * Tämä myös nostaa slapCounttia
	 * @param num
	 */
	public void Slap(int num){
		while (num >= 1) {
			// taunt
			LCD.clear();
			LCD.drawString("DIE, DIE, DIE!", 0, 2);
			
			slapCount++;
			num -= 1;
			
			// slap motion
			ms.setSpeed(900);
			ms.rotate(-180);
			ms.setSpeed(0);
			Delay.msDelay(800);
			
			// takes the hand back to the original position
			ms.setSpeed(200);
			ms.rotate(180);
			ms.setSpeed(0);
			Delay.msDelay(300);
			LCD.clear();
		}
	}
	
	/** Hyvin tietyntapainen läppäisy
	 * Minua pyydettiin tekemään tämä. En tiedä mitä varten.
	 * This one first rotates 180 degrees, then it moves back whatever amount of degrees you determine to
	 * Se ensin pyöräyttää kättä 180, sitten vain hieman takaisin, sitten hieman eteen ja viimeinkin 180 astetta takaisin.
	 * Miksi? Ehkä sen idea on antaa sille jotain eloa muistuttavaa liikettä.
	 * @param deg
	 */
	public void SpecificSlap(int deg){
			LCD.clear();
			LCD.drawString("DIE, DIE, DIE!", 0, 2);
			
			slapCount++;
			
			ms.setSpeed(900);
			ms.rotate(-180);
			ms.setSpeed(0);
			Delay.msDelay(200);

			ms.setSpeed(900);
			ms.rotate(deg);
			ms.setSpeed(0);
			Delay.msDelay(200);
			LCD.clear();
			ms.setSpeed(900);
			ms.rotate(-deg);
			ms.setSpeed(0);
			Delay.msDelay(200);
			LCD.clear();
			
			ms.setSpeed(300);
			ms.rotate(180);
			ms.setSpeed(0);
			Delay.msDelay(800);
	}
	
	/** sulkee läpsymoottorin
	 */
	public void shutSlap(){
		ms.close();
	}
	
	/** palauttaa läpsimismäärän
	 * @return slapCount
	 */
	public int getSlapCount(){
		return this.slapCount;
	}
	
}
