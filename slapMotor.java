import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class slapMotor {
	
	RegulatedMotor ms = new EV3MediumRegulatedMotor(MotorPort.D);
	
	int slapCount;
	
	public static slapMotor start(){
		return new slapMotor();
	}
	
	// destroys EVERYTHING
	public void Slap(){
		
		// taunt
		LCD.clear();
		LCD.drawString("YOUR WORLD IS", 0, 2);
		LCD.drawString("DOOMED!", 0, 3);
		LCD.drawString("DIE, DIE, DIE!", 0, 4);
		
		slapCount++;
		
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
	
	// shuts down the slap motor
	public void shutSlap(){
		ms.close();
	}
	
	// returns the number of slaps since activation
	public int getSlapCount(){
		return this.slapCount;
	}
	
}
