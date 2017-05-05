//clase donde sucede la union
public class ClaseChida  implements Runnable//para que funcione el hilo
{
	int z=9;
	int vel=0;
	int velDisparo, esperaDisparos;
	boolean avanzar=false,sonido;
	
	//metodo que se implementa de la clase Runnable donde se corren los hilos
	public void run()
	{
		//Creamos la pantalla............
	 	Pantalla p =new Pantalla();
	 	p.setVisible(true);
		p.crearGUI();
		avanzar=true;

		//INICIAMOS EL CICLO
		while(true)
		{
		
			//ESTA PARTE ES LA MAS IMPORTANTE YA QUE OCURRE LA UNION ENTRE LAS DOS CLASES PARA SABER 
			//QUE HACER EL ROBOT DEPENDIENDO DE COMO EL USUARIO SE RELACIONE CON LA INTERFAZ.....
		if (p.getAccion()==1)
		{
			vel=p.getPotencia();
			z=1;
		}	
		if(p.getAccion()==2)
		{
			vel=p.getPotencia();
			z=3;
		}
		if(p.getAccion()==3)
		{
			vel=p.getPotencia();
			z=2;
		}
		if(p.getAccion()==4)
		{
			vel=p.getPotencia();
			z=4;
		}
		if(p.getAccion()==5)
		{
			z=5;
		}
		if(p.getAccion()==7)
		{
			
			sonido=p.getSonido();
			velDisparo=p.getPotenciaDisparo();
			esperaDisparos=p.getEsperaDisparos();
			z=6;
		}
		
		}
	}

			 
	
}