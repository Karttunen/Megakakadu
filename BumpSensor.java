import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;

/**
*
* Kosketussensori k�sittely.
*
* @version 1.0
* @author Mikael R�m�
* 
*/
public class BumpSensor extends Thread {	
	
	EV3TouchSensor ts = new EV3TouchSensor(SensorPort.S2);
	
	private boolean stopSampling = false;
	private float bumpSample;

	/**
	 * Pys�ytt�� sensorin.
	 */
	public void stopSampling(){
		stopSampling = true;
	}
	
	/** 
	 * Palauttaa painallus tuloksen.
	 */
	public float getSample(){
		return this.bumpSample;
	}
	
	/** 
	 * Lukee kosketussensorin arvoa.
	 */
	public void run () {
			
		while (!stopSampling) {		 		
			float[] sample = new float[ts.sampleSize()];				
			ts.fetchSample(sample, 0);				
			bumpSample = sample[0];
		}
	}
}
