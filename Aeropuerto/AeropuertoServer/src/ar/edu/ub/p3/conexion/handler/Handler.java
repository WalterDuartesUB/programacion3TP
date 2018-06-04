package ar.edu.ub.p3.conexion.handler;

import java.io.ObjectOutputStream;

import ar.edu.ub.p3.conexion.Mensaje;

public interface Handler <T>{

	public void accept(Mensaje mensaje, ObjectOutputStream oos, T estado);
}
