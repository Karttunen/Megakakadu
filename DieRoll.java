import java.util.concurrent.ThreadLocalRandom;

/**
 * Heitt‰‰ nopan, jonka tulosta k‰ytet‰‰n k‰‰ntymissuunnan valitsemiseen
 * 
 * @version 1.0
 * @author Veli Oskari Karttunen
 */
public class DieRoll {
	
	//Talletetaan arvottu tulos
	private int rand;
	
	/**
	 * Arpoo luvun yhdest‰ kolmeen ja asettaa arvon muuttujaan.
	 */
	public void roll(){
		rand = ThreadLocalRandom.current().nextInt(1, 3);
	}
	
	/**
	 * Palauttaa arvotun luvun
	 * @return Nopan arvo
	 */
	public int getRoll(){
		return this.rand;
	}
}
