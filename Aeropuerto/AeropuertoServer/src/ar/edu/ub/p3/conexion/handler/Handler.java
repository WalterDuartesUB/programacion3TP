package ar.edu.ub.p3.conexion.handler;

public interface Handler <T>{

	public void accept(Mensaje mensaje, T estado);
}
