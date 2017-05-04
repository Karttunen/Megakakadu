
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;

/**
 * @version 0.1
 * @author Veli Oskari Karttuen
 * 
 * THIS is the most important part of the SlapMachine.
 * Without it, the SlapMachine would be BLIND!
 *
 */

public class IRSensor extends Thread {

	private EV3IRSensor infraredSensor;
	float distance;
	boolean stopSampling = false;
	
	public IRSensor(EV3IRSensor sensor) {
		this.infraredSensor = sensor;
	}
	
	/** return readings
	 * @return distance
	 */
	public float GetDistance () {
		return this.distance;
	}
	
	/** shuts down the IRSensor
	 */
	public void stopSampling(){
		stopSampling = true;
	}
	
	/** take readings
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
