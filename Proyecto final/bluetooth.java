//Librerias necesarias...........
import lejos.nxt.*;
import lejos.nxt.remote.NXTCommand;
import lejos.pc.comm.*;
import java.util.*;
//...............................

//Clase principal............................
public class bluetooth
{
	public static void main(String[] args)throws Exception
	{
	//Se declaran las variables necesarias............
	boolean conectado=false;
	//Se inicia hilo que une las dos clases...
	ClaseChida cc = new ClaseChida();
	Thread hilo=new Thread(cc);
	hilo.start();

	//SE HACE LA CONEXION BLUETHOOT
    NXTConnector b=new NXTConnector();
    
     if(!b.connectTo("gfdV",NXTComm.LCP))
	{
		conectado=false;
	}

	else
	    {
		conectado=true;
		}
				
		    NXTCommandConnector.setNXTCommand(new NXTCommand(b.getNXTComm()));	
	//empieza ciclo..........
	while(true){
		
	    //DEPENDIENDO DEL BOTON QUE ES OPRIMIDO,,,,,,,,,,,,,,,,,,
		if(cc.z==1)//avanza adelante
		{
			Motor.A.setSpeed(cc.vel);
			Motor.C.setSpeed(cc.vel);
			Motor.A.backward();
		    Motor.C.backward();
		    wait(200);
		}	

		if(cc.z==2)//atras.......
		{
			Motor.A.setSpeed(cc.vel);
			Motor.C.setSpeed(cc.vel);
			Motor.A.forward();
		    Motor.C.forward();	
		    wait(200);    
		}

		if(cc.z==3)//vuelta
		{
			Motor.A.setSpeed(cc.vel);
			Motor.C.setSpeed(cc.vel);
			Motor.A.forward();
		    Motor.C.backward();
		    wait(200);
		   
		    	
		}

		if(cc.z==4)//vuelta
		{
			Motor.A.setSpeed(cc.vel);
			Motor.C.setSpeed(cc.vel);
			Motor.A.backward();
		    Motor.C.forward();
		   wait(200);
		    	
		}

		if(cc.z==5)//frenar todo
		{
			Motor.A.stop();
	    	Motor.C.stop();
 			Motor.B.stop();
	    	wait(200);
	    	
		}

		if(cc.z==6)//disparar
		{
			if(cc.sonido==true)
			{
				Sound.playTone(800,600);
				wait(300);
				Sound.playTone(800,600);
				wait(300);
				Sound.playTone(800,600);
			}
			
			 Motor.A.stop();
	    	 Motor.C.stop();
			 Motor.B.setSpeed(cc.velDisparo);
			 Motor.B.rotate(180);
			 Motor.B.rotate(-180);
			 Motor.B.stop();
			 wait(cc.esperaDisparos);
			
			if(cc.sonido==true)
			{
				Sound.playTone(400,600);
			}		

		}


			
		
			
		}
			
		
		
	}
	//METODO STATIC PARA CREAR PAUSAS
	public static void wait(int t){
	try{
	Thread.sleep(t);
	}
	catch(Exception e){}
	}
}