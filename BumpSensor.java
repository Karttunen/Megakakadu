
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
//import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class BumpSensor extends Thread{
	
	//RegulatedMotor mot = new EV3MediumRegulatedMotor(MotorPort.A);
	
	//go2 rnn = new go2();
	EV3TouchSensor ts = new EV3TouchSensor(SensorPort.S2);
	
	int i = 0;			//Integer for loop
	boolean stopSampling = false;
	float bumpSample;
	
	
	public void stopSampling(){
		stopSampling = true;
	}
	
	public float getSample(){
		return this.bumpSample;
	}
	
	public void Bumped () {
		while (i == 0) {
			while (!stopSampling) {
				float[] sample = new float[ts.sampleSize()];
				ts.fetchSample(sample, 0);
				//When touch sensor is pressed
				bumpSample = sample[0];
				
				
				
//				if (sample[0] == 1) {
//					Button.LEDPattern(5);	//Red lights flash 
//					LCD.clear();
//					LCD.drawString("Bump!", 0, 0);	//Message displayed on screen
//					//rnn.stopRev();
//					//rnn.moveForward();	//Robot moves forward
//					Delay.msDelay(5000);	//Stops after 5 seconds
//					LCD.clear();
//					Button.LEDPattern(0);
//				}
				
				
			}
		}
	}
}