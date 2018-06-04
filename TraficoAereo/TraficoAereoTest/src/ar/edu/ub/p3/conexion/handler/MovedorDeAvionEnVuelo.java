package ar.edu.ub.p3.conexion.handler;

import ar.edu.ub.p3.interfaz.IPosicion;
import ar.edu.ub.p3.modelo.EstadoTraficoAereo;
import ar.edu.ub.p3.modelo.Posicion;
import ar.edu.ub.p3.modelo.Vuelo;

public class MovedorDeAvionEnVuelo implements Runnable {
	private EstadoTraficoAereo estadoTraficoAereo;
	private String idVuelo;
	
	public MovedorDeAvionEnVuelo(EstadoTraficoAereo estadoTA, String idVuelo) {
		this.setEstadoTraficoAereo(estadoTA);
		this.setIdVuelo(idVuelo);
	}

	@Override
	public void run() {

		//Muevo el avion hasta llegar a mi "destino"
		for( int i = 0; i < 30; i++)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//Cambio la posicion
			this.getEstadoTraficoAereo().moverAvion( this.getIdVuelo(), new Posicion(1,1) );

		}

	}

	public EstadoTraficoAereo getEstadoTraficoAereo() {
		return estadoTraficoAereo;
	}

	public void setEstadoTraficoAereo(EstadoTraficoAereo estadoTraficoAereo) {
		this.estadoTraficoAereo = estadoTraficoAereo;
	}

	public String getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(String idVuelo) {
		this.idVuelo = idVuelo;
	}

}
