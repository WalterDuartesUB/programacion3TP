package ar.edu.ub.p3.common.aeropuerto.conexion;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Comando implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4872674698643294867L;
	private CodigoComando        codigoComando;
	private Map<String, Object> parametros;
	
	public Comando(CodigoComando codigoPedido) {
		this.setCodigoPedido(codigoPedido);
		this.setParametros(new HashMap<String,Object>());
	}
	
	public CodigoComando getCodigoComando() {
		return codigoComando;
	}

	private void setCodigoPedido(CodigoComando codigoComando) {
		this.codigoComando = codigoComando;
	}
	
	public Map<String, Object> getParametros() {
		return parametros;
	}
	protected void setParametros(Map<String, Object> parametros) {
		this.parametros = parametros;
	}
}
