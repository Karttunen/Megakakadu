import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;

/**
 * Infrapuna-anturia k‰ytet‰‰n et‰isyyden mittaamiseen
 * Avaa s‰ikeen
 * 
 * @version 1.0
 * @author Veli Oskari Karttuen
 */
public class IRSensor extends Thread {

	private EV3IRSensor infraredSensor; 
	float distance; 					//pit‰‰ et‰isyyden muistissa
	boolean stopSampling = false; 		//Infrapuna-anturin sulkeminen
	
	
	/**
	 * M‰‰rittelee infrapuna-anturin
	 * @param sensor
	 */
	public IRSensor(EV3IRSensor sensor) {
		this.infraredSensor = sensor;
	}
	
	/** 
	 * Palauttaa et‰isyyslukeman
	 * @return Luokan distance-muuttujan arvo (float)
	 */
	public float GetDistance () {
		return this.distance;
	}
	
	/** 
	 * Sulkee infrapuna-anturin
	 */
	public void stopSampling(){
		stopSampling = true;
	}
	
	/** 
	 * Ottaa lukemia
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