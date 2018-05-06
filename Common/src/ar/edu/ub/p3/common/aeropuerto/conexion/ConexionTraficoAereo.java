package ar.edu.ub.p3.common.aeropuerto.conexion;

import ar.edu.ub.p3.common.aeropuerto.modelo.Aeropuerto;
import ar.edu.ub.p3.common.aeropuerto.modelo.Posicion;
import ar.edu.ub.p3.common.aeropuerto.modelo.Vuelo;

/* representa la conexion entre un aeropuerto y el espacio aereo desde la perspectiva de un aeropuerto
 */

public abstract class ConexionTraficoAereo {
	
	public abstract Aeropuerto[]  conectarse(Aeropuerto aeropuerto);
	public abstract void          despegar(Vuelo vuelo);
	public abstract Posicion      pedirPosicion(String idVuelo);
	public abstract void          confirmarAterrizaje(String  idVuelo);
	public abstract void          desconectar(String aeropuertoIata);
	
}
