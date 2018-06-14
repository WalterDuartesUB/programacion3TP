package ar.edu.ub.p3.aeropuerto.gestion.modelo;

import java.util.List;

public interface IRepositorioModelo <T> {
	
	public void add(T dato);
	public void delete(T dato);
	public void modify(T dato);
	public List<T> getList();
}
