import java.util.Random;
import lejos.hardware.Sound;

/**
 * Tuottaa ‰‰nisarjan
 * 
 * @version 1.0
 * @author Helena
 *
 */
public class Noise {
	
	/**
	 * Tuottaa satunnaisia ‰‰ni‰ 10 per‰kk‰in. 
	 * ƒ‰nten taajuus vaihtelee 1..5 kHz. 
	 * Kesto vaihtelee 30..200 msek. 
	 * Volyymi 100 %. 
	 * 
	 */
	public void mutise() {
		
		Random rand = new Random();	//luodaan satunnaisgeneraattori
		
		int aFrequency;	//‰‰nen taajuus Hertzein‰
		int aDuration;	//kesto
		//int aVolume;	//voimakkuus
		
		for (int i=0; i<10;i++){
			aFrequency = 1000+rand.nextInt(5000); 	// normaali ‰‰nialue on 1..4 kHz
			aDuration = 30+rand.nextInt(200);		// millisekunteina
			//aVolume = rand.nextInt(30, 100);		// prosentteina 100 => t‰ysill‰
			//Sound.playTone(aFrequency, aDuration, aVolume);
			Sound.playTone(aFrequency, aDuration, 100);
		}		
	}
}
