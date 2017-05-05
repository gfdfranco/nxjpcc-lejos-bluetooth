
//LIBRERIAS NECESARIAS....................................
import java.io.IOException;
import java.util.Locale;

import lejos.hardware.*;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.*;
import lejos.robotics.SampleProvider;
import lejos.utility.*;
import lejos.hardware.device.*;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.*;
import lejos.utility.Delay;
//.............................................................

@SuppressWarnings("unused") //QUITAMOS ADVERTENSIAS INECESARIAS

//CLASE MAIN...........................
public class Main extends Movimietos{ 	//HEREDAMOS DE LA CLASE MOVIMIENTOS...................	 

    //IMPORTAMOS LAS CLASES NECESARIAS QUE VAMOS A UTILIZAR A UN OBJETO
	
	static EV3IRSensor sensor;//ESTA CLASE ES PARA EL SENSOR IR DE EV3
	static float frecuencia=1; //sample por segundo
	static SampleProvider sp; //// SE NECESITA PARA OBTENER LOS VALORES A ULTRASONICO DE SENSOR IREV3
	static float[] sample;
	//EMPIEZA NUESTRA CLASE PRINCIPAL.............................................
	public static void main(String[] args) throws IOException {
			
        sensor = new EV3IRSensor(SensorPort.S4);//declaramos que el sensor infrarrojo esta en el puerto 4
        sp = new PublishFilter(sensor.getDistanceMode(), "IR valores", frecuencia); 
        			//PublishFilter Es una clase que esta en github que leJOS recomineda usar para cambiar el modo del sensor
        			//ESTA SUPER PODEROSA LA CLASE VEANLA, Y CON ESTO PODRAN CREAR SUS PROPIAS LIBRERIAS 
        sample = new float[sp.sampleSize()];//en un arreglo de float se obtiene los valores que esta dando el sensor
        				//ESTO LEJOS CON EV3 ES SUMAMENTE PODEROSO YA QUE SACA UN PROMEDIO ANTES DE DECIR LA DISTANCIA
        				//POR LO QUE CON LEJOS LA DISANCIA SE VUELVE 80% MAS EXACTA
		
        while(Button.ESCAPE.isUp()) //SI EL BOTON DE ESCAPE DE EV3 NO ESTA PRESIONADO ENTONCES....
		{
        		//IMPRIMIMOS EL VALOR QUE ESTA DANDO EL SENSOR
			    sp.fetchSample(sample, 0);
	            LCD.clear(3);
	            LCD.drawString("IR: " + sample[0],0,3);
	            Delay.msDelay((long) (1000/frecuencia));
	            //..........................................
	            
	            if(sample[0] > 40)
	            	avanzar();
	            else
	            {
	            	detener();
	            	cerrar();
	            	disparar();
	            	atras();
	            	abrir();
	            	
	            }	
		}
        sensor.close();//SI SE REINICIARA EL PROGRAMA ES NECESARIO CERRAR EL MODO CON EL QUE ESTA EL SENSOR INFRARROJO
	}
}
