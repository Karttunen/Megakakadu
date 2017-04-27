import lejos.hardware.Button;

public class totalMain {
	public static void main(String[] args) {
		//lelelelele
		go2 rnn = new go2();
		slapMotor slap = new slapMotor();
		
		while (!Button.ESCAPE.isDown()) {
			int keycode = Button.waitForAnyPress();
			
			if (keycode == 1) {
				rnn.moveForward();
			}
			if (keycode == 2){
				rnn.stawp();
			}
			if (keycode == 4) {
				rnn.moveBackward();
			}
			if (keycode == 8) {
				slap.Slap();
			}
			if (keycode == 16) {
				rnn.turnLeft();
			}
		}
		rnn.shut();
		slap.shutSlap();
	}
}
