import java.util.concurrent.ThreadLocalRandom;

/**
 * @version 0.1
 * @author Veli Oskari Karttunen
 * 
 * THIS is the most important part of the SlapMachine.
 * Without it, it wouldn't be able to... uhhh...
 * ... turn randomly...
 * That's barely even useful.
 *
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
