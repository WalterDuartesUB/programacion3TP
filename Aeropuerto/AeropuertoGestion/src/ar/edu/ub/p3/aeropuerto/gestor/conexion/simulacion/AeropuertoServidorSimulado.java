package ar.edu.ub.p3.aeropuerto.gestor.conexion.simulacion;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import ar.edu.ub.p3.interfaz.IAerolinea;
import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.interfaz.IVuelo;
import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Avion;
import ar.edu.ub.p3.modelo.Posicion;
import ar.edu.ub.p3.modelo.Vuelo;

public class AeropuertoServidorSimulado {

	private List<IAvion> 		avionesSimulados;
	private List<IAeropuerto>	aeropuertosSimulados;
	private List<IVuelo>		vuelosSimulados;
	private List<IAerolinea>	aerolineasSimuladas;
	
	
	public AeropuertoServidorSimulado() {
		setAvionesSimulados(new LinkedList<IAvion> ());
		setAeropuertosSimulados(new LinkedList<IAeropuerto>());
		setAerolineasSimuladas(new LinkedList<IAerolinea>());
		setVuelosSimulados(new LinkedList<IVuelo>());
		
		generarAerolineas();
		generarAeropuertos();
		generarAviones();
		generarVuelos();
	}
	
	
	public void generarAviones() {
		int i =0;
		for( i=0;i<100;i++)
			getAvionesSimulados().add(new Avion("AVI-"+i,getAerolineasSimuladas().get(i%getAerolineasSimuladas().size()), new Posicion(10,10)));
	}
	
	public void generarAeropuertos() {
		
		int i = 0;
		for(i=1;i<18;i++)
			getAeropuertosSimulados().add(new Aeropuerto("AEROP-"+i, "Aeropuerto "+i, new Posicion(i,i*3)));
	}
	
	public void generarVuelos() {
		
		int i = 0;
		for(i=0;i<200;i++)
			getVuelosSimulados().add(new Vuelo("VUELO-"+i, 
									 getAvionesSimulados().get(i%100), 
									 getAeropuertosSimulados().get(i%(getAeropuertosSimulados().size()/2)), 
									 getAeropuertosSimulados().get((i%(getAeropuertosSimulados().size()/2))+(getAeropuertosSimulados().size()/2)),
									 new Date()));
		
		
	}
	
	public void generarAerolineas() {
		
			getAerolineasSimuladas().add(new Aerolinea("AIRL-1", "Austral Airlnes"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-2", "Aerolineas Argentinas"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-3", "Airline LATAM"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-4", "American Airline"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-5", "Austrian Airline"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-6", "Air France"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-7", "Aeromexico"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-8", "AIRLINES LATAM"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-9", "China Eastern"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-10", "Pegasus Airlines"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-11", "Qatar Airways"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-12", "TAP Air Portugal"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-13", "Cathay Pacific"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-14", "Aegean Airlines"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-15", "Norwegian Air Int"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-16", "Royal Air Maroc"));
			getAerolineasSimuladas().add(new Aerolinea("AIRL-17", "Binter Canarias"));
			
		
	}
	
	public List<IAvion> getAviones(){
		
		return getAvionesSimulados();
		
	}
	
	
	public void addAvion(IAvion avion) {
		
		getAvionesSimulados().add(avion);
		
	}


	public void modifyAvion(IAvion avion) {
		
		getAviones().add(avion);
		
	}


	public void deleteAvion(IAvion avion) {
		
		getAvionesSimulados().remove(avion);
		
	}

	private List<IAvion> getAvionesSimulados() {
		return avionesSimulados;
	}

	private void setAvionesSimulados(List<IAvion> avionesSimulados) {
		this.avionesSimulados = avionesSimulados;
	}


	public List<IAeropuerto> getAeropuertosSimulados() {
		return aeropuertosSimulados;
	}


	public void setAeropuertosSimulados(List<IAeropuerto> aeropuertosSimulados) {
		this.aeropuertosSimulados = aeropuertosSimulados;
	}


	public List<IVuelo> getVuelosSimulados() {
		return vuelosSimulados;
	}


	public void setVuelosSimulados(List<IVuelo> vuelosSimulados) {
		this.vuelosSimulados = vuelosSimulados;
	}


	public List<IAerolinea> getAerolineasSimuladas() {
		return aerolineasSimuladas;
	}


	public void setAerolineasSimuladas(List<IAerolinea> aerolineasSimuladas) {
		this.aerolineasSimuladas = aerolineasSimuladas;
	}


	
	
}
