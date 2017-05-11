import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

/**
 *
 * Moottorien k‰ytt‰minen. 
 *
 * @version 1.0
 * @author Veli Oskari Karttunen
 * 
 */

public class Go2 extends Thread {
	
	private RegulatedMotor ma = new EV3MediumRegulatedMotor(MotorPort.A);
	private RegulatedMotor mb = new EV3MediumRegulatedMotor(MotorPort.B);
	private RegulatedMotor mc = new EV3MediumRegulatedMotor(MotorPort.C);
	
	private boolean stopReverse = false; //pys‰ytysmoodi
	
	
	/** 
	 * K‰‰ntyy vasempaan.
	 */
	public void turnLeft(){
		ma.setSpeed(600);
		mb.setSpeed(0);
		mc.setSpeed(400);
		ma.forward();
		mb.backward();
		mc.backward();
	}
	/** 
	 * K‰‰ntyy vasempaan, samaan aikaan kuin liikkuu.
	 */
	public void steerLeft(){
		ma.setSpeed(400);
		mb.setSpeed(200);
		mc.setSpeed(400);
		ma.forward();
		mb.backward();
		mc.backward();
	}
	/** K‰‰ntyy oikealle.
	 */
	public void turnRight(){
		ma.setSpeed(400);
		mb.setSpeed(0);
		mc.setSpeed(600);
		ma.backward();
		mb.forward();
		mc.forward();
	}
	/** K‰‰ntyy oikealle, samaan aikaan kuin liikkuu.
	 */
	public void steerRight(){
		ma.setSpeed(400);
		mb.setSpeed(200);
		mc.setSpeed(400);
		ma.backward();
		mb.forward();
		mc.forward();
	}
	/** 
	 * Menee suoraan eteenp‰in.
	 */
	public void moveForward(){
		ma.setSpeed(400);
		mb.setSpeed(400);
		mc.setSpeed(400);
		ma.backward();
		mb.forward();
		mc.backward();
	}
	/** Per‰‰ntyy.
	 */
	public void moveBackward(){
		ma.setSpeed(400);
		mb.setSpeed(400);
		mc.setSpeed(400);
		ma.forward();
		mb.backward();
		mc.forward();
	}
	/** Pys‰htyy.
	 */
	public void stawp(){
		ma.setSpeed(0);
		mb.setSpeed(0);
		mc.setSpeed(0);
	}
	/** 
	 * Sulkee moottorin.
	 */
	public void shut(){
		ma.close();
		mb.close();
		mc.close();
	}

	/**
	 * Pys‰ytt‰‰.
	 */
	public void stopRev(){
		stopReverse = true;
	}
}
