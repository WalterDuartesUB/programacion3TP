package ar.edu.ub.p3.aeropuerto.gestion.view.abm.vuelo;


import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ar.edu.ub.p3.aeropuerto.gestion.modelo.IRepositorioModelo;
import ar.edu.ub.p3.modelo.Aeropuerto;
import ar.edu.ub.p3.modelo.Avion;
import ar.edu.ub.p3.modelo.EstadoVuelo;

 

public class PanelFichaCamposVuelo extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private IRepositorioModelo<Avion> aviones;
	private IRepositorioModelo<Aeropuerto> aeropuertos;
	
	
	private JTextField 	txtIdVuelo;
	private JComboBox<String> 	comboAvion;
	private JComboBox<String>  	comboOrigen;
	private JComboBox<String>  	comboDestino;
	private JComboBox<EstadoVuelo> comboEstado;
	private JTextField 	txtHoraProgramada;

	private JLabel 	lblIdVuelo;
	private JLabel 	lblAvion;
	private JLabel  lblOrigen;
	private JLabel  lblDestino;
	private JLabel  lblEstado;
	private JLabel 	lblHoraProgramada;
	
	
	public PanelFichaCamposVuelo(IRepositorioModelo<Aeropuerto> aeropuertos, IRepositorioModelo<Avion> aviones ) {
		
		setAeropuertos(aeropuertos);
		setAviones(aviones);
		
		
		genererComponentes();
		configurarVentana();
		
	}
	
	private void genererComponentes() {
		
		setTxtIdVuelo( new JTextField() ); 
		setComboAvion( new JComboBox<String>() );
		setComboDestino(new JComboBox<String>() );
		setComboOrigen (new JComboBox<String>() );
		setComboEstado ( new JComboBox<EstadoVuelo>() );
		setTxtHoraProgramada( new JTextField() );
		
		
		setLblIdVuelo(new JLabel("        Id Vuelo:" )  );
		setLblAvion(new JLabel("        Id Avion:" ) );
		setLblOrigen(new JLabel("        Aeropuerto Origen" ) );
		setLblDestino(new JLabel("       Aeropuerto Destino" ) );
		setLblEstado(new JLabel("        Estado de Vuelo" ) );
		setLblHoraProgramada(new JLabel("        Programacion" ) );
		
		add( getLblIdVuelo());
		add( getTxtIdVuelo());
		
		add( getLblAvion());
		add( getComboAvion());
		
		add( getLblOrigen());
		add( getComboOrigen());
		
		add( getLblDestino());
		add( getComboDestino());
		
		add( getLblEstado());
		add( getComboEstado());
		
		add( getLblHoraProgramada());
		add( getTxtHoraProgramada());
		
		
		agregarItemsEnComboAviones();
		agregarItemsEnComboOrigenyDestino();
		agregarItemsEnComboEstadoVuelo();
	
	}

	private void configurarVentana() {
		
		setBackground(Color.BLACK);
		setLayout( new GridLayout( 6,1));

		getLblIdVuelo().setBackground(Color.BLACK);
		getLblIdVuelo().setForeground(Color.WHITE);
		
		getTxtIdVuelo().setBackground(Color.DARK_GRAY);
		getTxtIdVuelo().setForeground(Color.WHITE);
		
		getLblAvion().setBackground(Color.BLACK);
		getLblAvion().setForeground(Color.WHITE);
		
		getComboAvion().setBackground(Color.DARK_GRAY);
		getComboAvion().setForeground(Color.WHITE);
		
		getLblOrigen().setBackground(Color.BLACK);
		getLblOrigen().setForeground(Color.WHITE);
		
		getComboOrigen().setBackground(Color.DARK_GRAY);
		getComboOrigen().setForeground(Color.WHITE);
		
		getLblDestino().setBackground(Color.BLACK);
		getLblDestino().setForeground(Color.WHITE);
		
		getComboDestino().setBackground(Color.DARK_GRAY);
		getComboDestino().setForeground(Color.WHITE);
		
		getLblEstado().setBackground(Color.BLACK);
		getLblEstado().setForeground(Color.WHITE);
		
		getComboEstado().setBackground(Color.DARK_GRAY);
		getComboEstado().setForeground(Color.WHITE);
		
		getLblHoraProgramada().setBackground(Color.BLACK);
		getLblHoraProgramada().setForeground(Color.WHITE);
		
		getTxtHoraProgramada().setBackground(Color.DARK_GRAY);
		getTxtHoraProgramada().setForeground(Color.WHITE);
		
		
		
	}

	private void agregarItemsEnComboAviones() {
		
		for(Avion avion : getAviones().getList())
			getComboAvion().addItem(avion.getIdAvion());
		
	}
	
	private void agregarItemsEnComboOrigenyDestino() {
		
		for(Aeropuerto aeropuerto : getAeropuertos().getList()) {
			getComboOrigen().addItem(aeropuerto.getNombre());
			getComboDestino().addItem(aeropuerto.getNombre());
		}
			
		
	}

	private void agregarItemsEnComboEstadoVuelo() {
	
	for(EstadoVuelo estadoVuelo : EstadoVuelo.values())
		getComboEstado().addItem( estadoVuelo );
	
	}

	public JTextField getTxtIdVuelo() {
		return txtIdVuelo;
	}

	public void setTxtIdVuelo(JTextField txtIdVuelo) {
		this.txtIdVuelo = txtIdVuelo;
	}

	public JComboBox<String> getComboAvion() {
		return comboAvion;
	}

	public void setComboAvion(JComboBox<String> comboAvion) {
		this.comboAvion = comboAvion;
	}



	public JComboBox<EstadoVuelo> getComboEstado() {
		return comboEstado;
	}

	public void setComboEstado(JComboBox<EstadoVuelo> comboEstado) {
		this.comboEstado = comboEstado;
	}

	public JTextField getTxtHoraProgramada() {
		return txtHoraProgramada;
	}

	public void setTxtHoraProgramada(JTextField txtHoraProgramada) {
		this.txtHoraProgramada = txtHoraProgramada;
	}

	public JLabel getLblIdVuelo() {
		return lblIdVuelo;
	}

	public void setLblIdVuelo(JLabel lblIdVuelo) {
		this.lblIdVuelo = lblIdVuelo;
	}

	public JLabel getLblAvion() {
		return lblAvion;
	}

	public void setLblAvion(JLabel lblAvion) {
		this.lblAvion = lblAvion;
	}

	public JLabel getLblOrigen() {
		return lblOrigen;
	}

	public void setLblOrigen(JLabel lblOrigen) {
		this.lblOrigen = lblOrigen;
	}

	public JLabel getLblDestino() {
		return lblDestino;
	}

	public void setLblDestino(JLabel lblDestino) {
		this.lblDestino = lblDestino;
	}

	public JLabel getLblEstado() {
		return lblEstado;
	}

	public void setLblEstado(JLabel lblEstado) {
		this.lblEstado = lblEstado;
	}

	public JLabel getLblHoraProgramada() {
		return lblHoraProgramada;
	}

	public void setLblHoraProgramada(JLabel lblHoraProgramada) {
		this.lblHoraProgramada = lblHoraProgramada;
	}

	public JComboBox<String> getComboOrigen() {
		return comboOrigen;
	}

	public void setComboOrigen(JComboBox<String> comboOrigen) {
		this.comboOrigen = comboOrigen;
	}

	public JComboBox<String> getComboDestino() {
		return comboDestino;
	}

	public void setComboDestino(JComboBox<String> comboDestino) {
		this.comboDestino = comboDestino;
	}

	public IRepositorioModelo<Avion> getAviones() {
		return aviones;
	}

	public void setAviones(IRepositorioModelo<Avion> aviones) {
		this.aviones = aviones;
	}

	public IRepositorioModelo<Aeropuerto> getAeropuertos() {
		return aeropuertos;
	}

	public void setAeropuertos(IRepositorioModelo<Aeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}



}
