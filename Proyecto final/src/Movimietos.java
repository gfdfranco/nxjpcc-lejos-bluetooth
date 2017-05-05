import lejos.hardware.motor.*;
import lejos.utility.Delay;

public class Movimietos {
	
	
	public static void avanzar(){
		Motor.B.setSpeed(900);
		Motor.B.forward();
	}
	public static  void detener(){
		Motor.B.stop();
	}
	public static  void atras(){
		girar();
		Delay.msDelay(2000);
	}
	public static void disparar(){
		Motor.D.setSpeed(900);
		Motor.D.rotate(-100);
	
	}
	public static void girar(){
		Motor.B.setSpeed(900);
		Motor.B.backward();
	}
	public static void cerrar(){
		Motor.A.setSpeed(900);
		Motor.A.rotate(-100);
	}
	public static void abrir(){
		Motor.A.setSpeed(900);
		Motor.A.rotate(100);
	}
	
	
}