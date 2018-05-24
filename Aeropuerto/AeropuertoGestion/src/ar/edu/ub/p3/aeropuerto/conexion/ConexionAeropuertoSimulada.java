package ar.edu.ub.p3.aeropuerto.conexion;

import java.util.List;

import ar.edu.ub.p3.aeropuerto.configuracion.Configuracion;
import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.interfaz.IVuelo;

public class ConexionAeropuertoSimulada extends ConexionAeropuerto{

	public ConexionAeropuertoSimulada(Configuracion configuracion) {
		super(configuracion);
		// TODO Auto-generated constructor stub
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
		return null;
	}

	@Override//NO TENGO QUE TOCAR ESTE METODO TODAVIA........................
	public List<IVuelo> getVuelos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override//NO TENGO QUE TOCAR ESTE METODO TODAVIA........................
	public List<IVuelo> getVuelosCercanosAlAeropuerto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override//MODIFICAR ESTE METODO........................
	public List<IAvion> getAviones() {
		//LE PIDO LA LISTA DE  IAVIONES AL SERVER
		//CARGAR UNA LISTA SIMULADA
		return null;
	}
	//---------------------------------------------------------------------------------------
	//OPERACIONES DE AVIONES-----------------------------------------------------------------
	//---------------------------------------------------------------------------------------
	
	@Override//MODIFICAR ESTE METODO........................
	public void addAvion(IAvion avion) {
		
		//SE ENVIA AL SERVER LA INTERFAZ DEL AVION NUEVO
		//SIMULAR EL ENVIO DE EL IAVION NUEVO
	}

	@Override//MODIFICAR ESTE METODO........................
	public void modifyAvion(IAvion avion) {
		
		//SE ENVIA AL SERVER LA INTERFZA DEL AVION MODIFICADO 
		//SIMULAR EL ENVIO DE UN IAVION MODIFICADO
	}

	@Override//MODIFICAR ESTE METODO........................
	public void deleteAvion(IAvion avion) {
		
		//SE ENVIA AL SERVER EL IAVION QUE SE VA ELIMINAR 
		//SIMULAR EL ENVIO PARA LA BAJA DE UN IAVION
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

	
	
}
