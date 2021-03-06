package ar.edu.ub.p3.modelo;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.ub.p3.interfaz.IPosicion;
import ar.edu.ub.p3.util.CargadorArchivosData;
import ar.edu.ub.p3.util.Configuracion;
import ar.edu.ub.p3.util.factory.AerolineaFactory;
import ar.edu.ub.p3.util.factory.AeropuertoFactory;
import ar.edu.ub.p3.util.factory.AvionFactory;
import ar.edu.ub.p3.util.factory.VueloFactory;

public class EstadoAeropuerto {

	private Aeropuerto aerpuerto;
	private Map<String, Avion> aviones;
	private Map<String, Aerolinea> aerolineas;
	private Map<String, Vuelo> vuelos;
	private Map<String, Aeropuerto> aeropuertos;
	private Map<String, Vuelo> vuelosAterrizando;
	
	private boolean estoyConectado;
	private boolean estoyEsperandoRespuestaConexion;
	private boolean deboContinuar;
	
	private Vuelo vueloRecibido;
	
	public EstadoAeropuerto( Configuracion configuracion  ) {
		 
		String idAeropuerto = configuracion.getConfiguracion("idAeropuerto");
		String nomAeropuerto = configuracion.getConfiguracion("nombreAeropuerto");
		double posX = Double.parseDouble(configuracion.getConfiguracion("posicionAeropuertoX")) ;
		double posY = Double.parseDouble(configuracion.getConfiguracion("posicionAeropuertoY")) ;
		
		Posicion posicion = new Posicion(posX, posY);
		
		this.setAerpuerto(new Aeropuerto(idAeropuerto, nomAeropuerto,posicion));
		this.setAviones(new HashMap<String, Avion>());
		this.setVuelosAterrizando(new HashMap<String, Vuelo>());
		
		this.setEstoyConectado(false);
		this.setEstoyEsperandoRespuestaConexion(false);
		this.setDeboContinuar(true);
		
		//Cargo la informacion que maneja el aeropuerto
		this.cargarAeropuertos( configuracion.getConfiguracion("pathAeropuertos") );
		this.cargarAerolineas( configuracion.getConfiguracion("pathAerolineas") );
		this.cargarAviones( configuracion.getConfiguracion("pathAviones") );
		this.cargarVuelos( configuracion.getConfiguracion("pathVuelos") );
		
		//Otros
		this.setVueloRecibido( null );
		
	}
	
	
	private void cargarVuelos(String pathData) {
		this.setVuelos( CargadorArchivosData.cargarMapaDesdeArchivo(pathData, new VueloFactory(this.getAviones(), this.getAeropuertos())));
		
		System.out.println("Vuelos: ");
		System.out.println( this.getVuelos() );
	}


	private void cargarAviones(String pathData) {
		this.setAviones( CargadorArchivosData.cargarMapaDesdeArchivo(pathData, new AvionFactory( this.getAerolineas(), this.getAerpuerto().getPosicion() ) ) );
		
		System.out.println("Aviones: ");
		System.out.println( this.getAviones() );		
	}


	private void cargarAerolineas(String pathData) {
		this.setAerolineas( CargadorArchivosData.cargarMapaDesdeArchivo(pathData, new AerolineaFactory() ) );
		
		System.out.println("Aerolineas: ");
		System.out.println( this.getAerolineas() );
	}
	
	private void cargarAeropuertos(String pathData) {

		this.setAeropuertos( CargadorArchivosData.cargarMapaDesdeArchivo(pathData, new AeropuertoFactory() ) );
		
		System.out.println("Aeropuertos: ");
		System.out.println( this.getAeropuertos() );		
	}


	public Aeropuerto getAerpuerto() {
		return aerpuerto;
	}

	private void setAerpuerto(Aeropuerto aerpuerto) {
		this.aerpuerto = aerpuerto;
	}

	public Map<String, Avion> getAviones() {
		return aviones;
	}

	private void setAviones(Map<String, Avion> aviones) {
		this.aviones = aviones;
	}


	public boolean isEstoyConectado() {
		return estoyConectado;
	}


	public void setEstoyConectado(boolean estoyConectado) {
		this.estoyConectado = estoyConectado;
	}


	public boolean isEstoyEsperandoRespuestaConexion() {
		return estoyEsperandoRespuestaConexion;
	}


	public void setEstoyEsperandoRespuestaConexion(boolean estoyEsperandoRespuestaConexion) {
		this.estoyEsperandoRespuestaConexion = estoyEsperandoRespuestaConexion;
	}


	public boolean isDeboContinuar() {
		return deboContinuar;
	}


	public void setDeboContinuar(boolean deboContinuar) {
		this.deboContinuar = deboContinuar;
	}


	public Map<String, Aerolinea> getAerolineas() {
		return aerolineas;
	}


	private void setAerolineas(Map<String, Aerolinea> aerolineas) {
		this.aerolineas = aerolineas;
	}


	public Map<String, Vuelo> getVuelos() {
		return vuelos;
	}


	private void setVuelos(Map<String, Vuelo> vuelos) {
		this.vuelos = vuelos;
	}


	public Map<String, Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}


	private void setAeropuertos(Map<String, Aeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}


	public Vuelo getVueloRecibido() {
		return vueloRecibido;
	}


	public void setVueloRecibido(Vuelo vueloRecibido) {
		this.vueloRecibido = vueloRecibido;
	}


	public void addVueloAterrizando(Vuelo vuelo) {		
		synchronized (this.getVuelosAterrizando()) {
			this.getVuelosAterrizando().put( vuelo.getIdVuelo(), vuelo );	
		}
	}

	public Map<String, Vuelo> getVuelosAterrizando() {
		return vuelosAterrizando;
	}
	
	public Map<String, Vuelo> getVuelosProximoDespegue() {
		return this.getVuelos();
	}

	public void setVuelosAterrizando(Map<String, Vuelo> vuelosAterrizando) {
		this.vuelosAterrizando = vuelosAterrizando;
	}

	public void cambiarEstadoAvion( String idVuelo, EstadoVuelo estadoVuelo){
		Vuelo vuelo = this.getTodosLosVuelos().get( idVuelo );
		
		synchronized (vuelo) {
			vuelo.setEstadoVuelo(estadoVuelo);
		}		
	}

	public void moverAvion(String idVuelo, IPosicion posicion) {
		Vuelo vuelo = this.getTodosLosVuelosEntantesYSalientes().get( idVuelo );
		
		synchronized (vuelo) {
			vuelo.setPosicion( new Posicion( vuelo.getPosicion().sumar( posicion ) ) );
		}		
	}

	public Map<String, Vuelo> getTodosLosVuelos() {
		Map<String, Vuelo> todosLosVuelos = new HashMap<String,Vuelo>();
		
		todosLosVuelos.putAll( this.getVuelos() );
		todosLosVuelos.putAll( this.getTodosLosVuelosEntantesYSalientes() );
		
		return todosLosVuelos;
	}
	
	private Map<String, Vuelo> getTodosLosVuelosEntantesYSalientes() {
		Map<String, Vuelo> todosLosVuelos = new HashMap<String,Vuelo>();
		
		todosLosVuelos.putAll( this.getVuelosDespegados() );
		todosLosVuelos.putAll( this.getVuelosAterrizando() );
		
		return todosLosVuelos;
	}


	public Collection<Vuelo> getVuelosProgramados() {
		Set<Vuelo> vuelosDespegados = new TreeSet<Vuelo>( new Comparator<Vuelo>() {
			@Override
			public int compare(Vuelo v1, Vuelo v2) {
				return v1.getHorarioProgramado().compareTo( v2.getHorarioProgramado() );
			}
		});
		
		for( Vuelo vuelo : this.getVuelos().values() )
			if( vuelo.getEstadoVuelo() == EstadoVuelo.PROGRAMMED )
				vuelosDespegados.add( vuelo );
		
		return vuelosDespegados;
	}
	
	public Map<String,Vuelo> getVuelosDespegados() {
		Map<String,Vuelo> vuelosDespegados = new HashMap<String, Vuelo>();
		
		for( Vuelo vuelo : this.getVuelos().values() )
			if( vuelo.getEstadoVuelo() == EstadoVuelo.BOARDING )
				vuelosDespegados.put( vuelo.getIdVuelo(), vuelo );
			
		return vuelosDespegados;
	}


	
	public Collection<Vuelo> getVuelosProgramadosYDespegados() {
		Set<Vuelo> vuelosDespegados = new TreeSet<Vuelo>( new Comparator<Vuelo>() {
			@Override
			public int compare(Vuelo v1, Vuelo v2) {
				return v1.getHorarioProgramado().compareTo( v2.getHorarioProgramado() );
			}
		});
		
		for( Vuelo vuelo : this.getVuelos().values() )
			if(vuelo.getEstadoVuelo()== EstadoVuelo.PROGRAMMED || vuelo.getEstadoVuelo()==EstadoVuelo.BOARDING || vuelo.getEstadoVuelo() == EstadoVuelo.ON_AIR )
				vuelosDespegados.add( vuelo );
		
		return vuelosDespegados;
	}

	
	
	
}
