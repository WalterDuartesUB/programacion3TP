package ar.edu.ub.p3.aeropuerto.pedido;

import ar.edu.ub.p3.aeropuerto.servidor.ConfiguracionAeropuerto;
import ar.edu.ub.p3.aeropuerto.servidor.EstadoAeropuerto;

// TODO esto deberia estar en un JAR comun a todas las aplicaciones que se puedan
//      conectarse al servidor de aeropuerto

public abstract class PedidoAeropuerto {
	public abstract void atender(ConfiguracionAeropuerto configuracionAeropuerto, EstadoAeropuerto estadoAeropuerto);

}
