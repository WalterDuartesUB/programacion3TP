package ar.edu.ub.p3.conexion.handler;

import ar.edu.ub.p3.conexion.Mensaje;
import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IVuelo;
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

		//TODO reveer esto para los casos en los que una recta no sirva
		//Uno los aeropuertos con una recta
		//IAeropuerto aeropuertoOrigen = this.getEstadoTraficoAereo().getVuelo( this.getIdVuelo() ).getAeropuertoOrigen();
		IAeropuerto aeropuertoDestino = this.getEstadoTraficoAereo().getVuelo( this.getIdVuelo() ).getAeropuertoDestino();
/*		
		//Calculo la pendiente
		double pendiente = ( aeropuertoDestino.getPosicion().getY() -  aeropuertoOrigen.getPosicion().getY() ) / ( aeropuertoDestino.getPosicion().getX() - aeropuertoOrigen.getPosicion().getX() );
		
		//calculo la ordenada al origen
		double ordenadaAlOrigen = aeropuertoOrigen.getPosicion().getY() - pendiente * aeropuertoOrigen.getPosicion().getX();
		
		double orientacionX = ( aeropuertoDestino.getPosicion().getX() - aeropuertoOrigen.getPosicion().getX() ) > 0 ? 1 : -1;
		
		System.out.println( String.format("y = %f X + %f", pendiente, ordenadaAlOrigen));
*/		
		IVuelo vuelo = this.getEstadoTraficoAereo().getVuelo(this.getIdVuelo());
		
		//Avanzo hasta estar en la zona de aterrizaje
		this.moverAvion(aeropuertoDestino, vuelo, 20);
		
		//Envio un mensaje de proximidad al aeropuerto de destino
		this.getEstadoTraficoAereo().getConexionAeropuerto( aeropuertoDestino.getIdAeropuerto() ).enviarMensaje( Mensaje.crearMensajeVueloProximoAterrizar(new Vuelo(this.getEstadoTraficoAereo().getVuelo(this.getIdVuelo()))));
	
		//TODO Sacar de la lista de vuelos del TA
		//Sigo avanzando el avion hasta llegar
//		this.moverAvion(aeropuertoDestino, pendiente, orientacionX, vuelo, 0.1);
	}

	private void moverAvion(IAeropuerto aeropuertoDestino, IVuelo vuelo, double distanciaAlDestino) {
		double angulo = vuelo.getPosicion().calcularAngulo( aeropuertoDestino.getPosicion() ); 
		double avanceX = Math.cos( angulo );
		double avanceY = Math.sin(angulo);
		
//		while( Math.abs( vuelo.getPosicion().getY() - aeropuertoDestino.getPosicion().getY() ) > distanciaAlDestino) {
		while( vuelo.getPosicion().calcularDistancia( aeropuertoDestino.getPosicion() ) > distanciaAlDestino ) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//cambio el avion
//			this.getEstadoTraficoAereo().moverAvion( this.getIdVuelo(), new Posicion( orientacionX, pendiente * orientacionX  ) );			
			this.getEstadoTraficoAereo().moverAvion( this.getIdVuelo(), new Posicion( avanceX, avanceY  ) );
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
