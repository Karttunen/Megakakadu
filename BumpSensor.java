import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
/**
*
* Täältä katsotaan onko kosketussensoria painettu vai ei.
*
* @version 0.1
* @author Mikael Rämö
*/

public class BumpSensor extends Thread{
	

	
	EV3TouchSensor ts = new EV3TouchSensor(SensorPort.S2);
	

	boolean stopSampling = false;
	float bumpSample;
	
	/** Pysäyttää homman.
	*/
	public void stopSampling(){
		stopSampling = true;
	}
	
	/** Palauttaa painallus tuloksen.
	*/
	public float getSample(){
		return this.bumpSample;
	}
	
	/** Etsii koko ajan painalluksen tulosta.
	*/
	public void run () {
			while (!stopSampling) {
				float[] sample = new float[ts.sampleSize()];
				ts.fetchSample(sample, 0);
				bumpSample = sample[0];

		}
	}
}
