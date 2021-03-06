package ar.edu.ub.p3.aeropuerto.tablero.conexion;

import java.util.List;

import ar.edu.ub.p3.aeropuerto.tablero.conexion.simulada.AeropuertoServidorSimulado;
import ar.edu.ub.p3.aeropuerto.tablero.configuracion.Configuracion;
import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.interfaz.IVuelo;

public class ConexionAeropuertoSimulada extends ConexionAeropuerto {
	
	private AeropuertoServidorSimulado servidorAeropuerto;

	public ConexionAeropuertoSimulada(Configuracion configuracion) {
		super(configuracion);
		setServidorAeropuerto(new AeropuertoServidorSimulado());
	}

	@Override
	public List<IVuelo> getVuelos() {
		return getServidorAeropuerto().getVuelosPrueba();
		// TODO Auto-generated method stub

	}
	
	@Override
	public void conectarAlAeropuerto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desconectarDelAeropuerto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IAeropuerto> getAeropuertos() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<IVuelo> getVuelosCercanosAlAeropuerto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IAvion> getAviones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAvion(IAvion avion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyAvion(IAvion avion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAvion(IAvion avion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addVuelo(IVuelo vuelo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyVuelo(IVuelo vuelo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVuelo(IVuelo vuelo) {
		// TODO Auto-generated method stub
		
	}

	public AeropuertoServidorSimulado getServidorAeropuerto() {
		return servidorAeropuerto;
	}

	public void setServidorAeropuerto(AeropuertoServidorSimulado servidorAeropuerto) {
		this.servidorAeropuerto = servidorAeropuerto;
	}

}
