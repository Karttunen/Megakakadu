import java.util.concurrent.ThreadLocalRandom;


public class DieRoll {
	
	private int rand;
	
	public void Roll(){
		rand = ThreadLocalRandom.current().nextInt(1, 3);
	}
	
	public int getRoll(){
		return this.rand;
	}
}
