package ar.edu.ub.p3.aeropuerto.pedido;
import java.io.Serializable;

import ar.edu.ub.p3.aeropuerto.modelo.Avion;
import ar.edu.ub.p3.aeropuerto.servidor.ConfiguracionAeropuerto;
import ar.edu.ub.p3.aeropuerto.servidor.EstadoAeropuerto;

public class PedidoAeropuertoImprimirAviones extends PedidoAeropuerto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 197444045880050805L;

	@Override
	public void atender(ConfiguracionAeropuerto configuracionAeropuerto, EstadoAeropuerto estadoAeropuerto) {
		//TODO esto de alguna forma tiene que devolverse al tablero para que el lo imprima
		for( Avion avion : estadoAeropuerto.getAviones() )
			System.out.println( avion );

	}

}
