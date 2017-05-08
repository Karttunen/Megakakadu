import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

/**
 * Läpsimismoottorin luokka
 * Suorittaa läpsimisen.
 * @version 0.1
 * @author Veli Oskari Karttunen
 */
public class slapMotor {
	
	RegulatedMotor ms = new EV3MediumRegulatedMotor(MotorPort.D);
	
	int slapCount;
	
	/** 
	 * Moottori pyörähtää 180 astetta ja palaa sitten takaisin
	 * Lisää slapCounttia yhdellä
	 * @param num Määrittää kuinka monta kertaa läpsitään
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
	
	/** 
	 * Läpsäisysarja
	 * Pyöräyttää kättä 180 ja palaa takaisin. 
	 * Sitten deg-arvon verran eteenpäin. 
	 * Lopuksi palaa alkuasentoon.
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
	
	/** 
	 * Sulkee läpsymoottorin
	 */
	public void shutSlap(){
		ms.close();
	}
	
	/** 
	 * Palauttaa läpsimismäärän
	 * @return slapCount Läpsittyjen kertojen määrä
	 */
	public int getSlapCount(){
		return this.slapCount;
	}	
}
