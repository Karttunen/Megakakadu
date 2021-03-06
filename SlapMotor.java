import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

/**
 * L�psimismoottorin luokka
 * 
 * @version 1.0
 * @author Oskari
 * 
 */
public class SlapMotor {
	
	private RegulatedMotor ms = new EV3MediumRegulatedMotor(MotorPort.D);	//l�psymoottori
	
	private int slapCount;	//l�psylaskuri
	
	/** 
	 * Suorittaa perusl�im�isyn k�dell�.
	 * Moottori py�r�ht�� 180 astetta ja palaa sitten takaisin.
	 * Lis�� slapCounttia yhdell�.
	 * 
	 * @param num M��ritt�� kuinka monta kertaa l�psit��n
	 */
	public void slap(int num){
		
		while (num >= 1) {
			
			// kommentoi n�yt�lle
			LCD.clear();
			LCD.drawString("DIE, DIE, DIE!", 0, 2);
			
			slapCount++;	//lis�� laskurin arvoa
			num -= 1;
			
			// l�psimisk�den liikuttaminen/rotaatio
			ms.setSpeed(900);
			ms.rotate(-180);
			ms.setSpeed(0);
			Delay.msDelay(800);
			
			// palauttaa k�den alkuasentoon
			ms.setSpeed(200);
			ms.rotate(180);
			ms.setSpeed(0);
			Delay.msDelay(300);
			LCD.clear();
		}
	}
	
	/** 
	 * Suorittaa l�im�isysarjan.
	 * Py�r�ytt�� k�tt� 180 ja palaa takaisin. 
	 * Sitten annetun astearvon verran eteenp�in. 
	 * Lopuksi palaa alkuasentoon.
	 * 
	 * @param deg Astem��r�, jolla k�tt� k��nnet��n perusliikkeen lis�ksi
	 */
	public void specificSlap(int deg){
		
			//kommentti n�yt�lle
			LCD.clear();
			LCD.drawString("DIE, DIE, DIE!", 0, 2);
			
			slapCount++;	//laskurin arvon kasvatus
			
			//k�den k��nt� eteenp�in
			ms.setSpeed(900);
			ms.rotate(-180);
			ms.setSpeed(0);
			Delay.msDelay(200);

			//k�den k��nt� eteenp�in deg-muuttujan verran
			ms.setSpeed(900);
			ms.rotate(deg);
			ms.setSpeed(0);
			Delay.msDelay(200);
			LCD.clear();
			
			//k�den palauttaminen taaksep�in deg-muuttujan verran
			ms.setSpeed(900);
			ms.rotate(-deg);
			ms.setSpeed(0);
			Delay.msDelay(200);
			LCD.clear();
			
			//k�den palauttaminen alkuasentoon
			ms.setSpeed(300);
			ms.rotate(180);
			ms.setSpeed(0);
			Delay.msDelay(800);
	}
	
	/** 
	 * Sulkee l�psymoottorin
	 */
	public void shutSlap(){
		ms.close();
	}
	
	/** 
	 * Palauttaa l�psimism��r�n.
	 * 
	 * @return slapCount L�psittyjen kertojen m��r�
	 */
	public int getSlapCount(){
		return this.slapCount;
	}	
}
