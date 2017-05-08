import java.util.Random;

import lejos.hardware.Sound;

/**
 * Tuottaa ‰‰nisarjan
 * @author Helena
 *
 */
public class Noise {
	
	/**
	 * Tuottaa satunnaisia ‰‰ni‰ 10 per‰kk‰in
	 * ƒ‰nten taajuus vaihtelee ..5 kHz
	 * Kesto vaihtelee 30..100 msek
	 * @author Helena
	 */
	public void Mutise() {
		
		Random rand = new Random();	//satunnaisesti
		
		int aFrequency;
		int aDuration;
		//int aVolume;
		
		for (int i=0; i<10;i++){
			aFrequency = rand.nextInt(5000); //normaali ‰‰nialue 1..4 kHz
			aDuration = rand.nextInt(200);	//msek
			//aVolume = 30+rand.nextInt(70);	//prosentteina
			//Sound.playTone(aFrequency, aDuration, aVolume);
			Sound.playTone(aFrequency, aDuration, 100);
		}		
	}
}
