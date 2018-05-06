package ar.edu.ub.p3.aeropuerto.pedido;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;


import ar.edu.ub.p3.aeropuerto.servidor.ConfiguracionAeropuerto;
import ar.edu.ub.p3.aeropuerto.servidor.EstadoAeropuerto;
import ar.edu.ub.p3.common.aeropuerto.modelo.Avion;

public enum PedidoAeropuerto {
	OBTENER_LISTA_AVIONES{

		@Override
		public void ejecutar(	ConfiguracionAeropuerto configuracionAeropuerto, 
								EstadoAeropuerto        estadoAeropuerto,
								Map<String,Object>      parametros, 
								Socket socket) {
			
			System.out.println( parametros.get("marta"));
/*			
			System.out.println( parametros.get("oscar"));
			
			Avion avion = (Avion) parametros.get("avion");
			
			System.out.println( avion.getModelo());
			System.out.println( avion.getPatente());
*/	
			/*
			ObjectOutputStream oos;
			
			try {
				oos = new ObjectOutputStream( socket.getOutputStream() );
				oos.writeObject( estadoAeropuerto.getAviones().toArray( new Avion[ estadoAeropuerto.getAviones().size() ] ) );
			} catch (IOException e) { 
				e.printStackTrace();
			}
			*/
						
		}
		
	},
	CREAR_AVION{

		@Override
		public void ejecutar(	ConfiguracionAeropuerto configuracionAeropuerto, 
								EstadoAeropuerto        estadoAeropuerto,
								Map<String,Object>      parametros, 
								Socket socket) {
		
			
		}
		
	};
	
	public abstract void ejecutar(ConfiguracionAeropuerto configuracionAeropuerto, EstadoAeropuerto estadoAeropuerto, Map<String,Object> parametros, Socket socket);
}
