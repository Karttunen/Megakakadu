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
	
	public void Slap(){
		
		LCD.clear();
		LCD.drawString("YOUR WORLD IS", 0, 2);
		LCD.drawString("DOOMED!", 0, 3);
		LCD.drawString("DIE, DIE, DIE!", 0, 4);
		slapCount++;
		
		ms.setSpeed(900);
		ms.rotate(-180);
		ms.setSpeed(0);
		Delay.msDelay(800);
		
		ms.setSpeed(200);
		ms.rotate(180);
		ms.setSpeed(0);
		Delay.msDelay(300);
		LCD.clear();
	}
	public void shutSlap(){
		ms.close();
	}
	
	public int getSlapCount(){
		return this.slapCount;
	}
	
}
