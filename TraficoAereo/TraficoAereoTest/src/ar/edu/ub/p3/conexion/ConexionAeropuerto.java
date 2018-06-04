package ar.edu.ub.p3.conexion;

import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.modelo.Aeropuerto;

public class ConexionAeropuerto implements IConexionAeropuerto{
	private IAeropuerto aeropuerto;
	private IConexionAeropuerto conexionAeropuerto;
	
	public ConexionAeropuerto(IAeropuerto aeropuerto, IConexionAeropuerto conexionAeropuerto) {
		this.setAeropuerto( new Aeropuerto( aeropuerto ) );
		this.setConexionAeropuerto(conexionAeropuerto);
	}

	public IAeropuerto getAeropuerto() {
		return aeropuerto;
	}

	private void setAeropuerto(IAeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}
	
	@Override
	public void enviarMensaje(Mensaje mensaje) {		
		this.getConexionAeropuerto().enviarMensaje(mensaje);
	}

	public String getIdAeropuerto() {
		return this.getAeropuerto().getIdAeropuerto();
	}

	private IConexionAeropuerto getConexionAeropuerto() {
		return conexionAeropuerto;
	}

	private void setConexionAeropuerto(IConexionAeropuerto conexionAeropuerto) {
		this.conexionAeropuerto = conexionAeropuerto;
	}
}
