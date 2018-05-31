package ar.edu.ub.p3.conexion.handler;

import ar.edu.ub.p3.interfaz.IPosicion;
import ar.edu.ub.p3.modelo.Posicion;
import ar.edu.ub.p3.modelo.Vuelo;

public class MovedorDeAvionEnVuelo implements Runnable {

	private Vuelo vuelo;
	public MovedorDeAvionEnVuelo(Vuelo vuelo) {
		this.setVuelo(vuelo);
	}

	@Override
	public void run() {

		//Muevo el avion hasta llegar a mi "destino"
		for( int i = 0; i < 15; i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//Cambio la posicion
			this.getVuelo().setPosicion( this.sumar( this.getVuelo().getAvion().getPosicion(), new Posicion(1,1) ) );
/*			
			System.out.println("Movi el vuelo " + this.getVuelo().getIdVuelo() );
			System.out.println("Movi el vuelo " + this.getVuelo().getAvion().getPosicion() );
*/			
		}

	}

	private Posicion sumar(IPosicion posicion, Posicion posicion2) {
		return new Posicion( posicion.getX() + posicion2.getX(), posicion.getY() + posicion2.getY() );
	}

	private Vuelo getVuelo() {
		return vuelo;
	}

	private void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

}
