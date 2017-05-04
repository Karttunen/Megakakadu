import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

/**
 * @version 0.1
 * @author Veli Oskari Karttunen
 *
 *THIS is the most important part of the SlapMachine.
 *Without the slapMotor, there would be no slapping.
 *
 */

public class slapMotor {
	
	RegulatedMotor ms = new EV3MediumRegulatedMotor(MotorPort.D);
	
	int slapCount;
	

	
	/** destroys EVERYTHING
	 * 
	 * @param num
	 * 
	 * THIS is where the magic happens.
	 * The motor rotates 180 degrees, and then it rotates back.
	 * the constructor "num" determines how many slaps you'd like.
	 * It also increases the slapCount.
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
	
	/** Highly specific kind of slap
	 * 
	 * @param deg
	 * 
	 * For whatever reason that I cannot discern, I was asked to create a very specific kind of slap.
	 * This one first rotates 180 degrees, then it moves back whatever amount of degrees you determine to
	 * move back, then it rotates FORWARD again (by the detemined amount of degrees) and then it finally returns
	 * to its' original position.
	 * Why? I couldn't even begin to guess.
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
	
	/** shuts down the slap motor
	 */
	public void shutSlap(){
		ms.close();
	}
	
	/** returns the number of slaps since activation
	 * @return slapCount
	 */
	public int getSlapCount(){
		return this.slapCount;
	}
	
}
