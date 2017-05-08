import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

/**
 * @version 0.1
 * @author Markus NolÈn
 */
public class RCMode {
	
	//public static void main(String[] args) {
		
		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S1); //sensori		
		IrsChecker checkerThread = new IrsChecker(irSensor, true); //s‰ie		
		//Motor moottorit = new Motor(); //moottorit		
		checkerThread.start(); // k‰ynnistet‰‰n IR-lukija -s‰ie
		
		int rivi = 0;
		LCD.drawString("Lopetus ENTER", 0, rivi++);
		rivi++;
		float etaisyys;
		
		while (Button.ENTER.isUp()) {
			
			switch (checkerThread.getSensor()) {
			case 1:
				LCD.drawString("C1 K‰‰nny vasempaan", 0, rivi);
				//rnn.turnLeft();
				break;
			case 2:
				LCD.drawString("C2 K‰‰nny oikeaan", 0, rivi);
				//rnn.turnRight();
				break;
			case 3:
				LCD.drawString("C3 Aja eteenp‰in", 0, rivi);
				//rnn.moveForward();
				break;
			case 4:
				LCD.drawString("C4     ", 0, rivi);
				break;
			default:
				break;
			}
			
			etaisyys = checkerThread.getDistSample();
			LCD.drawString("distance: " + etaisyys + "     ", 0, rivi+2);
			if (etaisyys < 10) {
				moottorit.pysahdy();			
			}
			Delay.msDelay(200);			
		}
		
		checkerThread.setRunning(false); //lopetus
				
		//lopetustoimet
		//moottorit.sammuta();
		//irSensor.close();
		
	}
}
	