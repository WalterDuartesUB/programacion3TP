package ar.edu.ub.p3.vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.Closeable;
import java.io.IOException;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


import ar.edu.ub.p3.util.Configuracion;

public class LabelDia extends JPanel implements Closeable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Configuracion 			configuracion;
	private Timer 					timerPedirVuelos;
	
	
	public LabelDia(Configuracion configuracion) {
		super();

		this.setConfiguracion(configuracion);
		
		this.setTimerPedirVuelos(new Timer (this.getConfiguracion().getConfiguracionAsInt("tableroTiempoRefresh"), this ::actualizarHora));
		this.getTimerPedirVuelos().start();
	}
	
	public void actualizarHora(ActionEvent arg0) {
		//this.setVuelosProgramadosDespegue(this.getConexionTA().getEstadoAeropuerto().getVuelosProximoADespegarYDespegados().values());
		this.hora();
	}

	private void hora() {
		this.validate();
		this.Iniciar();	
	}

	private void Iniciar() {
		//String date = new Date().toString();
		//JLabel dia = new JLabel(date);
		this.add(dia());
	}
	
	private Component dia () {
		String date = new Date().toString();
		JLabel dia = new JLabel(date);
		System.out.println(date);
		return dia;
	}

	public Configuracion getConfiguracion() {
		return configuracion;
	}

	public void setConfiguracion(Configuracion configuracion) {
		this.configuracion = configuracion;
	}

	public Timer getTimerPedirVuelos() {
		return timerPedirVuelos;
	}

	public void setTimerPedirVuelos(Timer timerPedirVuelos) {
		this.timerPedirVuelos = timerPedirVuelos;
	}

	@Override
	public void close() throws IOException {
		this.getTimerPedirVuelos().stop();
		
	}

}
