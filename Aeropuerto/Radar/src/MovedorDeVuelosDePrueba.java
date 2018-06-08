import java.util.List;

import ar.edu.ub.p3.interfaz.IVuelo;
import ar.edu.ub.p3.modelo.Posicion;
import ar.edu.ub.p3.modelo.Vuelo;

public class MovedorDeVuelosDePrueba implements Runnable {
	
	private IRadar radar;
	private List<Vuelo> vuelosDePrueba;
	public MovedorDeVuelosDePrueba(IRadar radar, List<Vuelo> list) {
		this.setVuelosDePrueba(list);
		this.setRadar(radar);
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for (Vuelo vuelo: this.getVuelosDePrueba()){
				Posicion posicion = new Posicion(vuelo.getAvion().getPosicion());
				posicion.setX(posicion.getX()+1);
				posicion.setY(posicion.getY()+1);
				vuelo.setPosicion(posicion);
			}
			this.getRadar().dibujarRadar();
			
		}
	}

	public List<Vuelo> getVuelosDePrueba() {
		return vuelosDePrueba;
	}

	public void setVuelosDePrueba(List<Vuelo> vuelosDePrueba) {
		this.vuelosDePrueba = vuelosDePrueba;
	}

	public IRadar getRadar() {
		return radar;
	}

	public void setRadar(IRadar radar) {
		this.radar = radar;
	}

}
