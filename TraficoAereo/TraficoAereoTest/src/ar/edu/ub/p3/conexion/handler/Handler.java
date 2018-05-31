package ar.edu.ub.p3.conexion.handler;
import java.io.ObjectOutputStream;

import ar.edu.ub.p3.conexion.AtendedorDePedidosDeAeropuerto;
import ar.edu.ub.p3.conexion.Mensaje;

public interface Handler {
	void accept(Mensaje m, ObjectOutputStream oos, AtendedorDePedidosDeAeropuerto atendedorDePedidosDeAeropuerto);
}
