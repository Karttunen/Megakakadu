import java.util.concurrent.ThreadLocalRandom;


public class DieRoll {
	
	private int rand;
	
	public static DieRoll start(){
		return new DieRoll();
	}
	
	public void Roll(){
		rand = ThreadLocalRandom.current().nextInt(1, 3);
	}
	
	public int getRoll(){
		//Roll();
		return this.rand;
	}
	
	
}
