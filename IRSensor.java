
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;

/**
 * @version 0.1
 * @author Veli Oskari Karttuen
 * 
 * T�m� on kaikkein t�rkein osa SlapMAchinea.
 * Ilman t�t�, SlapMachine olisi sokea.
 *
 */

public class IRSensor extends Thread {

	private EV3IRSensor infraredSensor;
	float distance;
	boolean stopSampling = false;
	
	public IRSensor(EV3IRSensor sensor) {
		this.infraredSensor = sensor;
	}
	
	/** palauttaa et�isyyslukeman
	 * @return distance
	 */
	public float GetDistance () {
		return this.distance;
	}
	
	/** Sulkee IRSensorin
	 */
	public void stopSampling(){
		stopSampling = true;
	}
	
	/** Ota lukemia
	 */
	public void run() {
		while (!stopSampling) {
			SampleProvider dist = infraredSensor.getDistanceMode();
			float[] distSample = new float[dist.sampleSize()];
			dist.fetchSample(distSample, 0);
			distance = distSample[0];
		}
	}
}
