package ar.edu.ub.p3.util.factory;

import java.util.Calendar;
import java.util.Map;

import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Avion;
import ar.edu.ub.p3.modelo.Vuelo;

public class VueloFactory extends Fabrica<Vuelo>{
	private Map<String, Avion> aviones;
	private Map<String, Aeropuerto> aeropuertos;
	
	public VueloFactory(Map<String, Avion> aviones, Map<String, Aeropuerto> aeropuertos) {
		this.setAviones(aviones);
		this.setAeropuertos(aeropuertos);
	}
	
	private Map<String, Avion> getAviones() {
		return aviones;
	}
	
	private void setAviones(Map<String, Avion> aviones) {
		this.aviones = aviones;
	}
	
	private Map<String, Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}
	
	private void setAeropuertos(Map<String, Aeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}
	
	@Override
	public String obtenerIdentificador(Vuelo objeto) {
		return objeto.getIdVuelo();
	}
	
	@Override
	public Vuelo crear(String[] campos) {
		String[] camposFecha = campos[4].split(":");
		Calendar ahora = Calendar.getInstance();
		ahora.set(Calendar.HOUR, Integer.parseInt( camposFecha[0] ));
		ahora.set(Calendar.MINUTE, Integer.parseInt( camposFecha[1] ));		
		
		return new Vuelo( campos[0], this.getAviones().get( campos[1] ), this.getAeropuertos().get( campos[2] ), this.getAeropuertos().get( campos[3] ), ahora.getTime() );
	}

}
