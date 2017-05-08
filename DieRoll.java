import java.util.concurrent.ThreadLocalRandom;

/**
 * ... kääntymään satunnaiseen suuntaan...
 * Se ei kuulosta erityisen hyödylliseltä.
 * @version 0.1
 * @author Veli Oskari Karttunen
 */
public class DieRoll {
	
	private int rand;
	
	public void Roll(){
		rand = ThreadLocalRandom.current().nextInt(1, 3);
	}
	
	public int getRoll(){
		return this.rand;
	}
}
