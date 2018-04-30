package ar.edu.ub.p3.aeropuerto.servidor;

import ar.edu.ub.p3.aeropuerto.configuracion.Configuracion;

public class ConfiguracionAeropuerto {

	private Configuracion configuracion;
	
	private int puertoPedidosAeropuerto = 0;
	private int puertoGestionAeropuerto = 0;
	
	public ConfiguracionAeropuerto(String pathCfg) {
		
		//Creo una instancia de la configuracion
		this.setConfiguracion( new Configuracion( pathCfg ) );
		
		//Levanto los valores que necesito
		this.setPuertoPedidosAeropuerto( Integer.parseInt( this.getConfiguracion().obtenerValor("puertoPedidosAeropuerto", "8888") ) );		
		this.setPuertoGestionAeropuerto( Integer.parseInt( this.getConfiguracion().obtenerValor("puertoGestionAeropuerto", "8889") ) );		
	}

	public int getPuertoPedidosAeropuerto() {
		return this.puertoPedidosAeropuerto;
	}

	private void setPuertoPedidosAeropuerto(int puertoPedidosAeropuerto) {
		this.puertoPedidosAeropuerto = puertoPedidosAeropuerto;
	}

	public int getPuertoGestionAeropuerto() {
		return this.puertoGestionAeropuerto;
	}

	private void setPuertoGestionAeropuerto(int puertoGestionAeropuerto) {
		this.puertoGestionAeropuerto = puertoGestionAeropuerto;
	}

	private Configuracion getConfiguracion() {
		return configuracion;
	}

	private void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}

}
