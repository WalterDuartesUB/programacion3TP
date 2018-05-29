package ar.edu.ub.p3.util.factory;

public abstract class Fabrica<T> {
	public abstract String obtenerIdentificador( T objeto );
	public abstract T crear( String[] campos);
}
