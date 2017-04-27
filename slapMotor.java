import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class slapMotor {
	
	RegulatedMotor ms = new EV3MediumRegulatedMotor(MotorPort.D);
	
	public static slapMotor start(){
		return new slapMotor();
	}
	
	public void Slap(){
		ms.setSpeed(500);
		ms.rotate(40);
		Delay.msDelay(200);
		ms.rotate(-40);
	}
	public void shutSlap(){
		ms.close();
	}
	
}
