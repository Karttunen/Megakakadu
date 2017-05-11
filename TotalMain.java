import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Delay;

/**
 * 
 * Hallinnoi robotin toimintaa.
 * 
 * @version 1.0
 * @author Kakadu
 * 
 */
public class TotalMain {
	
	/**
	 * P��metodi hoitaa kaikki toiminnot.	
	 * @param args
	 */
	public static void main(String[] args) {

		boolean stopReverse = false;	//
		BumpSensor Bumble = new BumpSensor();	//kosketussensori
		Bumble.start();	//kosketussensorin k�ynnistys
		
		// rnn liikkumiseen
		//Komennot ovat: moveForward(), moveBackward(), turnLeft(), steerLeft(),
		//turnRight(), steerRight(), stawp(), shut()
		//Selitykset l�yt�� "Go2.java" luokasta
		Go2 rnn = new Go2();
		
		// slap l�iskimiseen ja l�iskinn�n laskemiseen.
		// Contruktorilla voi m��ritt�� l�iskimis m��r�n "slap.Slap(int)"
		//
		SlapMotor slap = new SlapMotor();
		
		// die on noppa. Sit� k�ytet��n m��ritt�m��n mihin suuntaan k��nyt��n, kun etsit��n kohdetta.

		DieRoll die = new DieRoll();
		die.roll();
		
		// LEDej�. Ne ovat valoja.

		Leds leds = new Leds();
		
		// ��net
		
		Noise rawr = new Noise();
		
		//telem. Lyhenne "telemetriasta". Varmaan v��r� sana t�ss� yhteydess�, mutta ihan sama.
		//Se chekkaa et�isyytt�.

		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S1);
		IrSensor telem = new IrSensor(irSensor);
		telem.start();
		
		rawr.mutise();
		
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
			if (telem.getDistance() > 49.0f){
				if (die.getRoll() == 1) {
					rnn.turnRight();
					leds.searchLight();
				}
				if (die.getRoll() == 2) {
					rnn.turnLeft();
					leds.searchLight();
				}
			}
			
			// l�hesty kohdetta
			if (telem.getDistance() > 8.0f && telem.getDistance() < 49.0f) {
				//rawr.Mutise();
				rnn.moveForward();
				leds.approach();
				
			}
			
			//tuhoa kohde
			//slap.Slap(int)
			if (telem.getDistance() < 8.0f){
				rnn.stawp();
				rawr.mutise();
				
				die.roll();
				slap.slap(die.getRoll());
				
				leds.slap();
				
				long start = System.currentTimeMillis();
				long end = start + 4000;
				stopReverse = false;
				LCD.clear();
				LCD.drawString(" " + Bumble.getSample(), 0, 0);
				
				while (System.currentTimeMillis() < end && stopReverse == false) {
					rnn.moveBackward();
					if (Bumble.getSample() == 1 || Button.ENTER.isDown()) {
						rnn.moveForward();
						Delay.msDelay(2000);
						stopReverse = true;
					}
				}
				die.roll();				
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
