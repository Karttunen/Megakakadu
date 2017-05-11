import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;

/**
 * 
 * Infrapunasensorin k‰sittely.
 *
 * @version 1.0
 * @author Veli Oskari Karttunen
 * 
 */
public class IrSensor extends Thread {

	private EV3IRSensor infraredSensor;	//kahva sensoriin
	private float distance;	//pit‰‰ et‰isyyden muistissa
	private boolean stopSampling;	//Infrapuna-anturin sulkeminen
	
	/**
	 * Luo olion. 
	 * @param sensor Sensorikahva.
	 */
	public IrSensor(EV3IRSensor sensor) {
		this.infraredSensor = sensor;
		this.stopSampling = false;
	}
	
	/** 
	 * Palauttaa et‰isyyslukeman.
	 * @return distance Et‰isyys kohteeseen.
	 */
	public float GetDistance () {
		return this.distance;
	}
	
	/** 
	 * Sulkee IRSensorin.
	 */
	public void stopSampling(){
		stopSampling = true;
	}
	
	/** 
	 * Mittaa et‰isyytt‰.
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
