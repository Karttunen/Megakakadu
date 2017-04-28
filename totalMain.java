
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

public class totalMain {
	public static void main(String[] args) {
		
		// rnn for movement
		// commands are: moveForward(), moveBackward(), turnLeft(), steerLeft(),
		// turnRight(), steerRight(), stawp(), shut()
		go2 rnn = new go2();
		
		// slap for slapping and slap counting
		slapMotor slap = new slapMotor();
		
		// sensor for looking
		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S1);
		IRSensor telem = new IRSensor(irSensor);
		telem.start();
		
		// press ESCAPE on the EV3 to quit
		while (!Button.ESCAPE.isDown()) {
			
			LCD.clear();
			
			// prints distance, but doesn't refresh without input ATM
			LCD.drawString("Distance: " + telem.GetDistance(), 0, 0);
			
			LCD.drawString("WHAT SHALL I", 0, 2);
			LCD.drawString("DESTROY THIS TIME?", 0, 3);
			Delay.msDelay(50);
			
			//This is currently interfering with telem.GetDistance()
			//we're not gonna use waitForAnyPress() in the final release, tho
			int keycode = Button.waitForAnyPress();
			
			if (keycode == 1) {
				//rnn.moveForward();
				slap.Slap();
			}
			if (keycode == 2){
				//rnn.stawp();
				LCD.clear();
				LCD.drawString("TOTAL SLAPS SINCE", 0, 2);
				LCD.drawString("ACTIVATION: " + slap.getSlapCount(), 0, 3);
				Delay.msDelay(2000);
			}
			if (keycode == 4) {
				//rnn.moveBackward();
			}
			if (keycode == 8) {
				//slap.Slap();
			}
			if (keycode == 16) {
				//rnn.turnLeft();
			}
		}
		rnn.shut();
		slap.shutSlap();
		telem.stopSampling();
		Delay.msDelay(500);
		irSensor.close();
	}
}
