import java.util.Random;

import lejos.hardware.Sound;
//import lejos.utility.Delay;

/** 
 * Ääntelee
 * @author Helena
 * */
public class Noise {
	
	/**
	 * Tuottaa satunnaisia ääniä 10 peräkkäin
	 * Äänten taajuus vaihtelee ..5 kHz
	 * Kesto vaihtelee 30..100 msek
	 * @author Helena
	 */
	public void Mutise() {
		
		Random rand = new Random();	//satunnaisesti
		
		int aFrequency;
		int aDuration;
		//int aVolume;
		
		for (int i=0; i<10;i++){
			aFrequency = rand.nextInt(5000); //normaali äänialue 1..4 kHz
			aDuration = rand.nextInt(200);	//msek
			//aVolume = 30+rand.nextInt(70);	//prosentteina
			//Sound.playTone(aFrequency, aDuration, aVolume);
			Sound.playTone(aFrequency, aDuration, 100);
		}		
	}
}
