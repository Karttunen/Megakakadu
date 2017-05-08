package test;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class test1 {
	public static void main(String[] args) {

		RegulatedMotor mot = new EV3MediumRegulatedMotor(MotorPort.A);
		EV3TouchSensor ts = new EV3TouchSensor(SensorPort.S2);
		float[] sample = new float[ts.sampleSize()];
		int i = 0;			//Integer for loop

		while (i == 0) {
			
			while (!Button.ESCAPE.isDown()) {
				ts.fetchSample(sample, 0);
				
				//When touch sensor is pressed
				if (sample[0] == 1) {
					Button.LEDPattern(5);	//Red lights flash 
					LCD.clear();
					LCD.drawString("Törmäys!", 0, 0);	//Message displayed on screen
					// rnn.moveForward();	//Robot moves forward
					Delay.msDelay(5000);	//Stops after 5 seconds
					LCD.clear();	
					Button.LEDPattern(0);
				
				}

			}
		}
	}
}
