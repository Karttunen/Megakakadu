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
	 * Tuottaa satunnaisia ‰‰ni‰ 10 per‰kk‰in
	 * ƒ‰nten taajuus vaihtelee 1..5 kHz
	 * Kesto vaihtelee 30..100 msek
	 * Volyymi on 100 %
	 * 
	 */
	public void Mutise() {
		
		Random rand = new Random();	//luodaan satunnaisgeneraattori
		
		int aFrequency;	//‰‰nen taajuus Hertzein‰
		int aDuration;	//kesto
		//int aVolume;	//voimakkuus
		
		for (int i=0; i<10;i++){
			aFrequency = rand.nextInt(1000, 5000); 	//normaali ‰‰nialue on 1..4 kHz
			aDuration = rand.nextInt(20, 200);		//millisekunteina
			//aVolume = rand.nextInt(30, 100);	//prosentteina 100=>t‰ysill‰
			//Sound.playTone(aFrequency, aDuration, aVolume);
			Sound.playTone(aFrequency, aDuration, 100);
		}		
	}
}
