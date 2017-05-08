import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

/**
 * Läpsimismoottorin luokka
 * @version 1.0
 * @author Oskari
 * 
 */
public class slapMotor {
	
	RegulatedMotor ms = new EV3MediumRegulatedMotor(MotorPort.D);	//läpsymoottori
	
	int slapCount;	//läpsylaskuri
	
	/** 
	 * Perusläimäisy
	 * Moottori pyörähtää 180 astetta ja palaa sitten takaisin
	 * Lisä slapCounttia yhdellä
	 * @param num Määrittää kuinka monta kertaa läpsitään (int)
	 */
	public void Slap(int num){
		
		while (num >= 1) {
			
			// kommentoi näytölle
			LCD.clear();
			LCD.drawString("DIE, DIE, DIE!", 0, 2);
			
			slapCount++;	//lisää laskurin arvoa
			num -= 1;
			
			// läpsimiskäden liikuttaminen/rotaatio
			ms.setSpeed(900);
			ms.rotate(-180);
			ms.setSpeed(0);
			Delay.msDelay(800);
			
			// palauttaa käden alkuasentoon
			ms.setSpeed(200);
			ms.rotate(180);
			ms.setSpeed(0);
			Delay.msDelay(300);
			LCD.clear();
		}
	}
	
	/** 
	 * Muokattu läimäisysarja
	 * Läpsäisysarja
	 * Pyöräyttää kättä 180 ja palaa takaisin 
	 * Sitten deg-arvon verran eteenpäin 
	 * Lopuksi palaa alkuasentoon
	 * @param deg Astemäärä, jolla kättä käännetään perusliikkeen lisäksi (int)
	 */
	public void SpecificSlap(int deg){
		
			//kommentti näytölle
			LCD.clear();
			LCD.drawString("DIE, DIE, DIE!", 0, 2);
			
			slapCount++;	//laskurin arvon kasvatus
			
			//käden kääntö eteenpäin
			ms.setSpeed(900);
			ms.rotate(-180);
			ms.setSpeed(0);
			Delay.msDelay(200);

			//käden kääntö eteenpäin deg-muuttujan verran
			ms.setSpeed(900);
			ms.rotate(deg);
			ms.setSpeed(0);
			Delay.msDelay(200);
			LCD.clear();
			
			//käden palauttaminen taaksepäin deg-muuttujan verran
			ms.setSpeed(900);
			ms.rotate(-deg);
			ms.setSpeed(0);
			Delay.msDelay(200);
			LCD.clear();
			
			//käden palauttaminen alkuasentoon
			ms.setSpeed(300);
			ms.rotate(180);
			ms.setSpeed(0);
			Delay.msDelay(800);
	}
	
	/** 
	 * Sulkee läpsymoottorin
	 */
	public void shutSlap(){
		ms.close();
	}
	
	/** 
	 * Palauttaa läpsimismäärän
	 * @return slapCount Läpsittyjen kertojen määrä (int)
	 */
	public int getSlapCount(){
		return this.slapCount;
	}	
}
