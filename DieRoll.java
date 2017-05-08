import java.util.concurrent.ThreadLocalRandom;

/**
 * @version 0.1
 * @author Veli Oskari Karttunen
 * 
 * T�m� on kaikkein t�rkein osa SlapMAchinea.
 * Ilman t�t�, laite ei pystyisi... ���...
 * ... k��ntym��n satunnaiseen suuntaan...
 * Se ei kuulosta erityisen hy�dylliselt�.
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
