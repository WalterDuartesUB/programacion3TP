package ar.edu.ub.p3.common.aeropuerto.conexion;

import ar.edu.ub.p3.common.aeropuerto.modelo.Aeropuerto;
import ar.edu.ub.p3.common.aeropuerto.modelo.Vuelo;

/* representa la conexion de el trafico aereo hacia un aeropuerto */

public abstract class ConexionAeropuerto {
	
	public abstract void enviarListaAeropuertos(Aeropuerto aeropuerto, Aeropuerto[] aeropuertos);
	public abstract void confirmarDespegue(Vuelo vuelo);
	public abstract void quieroAterrizar(String idVuelo);
	public abstract void actualizarVuelo(Vuelo vuelo);
	
}
