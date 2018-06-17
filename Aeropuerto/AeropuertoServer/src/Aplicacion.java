import ar.edu.ub.p3.conexion.ConexionTraficoAereo;
import ar.edu.ub.p3.modelo.EstadoAeropuerto;
import ar.edu.ub.p3.util.Configuracion;
import ar.edu.ub.p3.vista.VentanaPrincipal;

public class Aplicacion {

	public static void main(String[] args) {
		Configuracion configuracion = new Configuracion(args[0]);
		EstadoAeropuerto estadoAeropuerto = new EstadoAeropuerto(configuracion);
		ConexionTraficoAereo conexionTA = new ConexionTraficoAereo(configuracion,estadoAeropuerto);

		new VentanaPrincipal( configuracion, estadoAeropuerto, conexionTA );	
	}

}
