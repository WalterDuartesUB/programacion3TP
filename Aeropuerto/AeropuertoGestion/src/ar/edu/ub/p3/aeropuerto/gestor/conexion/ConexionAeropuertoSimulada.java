package ar.edu.ub.p3.aeropuerto.gestor.conexion;

import java.util.List;

import ar.edu.ub.p3.aeropuerto.gestor.conexion.simulacion.AeropuertoServidorSimulado;
import ar.edu.ub.p3.aeropuerto.gestor.configuracion.Configuracion;
import ar.edu.ub.p3.interfaz.IAerolinea;
import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.interfaz.IVuelo;

public class ConexionAeropuertoSimulada extends ConexionAeropuerto{

	private AeropuertoServidorSimulado servidorAeropuerto;
	
	 
	public ConexionAeropuertoSimulada(Configuracion configuracion) {
		super(configuracion);
		setServidorAeropuerto(new AeropuertoServidorSimulado());
	}

	//---------------------------------------------------------------------------------------
	//OPERACIONES DE CONECTIVIDAD------------------------------------------------------------
	//---------------------------------------------------------------------------------------
	
	@Override //NO TENGO QUE TOCAR ESTE METODO........................
	public void conectarAlAeropuerto() {
		// TODO Auto-generated method stub
		
	}

	@Override //NO TENGO QUE TOCAR ESTE METODO........................
	public void desconectarDelAeropuerto() {
		// TODO Auto-generated method stub
		
	}
	
	//---------------------------------------------------------------------------------------
	//OPERACIONES DE LISTA-------------------------------------------------------------------
	//---------------------------------------------------------------------------------------
	
	@Override //NO TENGO QUE TOCAR ESTE METODO........................
	public List<IAeropuerto> getAeropuertos() {
		// TODO Auto-generated method stub
		return getServidorAeropuerto().getAeropuertosSimulados();
	}

	@Override//NO TENGO QUE TOCAR ESTE METODO TODAVIA........................
	public List<IVuelo> getVuelos() {
		// TODO Auto-generated method stub
		return getServidorAeropuerto().getVuelosSimulados();
	}
	
	@Override
	public List<IAerolinea> getAerolineas() {
		// TODO Auto-generated method stub
		return getServidorAeropuerto().getAerolineasSimuladas();
	}

	@Override//NO TENGO QUE TOCAR ESTE METODO TODAVIA........................
	public List<IVuelo> getVuelosCercanosAlAeropuerto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override//MODIFICAR ESTE METODO........................
	public List<IAvion> getAviones() {
		
		return getServidorAeropuerto().getAviones();
		
	}
	//---------------------------------------------------------------------------------------
	//OPERACIONES DE AVIONES-----------------------------------------------------------------
	//---------------------------------------------------------------------------------------
	
	@Override//MODIFICAR ESTE METODO........................
	public void addAvion(IAvion avion) {
		
		
		getServidorAeropuerto().addAvion(avion);
		
	}

	@Override//MODIFICAR ESTE METODO........................
	public void modifyAvion(IAvion avion) {
		//SE DEBERIA CREAR EL MENSAJE DE MODIFICACION PERO SE SIMULA QUE ESTAMOS YA CONECTADOS
		getServidorAeropuerto().modifyAvion(avion);
		
	}

	@Override//MODIFICAR ESTE METODO........................
	public void deleteAvion(IAvion avion) {
		
		//SIMULO LA ORDEN PARA QUE EL SERVIDOR ELIMINE ESE AVION
		getServidorAeropuerto().deleteAvion(avion);
		
	}
	//---------------------------------------------------------------------------------------
	//OPERACIONES DE VUELOS------------------------------------------------------------------
	//---------------------------------------------------------------------------------------
	
	@Override//NO TENGO QUE TOCAR ESTE METODO TODAVIA........................
	public void addVuelo(IVuelo vuelo) {
		// TODO Auto-generated method stub
		
	}

	@Override//NO TENGO QUE TOCAR ESTE METODO TODAVIA........................
	public void modifyVuelo(IVuelo vuelo) {
		// TODO Auto-generated method stub
		
	}

	@Override//NO TENGO QUE TOCAR ESTE METODO TODAVIA........................
	public void deleteVuelo(IVuelo vuelo) {
		// TODO Auto-generated method stub
		
	}

	public AeropuertoServidorSimulado getServidorAeropuerto() {
		return servidorAeropuerto;
	}

	public void setServidorAeropuerto(AeropuertoServidorSimulado aeropuerto) {
		this.servidorAeropuerto = aeropuerto;
	}

	
	
}
