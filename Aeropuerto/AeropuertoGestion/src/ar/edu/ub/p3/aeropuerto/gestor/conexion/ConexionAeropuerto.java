package ar.edu.ub.p3.aeropuerto.gestor.conexion;

import java.util.List;

import ar.edu.ub.p3.aeropuerto.gestor.configuracion.Configuracion;
import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IAvion;
import ar.edu.ub.p3.interfaz.IVuelo;


public abstract class ConexionAeropuerto {
	public ConexionAeropuerto( Configuracion configuracion ) {
		 
	}
	
	//Operaciones de conectividad
	public abstract void              conectarAlAeropuerto();
	public abstract void              desconectarDelAeropuerto();
	
	//Operaciones de lista
	public abstract List<IAeropuerto> getAeropuertos();
	public abstract List<IVuelo>      getVuelos();
	public abstract List<IVuelo>      getVuelosCercanosAlAeropuerto();	
	public abstract List<IAvion>      getAviones();	
	
	//Operaciones de aviones
	public abstract void              addAvion( IAvion avion );
	public abstract void              modifyAvion( IAvion avion );
	public abstract void              deleteAvion( IAvion avion );
	
	//Operaciones de vuelo
	public abstract void              addVuelo( IVuelo vuelo );
	public abstract void              modifyVuelo( IVuelo vuelo );
	public abstract void              deleteVuelo( IVuelo vuelo );	
}
