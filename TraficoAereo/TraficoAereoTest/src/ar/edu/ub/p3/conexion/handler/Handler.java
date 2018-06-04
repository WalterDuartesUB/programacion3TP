package ar.edu.ub.p3.conexion.handler;
import ar.edu.ub.p3.conexion.AtendedorDePedidosDeAeropuerto;
import ar.edu.ub.p3.conexion.IConexionAeropuerto;
import ar.edu.ub.p3.conexion.Mensaje;

public interface Handler {
	void accept(Mensaje m, IConexionAeropuerto conexionAeropuerto, AtendedorDePedidosDeAeropuerto atendedorDePedidosDeAeropuerto);
}
