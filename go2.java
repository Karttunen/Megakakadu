import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

/**
*Tämä olio määrittelee kuinka moottoreita käytetään robotin liikuttamiseen
*Luonut Oskari Karttunen
*/

public class go2 {
	
	RegulatedMotor ma = new EV3MediumRegulatedMotor(MotorPort.A);
	RegulatedMotor mb = new EV3MediumRegulatedMotor(MotorPort.B);
	RegulatedMotor mc = new EV3MediumRegulatedMotor(MotorPort.C);
	
	
	// turn left, while front wheel's speed is 0
	public void turnLeft(){
		ma.setSpeed(600);
		mb.setSpeed(0);
		mc.setSpeed(400);
		ma.forward();
		mb.backward();
		mc.backward();
	}
	// turn left, while front wheel continues to move forward
	public void steerLeft(){
		ma.setSpeed(400);
		mb.setSpeed(200);
		mc.setSpeed(400);
		ma.forward();
		mb.backward();
		mc.backward();
	}
	// turn right, while front wheel's speed is 0
	public void turnRight(){
		ma.setSpeed(400);
		mb.setSpeed(0);
		mc.setSpeed(600);
		ma.backward();
		mb.forward();
		mc.forward();
	}
	// turn right, while front wheel continues to move forward
	public void steerRight(){
		ma.setSpeed(400);
		mb.setSpeed(200);
		mc.setSpeed(400);
		ma.backward();
		mb.forward();
		mc.forward();
	}
	// move forward
	public void moveForward(){
		ma.setSpeed(400);
		mb.setSpeed(400);
		mc.setSpeed(400);
		ma.backward();
		mb.forward();
		mc.backward();
	}
	// move backward
	public void moveBackward(){
		ma.setSpeed(400);
		mb.setSpeed(400);
		mc.setSpeed(400);
		ma.forward();
		mb.backward();
		mc.forward();
	}
	// stop
	public void stawp(){
		ma.setSpeed(0);
		mb.setSpeed(0);
		mc.setSpeed(0);
	}
	// shut down
	public void shut(){
		ma.close();
		mb.close();
		mc.close();
	}
}
