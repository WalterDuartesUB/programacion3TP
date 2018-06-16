package ar.edu.ub.p3.conexion;

import ar.edu.ub.p3.interfaz.IPosicion;
import ar.edu.ub.p3.interfaz.IVuelo;
import ar.edu.ub.p3.modelo.EstadoVuelo;
import ar.edu.ub.p3.modelo.Posicion;
import ar.edu.ub.p3.modelo.Vuelo;

public enum CalculadorPosicionDestino {
	NEUTRO {
		@Override
		public IPosicion obtenerPosicionDestino(Vuelo vuelo, double distanciaAlAeropuertoOrigen) {			
			return vuelo.getPosicion();
		}

		@Override
		public EstadoVuelo obtenerEstadoVueloAlLlegar(EstadoVuelo estadoVuelo) {			
			return estadoVuelo;
		}

		@Override
		public void enviarMensaje(ConexionTraficoAereo conexionTraficoAereo, IVuelo vuelo) {			
		}
	},
	AVANZA_A_DESTINO {
		@Override
		public IPosicion obtenerPosicionDestino(Vuelo vuelo, double distanciaAlAeropuertoOrigen) {			
			return vuelo.getAeropuertoDestino().getPosicion();
		}

		@Override
		public EstadoVuelo obtenerEstadoVueloAlLlegar(EstadoVuelo estadoVuelo) {
			return EstadoVuelo.LANDED;
		}

		@Override
		public void enviarMensaje(ConexionTraficoAereo conexionTraficoAereo, IVuelo vuelo) {
		}
	},
	ALEJA_DE_ORIGEN {
		@Override
		public IPosicion obtenerPosicionDestino(Vuelo vuelo, double distanciaAlAeropuertoOrigen) {
			
			double angulo = vuelo.getAeropuertoOrigen().getPosicion().calcularAngulo( vuelo.getAeropuertoDestino().getPosicion() );
			double distanciaEntreAeropuertos = vuelo.getAeropuertoOrigen().getPosicion().calcularDistancia( vuelo.getAeropuertoDestino().getPosicion() );
			
			double avanceX = Math.cos( angulo ) * Math.min( distanciaAlAeropuertoOrigen, distanciaEntreAeropuertos );
			double avanceY = Math.sin( angulo ) * Math.min( distanciaAlAeropuertoOrigen, distanciaEntreAeropuertos );
			
			return vuelo.getAeropuertoOrigen().getPosicion().sumar( new Posicion( avanceX, avanceY ) );
		}

		@Override
		public EstadoVuelo obtenerEstadoVueloAlLlegar(EstadoVuelo estadoVuelo) {
			return EstadoVuelo.ON_AIR;
		}

		@Override
		public void enviarMensaje(ConexionTraficoAereo conexionTraficoAereo, IVuelo vuelo) {
			conexionTraficoAereo.enviarMensaje( Mensaje.crearMensajeProgramarVuelo(vuelo));
			
		}
	};

	public abstract IPosicion    obtenerPosicionDestino(Vuelo vuelo, double distanciaAlAeropuertoOrigen);
	
	public abstract EstadoVuelo  obtenerEstadoVueloAlLlegar( EstadoVuelo estadoVuelo );

	public abstract void enviarMensaje(ConexionTraficoAereo conexionTraficoAereo, IVuelo vuelo);
}
