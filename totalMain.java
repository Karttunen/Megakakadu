
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.utility.Delay;

/**
 * 
 * @version 0.1
 * @author Kakadu
 *
 * Tervetuloa totalMainiin.
 * Tämä on main.
 * Jos et jo arvannut.
 *
 */

public class totalMain {
	public static void main(String[] args) {
		

		
		//BumpSensor Bumble = new BumpSensor();
		
		// rnn liikkumiseen
		//Komennot ovat: moveForward(), moveBackward(), turnLeft(), steerLeft(),
		//turnRight(), steerRight(), stawp(), shut()
		//Selitykset löytää "go2.java" luokasta
		go2 rnn = new go2();
		
		// slap läiskimiseen ja läiskinnän laskemiseen.
		// Contruktorilla voi määrittää läiskimis määrän "slap.Slap(int)"
		//
		slapMotor slap = new slapMotor();
		
		// die on noppa. Sitä käytetään määrittämään mihin suuntaan käänytään, kun etsitään kohdetta.

		DieRoll die = new DieRoll();
		die.Roll();
		
		// LEDejä. Ne ovat valoja.

		LEDS leds = new LEDS();
		
		Noise rawr = new Noise();
		
		//telem. Lyhenne "telemetriasta". Varmaan väärä sana tässä yhteydessä, mutta ihan sama.
		//Se chekkaa etäisyyttä.

		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S1);
		IRSensor telem = new IRSensor(irSensor);
		telem.start();
		
		rawr.Mutise();
		
		//paina ESCAPE lopettamaan

		while (!Button.ESCAPE.isDown()) {
			
			LCD.clear();
			LCD.drawString("Distance: " + telem.GetDistance(), 0, 0);
			LCD.drawString("WHAT SHALL I", 0, 2);
			LCD.drawString("DESTROY THIS TIME?", 0, 3);
			LCD.drawString("slap count: " + slap.getSlapCount(), 1, 5);
			LCD.drawString("die: " + die.getRoll(), 1, 6);
			Delay.msDelay(50);
			
			//etsi kohdetta

			if (telem.GetDistance() > 49.0f){
				if (die.getRoll() == 1) {
					rnn.turnRight();
					leds.searchlight();
				}
				if (die.getRoll() == 2) {
					rnn.turnLeft();
					leds.searchlight();
				}
			}
			// lähesty kohdetta
			if (telem.GetDistance() > 8.0f && telem.GetDistance() < 49.0f) {
				//rawr.Mutise();
				rnn.moveForward();
				leds.approach();
				
			}
			//tuhoa kohde
			//slap.Slap(int)
			if (telem.GetDistance() < 8.0f){
				rnn.stawp();
				rawr.Mutise();
				
				die.Roll();
				slap.Slap(die.getRoll());
				//slap.SpecificSlap(80);
				
				leds.slap();
				


				rnn.reverseMenouver();
				die.Roll();
				//Delay.msDelay(1500);

				
			}
		}
		// sulkee kaiken
		leds.shutDown();
		rnn.shut();
		slap.shutSlap();
		telem.stopSampling();
		Delay.msDelay(500);
		irSensor.close();
	}
}
