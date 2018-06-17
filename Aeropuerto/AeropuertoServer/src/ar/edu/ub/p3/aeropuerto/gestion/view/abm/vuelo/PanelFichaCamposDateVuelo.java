package ar.edu.ub.p3.aeropuerto.gestion.view.abm.vuelo;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelFichaCamposDateVuelo extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JComboBox <Integer> comboAnio;
	private JComboBox <Integer> comboMes;
	private JComboBox <Integer> comboDia;
	private JComboBox <Integer> comboHora;
	private JComboBox <Integer> comboMinutos;
	
	private JLabel	lblAnio;
	private JLabel	lblMes;
	private JLabel	lblDia;
	private JLabel	lblHora;
	private JLabel	lblMinutos;
	
	private Date fecha;
	
	public PanelFichaCamposDateVuelo( ) {
		
		generarComponentes();
		configurarPanel();
		
	}

	private void configurarPanel() {
		
		setBackground( Color.BLACK );
		setLayout( new GridLayout( 5,1) );
		
		getComboAnio().setForeground(Color.WHITE);
		getComboAnio().setBackground(Color.DARK_GRAY);
		
		getComboMes().setForeground(Color.WHITE);
		getComboMes().setBackground(Color.DARK_GRAY);
		
		getComboDia().setForeground(Color.WHITE);
		getComboDia().setBackground(Color.DARK_GRAY);
		
		getComboHora().setForeground(Color.WHITE);
		getComboHora().setBackground(Color.DARK_GRAY);
		
		getComboMinutos().setForeground(Color.WHITE);
		getComboMinutos().setBackground(Color.DARK_GRAY);
		
		getLblAnio().setForeground(Color.WHITE);
		getLblAnio().setBackground(Color.BLACK);
		
		getLblMes().setForeground(Color.WHITE);
		getLblMes().setBackground(Color.BLACK);
		
		getLblDia().setForeground(Color.WHITE);
		getLblDia().setBackground(Color.BLACK);
		
		getLblHora().setForeground(Color.WHITE);
		getLblHora().setBackground(Color.BLACK);
		
		getLblMinutos().setForeground(Color.WHITE);
		getLblMinutos().setBackground(Color.BLACK);
	}

	private void generarComponentes() {
		
		setComboAnio(new JComboBox<Integer>());
		setComboMes(new JComboBox<Integer>());
		setComboDia(new JComboBox<Integer>());
		setComboHora(new JComboBox<Integer>());
		setComboMinutos(new JComboBox<Integer>());
		
		setLblAnio( new JLabel("        Anio") );
		setLblMes( new JLabel("        Mes") );
		setLblDia( new JLabel("        Dia") );
		setLblHora( new JLabel("        Hora") );
		setLblMinutos( new JLabel("        Minutos") );
		
		add( getLblDia());
		add( getComboDia());
		
		add( getLblMes());
		add( getComboMes() );
		
		add( getLblAnio());
		add( getComboAnio() );
		
		add( getLblHora());
		add( getComboHora() );
		
		add( getLblMinutos());
		add( getComboMinutos() );
		
		agreagarItemsComboAnio();
		agreagarItemsComboMes();
		agreagarItemsComboDia();
		agreagarItemsComboHora();
		agreagarItemsComboMinutos();
		
	}

	private void agreagarItemsComboMinutos() {
		
		getComboMinutos().addItem(00);
		getComboMinutos().addItem(30);
		
	}

	private void agreagarItemsComboHora() {
		
		for( int i=0 ; i<24 ; i++ )
			getComboHora().addItem(i);
		
	}

	private void agreagarItemsComboDia() {
		
		for(int i=1; i<32;i++)
			getComboDia().addItem(i);
		
	}

	private void agreagarItemsComboMes() {
		
		for(int i=1; i<13;i++)
			getComboMes().addItem(i);
		
	}

	@SuppressWarnings("deprecation")
	private void agreagarItemsComboAnio() {

		Date date = new Date();
		for(int i = date.getYear(); i<(date.getYear()+5);i++)
			getComboAnio().addItem((i-100));
		
	}

	public JComboBox <Integer> getComboAnio() {
		return comboAnio;
	}

	public void setComboAnio(JComboBox <Integer> comboAnio) {
		this.comboAnio = comboAnio;
	}

	public JComboBox <Integer> getComboMes() {
		return comboMes;
	}

	public void setComboMes(JComboBox <Integer> comboMes) {
		this.comboMes = comboMes;
	}

	public JComboBox <Integer> getComboDia() {
		return comboDia;
	}

	public void setComboDia(JComboBox <Integer> comboDia) {
		this.comboDia = comboDia;
	}

	public JComboBox <Integer> getComboHora() {
		return comboHora;
	}

	public void setComboHora(JComboBox <Integer> comboHora) {
		this.comboHora = comboHora;
	}

	public JComboBox <Integer> getComboMinutos() {
		return comboMinutos;
	}

	public void setComboMinutos(JComboBox <Integer> comboMinutos) {
		this.comboMinutos = comboMinutos;
	}

	public JLabel getLblAnio() {
		return lblAnio;
	}

	public void setLblAnio(JLabel lblAnio) {
		this.lblAnio = lblAnio;
	}

	public JLabel getLblMes() {
		return lblMes;
	}

	public void setLblMes(JLabel lblMes) {
		this.lblMes = lblMes;
	}

	public JLabel getLblDia() {
		return lblDia;
	}

	public void setLblDia(JLabel lblDia) {
		this.lblDia = lblDia;
	}

	public JLabel getLblHora() {
		return lblHora;
	}

	public void setLblHora(JLabel lblHora) {
		this.lblHora = lblHora;
	}

	public JLabel getLblMinutos() {
		return lblMinutos;
	}

	public void setLblMinutos(JLabel lblMinutos) {
		this.lblMinutos = lblMinutos;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
