package ar.edu.ub.p3.aeropuerto.servidor;

public class ConfiguracionAeropuerto {

	private int puertoPedidosAeropuerto = 0;
	private int puertoPedidosAeropuertoGestion = 0;
	
	public ConfiguracionAeropuerto(String pathCfg) {
		this.setPuertoPedidosAeropuerto( 8888 );
		this.setPuertoPedidosAeropuertoGestion( 8889 );
	}

	public int getPuertoPedidosAeropuerto() {
		return this.puertoPedidosAeropuerto;
	}

	private void setPuertoPedidosAeropuerto(int puertoPedidosAeropuerto) {
		this.puertoPedidosAeropuerto = puertoPedidosAeropuerto;
	}

	public int getPuertoPedidosAeropuertoGestion() {
		return this.puertoPedidosAeropuertoGestion;
	}

	private void setPuertoPedidosAeropuertoGestion(int puertoPedidosAeropuertoGestion) {
		this.puertoPedidosAeropuertoGestion = puertoPedidosAeropuertoGestion;
	}

}
