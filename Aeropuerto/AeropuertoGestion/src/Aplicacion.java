import ar.edu.ub.p3.aeropuerto.gestor.conexion.*;
import ar.edu.ub.p3.aeropuerto.gestor.configuracion.Configuracion;
import ar.edu.ub.p3.aeropuerto.gestor.interfazgrafica.InterfazGrafica;


public class Aplicacion {
 
	//JUST - STRING IT - 
	public static void main(String[] args) {
		
		ConexionAeropuerto conexion = new ConexionAeropuertoSimulada(new Configuracion("appgestion.properties"));
		
		new InterfazGrafica(conexion);
		
	}

}
