package ar.edu.ub.p3.aeropuerto.gestor.configuracion;

public class ConfiguracionAppGestion {

	private Configuracion configuracion;
	private String        ipGestionAeropuerto;
	private int           puertoGestionAeropuerto;
	 
	public ConfiguracionAppGestion(String pathCfg) {
		
		//Creo una instancia de la configuracion
		this.setConfiguracion( new Configuracion( pathCfg ) );
		
		//Levanto los valores que necesito
		this.setIpGestionAeropuerto( this.getConfiguracion().obtenerValor("ipServerAeropuerto", "127.0.0.1"));
		this.setPuertoGestionAeropuerto( Integer.parseInt( this.getConfiguracion().obtenerValor("puertoAeropuerto", "8889") ) );
		
	}
	
	private Configuracion getConfiguracion() {
		return configuracion;
	}

	private void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}

	public String getIpGestionAeropuerto() {
		return ipGestionAeropuerto;
	}

	private void setIpGestionAeropuerto(String ipGestionAeropuerto) {
		this.ipGestionAeropuerto = ipGestionAeropuerto;
	}

	public int getPuertoGestionAeropuerto() {
		return puertoGestionAeropuerto;
	}

	private void setPuertoGestionAeropuerto(int puertoGestionAeropuerto) {
		this.puertoGestionAeropuerto = puertoGestionAeropuerto;
	}

}
