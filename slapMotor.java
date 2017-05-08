import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

/**
 * @version 0.1
 * @author Veli Oskari Karttunen
 *
 *T‰m‰ on kaikkein t‰rkein osa SlapMAchinea
 *Ilman SlapMotoria, l‰psiminen ei tapahtuisi
 *
 */

public class slapMotor {
	
	RegulatedMotor ms = new EV3MediumRegulatedMotor(MotorPort.D);
	
	int slapCount;
	

	
	/** tuhoaa KAIKEN
	 * 
	 * @param num
	 * 
	 * Moottori pyˆr‰ht‰‰ 180 astetta ja sitten pyˆrii takaisin.
	 * Construktori "num" m‰‰ritt‰‰ kuinka monta kertaa l‰psit‰‰n.
	 * T‰m‰ myˆs nostaa slapCounttia
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
	
	/** Hyvin tietyntapainen l‰pp‰isy
	 * 
	 * @param deg
	 * 
	 * Minua pyydettiin tekem‰‰n t‰m‰. En tied‰ mit‰ varten.
	 * This one first rotates 180 degrees, then it moves back whatever amount of degrees you determine to
	 * Se ensin pyˆr‰ytt‰‰ k‰tt‰ 180, sitten vain hieman takaisin, sitten hieman eteen ja viimeinkin 180 astetta takaisin.
	 * Miksi? Ehk‰ sen idea on antaa sille jotain eloa muistuttavaa liikett‰.
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
	
	/** sulkee l‰psymoottorin
	 */
	public void shutSlap(){
		ms.close();
	}
	
	/** palauttaa l‰psimism‰‰r‰n
	 * @return slapCount
	 */
	public int getSlapCount(){
		return this.slapCount;
	}
	
}
