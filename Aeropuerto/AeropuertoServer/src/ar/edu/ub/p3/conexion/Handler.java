package ar.edu.ub.p3.conexion;

public interface Handler <T>{

	public void accept(Mensaje mensaje, T estado);
}
