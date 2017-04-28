
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

public class totalMain {
	public static void main(String[] args) {
		
		go2 rnn = new go2();
		slapMotor slap = new slapMotor();
		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S1);
		IRSensor telem = new IRSensor(irSensor);
		
		while (!Button.ESCAPE.isDown()) {
			
			LCD.clear();
			LCD.drawString("" + telem.GetDistance(), 0, 0);
			LCD.drawString("WHAT SHALL I", 0, 2);
			LCD.drawString("DESTROY THIS TIME?", 0, 3);
			Delay.msDelay(50);
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
