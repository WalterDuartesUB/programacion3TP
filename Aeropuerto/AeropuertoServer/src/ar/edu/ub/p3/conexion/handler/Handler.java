package ar.edu.ub.p3.conexion.handler;

import ar.edu.ub.p3.conexion.IConexionTraficoAereo;
import ar.edu.ub.p3.conexion.Mensaje;

public interface Handler <T>{

	public void accept(Mensaje mensaje, IConexionTraficoAereo conexionTraficoAereo, T estado);
}
