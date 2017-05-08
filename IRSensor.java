
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;

/**
 * @version 0.1
 * @author Veli Oskari Karttuen
 * 
 * Tämä on kaikkein tärkein osa SlapMAchinea.
 * Ilman tätä, SlapMachine olisi sokea.
 *
 */

public class IRSensor extends Thread {

	private EV3IRSensor infraredSensor;
	float distance;
	boolean stopSampling = false;
	
	public IRSensor(EV3IRSensor sensor) {
		this.infraredSensor = sensor;
	}
	
	/** palauttaa etäisyyslukeman
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
