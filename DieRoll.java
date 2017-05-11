import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * Tämä on kaikkein tärkein osa SlapMAchinea.
 * Ilman tätä, laite ei pystyisi... ööö...
 * ... kääntymään satunnaiseen suuntaan...
 * Se ei kuulosta erityisen hyödylliseltä.
 * 
 * @version 0.1
 * @author Veli Oskari Karttunen
 *
 */

public class DieRoll {
	
	private int rand;
	
	/**
	*Tuottaa satunnaisen numeron.
	*/
	public void Roll(){
		rand = ThreadLocalRandom.current().nextInt(1, 3);
	}
	
	/**
	* Palauttaa numeron.
	*/
	public int getRoll(){
		return this.rand;
	}
}
