package ar.edu.ub.p3.tablero;

import ar.edu.ub.p3.aeropuerto.configuracion.Configuracion;

public class ConfiguracionTableroLlegadas {
	
	private Configuracion configuracion;
	
	private String        ipPedidosAeropuerto;
	private int           puertoPedidosAeropuerto;
	
	public ConfiguracionTableroLlegadas(String pathCfg) {
		//Creo una instancia de la configuracion
		this.setConfiguracion( new Configuracion( pathCfg ) );
		
		//Levanto los valores que necesito
		this.setIpPedidosAeropuerto( this.getConfiguracion().obtenerValor("ipServerAeropuerto", "127.0.0.1"));
		this.setPuertoPedidosAeropuerto( Integer.parseInt( this.getConfiguracion().obtenerValor("puertoAeropuerto", "8888") ) );
	}

	public String getIpPedidosAeropuerto() {
		return ipPedidosAeropuerto;
	}

	private void setIpPedidosAeropuerto(String ipPedidosAeropuerto) {
		this.ipPedidosAeropuerto = ipPedidosAeropuerto;
	}

	public int getPuertoPedidosAeropuerto() {
		return puertoPedidosAeropuerto;
	}

	private void setPuertoPedidosAeropuerto(int puertoPedidosAeropuerto) {
		this.puertoPedidosAeropuerto = puertoPedidosAeropuerto;
	}

	private Configuracion getConfiguracion() {
		return configuracion;
	}

	private void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}



}
