
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
	
	public void run () {
			while (!stopSampling) {
				float[] sample = new float[ts.sampleSize()];
				ts.fetchSample(sample, 0);
				bumpSample = sample[0];

		}
	}
}