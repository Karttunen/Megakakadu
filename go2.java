import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class go2 {
	
	RegulatedMotor ma = new EV3MediumRegulatedMotor(MotorPort.A);
	RegulatedMotor mb = new EV3MediumRegulatedMotor(MotorPort.B);
	RegulatedMotor mc = new EV3MediumRegulatedMotor(MotorPort.C);
	
	public static go2 start(){
		return new go2();
	}
	
	public void turnLeft(){
		ma.setSpeed(400);
		mb.setSpeed(0);
		mc.setSpeed(400);
		ma.forward();
		mb.backward();
		mc.backward();
	}
	public void steerLeft(){
		ma.setSpeed(400);
		mb.setSpeed(200);
		mc.setSpeed(400);
		ma.forward();
		mb.backward();
		mc.backward();
	}
	public void turnRight(){
		ma.setSpeed(400);
		mb.setSpeed(0);
		mc.setSpeed(400);
		ma.backward();
		mb.forward();
		mc.forward();
	}
	public void steerRight(){
		ma.setSpeed(400);
		mb.setSpeed(200);
		mc.setSpeed(400);
		ma.backward();
		mb.forward();
		mc.forward();
	}
	public void moveForward(){
		ma.setSpeed(400);
		mb.setSpeed(400);
		mc.setSpeed(400);
		ma.backward();
		mb.forward();
		mc.backward();
	}
	public void moveBackward(){
		ma.setSpeed(400);
		mb.setSpeed(400);
		mc.setSpeed(400);
		ma.forward();
		mb.backward();
		mc.forward();
	}
	public void stawp(){
		ma.setSpeed(0);
		mb.setSpeed(0);
		mc.setSpeed(0);
	}
	public void shut(){
		ma.close();
		mb.close();
		mc.close();
	}
}
