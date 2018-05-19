import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.util.Configuracion;

public class Aplicacion {

	public static void main(String[] args) {
		Configuracion configuracion = new Configuracion(args[0]);
		EstadoAeropuerto estadoAeropuerto = new EstadoAeropuerto(configuracion);
		ConexionTraficoAereo conexionTA = new ConexionTraficoAereo(configuracion,estadoAeropuerto);
		
		conexionTA.conectar();
		conexionTA.obtenerAeropuertosDisponibles();
		conexionTA.desconectar();
		configuracion.close();
		
		
		
		
		
	}

}
