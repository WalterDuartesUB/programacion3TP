package ar.edu.ub.p3.conexion;

import java.io.IOException;
import java.io.ObjectOutputStream;

import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.modelo.Aeropuerto;

public class ConexionAeropuerto {
	private IAeropuerto aeropuerto;
	private ObjectOutputStream objectOutputStream;
	
	public ConexionAeropuerto(IAeropuerto aeropuerto, ObjectOutputStream objectOutputStream) {
		this.setAeropuerto( new Aeropuerto( aeropuerto ) );
		this.setObjectOutputStream(objectOutputStream);
	}

	private ObjectOutputStream getObjectOutputStream() {
		return objectOutputStream;
	}

	private void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
		this.objectOutputStream = objectOutputStream;
	}

	public IAeropuerto getAeropuerto() {
		return aeropuerto;
	}

	private void setAeropuerto(IAeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}
	
	public void enviarMensaje(Mensaje mensaje) {		
		try {
			this.getObjectOutputStream().writeObject( mensaje );
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public String getIdAeropuerto() {
		return this.getAeropuerto().getIdAeropuerto();
	}
}
