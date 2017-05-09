import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;

/**
 * Infrapuna-anturia käytetään etäisyyden mittaamiseen
 * Avaa säikeen
 * 
 * @version 1.0
 * @author Veli Oskari Karttuen
 */
public class IrSensor extends Thread {

	private EV3IRSensor infraredSensor; 
	float distance; 					//pitää etäisyyden muistissa
	boolean stopSampling = false; 		//Infrapuna-anturin sulkeminen
	
	
	/**
	 * Määrittelee infrapuna-anturin
	 * @param sensor
	 */
	public IRSensor(EV3IRSensor sensor) {
		this.infraredSensor = sensor;
	}
	
	/** 
	 * Palauttaa etäisyyslukeman
	 * @return Luokan distance-muuttujan arvo (float)
	 */
	public float getDistance () {
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
