import java.util.concurrent.ThreadLocalRandom;
/**
*Tämä olio randomisoi joka mahdollistaa robotin kääntymisen eri suuntiin sattumanvaraisesti
*Luonut Oskari Karttunen
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
