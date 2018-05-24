package ar.edu.ub.p3.aeropuerto.conexion.simulada;

import java.util.LinkedList;
import java.util.List;

import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.modelo.Aerolinea;
import ar.edu.ub.p3.modelo.Avion;
import ar.edu.ub.p3.modelo.Posicion;

public class AeropuertoServidorSimulado {

	private List<IAvion> avionesSimulados;
	
	public AeropuertoServidorSimulado() {
		setAvionesSimulados(new LinkedList<IAvion> ());
		generarAviones();
	}
	
	
	public void generarAviones() {
		
		getAvionesSimulados().add(new Avion("AVI-01",new Aerolinea("AER-01","AUSTRAL"), new Posicion(10,10)));
		getAvionesSimulados().add(new Avion("AVI-02",new Aerolinea("AER-01","AUSTRAL"), new Posicion(11,11)));
		getAvionesSimulados().add(new Avion("AVI-03",new Aerolinea("AER-02","AUSTRAL")  , new Posicion(12,12)));
		getAvionesSimulados().add(new Avion("AVI-04",new Aerolinea("AER-03","AUSTRAL")  , new Posicion(13,13)));
		getAvionesSimulados().add(new Avion("AVI-05",new Aerolinea("AER-04","AUSTRAL")  , new Posicion(14,14)));
		
		getAvionesSimulados().add(new Avion("AVI-06",new Aerolinea("AER-05","LATAM")  , new Posicion(15,15)));
		getAvionesSimulados().add(new Avion("AVI-07",new Aerolinea("AER-06","LATAM")  , new Posicion(16,17)));
		getAvionesSimulados().add(new Avion("AVI-08",new Aerolinea("AER-07","LATAM")  , new Posicion(18,18)));
		getAvionesSimulados().add(new Avion("AVI-09",new Aerolinea("AER-08","LATAM")  , new Posicion(19,19)));
		getAvionesSimulados().add(new Avion("AVI-10",new Aerolinea("AER-09","LATAM")  , new Posicion(20,20)));
		
		
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


	
	
}
