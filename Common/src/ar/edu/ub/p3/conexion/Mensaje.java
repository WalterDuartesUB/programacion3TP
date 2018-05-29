package ar.edu.ub.p3.conexion;

import java.io.Serializable;
import java.util.List;

import ar.edu.ub.p3.interfaz.IAeropuerto;
import ar.edu.ub.p3.interfaz.IVuelo;

public class Mensaje implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8908279627091769482L;
	private TipoMensaje 	  tipoMensaje = null;
	private IAeropuerto 	  aeropuerto = null;
	private String  		  idAeropuerto = null;
	private List<IAeropuerto> aeropuertos = null;
	private String            descripcion = null;
	private IVuelo            vuelo = null;
	private String            idVuelo = null;
	private TipoError         tipoError = null;
	
	private Mensaje(TipoMensaje tipo) {
		this.setTipoMensaje(tipo);
	}
	
	public static Mensaje crearMensajeAltaAeropuerto(IAeropuerto aeropuerto) {
		Mensaje mensaje = new Mensaje(TipoMensaje.ALTA_AEROPUERTO);
		mensaje.setAeropuerto(aeropuerto);
		return mensaje;
	}
	public static Mensaje crearMensajeAltaAeropuertoAck(List<IAeropuerto> aeropuertos) {
		Mensaje mensaje = new Mensaje(TipoMensaje.ALTA_AEROPUERTO_ACK);
		mensaje.setAeropuertos(aeropuertos);
		return mensaje;
	}
	
	public static Mensaje crearMensajeObtenerListadoAeropuerto() {
		return new Mensaje(TipoMensaje.OBTENER_LISTADO_AEROPUERTOS_DISPONIBLES);
	}
	
	public static Mensaje crearMensajeListadoAeropuerto(List<IAeropuerto> aeropuertos) {
		Mensaje mensaje =new Mensaje(TipoMensaje.LISTADO_AEROPUERTOS_DISPONIBLES);
		mensaje.setAeropuertos(aeropuertos);
		return mensaje;
	}
	public static Mensaje crearMensajeBajaAeropuerto(String aeropuerto) {
		Mensaje mensaje = new Mensaje(TipoMensaje.BAJA_AEROPUERTO);
		mensaje.setIdAeropuerto(aeropuerto);
		return mensaje;
	}
	public static Mensaje crearMensajeBajaAeropuertoAck() {
		return new Mensaje(TipoMensaje.BAJA_AEROPUERTO_ACK);
	}
	
	public static Mensaje crearMensajeError(TipoError tipo, String descripcion) {
		Mensaje mensaje = new Mensaje(TipoMensaje.TRAFICO_AEREO_ERROR);
		mensaje.setTipoError(tipo);
		mensaje.setDescripcion(descripcion);
		return mensaje;
	}
	
	public static Mensaje crearMensajeProgramarVuelo(IVuelo vuelo) {
		Mensaje mensaje = new Mensaje(TipoMensaje.VUELO_PROGRAMADO);
		mensaje.setVuelo(vuelo);
		return mensaje;
	}
	
	public static Mensaje crearMensajeVueloProximoAterrizar(IVuelo vuelo) {
		Mensaje mensaje = new Mensaje(TipoMensaje.VUELO_PROXIMO_A_ATERRIZAR);
		mensaje.setVuelo(vuelo);
		return mensaje;
	}
	
	public static Mensaje crearMensajeVueloAterrizoEnDestino(String idVuelo) {
		Mensaje mensaje = new Mensaje(TipoMensaje.VUELO_ATERRIZO_EN_DESTINO);
		mensaje.setIdVuelo(idVuelo);
		return mensaje;
	}
	
	public static Mensaje crearMensajeObtenerInformacionVuelo( String idVuelo) {
		Mensaje mensaje = new Mensaje(TipoMensaje.OBTENER_INFORMACION_VUELO);
		mensaje.setIdVuelo(idVuelo);		
		return mensaje;
	}
	
	public static Mensaje crearMensajeInformacionVuelo(IVuelo vuelo) {
		Mensaje mensaje =new Mensaje(TipoMensaje.INFORMACION_VUELO);
		mensaje.setVuelo(vuelo);
		return mensaje;
	}
	
	
	
	
	
	public TipoMensaje getTipoMensaje() {
		return tipoMensaje;
	}
	private void setTipoMensaje(TipoMensaje tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}
	public IAeropuerto getAeropuerto() {
		return aeropuerto;
	}
	private void setAeropuerto(IAeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}
	public String getIdAeropuerto() {
		return idAeropuerto;
	}
	private void setIdAeropuerto(String idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}
	public List<IAeropuerto> getAeropuertos() {
		return aeropuertos;
	}
	private void setAeropuertos(List<IAeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public IVuelo getVuelo() {
		return vuelo;
	}
	private void setVuelo(IVuelo vuelo) {
		this.vuelo = vuelo;
	}
	public String getIdVuelo() {
		return idVuelo;
	}
	private void setIdVuelo(String idVuelo) {
		this.idVuelo = idVuelo;
	}

	public TipoError getTipoError() {
		return tipoError;
	}

	private void setTipoError(TipoError tipoError) {
		this.tipoError = tipoError;
	}
	
}
