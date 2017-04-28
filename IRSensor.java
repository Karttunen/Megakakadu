
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;

public class IRSensor extends Thread {

	private EV3IRSensor infraredSensor;
	float distance;
	boolean stopSampling = false;
	
	public IRSensor(EV3IRSensor sensor) {
		this.infraredSensor = sensor;
	}
	
	// return readings
	public float GetDistance () {
		return this.distance;
	}
	
	// shuts down the IRSensor
	public void stopSampling(){
		stopSampling = true;
	}
	
	// take readings
	public void run() {
		while (!stopSampling) {
			SampleProvider dist = infraredSensor.getDistanceMode();
			float[] distSample = new float[dist.sampleSize()];
			dist.fetchSample(distSample, 0);
			distance = distSample[0];
		}
	}
}
